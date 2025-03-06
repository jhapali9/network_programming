import java.io.*;
import java.net.*;
import java.util.Calendar;

public class Server {
    public static void main(String[] args) {
       try {
        ServerSocket s = new ServerSocket(4444);
        while(true){
            Socket clientConnection = s.accept();
            System.out.println("INFO: Clent connected "+clientConnection.getInetAddress());
            
            OutputStream out = clientConnection.getOutputStream();

            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            String greet = "";
            if(hour < 12){
                greet = "Good Morning\n";
            }else if(hour < 18){
                greet = "Good Afternoon\n";
            }else{
                greet = "Good Evening\n";
            }
            out.write(greet.getBytes());
            out.close();
            clientConnection.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
