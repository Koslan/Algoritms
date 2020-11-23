package Algorithms.Recursion3;

public class BinaryPrint {

    /*
    Реализуйте с помощью рекурсии и итеративным методом
    вывод десятичного числа n введенного пользователем
    на экран в двоичной системе счисления.
    */

    public static void main(String[] args) {
        System.out.println("print iterative");
        System.out.println(printIterative(1023));
        System.out.println(printIterative(1024));
        System.out.println(printIterative(24));
        System.out.println(printIterative(1));
        System.out.println(printIterative(0));
        System.out.println(printIterative(291_321));
        System.out.println(printIterative(2));
        System.out.println(printIterative(3));
        System.out.println(printIterative(4));
        System.out.println(printIterative(6));

        System.out.println("print recursion");

        System.out.println(printRecursion(1023));
        System.out.println(printRecursion(1024));
        System.out.println(printRecursion(24));
        System.out.println(printRecursion(1));
        System.out.println(printRecursion(0));
        System.out.println(printRecursion(291_321));
        System.out.println(printRecursion(2));
        System.out.println(printRecursion(3));
        System.out.println(printRecursion(4));
        System.out.println(printRecursion(6));
    }

    public static String printIterative(int n) {
        if (n == 0 || n == 1)
            return  "" + n;

        StringBuffer result = new StringBuffer();
        int power = 1;

        while(power < n)
            power *= 2;

        int n2 = n;
        result.append(n2 > 0 ? "" : 1);

        while(power > 0) {
            if(n2 >= power) {
            result.append(1);
                n2 -= power;
            } else {
                result.append(0);
            }
            power /= 2;
        }
        return result.toString();
    }


    public static String printRecursion(int n) {
        if (n == 0 || n == 1)
            return  "" + n;

        StringBuilder result = new StringBuilder();
        int power = 1;

        while(power < n)
            power *= 2;

        return printRecursion2(n, power, result);
    }

    public static String printRecursion2(int n, int power,  StringBuilder result) {
        if(n >= power) {
            result.append(1);
            n -= power;
        } else {
            result.append(0);
        }
        power /= 2;

        if(power > 0) {
            printRecursion2(n, power, result);
        }

        return result.toString();
    }
}
