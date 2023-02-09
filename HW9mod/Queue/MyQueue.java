package HW9mod.Queue;

import HW9mod.LinkedList.MyLinkedList;

public class MyQueue <T> {

    private final MyLinkedList <T> queue;

    public MyQueue (){
        queue = new MyLinkedList<>();
    }

    public void add (T value) {
        queue.add(value);
    }

    public void clear() {
        queue.clear();
    }

    public int size() {
        return queue.size();
    }

    public T peek() {
        return queue.get(0);
    }

    public T poll() {
        peek();
        return queue.remove(0);
    }

}
