package HW9mod.ArrayList;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList <T>  {
    transient Object[] arrList;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public MyArrayList() {
        arrList = new Object [DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T value) {
        for (int i = 0; i < arrList.length; i++) {
            if (size < arrList.length) {
                arrList[size] = value;
                size++;
                break;
            }
        }
        if (size == arrList.length){
                arrList = Arrays.copyOf(arrList, arrList.length * 2);
                arrList[size] = value;
                size++;
            }
        }

    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedEl = (T) arrList[index];
        for (int i = index + 1; i < arrList.length; i++) {
            removedEl = null;
            System.arraycopy(arrList, index + 1, arrList, index, arrList.length - index - 1);
            break;
        }
        return removedEl;
    }

    public void clear() {
        arrList = new Object [DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) arrList[index];
    }

    @Override
    public String toString() {
        if (arrList == null) {
            return " ";
        }
        return Arrays.toString(arrList);
    }

}
