import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class _3_CipherSuites {
	public static void main(String[] args) throws UnknownHostException, IOException {

		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket secureSocket = (SSLSocket) factory.createSocket();

		secureSocket.connect(new InetSocketAddress("newsummit.edu.np", 443));

		String[] supportedCipherSuites = secureSocket.getSupportedCipherSuites();

		String[] ciphersToEnable = {"TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA"};

		secureSocket.setEnabledCipherSuites(ciphersToEnable);

		for (String cipherSuite : supportedCipherSuites) {
			System.out.println(cipherSuite);
		}

		String[] enabledCipherSuites = secureSocket.getEnabledCipherSuites();

		for(String cipherSuite:enabledCipherSuites){
			System.out.println(cipherSuite);
		}

		secureSocket.close();

	}
}
