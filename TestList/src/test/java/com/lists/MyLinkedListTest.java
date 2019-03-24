package com.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {
    MyList<Integer> myList = new MyLinkedList<Integer>();

    @Test
    public void add() {
        myList.add(1);
        myList.add(2);
        myList.add(3);

        Integer firstExpectedValue = 1;
        Integer secondExpectedValue = 2;
        Integer thirdExpectedValue = 3;
        int expectedSize = 3;

        assertEquals(firstExpectedValue, myList.get(0));
        assertEquals(secondExpectedValue, myList.get(1));
        assertEquals(thirdExpectedValue, myList.get(2));
        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void get() {
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);

        Integer expectedValue = 4;
        assertEquals(expectedValue, myList.get(3));
    }

    @Test
    public void size() {
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        int expectedSize = 4;
        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void remove() {
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        Integer expectedValue = 3;
        assertEquals(expectedValue, myList.get(2));

        myList.remove(2);
        expectedValue = 4;
        assertEquals(expectedValue, myList.get(2));
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
