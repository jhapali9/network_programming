import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class _3_OpenConnection {
    public static void main(String[] args) throws IOException{
        URL u = new URL("https://www.google.com");
        URLConnection con = u.openConnection();
        InputStream i = con.getInputStream();
        int ch;
        while ((ch=i.read())!=-1) {
            System.out.write(ch);
        }
    }
}
