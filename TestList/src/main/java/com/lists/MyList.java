package com.lists;

public interface MyList<T> {
    T get(int index);
    void add(T t);
    void remove(int index);
    int size();
    void clear();
}
