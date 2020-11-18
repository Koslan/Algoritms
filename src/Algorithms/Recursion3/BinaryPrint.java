package Algorithms.Recursion3;

public class BinaryPrint {

    /*
    Реализуйте с помощью рекурсии и итеративным методом
    вывод десятичного числа n введенного пользователем
    на экран в двоичной системе счисления.
    */

    public static void main(String[] args) {
        System.out.println(printIterative(1023));
        System.out.println(printIterative(1024));
        System.out.println(printIterative(24));
        System.out.println(printIterative(1));
        System.out.println(printIterative(0));
        System.out.println(printIterative(291_321));
    }

    public static String printIterative(int n) {
        if (n == 0 || n == 1)
            return  "" + n;

        StringBuffer result = new StringBuffer();
        int power = 1;

        while(power < n)
            power *= 2;


        int n2 = n;
        int cur = 0;
        result.append(n2 > 0 ? 0 : 1);

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
}
