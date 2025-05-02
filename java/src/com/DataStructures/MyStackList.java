package com.DataStructures;



import java.util.ArrayList;
import java.util.List;

public class MyStackList<T> {
    List<T> list;
    int tSize;
    int tpSize;

    public MyStackList() {
        list = new ArrayList<>();
        tSize = 0;
        tpSize = 0;
    }

    public void push(T data) {
        list.add(tSize++, data);
        tpSize++;
    }

    public T pop() {
        tpSize--;
        return list.remove(tSize--);
    }

    public T top() {
        return list.get(tpSize--);
    }


}
