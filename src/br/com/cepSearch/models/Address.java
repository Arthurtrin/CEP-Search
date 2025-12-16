package br.com.cepSearch.models;
import br.com.cepSearch.records.ViaCepAddress;

/**
 * Represents an address within the application domain.
 *
 * <p>This class acts as a domain model that encapsulates and organizes
 * address data obtained from the ViaCEP API.</p>
 *
 * <p>It converts the data transfer object {@link ViaCepAddress}
 * into a domain-specific {@code Address} representation.</p>
 */

public class Address {
    private String cep, rua, bairro, cidade, estado, regiao;

    /**
     * Creates an {@code Address} instance based on a {@link ViaCepAddress} object.
     *
     * <p>This constructor maps the data returned by the ViaCEP API
     * into the application's internal address representation.</p>
     *
     * @param address the data object returned from the ViaCEP API
     */
    public Address(ViaCepAddress address) {
        this.cep = address.cep();
        this.rua = address.logradouro();
        this.bairro = address.bairro();
        this.cidade = address.localidade();
        this.estado = address.estado();
        this.regiao = address.regiao();
    }

    /**
     * Returns a string representation of the address.
     *
     * @return a formatted string containing the address information
     */
    @Override
    public String toString() {
        return "br.com.cepSearch.models.Address{" +
                "cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", regiao='" + regiao + '\'' +
                '}';
    }
}
