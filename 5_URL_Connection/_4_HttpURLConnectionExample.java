import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class _4_HttpURLConnectionExample {
    public static void main(String[] args) {
        try {
            // Define the target URL
            URL url = new URL("https://example.com");

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Connect to the server
            connection.connect();

            // Get and print the Content-Type
            String contentType = connection.getContentType();
            System.out.println("Content-Type: " + contentType);

            // Get and print the Content-Encoding
            String contentEncoding = connection.getContentEncoding();
            System.out.println("Content-Encoding: " + (contentEncoding != null ? contentEncoding : "Not specified"));

            // Get and print the Date (response date)
            long date = connection.getDate();
            System.out.println("Date: " + (date != 0 ? new Date(date) : "Not available"));

            // Get and print the Last-Modified date
            long lastModified = connection.getLastModified();
            System.out.println("Last-Modified: " + (lastModified != 0 ? new Date(lastModified) : "Not available"));

            // Get and print the Expiration date
            long expiration = connection.getExpiration();
            System.out.println("Expiration: " + (expiration != 0 ? new Date(expiration) : "Not available"));

            // Disconnect
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
