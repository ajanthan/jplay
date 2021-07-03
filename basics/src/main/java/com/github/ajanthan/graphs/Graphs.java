package com.github.ajanthan.graphs;

public interface Graphs {
    int V();

    int E();

    void addEdge(int v, int w);

    Iterable<Integer> adj(int v);

    String toString();
}
