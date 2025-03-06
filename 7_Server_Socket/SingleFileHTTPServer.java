import java.io.*;
import java.net.*;

public class SingleFileHTTPServer {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(4444)) {
            System.out.println("Server listening on port " + 4444);

            while (true) {
                try (Socket connection = serverSocket.accept()) {
                    OutputStream out = connection.getOutputStream();

                    PrintWriter writer = new PrintWriter(out);

                    // Write HTTP response headers
                    writer.println("HTTP/1.1 200 OK");
                    writer.println("Content-Type: text/plain");
                    writer.println();

                    // Send the content of the file
                    FileInputStream fileInputStream = new FileInputStream("index.html");

                    int ch;

                    while ((ch = fileInputStream.read()) != -1) {
                        out.write(ch);
                    }

                    out.flush();
                } catch (IOException e) {

                }
            }
        } catch (IOException e) {

        }
    }
}
