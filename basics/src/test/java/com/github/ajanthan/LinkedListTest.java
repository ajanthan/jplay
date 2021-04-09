package com.github.ajanthan;

import com.github.ajanthan.linkedlist.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    @Test
    public void basicTest() {
        Node head = new Node(0);
        Node currentNode = head;
        for (int i = 1; i < 10; i++) {
            Node node0 = new Node(i);
            currentNode.next = node0;
            currentNode = node0;
        }
        int i = 0;
        currentNode = head;
        while (currentNode != null) {
            assertEquals(currentNode.data, i);
            currentNode = currentNode.next;
            i++;
        }
    }

    @Test
    public void reverseLinkedListTest() {
        Node root = arrayToLinkedList(new Object[]{ 1, 2, 3, 4, 5 });
        Node reverse = reverseLinkedList(root);
        assertEquals(5, reverse.data);
        assertEquals(4, reverse.next.data);
    }

    public Node reverseLinkedList(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        Node next = root.next;
        root.next = null;
        return reverseLinkedListHelper(next, root);
    }

    /*
    Root->n1->n2

     */
    private Node reverseLinkedListHelper(Node current, Node prev) {
        if (current.next == null) {
            current.next = prev;
            return current;
        }
        Node next = current.next;
        current.next = prev;
        return reverseLinkedListHelper(next, current);
    }

    private Node arrayToLinkedList(Object[] values) {
        if (values.length == 0) {
            return null;
        }
        Node root = new Node(values[0]);
        Node current = root;
        for (int i = 1; i < values.length; i++) {
            Node next = new Node(values[i]);
            current.next = next;
            current = next;
        }
        return root;
    }
}
