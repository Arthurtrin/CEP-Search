package br.com.cepSearch.exceptions;
/**
 * Exception thrown when a CEP is not found.
 *
 * <p>This exception is raised when the ViaCEP API returns a response
 * indicating that the requested CEP does not exist.</p>
 *
 * <p>It represents a business rule violation and extends
 * {@link RuntimeException} to allow unchecked exception handling.</p>
 */
public class CepNotFoundException extends RuntimeException {
    String message;

    /**
     * Creates a new {@code CepNotFoundException} with a custom message.
     *
     * @param message the detail message explaining the error
     */
    public CepNotFoundException(String message) {
        this.message = message;

    }

    /**
     * Returns the detail message associated with this exception.
     *
     * @return the exception message
     */
    @Override
    public String getMessage() {
        return this.message;
    }
}
