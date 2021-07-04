package com.github.ajanthan.graphs;

import junit.framework.TestCase;

public class AdjMatrixTest extends TestCase {

    public void testAddEdge() {
        Graphs g = new AdjListGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal");
        g.DFS();

        System.out.println("Following is Breadth First Traversal");
        g.BFS(2);
    }
}