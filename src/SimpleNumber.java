import java.io.IOException;
import java.util.Scanner;

public class SimpleNumber {
    public static void main(String[] args) throws IOException {
        int temp, number;
        boolean numbersIsPrime = true;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            number = scanner.nextInt();


            for (int x = 2; x <= number / 2; x++) {
                temp = number % x;
                if (temp == 0) {
                    numbersIsPrime = false;
                    break;
                }
            }

            if (numbersIsPrime)
                System.out.println(number + " is simple");
            else
                System.out.println(number + " isn't simple");
        }
    }
}
