import java.io.IOException;
import java.net.URL;

public class _1_URL {
    public static void main(String[] args) throws IOException{
        URL u = new URL("https://www.google.com");
        System.out.println(u.getProtocol());
    }
}
