import java.util.Arrays;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line1 = in.nextLine();
        String line2 = in.nextLine();
        int[] one = Arrays.stream(line1.split(" "))
                .map(Integer::parseInt)
                .mapToInt(i->i)
                .toArray();


        int[] two = Arrays.stream(line2.split(" "))
                .map(Integer::parseInt)
                .mapToInt(i->i)
                .toArray();


        int rSum = one[2] + two[2];
        int distance = (int) (Math.sqrt((two[0] - one[0])*(two[0] - one[0]))  + ((two[1] - one[1]) * (two[1] - one[1])));

        if (rSum > distance) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    /*public static void main(String[] args) {
        String line;

      	DataInputStream in = new DataInputStream(System.in);

        String size = in.readLine();
        List<String> value = Arrays.asList(in.readLine().split(" "));
        Collections.reverse(value);

        for(String s: value) {
            System.out.print(s + " ");
        }
    }*/

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line1 = in.nextLine();
        String line2 = in.nextLine();

        List<String> list1 = Arrays.asList(line1.split(" "));
        List<String> list2 = Arrays.asList(line2.split(" "));

        boolean b = true;

        for(String s : list1) {
            if(!list2.contains(s)){
                b = false;
            }
        }

        if(b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }*/
}
