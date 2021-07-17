package architectural.api_gateway;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImageClientImpl implements ImageClient {
    @Override
    public String getImagePath() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest get = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost/image-path")).build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(get, HttpResponse.BodyHandlers.ofString());
            return httpResponse.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
