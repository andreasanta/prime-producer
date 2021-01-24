package com.andreasanta.PrimeProducer.strategies;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Optimized brute force strategy with sqrt(target) factor check.
 */
public class SqrtBruteforceStrategy implements IPrimeGenerationStratregy {

    public List<Integer> generate(int toNumber) {
        return IntStream.rangeClosed(2, toNumber).filter(x -> this.isPrime(x)).boxed().collect(Collectors.toList());
    }

    public boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number))).allMatch(n -> number % n != 0);
    }

}
