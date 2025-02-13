import java.net.*;
import java.io.*;

public class _8_MyAuthenticator extends Authenticator {
    private String username;
    private String password;

    public _8_MyAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        // Log details about the authentication request
        InetAddress site = getRequestingSite();
        String prompt = getRequestingPrompt();
        RequestorType requestorType = getRequestorType();
        int port = getRequestingPort();
        // String host = getRequestingHost();
        System.out.println("Requesting site: " + site);
        System.out.println("Requesting prompt: " + prompt);
        System.out.println("Requestor type: " + requestorType);
        System.out.println("Requesting port: " + port);
        return new PasswordAuthentication(username, password.toCharArray());
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) {
        String username = "yourUsername";
        String password = "yourPassword";
        
        // Set the default Authenticator
        Authenticator.setDefault(new _8_MyAuthenticator(username, password));

        _8_MyAuthenticator authenticator = (_8_MyAuthenticator) Authenticator.getDefault();
        System.out.println("Username: " + authenticator.getUserName());
        System.out.println("Password: " + authenticator.getPassword());

        // URL that requires authentication
        String urlString = "http://example.com/protected/resource";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
