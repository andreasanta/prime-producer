package com.andreasanta.PrimeProducer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import com.andreasanta.PrimeProducer.strategies.*;

@SpringBootTest
class PrimeProducerApplicationTests {

	private static final int FIRST_HUNDRED_PRIMES[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
			61, 67, 71, 73, 79, 83, 89, 97 };

	/*
	 * SQRT brute force
	 */

	@Test
	void sqrtBruteforceFirst100() {
		SqrtBruteforceStrategy s = new SqrtBruteforceStrategy();
		List<Integer> p = s.generate(100);

		assertArrayEquals(FIRST_HUNDRED_PRIMES, p.stream().mapToInt(v -> v).toArray(),
				"SQRT Brute Force wrong first 100 primes");
	}

	@Test
	void sqrtBruteforce0() {
		SqrtBruteforceStrategy s = new SqrtBruteforceStrategy();
		List<Integer> p = s.generate(0);

		assertArrayEquals(new int[] {}, p.stream().mapToInt(v -> v).toArray(), "SQRT Brute Force wrong empty array");
	}

	@Test
	void sqrtBruteforce1() {
		SqrtBruteforceStrategy s = new SqrtBruteforceStrategy();
		List<Integer> p = s.generate(1);

		assertArrayEquals(new int[] {}, p.stream().mapToInt(v -> v).toArray(), "SQRT Brute Force wrong primitive 1");
	}

	@Test
	void sqrtBruteforce2() {
		SqrtBruteforceStrategy s = new SqrtBruteforceStrategy();
		List<Integer> p = s.generate(2);

		assertArrayEquals(new int[] { 2 }, p.stream().mapToInt(v -> v).toArray(), "SQRT Brute Force wrong primitive 2");
	}

	@Test
	void sqrtBruteforce3() {
		SqrtBruteforceStrategy s = new SqrtBruteforceStrategy();
		List<Integer> p = s.generate(3);

		assertArrayEquals(new int[] { 2, 3 }, p.stream().mapToInt(v -> v).toArray(),
				"SQRT Brute Force wrong primitive 3");
	}

	/*
	 * Vedic bruteforce
	 */

	@Test
	void vedicBruteforceFirst100() {
		VedicBruteforceStrategy s = new VedicBruteforceStrategy();
		List<Integer> p = s.generate(100);

		assertArrayEquals(FIRST_HUNDRED_PRIMES, p.stream().mapToInt(v -> v).toArray(),
				"Vedic Brute Force wrong first 100 primes");
	}

	@Test
	void vedicBruteforce0() {
		VedicBruteforceStrategy s = new VedicBruteforceStrategy();
		List<Integer> p = s.generate(0);

		assertArrayEquals(new int[] {}, p.stream().mapToInt(v -> v).toArray(), "Vedic Brute Force wrong empty array");
	}

	@Test
	void vedicBruteforce1() {
		VedicBruteforceStrategy s = new VedicBruteforceStrategy();
		List<Integer> p = s.generate(1);

		assertArrayEquals(new int[] {}, p.stream().mapToInt(v -> v).toArray(), "Vedic Brute Force wrong primitive 1");
	}

	@Test
	void vedicBruteforce2() {
		VedicBruteforceStrategy s = new VedicBruteforceStrategy();
		List<Integer> p = s.generate(2);

		assertArrayEquals(new int[] { 2 }, p.stream().mapToInt(v -> v).toArray(),
				"Vedic Brute Force wrong primitive 2");
	}

	@Test
	void vedicBruteforce3() {
		VedicBruteforceStrategy s = new VedicBruteforceStrategy();
		List<Integer> p = s.generate(3);

		assertArrayEquals(new int[] { 2, 3 }, p.stream().mapToInt(v -> v).toArray(),
				"Vedic Brute Force wrong primitive 3");
	}

	/*
	 * Atkin
	 */

	@Test
	void soaBruteforceFirst100() {
		SieveOfAtkin s = new SieveOfAtkin();
		List<Integer> p = s.generate(100);

		assertArrayEquals(FIRST_HUNDRED_PRIMES, p.stream().mapToInt(v -> v).toArray(),
				"SoA Brute Force wrong first 100 primes");
	}

	@Test
	void soaBruteforce0() {
		SieveOfAtkin s = new SieveOfAtkin();
		List<Integer> p = s.generate(0);

		assertArrayEquals(new int[] {}, p.stream().mapToInt(v -> v).toArray(), "SoA Brute Force wrong empty array");
	}

