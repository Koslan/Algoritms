import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {
    public static void main(String[] args) throws IOException {
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();

            String value = "";

            for (int i = line.length() - 1; i >= 0; i--) {
                value += line.charAt(i);
            }
            System.out.println(value);
        }
    }
}
