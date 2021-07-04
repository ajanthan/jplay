package com.github.ajanthan.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class AdjListGraph implements Graphs {
    private int size;
    private LinkedList<Integer>[] adjList;

    public AdjListGraph(int size) {
        this.size = size;
        adjList = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    @Override
    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    @Override
    public void DFS() {
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    private void DFSUtil(int v, boolean[] visited) {
        System.out.println(v);
        visited[v] = true;

        Iterator<Integer> iterator = adjList[v].iterator();
        while (iterator.hasNext()) {
            int w = iterator.next();
            if (!visited[w]) {
                DFSUtil(w, visited);
            }
        }
    }


    @Override
    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[size];
        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.println(v);
            for (int neighbour : adjList[v]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }
}
