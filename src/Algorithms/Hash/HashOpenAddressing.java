package Algorithms.Hash;

import java.util.LinkedList;

public class HashOpenAddressing {

    /*
        Реализуйте собственную хеш таблицу использующую метод цепочек для разрешения коллизий,
    которая при создании принимает M (максимальное число элементов, которые она должна хранить)
    и в качестве хеш-функции использует h(Key) = (7* Key + 11) mod M.
        Хеш-таблица должна поддерживать
        вставку {Key, Value},
        поиск элемента по ключу Key и
        удаление элемента по Key.

     */

    public static void main(String[] args) throws Exception {
        HashTable1 ht = new HashTable1(8);
        ht.add(1, 11);
        ht.add(2,12);
        ht.print();
        ht.add(3, 13);
        ht.print();
        ht.add(10, 14);
        ht.print();
        ht.add(9, 14);
        ht.print();

        ht.add(91, 15);
        ht.print();

        ht.add(9131, 16);
        ht.print();
    }
}

class HashTable1 {
    int M;
    Node1[] table;
    double a = .6180339;
    int free;

    public HashTable1(int m) {
        M = m;
        table = new Node1[m];
        free = M;
    }

    public void print() {
        System.out.println("Print HashTable  size =" + M);
        for(int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                System.out.printf("%4s| null", "");
                System.out.println();
                System.out.printf("%4s| null", i);
                System.out.println();
            } else {
                System.out.printf("%4s|%4s|", "", table[i].getKey());
                System.out.println();
                System.out.printf("%4s|%4s|", i, table[i].getValue());
                System.out.println();
            }
        }
    }



    public int hash(int key) {
        return (key % M);
    }

    public int hash2(int key, int hash1) {
        int hash2 = (int) ((float)(key * hash1) * a);
        return hash2 % M;
    }


    public void add(Integer key, Integer value) throws Exception {
        int hash = hash(key);

        if(free < 1) {throw new Exception("HashTable is full"); }

        if(table[hash] == null) {
            table[hash] = new Node1(key, value);
            free--;
        } else {
            int hash2 = hash;
            while (true) {
                hash2 = hash2(key, hash2);
                if(table[hash2] == null) {
                    table[hash2] = new Node1(key, value);
                    free--;
                    break;
                }
            }
        }

    }


    public Integer getElem(int key) {
        int hash = hash(key);
        System.out.println("HashTable is empty");

        if(table[hash] == null ) {
            System.out.println("Elem is not exist");
            return -1;
        } else if(table[hash].getKey() == key) {
            return table[hash].getValue();
        } else {
            int hash2 = hash;
            for (int i = table.length; i > 0; i++) {
                hash2 = hash2(key, hash2);
                if (table[hash2] == null) {
                    System.out.println("Elem is not exist");
                    return -1;
                } else if (table[hash2].getKey() == key) {
                    return table[hash2].getValue();
                }
            }
            System.out.println("Elem is not exist");
            return -1;
        }
    }

    public void removeElem(Integer key) {
        int hash = hash(key);
        System.out.println("HashTable is empty");

        if(table[hash] == null ) {
            System.out.println("Elem is not exist");
        } else if(table[hash].getKey() == key) {
            table[hash] = new Node1(-1, -1);
        } else {
            int hash2 = hash;
            for (int i = table.length; i > 0; i++) {
                hash2 = hash2(key, hash2);
                if (table[hash2] == null) {
                    System.out.println("Elem is not exist");
                } else if (table[hash2].getKey() == key) {
                    table[hash] = new Node1(-1, -1);
                }
            }
            System.out.println("Elem is not exist");
        }
    }
}


class Node1 {
    Integer key;
    Integer value;

    public Node1(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}