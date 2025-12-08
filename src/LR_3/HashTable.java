package LR_3;

import java.util.ArrayList;
import java.util.LinkedList;

class Pair<K,V> {
    K key;
    V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}


public class HashTable<K, V> {
    private final ArrayList<LinkedList<Pair<K,V>>> table;
    private final int capacity = 100;

    public HashTable() {
        this.table = new ArrayList<LinkedList<Pair<K,V>>>();
        for (int i = 0; i < capacity; i++) {
            this.table.add(new LinkedList<Pair<K,V>>());
        }
    }

    public final int hash(Object object) {
        int hash = Math.abs(object.hashCode());
        int result = hash;
        if (hash >= capacity) {
            int dif = hash - capacity;
            result = capacity;
            while (dif > 0) {
                result = Math.abs(result - dif % 10);
                dif /= 10;
            }
        }
        return result;
    }


    public int size() {
        int result = 0;
        for (LinkedList<Pair<K,V>> list : table) {
            result += list.size();
        }
        return result;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void put(K key, V value) {
        int index = hash(key);
        boolean inserted = false;
        if (table.get(index) == null) {
            this.table.set(index, new LinkedList<Pair<K,V>>());
        }
        for (Pair<K,V> pair : table.get(index)) {
            if (pair.key.equals(key)) {
                pair.value = value;
                inserted = true;
            }
        }
        if (!inserted) this.table.get(index).add(new Pair<K,V>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Pair<K,V>> list = table.get(index);
        if (list.isEmpty()) return null;
        for (Pair<K,V> pair : list) {
            if (pair.key.equals(key)) return pair.value;
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<Pair<K,V>> list = table.get(index);
        if (list.isEmpty()) return;
        if (list.size() == 1) list.removeFirst();
        for (Pair<K,V> pair : list) {
            if (pair.key.equals(key)) {
                list.remove(pair);
                return;
            };
        }
    }

}

class Three {
    public static void main(String[] args) {
        HashTable<String, String> table =  new HashTable<String, String>();
        System.out.println("До внесения элементов:");
        System.out.println(table.isEmpty());
        System.out.println(table.get("j"));

        table.put("j", "Hello");
        table.put("s", "World");
        System.out.println("После внесения элементов:");
        System.out.println(table.get("j"));
        System.out.println(table.size());

        table.put("j", "Goodbye");
        System.out.println("После замены элемента с ключом 'j':");
        System.out.println(table.get("j"));
        System.out.println(table.size());

        table.remove("j");
        System.out.println("После удаления элемента с ключом 'j':");
        System.out.println(table.get("j"));
        System.out.println(table.size());
    }
}