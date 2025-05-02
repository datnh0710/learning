package com.DataStructures;

import java.util.LinkedList;

public class MaximumFlow {
    public static void main(String[] args) {
        // Let us create a graph shown in the above example
        int graph[][] = new int[][]{{0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };

        MaximumFlow maximumFlow = new MaximumFlow();
        System.out.println("The maximum possible flow is " +
                maximumFlow.maximumFlow(graph, 0, 5));
    }

    static final int V = 6; // number of vertices in graph

    /**
     * return true if there is a graph from source 's' to sink 't'
     * in residual graph. Also fills parent[] to store the path
     *
     * @param rGraph
     * @param s
     * @param t
     * @param parent
     * @return
     */
    boolean bfs(int[][] rGraph, int s, int t, int parent[]) {
        // create a visited array and mark all vertices as not visited
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // create a queue, enqueue source vertex and mark
        // source vertex as visited
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        parent[s] -= 1;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int v = 0; v < V; v++) {
                if (visited[v] == false && rGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        //if we reached sink in BFS starting from source, then return true, else false
        return (visited[t] == true);
    }

    int maximumFlow(int[][] graph, int s, int t) {
        int u, v;
        /**
         * create a residual graph and fill the residual graph
         * with given capacities in the original graph as
         * residual capacities in residual graph
         *
         **/

        /**
         * residual graph where rGraph[i][j] indicates
         * residual capacity of edge from i to j (if there is an edge. If rGraph[i][j] is 0, then there is not)
         */
        int rGraph[][] = new int[V][V];
        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                rGraph[u][v] = graph[u][v];
            }
        }

        // this array is filled by BFS and store path
        int parent[] = new int[V];

        int max_flow = 0; // there is no flow initially

        // augment the flow while there is path from source to sink
        while (bfs(rGraph, s, t, parent)) {
            //find the minimum residual capacity of edges
            //along the path filled by BFS. Or we can say
            // find the maximum flow through the path  found
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }
            //update residual capacities of the edges and reverse edges along the path
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }
            // add path flow to overall flow
            max_flow += path_flow;
        }
        //return overall flow
        return max_flow;

    }


}
