import java.io.*;
import java.net.*;

public class SimpleHTTPServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(4444)) {
            System.out.println("Simple HTTP Server started on port " + 4444);

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    handleRequest(clientSocket);
                } catch (IOException e) {
                    System.err.println("Error handling client connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Could not start server on port 4444 : " + e.getMessage());
        }
    }

    private static void handleRequest(Socket clientSocket) {
        try (
                OutputStream out = clientSocket.getOutputStream();
                PrintWriter pw = new PrintWriter(out, true);) {

            // Serve the requested file
            File file = new File("index.html");
            if (file.exists() && !file.isDirectory()) {
                // Send HTTP response headers
                pw.println("HTTP/1.1 200 OK");
                pw.println("Content-Type: text/html");
                pw.println("Content-Length: " + file.length());
                pw.println();

                // Send the file content
                try (FileInputStream fis = new FileInputStream(file);) {
                    int ch;
                    while ((ch = fis.read()) != -1) {
                        out.write(ch);
                    }
                    out.flush();
                } catch (IOException e) {
                    System.err.println("Error reading file: " + e.getMessage());
                }
            } else {
                // File not found
                pw.println("HTTP/1.1 404 Not Found");
                pw.println("Content-Type: text/plain");
                pw.println();
                pw.println("404 Not Found");
            }
        } catch (IOException e) {
            System.err.println("Error handling HTTP request: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}
