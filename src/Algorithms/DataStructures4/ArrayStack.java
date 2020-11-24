package Algorithms.DataStructures4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayStack {
    private int[] stack;
    private int top;
    private int stackSize;

    public ArrayStack(int stackSize) {
        this.stackSize = stackSize;
        this.top = 0;
        this.stack = new int[stackSize];
    }

    public int stackSize() {
        return stackSize;
    }

    public boolean push(int value) {
        if (top == stack.length)
            return false;

        stack[top] = value;
        this.top++;

        return true;
    }

    public int pop() throws Exception {

        if (top < 1)
            throw new Exception("error: stack is empty");

        int value = stack[top - 1];
        this.top--;

        return value;
    }

    public int capacity() {
        return top + 1;

    }


    public boolean clear() {
        if (top < 0)
            return false;
        this.top--;

        return true;
    }


    public static void printValue(String value) {

        System.out.printf("%4s|", value);
    }

    public void printStack() {
        for (int i = 0; i < stackSize; i++)
            printValue("" + stack[i]);

        System.out.println();
        for (int i = 0; i < stackSize; i++)
            printValue("----");

        System.out.println();

        for (int i = 0; i < stackSize; i++) {
            if(i == capacity() - 1)
                System.out.print(" top|");
            else
                printValue("" + i);


        }
    }


    public static String console(String str, ArrayStack stack) throws Exception {

        if (str.substring(0, 3).equals("pop")) {
            if (stack.capacity() > 1)
                System.out.println("pop value:" + stack.pop());
            else
                System.out.println("stack is empty, you can't pop()");

        } else if (str.substring(0, 3).equals("cle")) {
            if (stack.capacity() > 0)
                stack.clear();
            else
                System.out.println("stack is empty, you can't clear()");

        } else if (str.substring(0, 3).equals("cap")) {
            return "capacity = " + stack.capacity();

        } else if (str.substring(0, 5).equals("print")) {
            stack.printStack();


        } else if (str.substring(0, 4).equals("push")) {
            if (stack.capacity() <= stack.stackSize()) {
                String pS = str.substring(5, str.length());
                int pars = Integer.parseInt(pS);
                stack.push(pars);
            } else {
                System.out.println("stack is full, you can't push");
            }

        }
        return "";

    }


    public static void main(String[] args) throws Exception {
        int n = 3;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("set stack capacity");
        n = Integer.parseInt(br.readLine());
        ArrayStack stack = new ArrayStack(n);

        while (true) {
            System.out.println(console(br.readLine(), stack));
        }

    }

}
