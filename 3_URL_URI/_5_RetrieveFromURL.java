import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class _5_RetrieveFromURL {
    public static void main(String[] args) throws IOException{
        URL u = new URL("https://www.google.com");
        URLConnection conn = u.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while((line=in.readLine())!=null){
            System.out.println(line);
        }
    }
}
