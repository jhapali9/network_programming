// Write a program that shows a simple 
// CookiePolicy that blocks cookies from .gov 
// doamins but allows others

package Questions;

import java.net.*;

public class One {
    public static void main(String[] args) {
        // Custom CookiePolicy implementation to block cookies from .gov domains
        CookiePolicy policy = new CookiePolicy() {
            @Override
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                // Accept all cookies except those from .gov domains
                return !cookie.getDomain().toLowerCase().endsWith(".gov");
            }
        };

        // Set the custom CookiePolicy
        CookieHandler.setDefault(new CookieManager(null, policy));

        try {
            URL url = new URL("http://example.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response, or perform other operations as needed
            // ...

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
