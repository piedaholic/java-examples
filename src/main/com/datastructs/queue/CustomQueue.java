package com.datastructs.queue;

import java.util.Stack;

public class CustomQueue<T> {
    Stack<T> newestOnTop = new Stack<T>();
    Stack<T> oldestOnTop = new Stack<T>();

    private void stackShift() {
	if (oldestOnTop == null) {
	    while (!newestOnTop.isEmpty()) {
		oldestOnTop.push(newestOnTop.pop());
	    }
	}
    }

    public void enqueue(T item) {
	newestOnTop.push(item);
    }

    public T dequeue() {
	stackShift();
	return oldestOnTop.pop();
    }

    public T peek() {
	stackShift();
	return oldestOnTop.peek();
    }
}
