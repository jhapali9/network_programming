import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class _7_URI {
    public static void main(String[] args) throws IOException,URISyntaxException{
            URI uri = new URI("http://www.ibiblio.org:8080/javafaq/books/jnp/index.html?isbn=1565922069#toc");
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + uri.getPort());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Fragment: " + uri.getFragment());
    }
}
