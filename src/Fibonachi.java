import java.util.Scanner;

public class Fibonachi {
    public static void main(String args[]) {
        int first = 1;
        int second = 1;

        int next = 0;


        System.out.println(first);
        System.out.println(second);

        for(int i = 0; i < 20; i++) {
            next = first + second;
            System.out.println(next);
            first = second;
            second = next;
        }

    }
}
