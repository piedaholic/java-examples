/**
 * 
 */
package com.mathematics;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * @author hpsingh
 *
 */
public class NumberTheory {
    static int[][] mod11;
    static int[][] mod13;
    static int[][] mod37;
    static int[][] mod27; // [x][0] = x! mod 27, [x][1] = y mod 27, such that y * (x! mod 27) = 1 mod 27.
    static HashMap<Integer, int[][]> map;

    public static BigInteger pow_mod(BigInteger base, BigInteger exponent, BigInteger mod) {
	BigInteger result = BigInteger.ZERO;
	while (exponent.compareTo(BigInteger.ZERO) == 1) {
	    if (exponent.and(BigInteger.ONE).compareTo(BigInteger.ONE) == 0)// exponent.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE))
	    {
		result = result.multiply(base);
		result = result.mod(mod);
	    }
	    // (result * base) % mod;
	    base = base.mod(mod);
	    base = base.multiply(base);
	    base = base.mod(mod);
	    exponent = exponent.shiftRight(1);
	}
	return result;
    }

    public static BigInteger pow(BigInteger base, BigInteger exponent) {
	BigInteger result = BigInteger.ONE;
	while (exponent.compareTo(BigInteger.ZERO) == 1) {
	    if (exponent.and(BigInteger.ONE).compareTo(BigInteger.ONE) == 0)// exponent.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE))
	    {
		result = result.multiply(base);
	    }
	    // (result * base) % mod;
	    base = base.multiply(base);
	    exponent = exponent.shiftRight(1);
	}
	return result;
    }

    public static int choose(int n, int r) {
	// first, for each of 27->3, 11, 13, 37, find out how many factors are in the
	// result
	int count3 = countFactors(n, r, 3);
	int count11 = countFactors(n, r, 11);
	int count13 = countFactors(n, r, 13);
	int count37 = countFactors(n, r, 37);
	// System.out.printf("count3: %d, count
	if (count3 >= 3)
	    count3 = 3;
	int modulo27 = (count3 == 3 ? 0 : factorial(n, r, 27));
	while (count3-- > 0)
	    modulo27 *= 3;
	int modulo11 = (count11 != 0 ? 0 : factorial(n, r, 11));
	int modulo13 = (count13 != 0 ? 0 : factorial(n, r, 13));
	int modulo37 = (count37 != 0 ? 0 : factorial(n, r, 37));
	// System.out.printf("modulo27: %d, modulo11: %d, modulo13: %d, modulo37: %d\n",
	// modulo27, modulo11, modulo13, modulo37);
	int N = 27 * 11 * 13 * 37;
	int x = modulo27 * (N / 27) * modularInversion(N / 27, 27) + modulo11 * (N / 11) * modularInversion(N / 11, 11)
		+ modulo13 * (N / 13) * modularInversion(N / 13, 13)
		+ modulo37 * (N / 37) * modularInversion(N / 37, 37);
	x %= N;

	return x;
    }

    public static int modularInversion(int a, int mod) {
	a %= mod;
	int[] coeffs = extendedEuclidean(a, mod);
	// a*coeff[0] + mod*coeffs[1] = 1, assuming a and mod are relatively prime
	// so coeffs[0] is the inverse.
	if (coeffs[0] < 0)
	    coeffs[0] += mod;
	return coeffs[0];
    }

    public static int[] extendedEuclidean(int a, int b) {
	if (a % b == 0)
	    return new int[] { 0, 1 };
	int[] ee = extendedEuclidean(b, a % b);
	return new int[] { ee[1], ee[0] - ee[1] * (a / b) };
    }

    public static int factorial(int n, int r, int prime) {
	int result = factorialMod(n, prime, 0) * factorialInverse(n - r, prime) * factorialInverse(r, prime);
	result %= prime;
	return result;
    }

    public static int factorialInverse(int n, int prime) {
	return factorialMod(n, prime, 1);
    }

    public static int factorialMod(int n, int prime, int bit) {
	// System.out.printf("factiorialMod of %d, prime is %d, bit is %d\n", n, prime,
	// bit);
	// assume that all factors of prime are gone from n!. find n! mod prime.
	int ret = 1;
	int[][] modprime = map.get(prime); // dat prime better be there. "prime"
	int div = prime;
	if (div == 27)
	    div = 3;
	int q = n / prime;
	int r = n % prime;
	n /= div;
	while (!(q == 0 && r == 0)) {
	    ret *= modpow(modprime[prime - 1][bit], q, prime);
	    ret *= modprime[r][bit];
	    ret %= prime;

	    r = n % prime;
	    q = n / prime;
	    n /= div;
	}
	ret *= modprime[r][bit];
	return ret % prime;
    }

