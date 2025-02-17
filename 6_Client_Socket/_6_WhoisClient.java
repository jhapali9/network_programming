
// simple Java program that sends a WHOIS request

import java.io.*;
import java.net.*;

public class _6_WhoisClient {
    public static void main(String[] args) {
        String domain = "example.com";
        String whoisServer = "whois.verisign-grs.com"; // WHOIS server for .com domains

        try (Socket socket = new Socket(whoisServer, 43);
             OutputStream output = socket.getOutputStream();
             InputStream input = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

            output.write((domain + "\r\n").getBytes());
            output.flush();

            String response;
            while ((response = reader.readLine()) != null) {
                System.out.println(response);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
