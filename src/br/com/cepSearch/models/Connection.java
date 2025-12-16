package br.com.cepSearch.models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Utility class responsible for handling HTTP connections.
 *
 * <p>This class provides a simple abstraction over Java's
 * {@link HttpClient} to perform HTTP GET requests and return
 * the response body as a {@link HttpResponse}.</p>
 */
public class Connection {

    /**
     * Executes an HTTP GET request to the specified address.
     *
     * @param address the URL to which the request will be sent
     * @return an {@link HttpResponse} containing the response body as a {@code String}
     * @throws IOException if an I/O error occurs during the request
     * @throws InterruptedException if the HTTP request is interrupted
     */
    public static HttpResponse<String> search(String address) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
