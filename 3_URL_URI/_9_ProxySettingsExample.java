import java.net.*;
import java.io.*;

public class _9_ProxySettingsExample {
    public static void main(String[] args) {
        // Set proxy host and port
        System.setProperty("http.proxyHost", "proxy.example.com");
        System.setProperty("http.proxyPort", "8080");
        
        // Set non-proxy hosts
        System.setProperty("http.nonProxyHosts", "localhost|127.0.0.1|*.example.com");
    

        try {
            // Create URL object
            URL url = new URL("http://www.example.com");
            URLConnection connection =  url.openConnection();
            
            // Read the response
            InputStream in = connection.getInputStream();
            int ch;

            while ((ch = in.read()) != -1) {
                System.out.println(ch);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
