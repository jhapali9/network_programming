import java.io.*;
import java.net.*;

public class HttpRedirector {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(4444)) {
            System.out.println("Server listening on port " + 4444);

            while (true) {
                try (Socket connection = serverSocket.accept()) {
                    OutputStream out = connection.getOutputStream();

                    PrintWriter writer = new PrintWriter(out);

                    // Write HTTP response headers
                    writer.println("HTTP/1.1 302 Found");
                    writer.println("Location: https://example.com");
                    writer.println();

                    // Optionally, you can send an HTML response for browsers that don't
                    // automatically follow redirects
                    writer.println(
                            "<html><body>Redirecting to <a href=\"https://example.com" + ">" + "https://example.com"
                                    + "</a></body></html>");
                    out.flush();
                } catch (IOException e) {

                }
            }
        } catch (IOException e) {

        }
    }
}
