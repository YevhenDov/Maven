package com.lists;

public class MyStack<T> {
    private static final int DEFAULT_ARRAY_CAPACITY = 10;
    private Object[] stackArray;
    private int size;
    private int top;

    public MyStack() {
        this.top = DEFAULT_ARRAY_CAPACITY - 1;
        stackArray = new Object[DEFAULT_ARRAY_CAPACITY];
    }

    public MyStack(int top) {
        this.top = top - 1;
        stackArray = new Object[top];
    }

    public void push(T t) {
        if (size >= stackArray.length) {
            System.out.println("Stack full");
        } else {
            stackArray[size++] = t;
        }
    }

    public void pop() {

        int index = 0;
        while (stackArray[index] != null) {
            index++;
        }
        top = index;

        stackArray[top - 1] = null;
        top--;
    }

    public void clear() {
        for (int i = top; i >= 0; i--) {
            stackArray[i] = null;
        }
    }

    public int size() {
        return stackArray.length;
    }

    public T peek() {

        int index = 0;
        while (stackArray[index] != null) {
            index++;
        }

        top = index;
        return (T) stackArray[top - 1];
    }

    public T remove(int index) {
        T temp = (T) stackArray[index];
        System.arraycopy(stackArray, index + 1, stackArray, index, size - index - 1);
        size--;
        return temp;
    }

    public T get(int index) {
        T value = (T) stackArray[index];
        return value;
    }

    public void outArray() {
        for (int i = 0; i < stackArray.length; i++) {
            System.out.println(stackArray[i]);
        }
    }
}

