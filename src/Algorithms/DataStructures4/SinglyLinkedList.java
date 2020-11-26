package Algorithms.DataStructures4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class SinglyLinkedList {
    /*
    Реализуйте односвязный список и операции
    “добавление в начало”,
    “добавление в конец”,
    “добавление после указанного элемента”,
    “получение элемента под номером”,
    “извлечение выбранного элемента из списка”.
     */

    private SinglyLinkedListNode firstElem;
    private SinglyLinkedListNode lastElem;
    private int size = 0;


    public void addFirst(int value) {
        SinglyLinkedListNode elem = new SinglyLinkedListNode(null, value);

        if(size == 0) {
            lastElem = elem;
        } else {
            elem.setNextElem(this.firstElem);
        }

        firstElem = elem;
        elem.setValue(value);
        size++;
    }

    public void addLast(int value) {
        SinglyLinkedListNode elem = new SinglyLinkedListNode(null, value);

        if(size == 0) {
            firstElem = elem;
            lastElem = elem;
        }

        lastElem.setNextElem(elem);
        lastElem = elem;
        elem.setValue(value);
        size++;
    }

    public void addAfter(SinglyLinkedListNode link, int value) {
        // current   1 --> 3
        SinglyLinkedListNode one = link;
        SinglyLinkedListNode three = link.getNextElem();
        SinglyLinkedListNode two = new SinglyLinkedListNode(three, value);
        one.setNextElem(two);
        // current   1 --> 2 --> 3
        size++;
    }

    public int getValueByIndex(int index) throws Exception {
        int value = 0;

        if(index > size)
            throw new Exception("error: index > list.size");

        SinglyLinkedListNode result = firstElem;
        for(int i = 0; i < index; i++)
            result = result.getNextElem();

        value = result.getValue();

        return value;
    }

    public SinglyLinkedListNode getElemByIndex(int index) throws Exception {
        if(index > size)
            throw new Exception("error: index > list.size");

        SinglyLinkedListNode result = firstElem;
        for(int i = 0; i <= index; i++)
            result = firstElem.getNextElem();

        return result;
    }

    public SinglyLinkedListNode removeElemByIndex(int index) throws Exception {
        if(size == 0)
            return null;

        if(index == 0) {
            SinglyLinkedListNode elem = firstElem;
            firstElem = firstElem.getNextElem();

            if(size == 1) {
                lastElem = null;
                firstElem = null;
            }
            size--;
            return elem;

        }

        if(index == size)
            return lastElem;

        if(index > size)
            throw new Exception("error: index > list.size");

        SinglyLinkedListNode curr = firstElem;
        SinglyLinkedListNode prev = firstElem;
        for(int i = 1; i <= index; i++) {
            prev = firstElem;
            curr = firstElem.getNextElem();
        }

        prev.setNextElem(curr.getNextElem());
        size--;


        return curr;
    }



    public static void printValue(String value) {
        System.out.printf("%4s|", value);
    }

    public void print() throws Exception {
        for (int i = 0; i < size; i++)
            printValue("" + getValueByIndex(i));

        System.out.println();
        for (int i = 0; i < size; i++)
            printValue("----");

        System.out.println();

        for (int i = 0; i < size; i++) {
                printValue("" + i);
        }
    }


    public static String console(String str, SinglyLinkedList list) throws Exception {
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
            list.getValueByIndex(pars);
        } else if (str.length() > 5 && str.substring(0, 6).equals("remove")) {
            String pS = str.substring(7,  str.length());
            int pars = Integer.parseInt(pS);
            list.removeElemByIndex(pars);
        } else if (str.length() > 4 && str.substring(0, 5).equals("print")) {
            list.print();
        }


        return "";

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        SinglyLinkedList list = new SinglyLinkedList();

        while (true) {
            System.out.println(console(br.readLine(), list));
        }
    }
}
