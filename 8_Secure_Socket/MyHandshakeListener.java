import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLPeerUnverifiedException;

public class MyHandshakeListener implements HandshakeCompletedListener {

	@Override
	public void handshakeCompleted(HandshakeCompletedEvent e) {
		System.out.println("Session : " + e.getSession());
		System.out.println("Using cipher suite : " + e.getCipherSuite());
		try {
			System.out.println("Certificate chain: " + e.getPeerCertificates());
		} catch (SSLPeerUnverifiedException e1) {
			e1.printStackTrace();
		}
		System.out.println("Socket: " + e.getSocket());
	}

}
