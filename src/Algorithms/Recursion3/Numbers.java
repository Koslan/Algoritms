package Algorithms.Recursion3;

public class Numbers {
/*
Программу печатающую числа от n до 1, затем 0 и затем числа от 1 до n,
где n - переменная.
Например для n = 3 на экране должно быть что-то вроде
(разделитель используйте произвольный):
3,2,1,0,1,2,3 (20 баллов)
*/

    public static void main(String[] args) {
        recursion1(10);
    }

    public static void recursion1(int n) {
        int m = n;
        boolean direction = recursion2(m, n, true);
    }

    public static boolean recursion2(int m, int n, boolean direction) {
        if (m < 1) {
            direction = false;
        }

        if (direction) {
            System.out.print(" " + m);
            recursion2(--m, n, direction);
        }
        if (!direction) {
            if (m > n)
                return true;

            System.out.print(" " + m);
            recursion2(++m, n, direction);
        }
        return false;
    }

}