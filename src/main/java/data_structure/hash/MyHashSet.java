package data_structure.hash;

import java.util.Iterator;

public class MyHashSet<E> implements IHashSet<E> {
    private MyHashMap<E, E> hashMap = new MyHashMap<E, E>();


    @Override
    public void add(E key) {
        hashMap.put(key,null);
    }

    @Override
    public void remove(E key) {
        hashMap.remove(key);
    }

    @Override
    public void clear() {
        hashMap.clear();
    }

    @Override
    public boolean contains(E key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public int hash(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        Iterator<MyHashMap<E, E>.Node<E, E>> iterator = hashMap.iterator();
        StringBuilder stringBuilder = new StringBuilder("hashSet{ ");
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next().key + ", ");
        }
        return stringBuilder.append("}").toString();
    }
}
