package Algorithms.Hash;

import java.util.Formatter;
import java.util.Hashtable;
import java.util.LinkedList;

public class SeparateChaining {

    /*
    Реализуйте собственную хеш таблицу использующую метод цепочек для разрешения коллизий,
        которая при создании принимает M (максимальное число элементов, которые она должна хранить)
        и в качестве хеш-функции использует h(Key) = (7* Key + 11) mod M.
    Хеш-таблица должна поддерживать
        вставку {Key, Value},
        поиск элемента по ключу Key
        и удаление элемента по Key.
     */

    public static void main(String[] args) {
        HashTable ht = new HashTable(8);
        ht.add(3, 11);
        ht.add(32, 111);
        ht.add(31, 112);
        ht.add(4, 121);
        ht.add(1, 141);
        ht.add(2, 151);
        ht.add(8, 161);

        ht.print();


        ht.removeElem(32);
        ht.print();
        ht.removeElem(1);
        ht.print();
    }
}


class HashTable {
    int M;
    Object[] table;

    public void print() {
        System.out.println("Print HashTable  size =" + M);
        for(int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                System.out.printf("%4s| null", "");
                System.out.println();
                System.out.printf("%4s| null", i);
                System.out.println();
            } else {
                LinkedList<Node> list = (LinkedList<Node>) table[i];
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                Formatter fm = new Formatter(sb);

                for(Node node : list) {
                    sb.append(String.format("%4s|", node.getKey()));
                    sb2.append(String.format("%4s|", node.getValue()));
                }
                System.out.printf("%4s|", "");
                System.out.println(sb.toString());
                System.out.printf("%4s|",  i);
                System.out.println(sb2.toString());
            }
        }
    }

    public HashTable(int m) {
        M = m;
        table = new Object[m];
    }

    public int hash(int key) {
        return (7 * key + 11) % M;
    }

    public void add(Integer key, Integer value) {
        int hash = hash(key);
        Node node = new Node(key, value);

        if(table[hash] == null) {
            LinkedList<Node> list = new LinkedList<>();
            list.add(node);
            table[hash] = list;
        } else {
            LinkedList<Node> list = (LinkedList<Node>) table[hash];
            list.add(node);
        }
    }

    public Integer getElem(Integer key) {
        int hash = hash(key);

        if(table[hash] != null) {
            LinkedList<Node> list = (LinkedList<Node>) table[hash];
            for(Node node : list) {
                if(node.getKey() == key) return node.getValue();
            }
        }

        return null;
    }

    public void removeElem(Integer key) {
        int hash = hash(key);

        if(table[hash] != null) {
            LinkedList<Node> list = (LinkedList<Node>) table[hash];
            for(Node node : list) {
                if(node.getKey() == key) {
                    list.remove(node);
                    break;
                }
            }
        }
    }
}

class Node {
    Integer key;
    Integer value;

    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
