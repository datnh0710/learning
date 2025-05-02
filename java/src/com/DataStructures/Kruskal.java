package com.DataStructures;





import java.util.Arrays;

public class Kruskal {
    public static void main(String[] args) {
        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        Kruskal graph = new Kruskal(V, E);
        // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;

        // add edge 0-2
        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;

        // add edge 0-3
        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;

        // add edge 1-3
        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 15;

        // add edge 2-3
        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 4;

        //function call
        graph.KruskalMST();

    }

    // A class to represent a graph edge
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        // Comparator function used for
        // sorting edgesbased on their weight
        @Override
        public int compareTo(Kruskal.Edge edge) {
            return this.weight - edge.weight;
        }
    }

    // A class to represent a subset for
    // union-find
    class subset {
        int parent, rank;
    }

    int V, E; // V-> no. of vertices & E->no.of edges
    Edge[] edges; // collection of all edges

    // Creates a graph with V vertices and E edges
    Kruskal(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }
    }

    // A utility function to find set of an
    // element i (uses path compression technique)
    int find(subset[] subsets, int i) {
        // find root and make root as parent of i
        // (path compression)
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // A function that does union of two sets
    // of x and y (uses union by rank)
    void Union(subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        // Attach smaller rank tree under root
        // of high rank tree (Union by Rank)

        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        }
        // If ranks are same, then make one as
        // root and increment its rank by one
        else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's
    // algorithm
    void KruskalMST() {
        // This will store the resultant MST
        Edge[] result = new Edge[V];

        // An index variable, used for result[]
        int e = 0;

        // An index variable, used for sorted edges
        int i = 0;
        for (i = 0; i < V; i++) {
            result[i] = new Edge();
        }

        // Step 1:  Sort all the edges in non-decreasing
        // order of their weight.  If we are not allowed to
        // change the given graph, we can create a copy of
        // array of edges
        Arrays.sort(edges);

        // Allocate memory for creating V ssubsets
        subset[] subsets = new subset[V];
        for (i = 0; i < V; i++) {
            subsets[i] = new subset();
        }
        // Create V subsets with single elements
        for (int v = 0; v < V; v++) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0; // Index used to pick next edge

        // Number of edges to be taken is equal to V-1
        while (e < V - 1) {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration

            Edge next_edge = new Edge();
            next_edge = edges[i++];


            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);


            // If including this edge does't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }// Else discard the next_edge


        }
        // print the contents of result[] to display
        // the built MST

        System.out.println("Following are the edges in "
                + "the constructed MST");

        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- "
                    + result[i].dest
                    + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "
                + minimumCost);

    }
}
