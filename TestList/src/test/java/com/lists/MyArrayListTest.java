package com.lists;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyArrayListTest {
    MyList<Integer> myList;

    @Before
    public void setMyList() {
        myList = new MyArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
    }

    @After
    public void clearList() {
        myList.clear();
        myList = null;
    }

    @Test
    public void add() {
        myList.add(7);

        int expectedSize = 7;
        Integer expectedValue = 7;
        assertEquals(expectedSize, myList.size());
        assertEquals(expectedValue, myList.get(6));
    }

    @Test
    public void get() {
        Integer expectedValue = 5;
        assertEquals(expectedValue, myList.get(4));
    }

    @Test
    public void remove() {
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
        int expectedSize = 6;
        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void clear() {
        myList.clear();
        int expectedSize = 0;
        assertEquals(expectedSize, myList.size());
    }
}
