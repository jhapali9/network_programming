// dict.org
// 2628

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

class _2_WriteToServer{
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("dict.org",2628);
        s.setSoTimeout(1500);
        OutputStream out = s.getOutputStream();

        String outputText = "Close\r\n";
        out.write(outputText.getBytes());

        out.flush();

        s.close();
    }
}