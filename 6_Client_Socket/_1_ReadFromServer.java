// time.nist.gov
// 13

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

class _1_ReadFromServer{
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("time.nist.gov",13);
        s.setSoTimeout(1500);
        InputStream in =s.getInputStream();
        int ch;
        while((ch=in.read()) != -1){
            System.out.print((char)ch);
        }
        in.close();
        s.close();
    }
}