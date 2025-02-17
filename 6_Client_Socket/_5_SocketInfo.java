import java.io.IOException;
import java.net.*;

public class _5_SocketInfo {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket();
        SocketAddress addr = new InetSocketAddress("time.nist.gov",13);
        s.connect(addr);
        System.out.println(s.toString());
        s.close();
    }
}
