import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

class ServerThread extends Thread{
    private Socket client;
    ServerThread(Socket client){
        this.client = client;
    }
    @Override
    public void run(){
        OutputStream out;
        try {
            out = client.getOutputStream();
            String content = "Hello\r\n";
            out.write(content.getBytes());
            out.flush();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}

public class ServerDemo {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            while(true){
                Socket client = serverSocket.accept();
                Thread t = new ServerThread(client);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
