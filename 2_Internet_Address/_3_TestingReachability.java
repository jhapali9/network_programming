import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class _3_TestingReachability {
    public static void main(String[] args) throws IOException{
        InetAddress address = InetAddress.getByName("www.facebook.com");
        
        // testing reachability using isReachable(int timeout) function
        System.out.println(address.isReachable(2000));
        
        // printing all network intefaces available
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while(interfaces.hasMoreElements()){
            System.out.println(interfaces.nextElement());
        }

        // getting network interface which is currently running
        NetworkInterface networkInterface = null;
        while (interfaces.hasMoreElements()) {
            NetworkInterface i = interfaces.nextElement();
            if(!i.isLoopback() && i.isUp()){
                networkInterface = i;
                break;
            }
        }
        if(networkInterface == null){
            System.out.println("No suitable interface found");
        }else{
            System.out.println("Using network interface: "+ networkInterface.getDisplayName());
        }

        // testing reachability using isReachable(NetworkInterface i,int ttl,int timeout) function
        int ttl = 30; 
        int timeout = 5000; 
        System.out.println(address.isReachable(networkInterface, ttl, timeout));

    }
}
