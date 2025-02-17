import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class _5_HttpHeaderExample {
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

            // 1. Get a specific header field by name
            String contentType = connection.getHeaderField("Content-Type");
            System.out.println("Content-Type: " + contentType);

            // 2. Get a header field key by index
            String firstHeaderKey = connection.getHeaderFieldKey(1); // First header key
            System.out.println("First Header Key: " + firstHeaderKey);

            // 3. Get a header field value by index
            String firstHeaderValue = connection.getHeaderField(1); // First header value
            System.out.println("First Header Value: " + firstHeaderValue);

            // 4. Get a header field as a date
            long date = connection.getHeaderFieldDate("Date", 0);
            System.out.println("Date: " + (date != 0 ? new Date(date) : "Not available"));

            // 5. Get a header field as an integer
            int contentLength = connection.getHeaderFieldInt("Content-Length", -1);
            System.out.println("Content-Length: " + (contentLength != -1 ? contentLength : "Not available"));

            // Disconnect the connection
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
