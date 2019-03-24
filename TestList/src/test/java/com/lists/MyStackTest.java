package com.lists;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyStackTest {
    MyStack<Integer> myStack;

    @Before
    public void setMyStack() {
        myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
    }

    @After
    public void clearMyStack() {
        myStack.clear();
        myStack = null;
    }

    @Test
    public void push() {
        myStack.push(5);
        Integer expectedValue = 5;
        assertEquals(expectedValue, myStack.get(4));
    }

    @Test
    public void pop() {
        myStack.pop();
        Integer expectedValue = null;
        assertEquals(expectedValue, myStack.get(3));
    }

    @Test
    public void clear() {
        myStack.clear();
        Integer expectedValue = null;
        assertEquals(expectedValue, myStack.get(0));
    }

    @Test
    public void size() {
        int expectedSize = 10;
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void peek() {
        Integer expectedValue = 4;
        assertEquals(expectedValue, myStack.peek());
    }

    @Test
    public void remove() {
        myStack.remove(1);
        Integer expectedValue = 3;
        assertEquals(expectedValue, myStack.get(1));
    }
}
