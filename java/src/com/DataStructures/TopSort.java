package com.DataStructures;

import com.Generic.Queue;

import java.util.List;
import java.util.NoSuchElementException;


public class TopSort {
    public static class Vertex {
        public int topNum;
        int indegree;
    }

    private static final int NUM_VERTICES = 10;

    public void topsort() {
        for (int i = 0; i < NUM_VERTICES; i++) {
            Vertex v = findNewVertexOfIndegreeZero();
            if (v == null) {
                throw new NoSuchElementException();
            }
            v.topNum = i;
            for (Vertex w : V) {
                w.indegree--;
            }
        }
    }

    List<Vertex> V = null;

    private Vertex findNewVertexOfIndegreeZero() {
        return null;
    }

    public void topsort1() {
        Queue<Vertex> q = new Queue<>();
        int counter = 0;
        for (Vertex v : V) {
            if (v.indegree == 0) {
                q.enqueue(v);
            }
        }

        while (!q.isEmpty()) {
            Vertex v = q.dequeue();
            v.topNum = ++counter;
            for (Vertex w : V) {
                if (--w.indegree == 0)
                    q.enqueue(w);

            }

        }
        if (counter != NUM_VERTICES)
            throw new NoSuchElementException();

    }
}
