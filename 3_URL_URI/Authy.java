import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;

public class Authy extends Authenticator {
    String name;
    String pass;
    Authy(String name,String pass){
        this.name = name;
        this.pass = pass;
    }
    @Override
    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(name, pass.toCharArray());
    }
    public static void main(String[] args) throws IOException{
        
        Authenticator.setDefault(new Authy("Ram","ram@123"));

        URL u = new URL("http://example.com/protected/resource");
        HttpURLConnection conn = (HttpURLConnection)u.openConnection();

        System.out.println(conn.getResponseCode());

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line;
        while((line=in.readLine())!=null){
            System.out.println(line);
        }

        in.close();

    }
}
