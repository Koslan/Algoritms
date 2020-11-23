package Algorithms.DataStructures4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int queueSize;

    public ArrayQueue(int queueSize) {
        this.queueSize = queueSize;
        this.head = 0;
        this.queue = new int[queueSize];
    }

    public boolean add(int value) {
        if (head == queue.length)
            return false;

        queue[head] = value;
        this.head++;

        return true;
    }

    public int remove() throws Exception {

        if (head < 0)
            throw new Exception("error: queue is empty");

        int value = queue[head];
        this.head--;

        return value;
    }

    public int capacity() {
        return head + 1;

    }


    public boolean clear() {
        if (head < 0)
            return false;
        this.head--;

        return true;
    }


    public static void printValue(String value) {

        System.out.printf("%4s|", value );
    }

    public void printStack() {
        for(int i = 0; i < head; i++)
            printValue("" + queue[i]);

        System.out.println();
        for(int i = 0; i <= head; i++)
            System.out.print("----");

        System.out.println();

        for(int i = 0; i < head; i++){
            if(i == head) {
                System.out.print("|head|");
            } else if(i == tail) {
                System.out.print("|tail|");
            } else {
                printValue("" + i);
            }
        }
    }


    public static String console(String str, ArrayQueue queue) throws Exception {

        if(str.substring(0, 3).equals("pop"))
            queue.remove();

        else if(str.substring(0, 3).equals("cle"))
            queue.clear();

        else if(str.substring(0, 3).equals("cap"))
            return "capacity = "  + queue.capacity();

        else if(str.substring(0, 5).equals("print"))
            queue.printStack();


        else if(str.substring(0, 4).equals("push")) {
            String pS = str.substring(5, str.length());
            int pars = Integer.parseInt(pS);
            queue.add(pars);

        }
        return "";

    }


    public static void main(String[] args) throws Exception {
        int n = 8;
        ArrayQueue queue = new ArrayQueue(n);

        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(console(br.readLine(), queue));
        }

    }
}
