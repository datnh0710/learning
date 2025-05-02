package com.DataStructures;


import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collection;
import java.util.PriorityQueue;

/**
 * Graph class: evaluate shortest paths.
 * construction: with no parameters
 * <p>
 * ************* Public Operations ***********
 * void addEdge(String v,String w, double cvw) --> add additional edge
 * void printPath(String w)                    --> print path after alg is run
 * void unweighted(String s)                   --> Single-source unweighted
 * void dijkstra( String s )                   --> Single-source weighted
 * void negative( String s )                   --> Single-source negative weighted
 * void acyclic( String s )                    --> Single-source acyclic
 */
public class Graph {
    public static final double INFINITY = Double.MAX_VALUE;
    private Map<String, Vertex> vertexMap = new HashMap<>();

    /**
     * add a new edge to the graph
     *
     * @param sourceName
     * @param destName
     * @param cost
     */
    public void addEdge(String sourceName, String destName, double cost) {
        Vertex v = getVertex(sourceName);
        Vertex w = getVertex(destName);
        v.adj.add(new Edge(w, cost));
    }

    /**
     * if vertex name is not represent, add it to vertex map
     * in either case, return the vertex
     *
     * @param vertexName
     * @return
     */
    private Vertex getVertex(String vertexName) {
        Vertex v = vertexMap.get(vertexName);
        if (v == null) {
            v = new Vertex(vertexName);
            vertexMap.put(vertexName, v);
        }
        return v;
    }

    /**
     * driver routine to handle unreachable and print total cost
     * it calls recursive routine to print shortest path to
     * destNode after a shorted path algorithm has run
     *
     * @param destName
     */
    public void printPath(String destName) {
        Vertex w = getVertex(destName);
        if (w == null) {
            throw new NoSuchElementException("Destination vertex no found!!!");
        } else if (w.dist == INFINITY) {
            System.out.printf("%s is unreachable", destName);
        } else {
            System.out.printf("Cost is: %s ", w.dist);
            printPath(w);
            System.out.printf("%n");
        }
    }

    /**
     * recursive routinr to print shortest path to dest
     * after running shortest path algorithm. The path is known to exist.
     *
     * @param dest
     */
    private void printPath(Vertex dest) {
        if (dest.prev != null) {
            printPath(dest.prev);
            System.out.printf(" to ");
        }
        System.out.printf("%s", dest.name);
    }

    /**
     * Initializes the vertex output info prior to running
     * any shortest path algorithm
     */
    public void clearALL() {
        for (Vertex v : vertexMap.values()) {
            v.reset();
        }
    }

    /**
     * Single-source unweighted shortest-path algorithm.
     *
     * @param startName
     */
    public void unweighted(String startName) {

        Vertex start = vertexMap.get(startName);
        if (start == null) {
            throw new NoSuchElementException("Start vertex not found!!!");
        }
        Queue<Vertex> q = new LinkedList<>();
        q.add(start);

        start.dist = 0;
        while (!q.isEmpty()) {
            Vertex v = q.remove();
            for (Edge e : v.adj) {
                Vertex w = e.dest;
                if (w.dist == INFINITY) {
                    w.dist = v.dist + 1;
                    w.prev = v;
                    q.add(w);
                }

            }
        }
    }

    /**
     * single-source weighted shortest-path algorithm
     *
     * @param startName
     */
    public void dijkstra(String startName) {
        Vertex start = vertexMap.get(startName);
        if (start == null) {
            throw new NoSuchElementException("Start vertex not found!!!");
        }

        PriorityQueue<Path> pq = new PriorityQueue<Path>();
        clearALL();
        pq.add(new Path(start, 0));
        start.dist = 0;
        int nodesSeen = 0;

        while (!pq.isEmpty() && nodesSeen < vertexMap.size()) {
            Path vrec = pq.remove();
            Vertex v = vrec.dest;
            if (v.scratch != 0)
                continue;
            v.scratch = 1;
            nodesSeen++;
            for (Edge e : v.adj) {
                Vertex w = e.dest;
                double cvw = e.cost;
                if (cvw < 0)
                    throw new GraphException("Graph has negative edges!!!");
                if (w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                    pq.add(new Path(w, w.dist));
                }
            }
        }

    }

