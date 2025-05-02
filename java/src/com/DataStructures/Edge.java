package com.DataStructures;

/**
 * represents an edge in the graph
 */
public class Edge {
    public Vertex dest; // second vertex in edge
    public double cost;// edge cost

    public Edge(Vertex d, double c) {
        this.dest = d;
        this.cost = c;
    }
}
