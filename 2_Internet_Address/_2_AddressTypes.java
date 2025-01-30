import java.io.IOException;
import java.net.InetAddress;

public class _2_AddressTypes {
    public static void main(String[] args) throws IOException{
        
        InetAddress address = InetAddress.getByName("127.0.0.1");

        /*
         * Below methods are used to determine specific types of IP 
         * address based on their properties and usage
         * 
         * For e.g isAnyLocalAddress() Determines if the IP address is a
         * wildcard address or not, 
         * it prints true if IP is wildcard address 
         * and prints false if IP is not wildcard address
         */

        System.out.println(address.isAnyLocalAddress()); // (wildcard address) eg. for testing network configurations by accepting connection from any IP address 0.0.0.0 or ::

        System.out.println(address.isLoopbackAddress()); // (loopback address) address connecting to same computer 

        System.out.println(address.isLinkLocalAddress()); // (link-local address) self-configure IPV6 to communicate on a single network

        System.out.println(address.isSiteLocalAddress()); // (site-local address) within a site or campus 

        System.out.println(address.isMulticastAddress()); // (multi-cast address) broadcast to subscribed computers

        System.out.println(address.isMCGlobal()); // (global multicast address) subscribers around the world

        System.out.println(address.isMCOrgLocal()); // (organization wide multicast address) subscibers within all sites of company or organization

        System.out.println(address.isMCSiteLocal()); // (site-wide multicast address) packets transferred within local site

        System.out.println(address.isMCLinkLocal()); // (subnet-wide multicast address) packets transferred within a subnet

        System.out.println(address.isMCNodeLocal()); // (interface-local multicast address) packets transferred within same network-interface
    }
}
