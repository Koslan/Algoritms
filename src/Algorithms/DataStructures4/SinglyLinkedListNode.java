package Algorithms.DataStructures4;

public class SinglyLinkedListNode {

    private SinglyLinkedListNode link;
    private int value;

    public SinglyLinkedListNode(SinglyLinkedListNode link, int value) {
        this.link = link;
        this.value = value;
    }

    public SinglyLinkedListNode getLink() {
        return link;
    }

    public int getValue() {
        return value;
    }
}
