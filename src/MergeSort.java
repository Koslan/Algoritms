import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] inputArray = {1, 3, 19, -99, 0, 1, -41, 11, 2232, 18};

        mergeArray(inputArray);


        int[][] multiArray = {{1, 3, 19},{ -99, 0, 1},{ -41, 11, 2232, 18}};
        mergeMultiArray(multiArray);
    }

    public static void mergeArray(int[] mas) {
            mergeSort(mas, 0, mas.length - 1);
            System.out.println(Arrays.toString(mas));
    }

    public static void mergeMultiArray(int[][] mas) {
        for(int i = 0; i < mas.length; i++) {
            mergeSort(mas[i], 0, mas[i].length - 1);
            System.out.println(Arrays.toString(mas[i]));
        }

    }

    public static void mergeSort(int A[], int p, int r) {
        if (p < r) {
            int m = (p + r) / 2;

            mergeSort(A, p, m);
            mergeSort(A, m+1, r);
            merge(A, p, m, r);
        }
    }

    public static void merge(int A[], int p, int q, int r)
    {
        int n1 = q - p + 1; // size subArray1
        int n2 = r - q;  // size subArray2

        int L[] = new int[n1];
        int R[] = new int[n2];


        for (int i = 0; i < n1; ++i) { //Copy data to temp array1
            L[i] = A[p + i];
        }
        for (int i = 0; i < n2; ++i) { //Copy data to temp array2
            R[i] = A[q + i + 1];
    }
        int left = 0;
        int right = 0;
        int k = p;

        for(; left < n1 && right < n2; k++) {
            if(L[left] <= R[right]){
                A[k] = L[left];
                left++;
            } else {
                A[k] = R[right];
                right++;
            }
        }
        //Copy remaining elements of L[] if any
        while (left < n1) {
            A[k] = L[left];
            left++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (right < n2) {
            A[k] = R[right];
            right++;
            k++;
        }
    }
}
