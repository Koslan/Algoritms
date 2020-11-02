import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

public class Start {
    public static void main(String[] args) throws IOException {
        circleIntersection2();
    }

    public static void circleIntersection2() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] c1 = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .mapToInt(i->i)
                .toArray();

        int[] c2 = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .mapToInt(i->i)
                .toArray();

        int rSum = c1[2] + c2[2];

        double distance1 = Math.pow((c2[1] - c1[1]), 2);
        double distance2 = Math.pow((c2[2] - c1[2]), 2);

        double distance = Math.sqrt(distance1 + distance2);

        if(distance < rSum) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void reverseArray2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<String> list = Arrays.asList(br.readLine().split(" "));

        Collections.reverse(list);


        for(String s : list) {
            System.out.print(s + " ");

        }
    }

    public static void permutation2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list1 = Arrays.asList(br.readLine().split(" "));
        List<String> list2 = Arrays.asList(br.readLine().split(" "));

        boolean b = true;

        if(list1.size() != 11 || list2.size() != 11) {
            b = false;
        }

        for(String s : list1) {
            if(!list2.contains(s)) {
                b = false;
            }
        }

        if(b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void permutation() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list1 = Arrays.asList(br.readLine().split(" "));
        List<String> list2 = Arrays.asList(br.readLine().split(" "));

        Set<String> set = new HashSet<>();
        String[] mas = set.toArray(new String[set.size()]);

        boolean b = true;

        if(list1.size() != list2.size())
            b = false;

        for(String s : list1) {
            if(!list2.contains(s))
                b = false;
        }

        if(b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void circleIntersection() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] circle1 = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .mapToInt(i -> i)
                .toArray();
        int[] circle2 = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .mapToInt(i -> i)
                .toArray();

        int sum = circle1[2] + circle2[2];

        int distance = (int) Math.sqrt(((circle2[1] - circle1[1]) * (circle2[1] - circle1[1])) + ((circle2[2] - circle1[2]) * (circle2[2] - circle1[2])));

        if(sum>distance) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void reverseArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String value = br.readLine();

        List<String> list = Arrays.asList(value.split(" "));
        Collections.reverse(list);

        for(String s : list) {
            System.out.println(s + " ");
        }
    }
}
