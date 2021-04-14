package com.datastructs.queue;

import java.util.Stack;

public class CustomQueue<T> {
	Stack<T> newestOnTop = new Stack<T>();
	Stack<T> oldestOnTop = new Stack<T>();

	private void stackShift() {
		if (oldestOnTop.isEmpty()) {
			while (!newestOnTop.isEmpty()) {
				oldestOnTop.push(newestOnTop.pop());
			}
		}
	}

	public void enqueue(T item) {
		newestOnTop.push(item);
		stackShift();
	}

	public T dequeue() {
		stackShift();
		return oldestOnTop.pop();
	}

	public T peek() {
		stackShift();
		return oldestOnTop.peek();
	}

	public boolean isEmpty() {
		return newestOnTop.isEmpty() && oldestOnTop.isEmpty();
	}

	public void clear() {
		while (!newestOnTop.isEmpty()) {
			newestOnTop.pop();
		}
		while (!oldestOnTop.isEmpty()) {
			oldestOnTop.pop();
		}
	}
}
