import java.io.IOException;
import java.net.Inet4Address;

public class _5_Inet4Address {
    public static void main(String[] args) throws IOException{
        Inet4Address address = (Inet4Address)Inet4Address.getByName("www.google.com");
        System.out.println(address.getHostAddress());
        // we can now use every getter methods that were used in InetAddress class for eg. getHostName() and so on.....
    }
}
