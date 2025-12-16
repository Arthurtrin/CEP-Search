package br.com.cepSearch.records;

/**
 * Represents an address response returned by the ViaCEP API.
 *
 * <p>This record is used to map the JSON response fields provided by the
 * ViaCEP service into a strongly typed Java object.</p>
 *
 * <p>It acts as a Data Transfer Object (DTO), containing only the raw data
 * received from the API, without any business logic.</p>
 *
 * @param cep the postal code (CEP)
 * @param logradouro the street name
 * @param bairro the neighborhood
 * @param localidade the city
 * @param estado the state
 * @param regiao the region
 */
public record ViaCepAddress(String cep, String logradouro,
                            String bairro, String localidade,
                            String estado, String regiao) {
}
