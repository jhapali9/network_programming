import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class _7_ReadingAllHeaders {
    public static void main(String[] args) throws IOException{
        URL u = new URL("https://www.newsummit.edu.np/");
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();

        for (int i = 1; i <= 8; i++) {
            System.out.println(conn.getHeaderFieldKey(i) + " = " + conn.getHeaderField(i));
        }

        conn.disconnect();

    }
}
