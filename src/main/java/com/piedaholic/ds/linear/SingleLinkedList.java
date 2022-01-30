package com.piedaholic.ds.linear;

public class SingleLinkedList<T extends Comparable<? super T>> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public int size() {
        return this.size;
    }

    public void add(T data) {
        if (this.head == null && this.tail == null) {
            this.head = new Node<T>(data);
            this.tail = head;
        } else {
            this.tail.next = new Node<T>(data);
            this.tail = this.tail.next;
        }
        size++;
    }

    public boolean add(int index, T data) {
        if (index > size - 1)
            return false;
        int ctr = 0;
        if (this.head == null && this.tail == null) {
            if (ctr == index) {
                this.head = new Node<>(data);
                this.tail = head;
                size++;
            } else
                return false;
        } else {

            for (Node<T> node = this.head, prevNode = null; node != null;) {
                if (ctr == index) {
                    Node<T> newNode = new Node<>(data);
                    if (prevNode != null)
                        prevNode.next = newNode;
                    newNode.next = node;
                    size++;
                    return true;
                }
                ctr++;
                prevNode = node;
                node = node.next;
            }

        }
        return false;
    }

    public void remove(T data) {
        if (this.head == null && this.tail == null) {
        } else {
            Node<T> currNode = this.head;
            Node<T> prevNode = this.head;
            while (currNode != null) {

                if (currNode.data.compareTo(data) == 0) {
                    prevNode.next = currNode.next;
                    currNode.next = null;
                    currNode.data = null;
                    size--;
                    return;
                }
                prevNode = currNode;
                currNode = currNode.next;
            }
        }
    }

    public int get(T data) {
        if (this.head == null && this.tail == null)
            return -1;
        else {
            int ctr = 0;
            for (Node<T> node = this.head; node != null;) {
                if (node.data.compareTo(data) == 0)
                    return ctr;
                ctr++;
                node = node.next;
            }
        }
        return -1;
    }

    public boolean contains(T data) {
        if (this.head == null && this.tail == null)
            return false;
        else {
            for (Node<T> node = this.head; node != null;) {
                if (node.data.compareTo(data) == 0)
                    return true;
                node = node.next;
            }
        }
        return false;
    }

    public void reverse() {
        Node<T> tmp = null;
        Node<T> nextNode = null;
        Node<T> currNode = this.head;
        while (currNode != null) {
            tmp = currNode.next;
            currNode.next = nextNode;
            nextNode = currNode;
            currNode = tmp;
            if (tmp == null)
                this.head = nextNode;
        }
    }

    public SingleLinkedList<T> getReversedSingleLinkedList() {
        if (this.head == null)
            return null;
        SingleLinkedList<T> ll = new SingleLinkedList<>();
        ll.add(this.head.data);
        ll.size = this.size;
        for (Node<T> node = this.head.next; node != null;) {
            Node<T> newNode = new Node<>(node.data);
            newNode.next = ll.head;
            ll.head = newNode;
            node = node.next;
        }
        return ll;
    }

    public void clear() {
        for (Node<T> node = this.head; node != null;) {
            Node<T> tmp = node.next;
            node.data = null;
            node.next = null;
            node = tmp;
        }
    }

    public void print() {
        for (Node<T> node = this.head; node != null;) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
