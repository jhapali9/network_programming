import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLServerSocketFactory;

public class _2_CreatingSecureServerSockets {

	public static void main(String[] args) throws IOException {

		SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

		ServerSocket socket = factory.createServerSocket(1234);

		Socket s = socket.accept();

		System.out.println("Client connected : " + s.getInetAddress());

		s.close();

	}

}
