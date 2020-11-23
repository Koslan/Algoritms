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

    public boolean push(int value) {
        if (top == stack.length)
            return false;

        stack[top] = value;
        this.top++;

        return true;
    }

    public int pop() throws Exception {

        if (top < 0)
            throw new Exception("error: stack is empty");

        int value = stack[top];
        this.top--;

        return value;
    }

    public int capacity() {
        return top + 1;

    }

    public int peek() throws Exception {
        if (top < 0)
            throw new Exception("error: stack is empty");

        int value = stack[top];

        return value;

    }

    public boolean clear() {
        if (top < 0)
            return false;
        this.top--;

        return true;
    }


    public static void printValue(String value) {

        System.out.printf("%4s|", value );
    }

    public void printStack() {
        for(int i = 0; i < top; i++)
            printValue("" + stack[i]);

        System.out.println();
        for(int i = 0; i <= top; i++)
            printValue("----");

        System.out.println();

        for(int i = 0; i < top; i++)
            printValue("" + i);

        System.out.print(" top");
    }


    public static String console(String str, ArrayStack stack) throws Exception {

        if(str.substring(0, 3).equals("pop"))
            stack.pop();

        else if(str.substring(0, 3).equals("cle"))
            stack.clear();

        else if(str.substring(0, 3).equals("cap"))
                return "capacity = "  + stack.capacity();

        else if(str.substring(0, 5).equals("print"))
            stack.printStack();


        else if(str.substring(0, 4).equals("push")) {
            String pS = str.substring(5, str.length());
            int pars = Integer.parseInt(pS);
            stack.push(pars);

        }
                return "";

    }


    public static void main(String[] args) throws Exception {
        int n = 8;
        ArrayStack stack = new ArrayStack(n);

        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(console(br.readLine(), stack));
        }

    }

}
