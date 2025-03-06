import java.io.*;
import java.net.*;

public class TextFileServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(4444);
            while (true) {
                Socket client = ss.accept();
                System.out.println("Connected to client: " + client.getInetAddress());
                OutputStream out = client.getOutputStream();
                FileInputStream fis = new FileInputStream("example.txt");
                int ch;
                while ((ch = fis.read()) != -1) {
                    out.write((char) ch);
                }
                fis.close();
                ss.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
