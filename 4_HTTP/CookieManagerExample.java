import java.net.*;
import java.util.*;

class CookieManagerExample{
    public static void main(String[] args) {
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();

        HttpCookie cookieA = new HttpCookie("c1", "ram");
        HttpCookie cookieB = new HttpCookie("c2", "sita");
        HttpCookie cookieC = new HttpCookie("c3", "hari");

        URI uri1 = URI.create("http://test1.com");
        URI uri2 = URI.create("http://test2.com");

        cookieStore.add(uri1,cookieA);
        cookieStore.add(uri2, cookieB);
        cookieStore.add(null, cookieC);

        List<HttpCookie> cookieList = cookieStore.getCookies();
        System.out.println("Cookies list in cookie store: "+cookieList + "\n");

        cookieStore.remove(uri1, cookieA);
        List<HttpCookie> remainingCookies = cookieStore.getCookies();
        System.out.println("Cookies list in cookie store: "+remainingCookies + "\n");
        
        cookieStore.removeAll();
        List<HttpCookie> emptyCookies = cookieStore.getCookies();
        System.out.println("Cookies list in cookie store: "+emptyCookies + "\n");
    }
}