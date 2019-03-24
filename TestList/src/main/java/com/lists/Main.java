package com.lists;

import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        MyList<String> str = new MyLinkedList<String>();
        MyStack<String> myStack = new MyStack<String>(5);
        myStack.push("123");
        myStack.push("123");
        myStack.push("123457");
        myStack.push("123");
        myStack.push("123");
        myStack.push("123");
        System.out.println(myStack.size());
        System.out.println(myStack.remove(3));
    }
}
