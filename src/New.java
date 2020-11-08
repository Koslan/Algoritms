import java.util.Arrays;

public class New {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6};
        //int[] array = {6, 5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(array));

        int counter = 0;

        for (int j = array.length - 1; j > 0 ; j--) {
            int key = array[j];
            int i = j + 1;
            while ((i < array.length) && (array[i] > key)) {
                array[i - 1] = array[i];
                i++;
                counter++;
            }
            array[i - 1] = key;
        }




        System.out.println(Arrays.toString(array));
        System.out.println("counter: " + counter);


    }
}
