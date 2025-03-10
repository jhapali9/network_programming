import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class _1_1_SSLServer {
    public static void main(String[] args) {
        int port = 8443; // Secure port
        
        try {
            SSLServerSocketFactory serverFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket = (SSLServerSocket) serverFactory.createServerSocket(port);

            System.out.println("Secure server started on port " + port);
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected.");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Read client's message
                String message = in.readLine();
                System.out.println("Client: " + message);

                // Send response
                out.println("Hello, Secure Client!");

                // Close resources
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
