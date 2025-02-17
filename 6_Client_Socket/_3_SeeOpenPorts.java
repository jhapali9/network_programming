import java.io.IOException;
import java.net.*;

class _3_SeeOpenPorts {
    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";
        for (int i = 1; i < 1024; i++) {
            try {
                Socket s = new Socket(host, i);
                System.out.println("Port: " + i + " open for server: " + host);
                s.close();
            } catch (UnknownHostException e) {
                System.err.println("Unknown host: " + host);
                break;
            } catch (IOException e) {}
        }
    }
}