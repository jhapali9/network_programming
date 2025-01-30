import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _10_WebLog {
    public static void main(String[] args) {
        String logFilePath = "path_to_your_log_file.log";

        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the log file: " + e.getMessage());
        }
    }
}

