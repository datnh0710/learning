package com.DataStructures;

public interface HashFamily<T> {
    int hash(T x, int which);

    int getNumberOfFunction();

    void generateNewFunction();
}