    public static int modpow(int base, int exp, int mod) {
	// make sure mod is relatively small, or things are screwed.
	base %= mod;
	int ret = 1;
	int bit = 1;
	int mult = base;
	while (bit <= exp) {
	    if ((bit & exp) != 0) {
		ret *= mult;
		ret %= mod;
	    }
	    mult *= mult;
	    mult %= mod;
	    bit <<= 1;
	}
	// System.out.printf("%d to the power of %d modulo %d is %d\n", base, exp, mod,
	// ret);
	return ret;
    }

    public static int countFactors(int n, int r, int prime) {
	return countFactors(n, prime) - countFactors(n - r, prime) - countFactors(r, prime);
    }

    public static int countFactors(int n, int prime) {
	int total = 0;
	while (n >= prime) {
	    n /= prime;
	    total += n;
	}
	return total;
    }

    public static void precompute() {
	// compute 1! to 10! mod 11
	// compute 1! to 12! mod 13
	// compute 1! to 36! mod 37
	// also compute all the inverses
	// compute 1! to 26! mod 27 (ignoring powers of 3?)
	// also compute inverse
	mod11 = new int[11][2];
	mod13 = new int[13][2];
	mod37 = new int[37][2];
	mod27 = new int[27][2];
	mod11[0][0] = mod11[0][1] = mod13[0][0] = mod13[0][1] = 1;
	mod37[0][0] = mod37[0][1] = mod27[0][0] = mod27[0][1] = 1;

	int[] temp = getInverses(11);
	for (int i = 1; i < 11; ++i) {
	    mod11[i][0] = (mod11[i - 1][0] * i) % 11;
	    mod11[i][1] = temp[mod11[i][0]];
	}

	temp = getInverses(13);
	for (int i = 1; i < 13; ++i) {
	    mod13[i][0] = (mod13[i - 1][0] * i) % 13;
	    mod13[i][1] = temp[mod13[i][0]];
	}

	temp = getInverses(37);
	for (int i = 1; i < 37; ++i) {
	    mod37[i][0] = (mod37[i - 1][0] * i) % 37;
	    mod37[i][1] = temp[mod37[i][0]];
	}

	temp = getInverses(27);
	for (int i = 1; i < 27; ++i) {
	    int tempi = i;
	    if (tempi % 3 == 0)
		tempi = 1;
	    mod27[i][0] = (mod27[i - 1][0] * tempi) % 27;
	    mod27[i][1] = temp[mod27[i][0]];
	}

	map = new HashMap<Integer, int[][]>();
	map.put(11, mod11);
	map.put(13, mod13);
	map.put(27, mod27);
	map.put(37, mod37);
    }

    public static int[] getInverses(int prime) {
	int[] ret = new int[prime];
	for (int i = 1; i < ret.length; ++i) {
	    for (int j = 1; j < ret.length; ++j) {
		if (i * j % ret.length == 1) {
		    ret[i] = j;
		    break;
		}
	    }
	}
	return ret;
    }

    public static int computeCombination(int n, int r) {
	precompute();
	return choose(n, r);
    }

    public static long pow(long a, long n, long mod) {
	a %= mod;
	long ret = 1 % mod;
	int x = 63 - Long.numberOfLeadingZeros(n);
	for (; x >= 0; x--) {
	    ret = ret * ret % mod;
	    if (n << 63 - x < 0)
		ret = ret * a % mod;
	}
	return ret;
    }

    public static long invl(long a, long mod) {
	long b = mod;
	long p = 1, q = 0;
	while (b > 0) {
	    long c = a / b;
	    long d;
	    d = a;
	    a = b;
	    b = d % b;
	    d = p;
	    p = q;
	    q = d - c * q;
	}
	return p < 0 ? p + mod : p;
    }

    
    /**
     * @param k the divisor
     * @param s an array of integers
     * @return maximum possible size of a set such that any two numbers when added would not be divisible by k 
     */
    public static int nonDivisibleSubset(int k, int[] s) {
	int n = s.length;
	int[] C = new int[k];
	for (int i = 0; i < n; ++i)
	    C[s[i] % k]++; // Calculate modulii count
	int ans = 0;
	for (int i = 0; i < k; ++i) {
	    int need = (k - i) % k;
	    if (need <= i) {
		if (need == i) {
		    ans += Math.min(C[i], 1);
		}
	    } else {
		ans += Math.max(C[i], C[need]);
	    }
	}
	return ans;
    }

}
