package com.piedaholic.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;

    class Node {
        Node(int key) {
            this.key = key;
        }

        Node left;
        Node right;
        int key;
    }

    public void insert(int key) {
        this.root = insert(this.root, key);
    }

    public Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);
        else if (node.key > key) {
            node.left = insert(node.left, key);
        } else if (node.key < key) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    public List<Integer> sortInAscOrder() {
        List<Integer> li = new ArrayList<>();
        inOrderTraversal(this.root, li);
        return li;
    }

    public void inOrderTraversal(Node node, List<Integer> li) {
        if (node != null) {
            inOrderTraversal(node.left, li);
            li.add(node.key);
            inOrderTraversal(node.right, li);
        }
    }

    public List<Integer> sortInDescOrder() {
        List<Integer> li = new ArrayList<>();
        descOrderTraversal(this.root, li);
        return li;
        
    }

    public void descOrderTraversal(Node node, List<Integer> li) {
        if (node != null) {
            descOrderTraversal(node.right, li);
            li.add(node.key);
            descOrderTraversal(node.left, li);
        }
    }

    public Node search(Node node, int key) {
        if (node == null || key == node.key) {
            return node;
        } else if (node.key > key)
            return search(node.left, key);
        else if (node.key < key)
            return search(node.right, key);
        return null;
    }

}
