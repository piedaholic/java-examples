/**
 * 
 */
package com.piedaholic.streams;

import java.nio.charset.Charset;
import java.util.Random;

/**
 * @author HPSINGH
 *
 */
public class RandomDataGenerator {

	private static final int LOWER_ALPHA_START = 97;
	private static final int LOWER_ALPHA_END = 122;
	private static final int UPPER_ALPHA_START = 65;
	private static final int UPPER_ALPHA_END = 90;
	private static final int NUM_START = 57;
	private static final int NUM_END = 65;

	public static String generateRandomStringFromBytesArray() {
		Random random = new Random();
		byte[] array = new byte[random.nextInt(100)];
		random.nextBytes(array);
		return new String(array, Charset.forName("UTF-8"));
	}

	public static String generateRandomAlphaString() {
		Random r = new Random();
		return r.ints(UPPER_ALPHA_START, LOWER_ALPHA_END + 1).limit(r.nextInt(100))
				.filter(i -> (i >= UPPER_ALPHA_START && i <= UPPER_ALPHA_END))
				.filter(i -> (i >= LOWER_ALPHA_START && i <= LOWER_ALPHA_END))
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

	}

	public static String generateRandomAlphaNumString() {
		Random r = new Random();
		return r.ints(NUM_START, LOWER_ALPHA_END + 1)
				.filter(i -> (i >= UPPER_ALPHA_START && i <= UPPER_ALPHA_END))
				.filter(i -> (i >= LOWER_ALPHA_START && i <= LOWER_ALPHA_END))
				.filter(i -> (i >= NUM_START && i <= NUM_END))
				.limit(r.nextInt(100))
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

	}

	public static String generateRandomCamelCaseString() {
		Random r = new Random();
		return Character.toString(r.nextInt(LOWER_ALPHA_END - UPPER_ALPHA_START + 1) + LOWER_ALPHA_START)
				.concat(r.ints(LOWER_ALPHA_START, LOWER_ALPHA_END + 1)
						.filter(i -> (i >= LOWER_ALPHA_START && i <= LOWER_ALPHA_END))
						.limit(r.nextInt(100))
						.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());

	}

	public static int generateRandomNumericId(int len) {
		Random r = new Random();
		return r.nextInt(powBase10(len) - powBase10(len - 1)) + powBase10(len - 1);
	}

	public static String generateRandomNumericIdString(int len) {
		Random r = new Random();
		return String.valueOf(r.nextInt(powBase10(len) - powBase10(len - 1)) + powBase10(len - 1));
	}

	public static int pow(int base, int exponent) {
		int i = 0;
		int result = 1;
		while (i < exponent) {
			result = base * result;
		}
		return result;
	}

	private static int powBase10(int exponent) {
		int i = 0;
		int result = 1;
		while (i < exponent) {
			result = 10 * result;
			i++;
		}
		return result;
	}

}
