import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class _6_HttpURLConnectionPropertiesExample {
    public static void main(String[] args) {
        try {
            // Define the target URL
            URL url = new URL("https://example.com");

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Display the URL
            System.out.println("URL: " + connection.getURL());

            // Set input mode (default is true)
            connection.setDoInput(true);
            System.out.println("Do Input: " + connection.getDoInput());

            // Set output mode (default is false, but can be enabled for POST requests)
            connection.setDoOutput(true);
            System.out.println("Do Output: " + connection.getDoOutput());

            // Allow user interaction (usually false for automated requests)
            connection.setAllowUserInteraction(true);
            System.out.println("Allow User Interaction: " + connection.getAllowUserInteraction());

            // Enable or disable caching
            connection.setUseCaches(false);
            System.out.println("Use Caches: " + connection.getUseCaches());

            // Set modification check (if modified since a specific timestamp)
            long modifiedSince = System.currentTimeMillis() - 86400000; // 1 day ago
            connection.setIfModifiedSince(modifiedSince);
            System.out.println("If Modified Since: " + connection.getIfModifiedSince());

            // Disconnect the connection
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
