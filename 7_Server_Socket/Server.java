import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket s = new ServerSocket(4444)) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
