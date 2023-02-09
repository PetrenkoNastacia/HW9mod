package HW9mod.HashMap;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class MyHashMap<K,V> {

    Object [] arr;

    public MyHashMap(){
        arr = new Object [100000];
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = (int) (100000.0 * new Random(hash).nextDouble());
        System.out.println("key = " + key);
        System.out.println("hash = " + hash);
        System.out.println("index = " + index);
        arr[index] = value;
    }

    public void remove(K key) {
        int hash = key.hashCode();
        int index = (int) (100000.0 * new Random(hash).nextDouble());
        arr[index] = null;
    }

    public void clear() {
        Arrays.fill(arr,null);
    }

    public int size() {
        int count = 0;
        count += Arrays.stream(arr).filter(Objects::nonNull).count();
        return count;
    }

    public V get(K key){
        int hash = key.hashCode();
        int index = (int) (100000.0 * new Random(hash).nextDouble());
        return (V) arr[index];
    }

}

