package Algorithms.Sorting2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AlternativeCountingSort  {

    private static int[] inputArray = {};


    private static int[] inputArray2 = {};

    private static int[] inputArray3 = {};

    public AlternativeCountingSort() throws FileNotFoundException {
    }

    public static void main(String args[]) throws FileNotFoundException {
    /*int[] inputArray = {1, 3, 19, 19, 0, 0, 1, 41, 11, 2, 32, 18, 500};

    сountingSort(inputArray);

    int[][] multiArray = {{1, 3, 19}, {99, 0, 1}, {41, 11, 2232, 18}};
    multiCountingSort(multiArray);*/


        String fileName1= "/home/koslan/Idea-workspace/test_tasks/test/inputArray1.csv";
        String fileName2= "/home/koslan/Idea-workspace/test_tasks/test/inputArray2.csv";
        String fileName3= "/home/koslan/Idea-workspace/test_tasks/test/inputArray3.csv";
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        File file3 = new File(fileName3);

        int[] intMas1 = getIntArray(file1);
        int[] intMas2 = getIntArray(file2);
        int[] intMas3 = getIntArray(file3);


        long startTime1 = System.currentTimeMillis();
        for(int i = 0; i < 100; i++)
        сountingSort(intMas1);
        long timeSpent1 = System.currentTimeMillis() - startTime1;


        long startTime2 = System.currentTimeMillis();
        for(int i = 0; i < 100; i++)
        сountingSort(intMas2);
        long timeSpent2 = System.currentTimeMillis() - startTime2;


        long startTime3 = System.currentTimeMillis();
        for(int i = 0; i < 100; i++)
        сountingSort(intMas3);
        long timeSpent3 = System.currentTimeMillis() - startTime3;


        System.out.println("программа 1 выполнялась " + timeSpent1 + " миллисекунд" + "\n" + timeSpent1);
        System.out.println("программа 2 выполнялась " + timeSpent2 + " миллисекунд" + "\n" + timeSpent2);
        System.out.println("программа 3 выполнялась " + timeSpent3 + " миллисекунд" + "\n" + timeSpent3);


        System.out.println("size 1 " + intMas1.length);
        System.out.println("size 2 " + intMas2.length);
        System.out.println("size 3 " + intMas3.length);

        System.out.println("max 1 " + getMax(intMas1));
        System.out.println("max 2 " + getMax(intMas2));
        System.out.println("max 3 " + getMax(intMas3));

    }


    public static int[] getIntArray(File file) throws FileNotFoundException {
        Scanner inputStream;
        inputStream = new Scanner(file);
        String line= inputStream.next();
        String[] values = line.split(",");
        int[] mas1 = new int[values.length];

        for(int i = 0; i < values.length; i++){
            mas1[i] = Integer.parseInt(values[i]);
        }

        return mas1;
    }

    public static void сountingSort(int[] mas) {
        //System.out.println(Arrays.toString(
                sort(mas, new int[mas.length], getMax(mas));
    }

    public static void multiCountingSort(int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.println(Arrays.toString(sort(mas[i], new int[mas[i].length], getMax(mas[i]))));
        }

    }


    private static int getMin(int[] inputArray) {
        int result = Integer.MAX_VALUE;
        for (int i : inputArray) {
            result = i < result ? i : result;
        }
        return result;
    }

    private static int getMax(int[] inputArray) {
        int result = Integer.MIN_VALUE;
        for (int i : inputArray) {
            result = i > result ? i : result;
        }
        return result;
    }


    private static int[] sort(int[] inputArray, int[] resultArray, int k) {
        k++;
        int[] C = new int[k];

        for (int i = 0; i < inputArray.length; i++)
            C[inputArray[i]]++;

        for (int i = 0, j = 0; i < C.length; i++) {
            while (C[i] != 0) {
                C[i]--;
                resultArray[j] = i;
                j++;
            }
        }

        return resultArray;
    }
}
