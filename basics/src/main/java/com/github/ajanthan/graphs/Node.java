package com.github.ajanthan.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int val;
    List<Node> neighbours;

    public Node(int value) {
        this.val = value;
        this.neighbours=new ArrayList<>();
    }

    public Node(int val, List<Node> neighbours) {
        this.val = val;
        this.neighbours = neighbours;
    }

    public void addNeighbour(Node neighbour) {
        neighbours.add(neighbour);
    }
}
