import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class _2_OpenStream {
    public static void main(String[] args) throws IOException{
        URL u = new URL("https://www.google.com");
        InputStream i = u.openStream();
        int ch;
        while((ch=i.read()) != -1){
            System.out.write(ch);
        }
    }
}
