package com.piedaholic.ds.nonlinear.tree;

public class AvlTree<T extends Comparable> {
    Node<T> root;

    class Node<T> {
        Node(T data) {
            this.data = data;
        }

        Node<T> left;
        Node<T> right;
        T data;
        int height;
    }

    private int getBalance(Node<T> node) {
        return node == null ? 0 : height(node.right) - height(node.left);
    }

    private void updateHeight(Node<T> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int height(Node<T> node) {
        return node == null ? -1 : node.height;
    }

    private void insert(T data) {
        this.root = insert(this.root, data);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    private Node<T> insert(Node<T> node, T data) {
        //int cmp;
        if (node == null)
            return new Node<>(data);
        @SuppressWarnings("unchecked")
        int cmp = node.data.compareTo(data);
        if (cmp < 0)
            node.right = insert(node.right, data);
        else if (cmp > 0)
            node.left = insert(node.left, data);
        node = rebalance(node);
        return node;
    }

    private Node<T> rebalance(Node<T> node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (height(node.right.right) > height(node.right.left))
                node = rotateLeft(node);
            else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        } else if (balance < -1) {
            if (height(node.left.left) > height(node.left.right))
                node = rotateRight(node);
            else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
        return node;
    }

    private Node<T> rotateLeft(Node<T> y) {
        Node<T> x = y.right;
        Node<T> z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.left;
        Node<T> z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

}
