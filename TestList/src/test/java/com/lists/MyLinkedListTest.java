package com.lists;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {
    MyList<Integer> myList;

    @Before
    public void setMyList() {
        myList = new MyLinkedList<>();
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
        Integer expectedValue = 7;
        assertEquals(expectedValue, myList.get(6));
    }

    @Test
    public void get() {
        Integer expectedValue = 6;
        assertEquals(expectedValue, myList.get(5));
    }

    @Test
    public void size() {
        int expectedSize = 6;
        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void remove() {
        Integer expectedValue = 3;
        assertEquals(expectedValue, myList.get(2));

        myList.remove(2);
        expectedValue = 4;
        assertEquals(expectedValue, myList.get(2));
    }

    @Test
    public void clear() {
        myList.clear();
        int expectedSize = 0;
        assertEquals(expectedSize, myList.size());
    }
}
