/**
 * 
 */
package com.piedaholic.concurrency;

/**
 * @author HPSINGH
 *
 */

public class PrintNums {

	int counter = 1;
	final int limit;

	/**
	 * @param limit
	 */
	public PrintNums(int limit) {
		super();
		this.limit = limit;
	}

	public synchronized void printOdd() {
		synchronized (this) {
			while (this.counter < this.limit) {
				while (counter % 2 == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(counter);
				counter++;
				notify();
			}
		}

		// System.out.println("Stopping Odd Thread");
	}

	public synchronized void printEven() {
		while (this.counter < this.limit) {
			while (counter % 2 != 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(counter);
			counter++;
			notify();
		}
		// System.out.println("Stopping Even Thread");
	}

}

class Odd implements Runnable {
	PrintNums p;

	public Odd(PrintNums p) {
		this.p = p;
		new Thread(this).start();
	}

	@Override
	public void run() {
		p.printOdd();
	}

}

class Even implements Runnable {
	PrintNums p;

	public Even(PrintNums p) {
		this.p = p;
		new Thread(this).start();
	}

	@Override
	public void run() {
		p.printEven();
	}

}