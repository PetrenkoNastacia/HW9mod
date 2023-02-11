package HW9mod.HashMap;

public class MyHashMap<K, V> {
    private Node<K, V>[] buckets;
    private int size = 0;
    private int capacity = 16;

    public MyHashMap() {
        buckets = new Node[capacity];
    }

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value, null);
        int newNodeIndex = hash(key) % capacity;
        if (buckets[newNodeIndex] == null) {
            buckets[newNodeIndex] = newNode;
            size++;
        } else {
            Node<K, V> existingBucket = buckets[newNodeIndex];
            if (existingBucket.key.equals(key)) {
                while (existingBucket.next != null) {
                    existingBucket = existingBucket.next;
                }
                existingBucket.next = newNode;
                size++;
            } else {
                resize();
                put(key, value);
            }
        }
    }

    public Node<K, V> get(K key) {
        return buckets[hash(key) % capacity];
    }

    public void remove(K key) {
        int hash = hash(key) % capacity;
        buckets[hash] = null;
        size--;
    }

    public void clear() {
        buckets = new Node[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode());
    }

    private void resize() {
        while (true) {
            capacity *= 3;
            Node[] newBuckets = new Node[capacity];

            boolean collision = false;
            for (int i = 0; i < buckets.length; i++)
                if (buckets[i] != null) {
                    int newHash = hash(buckets[i].key) % capacity;
                    if (newBuckets[newHash] != null) {
                        collision = true;
                        break;
                    }
                    newBuckets[newHash] = buckets[i];
                }
            if (!collision) {
                buckets = newBuckets;
                break;
            }
        }
    }

    public static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return key + ", " + value;
        }


    }

}

