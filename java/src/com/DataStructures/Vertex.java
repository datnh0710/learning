package com.DataStructures;


import java.util.LinkedList;
import java.util.List;

/**
 * represents a vertex in a graph
 */
public class Vertex {
    public String name; // vertex name
    public List<Edge> adj; // adjacent vertices
    public boolean known;
    public double dist; // cost
    public Vertex prev; // previous vertex on shortest path
    public int scratch; // extra variable used in algorithm
    //public PairingHeap.Positon<Path> pos; //used for dijkstra2

    public Vertex(String nm) {
        name = nm;
        adj = new LinkedList<Edge>();
        known = false;
        reset();
    }

    public void reset() {
        dist = Graph.INFINITY;
        prev = null;
        known = false;
        //pos = 0;
        scratch = 0;
    }

}
