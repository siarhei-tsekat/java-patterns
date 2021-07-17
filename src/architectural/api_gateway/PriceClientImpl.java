package architectural.api_gateway;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PriceClientImpl implements PriceClient {
    @Override
    public String getPrice() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest get = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:5006/price")).build();
        try {
            HttpResponse<String> httpResponse = httpClient.send(get, HttpResponse.BodyHandlers.ofString());
            return httpResponse.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
