package com.lists;


public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_ARRAY_CAPACITY = 10;
    private Object[] dataArray;
    private int size;

    public MyArrayList() {
        dataArray = new Object[DEFAULT_ARRAY_CAPACITY];
    }

    public MyArrayList(int capacity) {
        dataArray = new Object[capacity];
    }

    public void add(T t) {
        if (size == dataArray.length) {
            growArray();
        }
        dataArray[size++] = t;
    }

    private void growArray() {
        Object[] tempArray = new Object[dataArray.length * 2];
        System.arraycopy(dataArray, 0, tempArray, 0, size - 1);
        dataArray = tempArray;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) dataArray[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException();
        }
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(dataArray, index + 1, dataArray, index, size - index);
        size--;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }

    public Object[] getDataArray() {
        return dataArray;
    }
}
