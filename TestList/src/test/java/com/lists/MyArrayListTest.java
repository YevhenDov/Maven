package com.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyArrayListTest {
    MyList<Integer> myList = new MyArrayList<Integer>();

    @Test
    public void add() {
        myList.add(7);

        int expectedSize = 1;
        Integer expectedValue = 7;
        assertEquals(expectedSize, myList.size());
        assertEquals(expectedValue, myList.get(0));
    }

    @Test
    public void get() {
        myList.add(5);

        Integer expectedValue = 5;
        assertEquals(expectedValue, myList.get(0));
    }

    @Test
    public void remove() {
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);

        Integer expectedValue = 4;
        int expectedSize = 6;
        assertEquals(expectedValue, myList.get(3));
        assertEquals(expectedSize, myList.size());

        myList.remove(3);
        expectedValue = 5;
        expectedSize = 5;
        assertEquals(expectedValue, myList.get(3));
        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void size() {
        myList.add(1);
        myList.add(2);
        myList.add(3);

        int expectedSize = 3;
        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void clear() {
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);

        myList.clear();
        int expectedSize = 0;
        assertEquals(expectedSize, myList.size());
    }
}
