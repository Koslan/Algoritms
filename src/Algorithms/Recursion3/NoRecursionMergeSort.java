package Algorithms.Recursion3;

import java.util.Arrays;

public class NoRecursionMergeSort {
    public static void main(String[] args) {
        int[] inputArray = {1, 3, 19, -99, 0, 1, -41, 11, 2232, 18};
        mergeArray(inputArray);


        int[][] multiArray = {{1, 3, 19},{ -99, 0, 1},{ -41, 11, 2232, 18}};
        mergeMultiArray(multiArray);
    }

    public static void mergeArray(int[] mas) {
        sortMergeNoRecursive(mas);
        System.out.println(Arrays.toString(mas));
    }

    public static void mergeMultiArray(int[][] mas) {
        for(int i = 0; i < mas.length; i++) {
            sortMergeNoRecursive(mas[i]);
            System.out.println(Arrays.toString(mas[i]));
        }

    }

    public static void sortMergeNoRecursive(int[] arr) {
        int n = 1;
        int shift;

        int[] arr2;
        int arr2Size;
        while (n < arr.length) {
            shift = 0;
            while (shift < arr.length) {
                if (shift + n >= arr.length) break;

                arr2Size = (shift + n * 2 > arr.length) ? (arr.length - (shift + n)) : n;
                arr2 = merge(Arrays.copyOfRange(arr, shift, shift + n),
                        Arrays.copyOfRange(arr, shift + n, shift + n + arr2Size));

                for (int i = 0; i < n + arr2Size; ++i) {
                    arr[shift + i] = arr2[i];
                }
                shift += n * 2;
            }
            n *= 2;
        }
    }

    public static int[] merge(int[] L, int[] R) {
        int a = 0;
        int b = 0;
        int size = L.length + R.length;
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            if (b < R.length && a < L.length) {
                if (L[a] > R[b]) result[i] = R[b++];
                else result[i] = L[a++];
            } else if (b < R.length) {
                result[i] = R[b++];
            } else {
                result[i] = L[a++];
            }
        }
        return result;
    }
}
