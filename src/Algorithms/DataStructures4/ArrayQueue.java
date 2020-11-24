package Algorithms.DataStructures4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int queueCapacity;

    public ArrayQueue(int queueCapacity) {
        this.queueCapacity = queueCapacity;
        this.head = 0;
        this.tail = 0;
        this.queue = new int[queueCapacity];
    }

    public boolean add(int value) throws Exception{
        int tailCandidate = (tail + 1) % queueCapacity;
        if(tailCandidate  == head)
            throw new Exception("error: queue is full");

        queue[tail] = value;
        tail = tailCandidate;

        return true;
    }

    public int remove() throws Exception {

        if (head == tail)
            throw new Exception("error: queue is empty");
        head = (head + 1) % queueCapacity;
        return queue[head];
    }

    public int size() {
        return (tail - head + queueCapacity) % queueCapacity;
    }

    public int capacity() {
        return queueCapacity;
    }


    public boolean clear() {
        tail = head;
        return true;
    }


    public static void printValue(String value) {

        System.out.printf("%4s|", value );
    }

    public void printStack() {
        for(int i = 0; i < queueCapacity; i++)
            printValue("" + queue[i]);

        System.out.println();
        for(int i = 0; i < queueCapacity; i++)
            System.out.print("-----");

        System.out.println();

        for(int i = 0; i < queueCapacity; i++){
            if(i == head) {
                System.out.print("head|");
            } else if(i == tail) {
                System.out.print("tail|");
            } else {
                printValue("" + i);
            }
        }
    }


    public static String console(String str, ArrayQueue queue) throws Exception {

        if (str.substring(0, 3).equals("rem")) {
            if (queue.size() > 1)
                System.out.println("remove value:" + queue.remove());
            else
                System.out.println("queue is empty, you can't pop()");

        } else if (str.substring(0, 3).equals("cle")) {
            if (queue.size() > 0)
                queue.clear();
            else
                System.out.println("queue is empty, you can't clear()");

        } else if (str.substring(0, 3).equals("cap")) {
            return "capacity = " + queue.size();

        } else if (str.substring(0, 5).equals("print")) {
            queue.printStack();


        } else if (str.substring(0, 3).equals("add")) {
            int size = queue.size();
            int capacity = queue.capacity();
            if ( size < capacity) {
                String pS = str.substring(4, str.length());
                int pars = Integer.parseInt(pS);
                queue.add(pars);
            } else {
                System.out.println("queue is full, you can't push");
            }

        }
        return "";
    }



    public static void main(String[] args) throws Exception {
        int n = 8;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("set queue capacity");
        n = Integer.parseInt(br.readLine());
        ArrayQueue queue = new ArrayQueue(n);


        while (true) {

            System.out.println(console(br.readLine(), queue));
        }

    }
}
