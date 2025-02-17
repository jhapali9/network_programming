import java.io.IOException;
import java.net.Inet6Address;

public class _6_Inet6Address {
    public static void main(String[] args) throws IOException{
        byte[] add = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        Inet6Address address = (Inet6Address) Inet6Address.getByAddress(add);
        System.out.println(address.getHostName());
        // we can now use every getter methods that were used in InetAddress class for eg. getHostName() and so on.....
    }
}
