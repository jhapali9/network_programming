import java.io.IOException;
import java.net.InetAddress;

public class _1_InetAddressDemo {
    public static void main(String[] args) throws IOException{

        /*
         * InetAddress
         */

        // creating InetAddress Object using static factory method getByName()
        InetAddress address = InetAddress.getByName("www.google.com");
        System.out.println(address); // www.google.com/142.250.192.4

        /*
         * Getter methods
         */

        // get host name using getHostName()
        System.out.println(address.getHostName()); // www.google.com

        // get Fully Qualified Domain Name (FQDN)
        System.out.println(address.getCanonicalHostName());

        // get Raw IP address of InetAddress object as an array / pprogram to find whether IP is IPV4 or IPV6
        byte[] rawIP = address.getAddress();
        if(rawIP.length == 4){
            System.out.println("IPV4 address");
        }else if(rawIP.length == 16){
            System.out.println("IPV6 address");
        }else{
            System.out.println("Invalid IP");
        }

        // get host address using getHostAddress()
        System.out.println(address.getHostAddress());

    }
}