	@Test
	void soaBruteforce1() {
		SieveOfAtkin s = new SieveOfAtkin();
		List<Integer> p = s.generate(1);

		assertArrayEquals(new int[] {}, p.stream().mapToInt(v -> v).toArray(), "SoA Brute Force wrong primitive 1");
	}

	@Test
	void soaBruteforce2() {
		SieveOfAtkin s = new SieveOfAtkin();
		List<Integer> p = s.generate(2);

		assertArrayEquals(new int[] { 2 }, p.stream().mapToInt(v -> v).toArray(), "SoA Brute Force wrong primitive 2");
	}

	@Test
	void soaBruteforce3() {
		SieveOfAtkin s = new SieveOfAtkin();
		List<Integer> p = s.generate(3);

		assertArrayEquals(new int[] { 2, 3 }, p.stream().mapToInt(v -> v).toArray(),
				"SoA Brute Force wrong primitive 3");
	}

	/*
	 * Eratosthenes
	 */

	@Test
	void soeBruteforceFirst100() {
		SieveOfEratosthenes s = new SieveOfEratosthenes();
		List<Integer> p = s.generate(100);

		assertArrayEquals(FIRST_HUNDRED_PRIMES, p.stream().mapToInt(v -> v).toArray(),
				"SoE Brute Force wrong first 100 primes");
	}

	@Test
	void soeBruteforce0() {
		SieveOfEratosthenes s = new SieveOfEratosthenes();
		List<Integer> p = s.generate(0);

		assertArrayEquals(new int[] {}, p.stream().mapToInt(v -> v).toArray(), "SoE Brute Force wrong empty array");
	}

	@Test
	void soeBruteforce1() {
		SieveOfEratosthenes s = new SieveOfEratosthenes();
		List<Integer> p = s.generate(1);

		assertArrayEquals(new int[] {}, p.stream().mapToInt(v -> v).toArray(), "SoE Brute Force wrong primitive 1");
	}

	@Test
	void soeBruteforce2() {
		SieveOfEratosthenes s = new SieveOfEratosthenes();
		List<Integer> p = s.generate(2);

		assertArrayEquals(new int[] { 2 }, p.stream().mapToInt(v -> v).toArray(), "SoE Brute Force wrong primitive 2");
	}

	@Test
	void soeBruteforce3() {
		SieveOfEratosthenes s = new SieveOfEratosthenes();
		List<Integer> p = s.generate(3);

		assertArrayEquals(new int[] { 2, 3 }, p.stream().mapToInt(v -> v).toArray(),
				"SoE Brute Force wrong primitive 3");
	}

	/*
	 * Eratosthenes
	 */

	@Test
	void sosBruteforceFirst100() {
		SieveOfSundaram s = new SieveOfSundaram();
		List<Integer> p = s.generate(100);

		assertArrayEquals(FIRST_HUNDRED_PRIMES, p.stream().mapToInt(v -> v).toArray(),
				"SoS Brute Force wrong first 100 primes");
	}

	@Test
	void sosBruteforce0() {
		SieveOfSundaram s = new SieveOfSundaram();
		List<Integer> p = s.generate(0);

		assertArrayEquals(new int[] {}, p.stream().mapToInt(v -> v).toArray(), "SoS Brute Force wrong empty array");
	}

	@Test
	void sosBruteforce1() {
		SieveOfSundaram s = new SieveOfSundaram();
		List<Integer> p = s.generate(1);

		assertArrayEquals(new int[] {}, p.stream().mapToInt(v -> v).toArray(), "SoS Brute Force wrong primitive 1");
	}

	@Test
	void sosBruteforce2() {
		SieveOfSundaram s = new SieveOfSundaram();
		List<Integer> p = s.generate(2);

		assertArrayEquals(new int[] { 2 }, p.stream().mapToInt(v -> v).toArray(), "SoS Brute Force wrong primitive 2");
	}

	@Test
	void sosBruteforce3() {
		SieveOfSundaram s = new SieveOfSundaram();
		List<Integer> p = s.generate(3);

		assertArrayEquals(new int[] { 2, 3 }, p.stream().mapToInt(v -> v).toArray(),
				"SoS Brute Force wrong primitive 3");
	}

}
