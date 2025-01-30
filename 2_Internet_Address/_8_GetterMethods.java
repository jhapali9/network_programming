import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class _8_GetterMethods {
    public static void main(String[] args) throws IOException{

        // print all the network interfaces
        Enumeration<NetworkInterface> i = NetworkInterface.getNetworkInterfaces();
        while(i.hasMoreElements()){
            System.out.println(i.nextElement());
        }

        // get object of an interface
        NetworkInterface wlo1 = NetworkInterface.getByName("wlo1");
        System.out.println(wlo1.getName()); //getName()
        System.out.println(wlo1.getDisplayName()); //getDisplayName()
        Enumeration<InetAddress> addreses = wlo1.getInetAddresses(); // getInetAddresses()
        while(addreses.hasMoreElements()){
            System.out.println(addreses.nextElement());
        }
    }
}