    /**
     * single-source negative-weighted shortest-path algorithm
     *
     * @param startName
     */
    public void negative(String startName) {
        clearALL();

        Vertex start = vertexMap.get(startName);
        if (start == null) {
            throw new NoSuchElementException("Start vertex not found!!!");
        }
        Queue<Vertex> q = new LinkedList<>();
        start.dist = 0;
        q.add(start);
        start.scratch++;
        while (!q.isEmpty()) {
            Vertex v = q.remove();
            if (v.scratch++ > 2 * vertexMap.size()) {
                throw new GraphException("Negative cycle detected!!!");
            }
            for (Edge e : v.adj) {
                double cvw = e.cost;
                Vertex w = e.dest;
                if (v.dist + cvw < w.dist) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                    //ensure only if not already on the queue
                    if (w.scratch++ % 2 == 0)
                        q.add(w);
                    else
                        w.scratch--; // undo the enqueue increment
                }
            }
        }
    }

    /**
     * single-source negative-weighted acyclic-graph shortest-path algorithm.
     *
     * @param startName
     */
    public void acyclic(String startName) {
        Vertex start = vertexMap.get(startName);
        if (start == null)
            throw new NoSuchElementException("Start vertex not found!!!");
        clearALL();
        Queue<Vertex> q = new LinkedList<>();
        start.dist = 0;

        //compute the indegrees
        Collection<Vertex> vertexSet = vertexMap.values();
        for (Vertex v : vertexSet) {
            for (Edge e : v.adj) {
                e.dest.scratch++;
            }
        }

        //enqueue vertices of indegree zero
        for (Vertex v : vertexSet) {
            if (v.scratch == 0) {
                q.add(v);
            }

        }

        int interations;
        for (interations = 0; !q.isEmpty(); interations++) {
            Vertex v = q.remove();
            for (Edge e : v.adj) {
                Vertex w = e.dest;
                double cvw = e.cost;
                if (--w.scratch == 0) {
                    q.add(w);
                }
                if (w.dist == INFINITY) {
                    continue;
                }
                if (w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                }
            }

        }
        ;
        if (interations != vertexSet.size())
            throw new GraphException("Graph has a cycle!!!");
    }

    /**
     * depth first search method
     *
     * @param startVertex
     */
    private void dfs(String startVertex) {
        Queue<Vertex> q = new LinkedList<>();
        Vertex start = vertexMap.get(startVertex);
        if (start == null) {
            throw new NoSuchElementException("Start vertex not found!!!");
        }
        clearALL();
        dfs(start, q);

    }

    /**
     * internal depth first search method
     *
     * @param start
     * @param q
     */
    private void dfs(Vertex start, Queue<Vertex> q) {

        q.add(start);
        start.scratch = 1;
        System.out.print(start.name + " ");
        Vertex v = q.poll();
        for (Edge e : v.adj) {
            Vertex w = e.dest;
            if (w.scratch == 0) {
                dfs(w, q);
            }
        }


    }

    /**
     * breath first search
     *
     * @param startVertex
     */
    public void bfs(String startVertex) {
        Queue<Vertex> q = new LinkedList<>();
        Vertex start = vertexMap.get(startVertex);
        if (start == null) {
            throw new NoSuchElementException("Start vertex not found!!!");
        }
        clearALL();
        bfs(start, q);

    }

    /**
     * internal method bfs
     *
     * @param v
     */
    private void bfs(Vertex v, Queue<Vertex> q) {

        q.add(v);
        v.scratch = 1;
        while (!q.isEmpty()) {
            Vertex v1 = q.poll();
            System.out.print(v1.name + " ");
            for (Edge e : v1.adj) {
                Vertex w = e.dest;
                if (w.scratch == 0) {
                    q.add(w);
                    w.scratch = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("D", "C", 10);
        g.addEdge("A", "B", 12);
        g.addEdge("D", "B", 23);
        g.addEdge("A", "D", 87);
        g.addEdge("E", "D", 43);
        g.addEdge("B", "E", 11);
        g.addEdge("C", "A", 19);


        Graph g1 = new Graph();
        g1.addEdge("0", "1", 10);
        g1.addEdge("0", "2", 12);
        g1.addEdge("1", "2", 23);
        g1.addEdge("2", "0", 87);
        g1.addEdge("2", "3", 43);
        g1.addEdge("3", "3", 11);

        System.out.printf("Vertices: %d%n", g.vertexMap.size());

        System.out.printf("***************************%n");
        System.out.printf("dijkstra %n");
        g.dijkstra("D");
        g.printPath("A");


        System.out.printf("***************************%n");
        System.out.printf("unweighted %n");
        g.unweighted("D");
        g.printPath("A");


        System.out.printf("***************************%n");
        System.out.printf("negative %n");
        g.negative("D");
        g.printPath("A");


        System.out.printf("***************************%n");
        System.out.printf("breath first search %n");
        g1.bfs("2");
        System.out.printf("%n***************************%n");


        System.out.printf("depth first search %n");
        g1.dfs("2");
        System.out.printf("%n***************************%n");

    }

}
