import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestTaskUpiteck {

    public static void main(String[] args) throws IOException {

        while(true) {
            BufferedReader br = new BufferedReader(new FileReader("/home/koslan/Idea-workspace/test_tasks/test/text.csv"));

            Scanner scanner = new Scanner(System.in);

            int y = scanner.nextInt();
            int x = scanner.nextInt();

            int iter = 0;

            String line = "";
            boolean message = true;

            while ((line = br.readLine()) != null) {
                ++iter;
                if (iter == y) {
                    String[] result = line.split(",");
                    if (result.length + 1 > x) {
                        System.out.println(result[x]);
                        message = false;
                        break;
                    }
                }
            }

            if (message)
                System.out.println("invalid value");
        }
    }
}
