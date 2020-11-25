package Algorithms.DataStructures4;

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
        } else {
            elem.setNextElem(this.firstElem);
        }

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

    public int getValueByIndex(int index) {
        int value = 0;

        return value;
    }

    public SinglyLinkedListNode getElemByIndex(int index) throws Exception {
        int value = 0;

        if(index > size)
            throw new Exception("error: index > list.size");

        SinglyLinkedListNode result = firstElem;
        for(int i = 0; i <= index; i++)
            result = firstElem.getNextElem();

        return result;
    }


    public static void main(String[] args) {

    }
}
