package Algorithms.Trees6;

import java.util.LinkedList;
import java.util.Random;

public class BinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            Integer n = random.nextInt(300);
            bt.add(n);
            list.add(n);
        }

        System.out.println("Входящая последовательность");

        int i = 0;
        for (Integer v: list)
            System.out.println(i++ + ": " + v);


        System.out.println("--------------");
        System.out.println("Вывод всех узлов дерева подрят");
        bt.printTree();

        System.out.println();
        System.out.println("------");

        System.out.println("Функция подсчета узлов \n" + bt.countTree() + "\n------------------");
        System.out.println("ключи узлов нижнего уровня |значение, растояние до корня|");
        bt.getLowLevelNode();
    }


}

class BinarySearchTree {
    private int size;
    private Node root;

    public Node getRoot() {
        return root;
    }

    public int countTree() {
        return countSubTree(root);
    }

    public int countSubTree(Node root) {
        int result = 1;
        Node node = treeMin(root);
        while (true) {
            node = getNext(root, node);
            if(node != null)
                result++;
            else
                return result;
        }

    }

    //задание 3
    public void getLowLevelNode() {
        StringBuffer b1 = new StringBuffer();
        Node min = treeMin(root);

        while (true) {
            if(min == null) {
                break;
            } else if(min.getLeft() == null && min.getRight() == null) {
                b1.append(min.getValue() + "," + getWay(min) + " | ");
            }
            min = getNext(root, min);
        }

        //System.out.println("lowest node    |value , count to root|");
        System.out.println(b1.toString());

    }

    private int getWay(Node min) {
        return getWayRec(min, 1);
    }

    private int getWayRec(Node node, int i) {
        if(node.getParent() == null)
            return i;
        else
            return getWayRec(node.getParent(), ++i);
    }

    public void printTree() {
        if(root == null) {
            System.out.println("Sorry Tree is Empty");
        } else {
            printNode(treeMin(root));
        }
    }

    private void printNode(Node node)  {
        Node next = getNext(root, node);

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
                newNode.setParent(oldNode);
            }
        } else  if (oldNode.getLeft() != null) {
            addNode(newNode, oldNode.getLeft());
        } else {
            oldNode.setLeft(newNode);
            newNode.setParent(oldNode);
        }

    }


    public Node treeMin(Node node) {
        while(node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public Node getNext(Node root, Node n) {
        if(n.getRight() != null) {
            return treeMin(n.getRight());
        }

        Node p = n.getParent();
        while (p!= null && n == p.getRight()) {
            n = p;
            p = p.getParent();
        }

        return p;
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
