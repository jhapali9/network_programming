import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ServerTask implements Callable<Void> {
    private Socket client;

    ServerTask(Socket client) {
        this.client = client;
    }

    public Void call() {
        try {
            OutputStream out = client.getOutputStream();
            String content = "Hello\r\n";
            out.write(content.getBytes());
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class ThreadPoolServer {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(50);
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            while (true) {
                try {
                    Socket client = serverSocket.accept();
                    Callable<Void> task = new ServerTask(client);
                    pool.submit(task);
                } catch (IOException e) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
