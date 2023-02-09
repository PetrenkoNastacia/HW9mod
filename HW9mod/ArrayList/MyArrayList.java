package HW9mod.ArrayList;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList <T>  {
    transient Object[] arrList;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int index;

    public MyArrayList() {
        arrList = new Object [DEFAULT_CAPACITY];

    }

    public boolean add(T value) {
        int freeSlot = -1;
        for (int i = 0; i < arrList.length; i++) {
            if (arrList[i] == null) {
                freeSlot = i;
                break;
            }
        }
        if(freeSlot != -1){
            arrList[freeSlot] = value;
        } else {
            arrList = Arrays.copyOf(arrList, arrList.length * 2);
            add(value);
        }
        return true;
    }

    public T remove(int index) {
        T removedEl = (T) arrList[index];
        for (int i = index + 1; i < arrList.length; i++) {
            removedEl = null;
            Objects.checkIndex(index, size());
            System.arraycopy(arrList, index + 1, arrList, index, arrList.length - index - 1);
            break;
        }
        return removedEl;
    }

    public void clear() {
        Arrays.fill(arrList, null);
    }

    public int size() {
        int count = 0;
        for (Object o : arrList)
            if (o != null) {
                count++;
                size = count;
            }
        return size;
    }

    public T get(int index) {
        Objects.checkIndex(index, size());
        return (T) arrList[index];
    }

}
