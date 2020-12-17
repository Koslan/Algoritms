package Algorithms.Trees6;

import java.util.Random;

public class BinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        Random random = new Random();

        for (int i = 0; i < 15; i++)
            bt.add(random.nextInt(300));

        bt.printTree();

    }


}

class BinarySearchTree {
    private int size;
    private Node root;

    public void printTree() {
        if(root == null) {
            System.out.println("Sorry Tree is Empty");
        } else {
            printNode(root);
        }
    }

    private void printNode(Node node)  {
        Node next = next(node);

        if(next == null) {
            System.out.print(node.getValue());
        } else {
            System.out.print(node.getValue()+ " , ");
            printNode(next);
        }
    }

    public void add(int value) {
        Node node = new Node(value);

        if (root == null)
            root = node;
        else
            addNode(node, root);

        this.size++;
    }


    private void addNode(Node newNode, Node oldNode) {
        if (newNode.getValue() >= oldNode.getValue()) {
            if (oldNode.getRight() != null) {
                addNode(newNode, oldNode.getRight());
            } else {
                oldNode.setRight(newNode);
            }
        } else  if (oldNode.getLeft() != null) {
            addNode(newNode, oldNode.getLeft());
        } else {
            oldNode.setLeft(newNode);
        }

    }

    private Node findMin(Node node) {
        Node next = node.getLeft();

        if (next == null) {
            return node;
        }

        return findMin(next);
    }

    public Node getMinNodeInTree() {
        return findMin(root);
    }

    public Node next(Node node) {
        if (node.getRight() == null) {
            return node.getParent();
        }

        return findMin(node.getParent().getRight());
    }

}

class Node {
    private int value;
    private Node left;
    private Node right;
    private Node parent;

    public Node(int value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
