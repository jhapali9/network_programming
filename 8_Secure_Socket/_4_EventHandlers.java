import javax.net.ssl.*;
import java.io.*;
import java.security.cert.Certificate;

public class _4_EventHandlers {
    public static void main(String[] args) {
        String host = "www.example.com";
        int port = 443;

        try {
            // Create an SSL socket factory
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            // Create an SSL socket
            SSLSocket sslSocket = (SSLSocket) factory.createSocket(host, port);

            sslSocket.addHandshakeCompletedListener(new MyHandshakeListener());

            // Start the handshake
            sslSocket.startHandshake();

            // Retrieve and print SSL session
            SSLSession session = sslSocket.getSession();
            System.out.println("SSL Session:");
            System.out.println("  Protocol: " + session.getProtocol());
            System.out.println("  Session ID: " + bytesToHex(session.getId()));

            // Retrieve and print the cipher suite
            String cipherSuite = session.getCipherSuite();
            System.out.println("Cipher Suite: " + cipherSuite);

            // Retrieve and print peer certificates
            Certificate[] peerCerts = session.getPeerCertificates();
            System.out.println("Peer Certificates:");
            for (Certificate cert : peerCerts) {
                System.out.println("  Type: " + cert.getType());
                System.out.println("  Hash Code: " + cert.hashCode());
                System.out.println("  Public Key Algorithm: " + cert.getPublicKey().getAlgorithm());
                System.out.println("  Format: " + cert.getPublicKey().getFormat());
            }

            // Retrieve and print socket information
            System.out.println("Socket Information:");
            System.out.println("  Local Address: " + sslSocket.getLocalSocketAddress());
            System.out.println("  Remote Address: " + sslSocket.getRemoteSocketAddress());

            // Close the socket
            sslSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Utility method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
