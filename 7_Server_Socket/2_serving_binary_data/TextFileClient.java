import java.io.*;
import java.net.*;

public class TextFileClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 4444);
            InputStream in = s.getInputStream();
            int ch;
            System.out.print("Recieved file content: ");
            while ((ch = in.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println();
            s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}