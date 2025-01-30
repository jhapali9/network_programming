import java.io.IOException;
import java.net.InetAddress;

public class _7_FactoryMethods {
    public static void main(String[] args) throws IOException{

        // Get the local host address
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("Localhost = "+localhost);

        // Get an InetAddress object by name 
        InetAddress address = InetAddress.getByName("www.google.com");
        System.out.println("IPV4 address by name: " + address);

        // Get all InetAddress objects associated with a given host name 
        InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
        System.out.println("All IP addresses associated with google: ");
        for( InetAddress addr : addresses ){
            System.out.println(addr);
        }

        // Get an InetAddress object by byte array 
        byte[] ipv4Bytes = {(byte)142, (byte)250, (byte)194, (byte)228};
        InetAddress ipv4 = InetAddress.getByAddress(ipv4Bytes);
        System.out.println("IPv4 Address by Bytes: " + ipv4);

        // Get an InetAddress object by host name and byte array (IPv6)
        byte[] addr = {0, 0, 0, 1};
        InetAddress addByNameAndAddress = InetAddress.getByAddress("localhost", addr);
        System.out.println("IPv6 Address by Bytes and Name: " + addByNameAndAddress);

    }
}
