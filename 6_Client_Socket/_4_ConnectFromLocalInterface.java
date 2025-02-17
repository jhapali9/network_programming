import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class _4_ConnectFromLocalInterface {
    public static void main(String[] args) throws IOException{
        InetAddress localInterface = InetAddress.getByName("router");
        Socket socket = new Socket("localhost",80,localInterface,0);
        InputStream in = socket.getInputStream();
        int ch;
        while((ch=in.read())!=-1){
            System.out.print((char)ch);
        }
        in.close();
        socket.close();
    }
}
