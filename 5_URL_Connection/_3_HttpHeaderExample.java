import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class _3_HttpHeaderExample {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("https://example.com");

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Connect to the server
            connection.connect();

            // Get header fields
            Map<String, List<String>> headers = connection.getHeaderFields();

            // Print headers
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Close the connection
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
