package HW9mod.Stack;

import HW9mod.ArrayList.MyArrayList;

public class MyStack <T> {

    private final MyArrayList<T> stack;

    public MyStack() {
        stack = new MyArrayList<>();
    }

    public void push(T value) {
        stack.add(value);
    }

    public T remove(int index) {
        return stack.remove(index);
    }

    public void clear() {
        stack.clear();
    }

    public int size() {
        return stack.size();
    }

    public T peek(){
         return stack.get(size()-1);
    }

    public T pop() {
        peek();
        return remove(size()-1);
    }

    @Override
    public String toString() {
        return String.valueOf(stack);
    }

}
