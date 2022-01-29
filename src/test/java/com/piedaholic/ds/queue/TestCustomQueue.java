package com.piedaholic.ds.queue;

import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.piedaholic.ds.linear.CustomQueue;

public class TestCustomQueue {
    private CustomQueue<Integer> queue;
    private Random random = new Random();
    int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        queue = new CustomQueue<Integer>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public final void testEnqueue() {
        queue.clear();
        try {
            for (int i = 0; i < array.length; i++) {
                queue.enqueue(array[i]);
            }
        } catch (Exception e) {
            fail("testEnqueue() failed-->" + e);
        }
        if (queue.isEmpty())
            fail("Queue Empty");
        if (!queue.peek().equals(array[0]))
            fail(queue.peek() + " fetched instead of " + array[array.length - 1]);
        queue.clear();
    }

    @Test
    public final void testDequeue() {
        queue.clear();
        queue.enqueue(random.nextInt());
        queue.dequeue();
        if (!queue.isEmpty())
            fail("Failed to remove element");
    }

    @Test
    public final void testPeek() {
        queue.clear();
        int i = random.nextInt();
        queue.enqueue(i);
        if (!queue.peek().equals(i))
            fail("Wrong Value Fetched");
    }

}
