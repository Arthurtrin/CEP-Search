package br.com.cepSearch.records;

/**
 * Represents an error response returned by the ViaCEP API.
 *
 * <p>This record is used to map the {@code "erro"} field from the API response,
 * which indicates whether the requested CEP was not found.</p>
 *
 * <p>When the value of {@code erro} is {@code "true"}, it means that the
 * requested CEP does not exist in the ViaCEP database.</p>
 *
 * @param erro a string flag indicating an error in the API response
 */
public record ErrorResponse(String erro) {
}
