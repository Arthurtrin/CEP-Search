package br.com.cepSearch.models;
import br.com.cepSearch.exceptions.CepNotFoundException;
import br.com.cepSearch.exceptions.InvalidCepException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import br.com.cepSearch.records.ErrorResponse;
import br.com.cepSearch.records.ViaCepAddress;

/**
 * Service class responsible for handling CEP-related operations.
 *
 * <p>This class validates CEP values, performs requests to the ViaCEP API,
 * handles error responses, converts JSON data into domain objects, and
 * persists address data into a JSON file.</p>
 */
public class CepServices {
    private String cep;
    private String semiJson;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a {@code CepServices} instance with the given CEP.
     *
     * <p>The CEP format is validated during construction. If the CEP
     * is invalid, an {@link InvalidCepException} is thrown.</p>
     *
     * @param cep the CEP to be processed
     * @throws InvalidCepException if the CEP format is invalid
     */
    public CepServices(String cep) {
        if(isValid(cep)){
            this.cep = cep;
        }
        else {
            throw new InvalidCepException("Formato de CEP não válido.");
        }

    }

    /**
     * Validates the format of a CEP.
     *
     * <p>Accepted formats:</p>
     * <ul>
     *   <li>{@code 12345678}</li>
     *   <li>{@code 12345-678}</li>
     * </ul>
     *
     * @param cep the CEP to be validated
     * @return {@code true} if the CEP format is valid, {@code false} otherwise
     */
    public static boolean isValid(String cep){
        if (cep.contains("-")){
            if (cep.length() != 9) return false;
            int index = cep.indexOf("-");
            if (index!=5) return false;
            cep = cep.substring(0,4) + cep.substring(6);
        }
        if(cep.length() != 8) return false;

        return cep.matches("\\d+");
    }

    /**
     * Performs a search for address information using the ViaCEP API.
     *
     * <p>If the CEP does not exist, a {@link CepNotFoundException} is thrown
     * based on the API response.</p>
     *
     * @throws IOException if an I/O error occurs during the request
     * @throws InterruptedException if the HTTP request is interrupted
     * @throws CepNotFoundException if the CEP was not found
     */
    public void cepSearch() throws IOException, InterruptedException {
        String address = String.format("https://viacep.com.br/ws/%s/json", this.cep);
        ErrorResponse errorResponse = gson.fromJson(Connection.search(address).body(), ErrorResponse.class);

        if(errorResponse.erro() != null && errorResponse.erro().equalsIgnoreCase("true"))
            throw new CepNotFoundException("CEP não encontrado.");

        this.semiJson = Connection.search(address).body();
        Gson gson = new Gson();
    }

    /**
     * Returns the CEP associated with this service.
     *
     * @return the CEP value
     */
    public String getCep() {
        return cep;
    }

    /**
     * Returns the raw JSON returned by the ViaCEP API.
     *
     * @return the JSON response as a string
     */
    public String getSemiJson() {
        return semiJson;
    }

    /**
     * Converts the JSON response into an {@link Address} object.
     *
     * @return an {@link Address} populated with the API response data
     */
    public Address fromJsonToAddress(){
        ViaCepAddress semiAddress = this.gson.fromJson(getSemiJson(), ViaCepAddress.class);
        return new Address(semiAddress);
    }

    /**
     * Writes a list of {@link Address} objects into a JSON file.
     *
     * <p>The file is created or overwritten with formatted JSON content.</p>
     *
     * @param addresses the list of addresses to be written
     * @throws IOException if an error occurs while writing the file
     */
    public void writeInJson(List<Address> addresses) throws IOException {
        FileWriter write = new FileWriter("addresses.json");
        write.write(this.gson.toJson(addresses));
        write.close();
    }

}
