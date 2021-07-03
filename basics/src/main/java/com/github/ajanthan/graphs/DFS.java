package com.github.ajanthan.graphs;

import java.util.List;

public class DFS {
    public void traverse(Node u, List<Node> visited) {
        if(u==null){
            return;
        }
        System.out.println(u.val);
        visited.add(u);
        for (Node neighbour : u.neighbours) {
            if (!visited.contains(neighbour)) {
                traverse(neighbour, visited);
            }
        }
    }
}
