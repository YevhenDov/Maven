package com.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyStackTest {
    MyStack<Integer> myStack = new MyStack<Integer>();

    @Test
    public void push() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        Integer expectedValue = 4;
        assertEquals(expectedValue, myStack.get(3));
    }

    @Test
    public void pop() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        myStack.pop();
        Integer expectedValue = null;
        assertEquals(expectedValue, myStack.get(3));
    }

    @Test
    public void clear() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        myStack.clear();
        Integer expectedValue = null;
        assertEquals(expectedValue, myStack.get(0));
    }

    @Test
    public void size() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        int expectedSize = 10;
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void peek() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        Integer expectedValue = 4;
        assertEquals(expectedValue, myStack.peek());
    }

    @Test
    public void remove() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        myStack.remove(1);
        Integer expectedValue = 3;
        assertEquals(expectedValue, myStack.get(1));
    }
}
