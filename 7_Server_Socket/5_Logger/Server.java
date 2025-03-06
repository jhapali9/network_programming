import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class ServiceClass implements Callable<Void> {
    private Socket connection;

    ServiceClass(Socket connection) {
        this.connection = connection;
    }

    @Override
    public Void call() {
        try {
            OutputStream out = connection.getOutputStream();
            out.write(new Date().toString().getBytes());
            out.flush();
            out.close();
            connection.close();
        } catch (IOException e) {

        }
        return null;
    }
}

public class Server {
    private static Logger auditLogger = Logger.getLogger("audit");
    private static Logger errorLogger = Logger.getLogger("error");

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(30);
        try (ServerSocket serverSocket = new ServerSocket(4444)) {
            while (true) {
                Socket connection = serverSocket.accept();
                // System.out.println();
                auditLogger.log(Level.INFO, "Client connected: " + connection.getInetAddress());
                Callable<Void> service = new ServiceClass(connection);
                pool.submit(service);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
