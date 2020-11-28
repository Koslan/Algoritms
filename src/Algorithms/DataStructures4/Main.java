package Algorithms.DataStructures4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private ListNode[] array;
    private int first = -1;
    private int last = -1;
    private int size;

    /*
    Реализация должна поддерживать операции
        “добавление в начало”,
        “добавление в конец”,
        “добавление после указанного элемента”,
        “получение элемента под номером”.

     */


    Main(int arraySize) {
        array = new ListNode[arraySize];
    }

    public int getFreePlaceInArray() {
        for (int i = 0; i < array.length; i++)
            if (array[i] == null)
                return i;

        return -1;
    }

    public void addFirst(int value) throws Exception {
        ListNode elem = new ListNode(value);

        int index = getFreePlaceInArray();

        if (size > array.length - 1)
            throw new Exception("error: index > list.size");

        if (index > array.length - 1 || array.length < 0)
            throw new Exception("error: incorrect value");

        if (size == 0) {
            last = index;
            first = index;
            array[index] = elem;
            elem.setIndex(index);
        } else {
            elem.setNext(array[first].getIndex());
            array[index] = elem;
            first = index;
            elem.setIndex(index);
        }
        size++;
    }

    public void addLast(int value) throws Exception {
        ListNode elem = new ListNode(value);

        int index = getFreePlaceInArray();

        if (size > array.length - 1)
            throw new Exception("error: index > list.size");

        if (index > array.length - 1 || array.length < 0)
            throw new Exception("error: incorrect value");

        if (size == 0) {
            last = index;
            first = index;
            array[index] = elem;
            elem.setIndex(index);
        } else {
            elem.setPrev(array[last].getIndex());
            array[index] = elem;
            elem.setIndex(index);
            last = index;
        }
        size++;
    }

    public void addAfterIndex(int prevIndex, int value) throws Exception {
        if (size > array.length - 1)
            throw new Exception("error: index > list.size");

        if (prevIndex > array.length - 1 || size < 0)
            throw new Exception("error: incorrect value");


        ListNode result = array[first];
        for (int i = 0; i <= prevIndex; i++)
            result = array[result.getNext()];

        ListNode elem = new ListNode(value);
        int index = getFreePlaceInArray();

        if (size == 0) {
            last = index;
            first = index;
            array[index] = elem;
        } else {
            elem.setPrev(result.getIndex());
            elem.setNext(result.getNext());
            array[index] = elem;

            array[elem.getPrev()].setNext(elem.getIndex());
            array[elem.getNext()].setPrev(elem.getIndex());
        }

        elem.setIndex(index);
        size++;
    }


    public ListNode removeElemByIndex(int index) throws Exception {
        if (size == 0)
            return null;

        if (index > array.length - 1 || size < 0)
            throw new Exception("error: incorrect value");

        if (index == 1) {
            ListNode elem = array[first];
            first = -1;
            last = -1;
            size--;

            return elem;
        } else {
            int elemIndex = first;
            for (int i = 0; i < index; i++)
                elemIndex = array[first].getNext();

            ListNode elem = array[elemIndex];

            array[elem.getPrev()].setNext(
                    elem.getNext()
            );
            array[elem.getNext()].setPrev(
                    elem.getPrev()
            );



            size--;

            return elem;
        }
    }

    public static void printValue(String value) {
        System.out.printf("%4s|", value);
    }


    public void print() throws Exception {

        // prev
        System.out.print(" p|");
        for (int i = 0; i < size; i++)
            printValue("" + (array[i] != null ? array[i].getPrev() : -1));

        System.out.println();
        System.out.print("--|");
        for (int i = 0; i < size; i++)
            printValue("----");
        System.out.println();

        // value
        System.out.print(" v|");
        for (int i = 0; i < size; i++)
            printValue("" + (array[i] != null ? array[i].getValue() : -1));

        System.out.println();
        System.out.print("--|");
        for (int i = 0; i < size; i++)
            printValue("----");
        System.out.println();


        // next
        System.out.print(" n|");
        for (int i = 0; i < size; i++)
            printValue("" + (array[i] != null ? array[i].getNext() : -1));

        System.out.println();
        System.out.print("--|");
        for (int i = 0; i < size; i++)
            printValue("----");

        //array index
        System.out.println();
        System.out.print(" i|");
        for (int i = 0; i < size; i++) {
            printValue("" + i);
        }
    }


    public static String console(String str, Main list) throws Exception {
        if (str.length() > 5 && str.substring(0, 4).equals("addf")) {
            String pS = str.substring(5, str.length());
            int pars = Integer.parseInt(pS);
            list.addFirst(pars);
        } else if (str.length() > 5 && str.substring(0, 4).equals("addl")) {
            String pS = str.substring(5, str.length());
            int pars = Integer.parseInt(pS);
            list.addLast(pars);
        } else if (str.length() > 5 && str.substring(0, 3).equals("get")) {
            String pS = str.substring(4,  str.length());
            int pars = Integer.parseInt(pS);
            //list.getValueByIndex(pars);
        } else if (str.length() > 5 && str.substring(0, 6).equals("remove")) {
            String pS = str.substring(7,  str.length());
            int pars = Integer.parseInt(pS);
            list.removeElemByIndex(pars);
        } else if (str.length() > 4 && str.substring(0, 5).equals("print")) {
            System.out.println("first elem id:" + list.first);
            System.out.println("last elem id:" + list.last);
            list.print();
        }


        return "";

    }


    public static void main(String[] args) throws Exception {
        int n = 8;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("set array capacity");
        n = Integer.parseInt(br.readLine());
        Main list = new Main(n);


        while (true) {

            System.out.println(console(br.readLine(), list));
        }

    }


}


class ListNode {
    private int prev;
    private int next;
    private int value;
    private int index;

    public ListNode(int prev, int next, int value, int index) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ListNode(int value) {
        this.value = value;
    }


    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
