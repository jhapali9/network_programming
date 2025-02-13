import java.io.IOException;
import java.net.URL;

public class _6_URLPieces {
    public static void main(String[] args) throws IOException{
        URL u = new URL("http://www.ibiblio.org:8080/javafaq/books/jnp/index.html?isbn=1565922069#toc");
        System.out.println(u.getProtocol());
        System.out.println(u.getHost());
        System.out.println(u.getAuthority());
        System.out.println(u.getPort());
        System.out.println(u.getPath());
        System.out.println(u.getFile());
        System.out.println(u.getQuery());
        System.out.println(u.getRef());
        System.out.println(u.getUserInfo());
    }
}
