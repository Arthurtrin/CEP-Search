package br.com.cepSearch.exceptions;
/**
 * Exception thrown when a CEP has an invalid format.
 *
 * <p>This exception is raised when the provided CEP does not match
 * the expected format or contains invalid characters.</p>
 *
 * <p>It represents a validation error and extends
 * {@link RuntimeException} to allow unchecked exception handling.</p>
 */

public class InvalidCepException extends RuntimeException {
    private String message;

    /**
     * Creates a new {@code InvalidCepException} with a custom message.
     *
     * @param message the detail message explaining why the CEP is invalid
     */
    public InvalidCepException(String message) {
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
