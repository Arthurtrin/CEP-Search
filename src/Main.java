import br.com.cepSearch.exceptions.CepNotFoundException;
import br.com.cepSearch.exceptions.InvalidCepException;
import br.com.cepSearch.models.Address;
import br.com.cepSearch.models.CepServices;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Application entry point.
 *
 * <p>This class demonstrates how to use the CEP search service to retrieve
 * address data from the ViaCEP API.</p>
 *
 * <p>The program reads CEP values from standard input, validates them,
 * performs the API request, converts the response into domain objects,
 * and stores the results in a JSON file.</p>
 *
 * <p>Typing {@code "sair"} ends the program execution.</p>
 */
public class Main {
    /**
     * Runs the CEP search example application.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if an error occurs while performing I/O operations
     * @throws InterruptedException if the HTTP request is interrupted
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        String busca;
        List<Address> addresses = new ArrayList<>();
        CepServices cepServices = null;
        Address cep;

        while(true){
            System.out.println("digite o cep para busca: ");
            busca = read.nextLine();

            if (busca.equals("sair")) break;

            try{
                cepServices = new CepServices(busca);
                cepServices.cepSearch();
                cep = cepServices.fromJsonToAddress();
                addresses.add(cep);

            } catch (InvalidCepException e){
                System.out.println(e.getMessage());
            } catch (CepNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        if(cepServices != null) cepServices.writeInJson(addresses);


    }
}