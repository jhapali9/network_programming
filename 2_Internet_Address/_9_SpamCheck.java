import java.net.InetAddress;
import java.net.UnknownHostException;

public class _9_SpamCheck {
    private static String reverseIP(String IP){
        String[] octets = IP.split("\\.");
        String reversed = "";
        for(int i=octets.length-1;i>=0;i--){
            reversed += octets[i];
            if(i>0){
                reversed += ".";
            }
        }
        return reversed;
    }
    public static void main(String[] args) throws UnknownHostException{
        String IP = "207.87.34.17";
        String blackHoleDomain = "sbl.spamhous.org";

        String reverseIP = reverseIP(IP);
        String finalDomain = reverseIP+"."+blackHoleDomain;

        try{
            // System.out.println(finalDomain);
            InetAddress address = InetAddress.getByName(finalDomain);
            System.out.println(IP+" is a spammer");
        }catch(UnknownHostException e){
            System.out.println(IP+" is not a spammer.");
        }

    }
}
