package com.andreasanta.PrimeProducer.strategies;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.math.BigInteger;

/**
 * Optimized brute force strategy with sqrt(target) factor check.
 */
public class VedicBruteforceStrategy implements IPrimeGenerationStratregy {

    public List<Integer> generate(int toNumber) {
        return IntStream.rangeClosed(2, toNumber).filter(x -> this.isPrime(x)).boxed().collect(Collectors.toList());
    }

    public boolean isPrime(int number) {
        BigInteger b = BigInteger.valueOf(2);
        return b.pow(number - 1).mod(BigInteger.valueOf(number)).intValue() == 1;
    }

}
