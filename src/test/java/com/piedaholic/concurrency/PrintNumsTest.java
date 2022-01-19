/**
 * 
 */
package com.piedaholic.concurrency;

import java.time.ZonedDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

/**
 * @author HPSINGH
 *
 */
public class PrintNumsTest {

	@Test
	public void test() {

		new Random().ints(10, 1, 50).forEachOrdered((k) -> {
			System.err.println(k);
			PrintNums p = new PrintNums(k);
			new Odd(p);
			new Even(p);
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void testPrintNumsUntilRandomGeneratedNumber() {
        Runnable print = () -> {
            int i = 1;
            while (i <= ThreadLocalRandom.current().nextInt()) {
                System.out.println(i);
                ++i;
            }
            ;
        };
        print.run();
    }

	
    static int counter = 0;
    
    @Test
    public void testPollingOnCounter() throws InterruptedException {
        new Thread(() -> {
            for (int i = 1; i < 501; i++)
                counter++;
        }).start();
        while (counter < 100) {
            System.out.println("Not reached 100 now : " + ZonedDateTime.now());
            Thread.sleep(100); // delay of 100 ms
        }
        System.out.println("Reached 100 now : " + ZonedDateTime.now());
    }
    

}
