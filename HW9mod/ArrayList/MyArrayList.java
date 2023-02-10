package HW9mod.ArrayList;

public class MyArrayList <T>  {
    transient Object[] arrList;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public MyArrayList() {
        arrList = new Object [DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T value) {
        if (size == arrList.length) {
            Object[] newArrList = new Object[arrList.length * 2];
            System.arraycopy(arrList, 0, newArrList, 0, arrList.length);
            arrList = newArrList;
        }
        arrList[size++] = value;
    }

    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedVal = (T) arrList[index];
        System.arraycopy(arrList, index + 1, arrList, index, size - index - 1);
        size--;
        return removedVal;
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

}
