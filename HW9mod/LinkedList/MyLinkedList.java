package HW9mod.LinkedList;

public class MyLinkedList<T> {

    static class Node<T> {
        T value;
        MyLinkedList.Node<T> prev;
        MyLinkedList.Node<T> next;

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return " [" +
                    "" + value +
                    ']';
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else if (size ==1) {
            tail.next = newNode;
            newNode.prev = head;
        } else {
            Node<T> current = tail;
            tail = newNode;
            tail.prev = current;
            current.next = tail;
        }
        tail = newNode;
        size++;
    }

    public T remove(int index) {
        if (index >= 0 && index < size) {
            Node<T> node = head;

            if (index == 0) {
                head = node.next;
                node.prev = null;
            } else if (index > 0) {
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
                if (size > 1 && node.prev != null) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
            }
            size--;
            return node.value;
        }
        throw new NegativeArraySizeException();
    }

    public void clear () {
            head = tail = null;
            size = 0;
    }

    public int size () {
            return size;
    }

    public T get(int index) throws IllegalArgumentException {
       Node<T> tempNode = head;
        if (index < 0 || index >= size) {
           throw new IllegalArgumentException("Index out of bound");
       }
       for (int i = 0; i < index; i++) {
           tempNode = tempNode.getNext();
       }
        return tempNode.getValue();
   }

}








