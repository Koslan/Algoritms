package Algorithms.DataStructures4;

public class SinglyLinkedListNode {

    private SinglyLinkedListNode nextElem;
    private int value;

    public SinglyLinkedListNode(SinglyLinkedListNode link, int value) {
        this.nextElem = link;
        this.value = value;
    }

    public SinglyLinkedListNode getNextElem() {
        return nextElem;
    }

    public int getValue() {
        return value;
    }

    public void setNextElem(SinglyLinkedListNode link) {
        this.nextElem = link;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
