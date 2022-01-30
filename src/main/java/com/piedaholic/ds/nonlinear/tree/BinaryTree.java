package com.piedaholic.ds.nonlinear.tree;

import java.util.*;

public class BinaryTree<T> {

    public static class Node<T> {
        public Node(T data) {
            this.data = data;
        }
        private T data;
        private Node<T> left;
        private Node<T> right;
    }

    public static void main(String...args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        Integer[] arr = {5, 6, 7, 8, 9, 10};
        for (Integer i : arr) {
            tree.insert(i);
        }
        tree.traverseAndPrint();
    }

    public Node<T> root;

    public void insert(T data) {
        if (this.root == null)
            this.root = new Node<T>(data);
        else {
            insert(this.root, data);
        }
    }

    public void insert(Node<T> root, T data) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> temp = queue.peek();
            queue.remove();

            if (temp.left == null) {
                temp.left = (new Node<T>(data));
                break;
            } else
                queue.add(temp.left);

            if (temp.right == null) {
                temp.right = (new Node<T>(data));
                break;
            } else
                queue.add(temp.right);

        }
    }

    public boolean compareIfMirrorImage(Node<T> b1, Node<T> b2) {
        if (b1 == null && b2 == null)
            return true;
        if (b1 == null || b2 == null)
            return false;
        return b1.data == b2.data && compareIfMirrorImage(b1.left, b2.right) && compareIfMirrorImage(b1.right, b2.left);
    }

    public List<T> traverse() {
        List<T> li = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            li.add(node.data);
            queue.add(node.left);
            queue.add(node.right);
        }
        return li;
    }

    private void traverseAndPrint() {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            System.out.print(node.data + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
    }
}
