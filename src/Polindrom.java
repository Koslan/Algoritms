import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Polindrom {
    public static void main(String[] args) throws IOException {

        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String line = br.readLine();

            boolean b = true;

            for (int i = 0, j = line.length() - 1; i < line.length(); i++, j--) {
                if (line.charAt(i) != line.charAt(j)) {
                    b = false;
                }
            }

            if (b) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
