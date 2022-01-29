package com.piedaholic.ds.nonlinear.tree;

import com.piedaholic.models.BinaryNode;

import java.util.*;

public class BinaryTree<T> {

    public static void main(String...args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        Integer[] arr = {5, 6, 7, 8, 9, 10};
        for (Integer i : arr) {
            tree.insert(i);
        }
        tree.traverseAndPrint();
    }

    public BinaryNode<T> root;

    public void insert(T data) {
        if (this.root == null)
            this.root = new BinaryNode<T>(data);
        else {
            insert(this.root, data);
        }
    }

    public void insert(BinaryNode<T> node, T data) {
        Queue<BinaryNode<T>> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BinaryNode<T> temp = queue.peek();
            queue.remove();

            if (node.getLeft() == null) {
                node.setLeft(new BinaryNode<T>(data));
                break;
            } else
                queue.add(node.getLeft());

            if (node.getRight() == null) {
                node.setRight(new BinaryNode<T>(data));
                break;
            } else
                queue.add(node.getRight());

        }
    }

    public boolean compareIfMirrorImage(BinaryNode<T> b1, BinaryNode<T> b2) {
        if (b1 == null && b2 == null)
            return true;
        if (b1 == null || b2 == null)
            return false;
        return b1.getData() == b2.getData() && compareIfMirrorImage(b1.getLeft(), b2.getRight()) && compareIfMirrorImage(b1.getRight(), b2.getLeft());
    }

    public List<T> traverse() {
        List<T> li = new ArrayList<>();
        Queue<BinaryNode<T>> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            BinaryNode<T> node = queue.poll();
            li.add(node.getData());
            queue.add(node.getLeft());
            queue.add(node.getRight());
        }
        return li;
    }

    private void traverseAndPrint() {
        Queue<BinaryNode<T>> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            BinaryNode<T> node = queue.poll();
            System.out.print(node.getData() + " ");
            queue.add(node.getLeft());
            queue.add(node.getRight());
        }
    }
}
