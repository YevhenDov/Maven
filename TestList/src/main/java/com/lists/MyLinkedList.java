package com.lists;

public class MyLinkedList<E> implements MyList<E>{
    private int size;
    private Node<E> first;
    private Node<E> last;

    MyLinkedList(){
        first = new Node(null, null, null);
        last = first;
    }

    public void add(E e) {
        Node newNode = new Node(e, last, null);
        if (size == 0){
            first = newNode;
        }

        last.next = newNode;
        newNode.prev = last;
        last = newNode;
        size++;
    }

    public E get(int index) {
        return getNode(index).element;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> element = first;
        for (int i = 0; i < index; i++){
            element = element.next;
        }
        return element;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        remove(getNode(index));
    }

    private void remove(Node<E> element) {
        Node<E> prev = element.prev;
        Node<E> next = element.next;

        if (prev.element == null){
            first = element.next;
        }
        else if (next == null){
            last = element.prev;
        }
        else {
            prev.next = next;
            next.prev = prev;

            element.next = null;
            element.prev = null;
        }
        element.element = null;
        size--;
    }

    public void clear() {
        for (int i = size; i > 0; i--){
            remove(0);
        }
    }

    private static class Node<E>{
        E element;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> next, Node<E> prev){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
