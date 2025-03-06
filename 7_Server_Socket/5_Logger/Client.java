import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 4444);
            InputStream in = s.getInputStream();
            int ch;
            while ((ch = in.read()) != -1) {
                System.out.print((char) ch);
            }
            in.close();
            s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}