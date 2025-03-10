import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class _1_SSLClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8443; // Use the same port as the server
        
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) factory.createSocket(host, port);

            // Get I/O streams
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

            // Send a message to the server
            out.println("Hello, Secure Server!");
            
            // Read server response
            String response = in.readLine();
            System.out.println("Server: " + response);

            // Close resources
            in.close();
            out.close();
            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
