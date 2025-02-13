import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class AuthDemo extends Authenticator {
    String uname;
    String pass;
    AuthDemo(String uname,String pass){
        this.uname = uname;
        this.pass = pass;
    }
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        // System.out.println(getRequestingHost());
        return new PasswordAuthentication(uname,pass.toCharArray());
    }
    public static void main(String[] args) throws IOException{

        Authenticator.setDefault(new AuthDemo("Shyam", "ram@123"));

        URL u = new URL("http://www.example.com");

        URLConnection conn = u.openConnection();

        // InputStream in = conn.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while((line=in.readLine())!=null){
            System.out.println(line);
        }

        // int ch;
        // while((ch=in.read())!=-1){
        //     System.out.print(ch);
        // }

        in.close();

    }
}
