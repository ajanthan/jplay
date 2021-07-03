package com.github.ajanthan.graphs;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DFSTest extends TestCase {

    public void testTraverse() {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node0.addNeighbour(node1);
        node1.neighbours = Arrays.asList(node0, node2, node3);
        node2.neighbours = Arrays.asList(node1, node3);
        node3.neighbours = Arrays.asList(node1, node2, node4);
        node4.addNeighbour(node3);
        node6.addNeighbour(node7);
        node7.addNeighbour(node6);
        List<Node> visited = new ArrayList<>();
        new DFS().traverse(node0, visited);

        List<Node> allNodes = Arrays.asList(node0, node1, node2, node3, node4, node5, node6, node7);
        List<Node> isolatedFromNode0 = allNodes.stream().filter(node -> !visited.contains(node)).collect(Collectors.toList());
        System.out.println("unreachable nodes from node0");
        isolatedFromNode0.forEach(node -> System.out.println(node.val));
    }
}