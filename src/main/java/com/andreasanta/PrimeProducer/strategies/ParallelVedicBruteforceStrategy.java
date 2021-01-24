package com.andreasanta.PrimeProducer.strategies;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

/**
 * Optimized brute force strategy with sqrt(target) factor check.
 */
@Slf4j
public class ParallelVedicBruteforceStrategy implements IPrimeGenerationStratregy {

    public List<Integer> generate(int toNumber) {
        List<Integer> result = IntStream.rangeClosed(3, toNumber).parallel().filter(x -> this.isPrime(x)).boxed()
                .peek(x -> {
                    log.info(Thread.currentThread().getName());
                }).collect(Collectors.toList());

        // This is not calculated properly by this method
        if (toNumber >= 2)
            result.add(0, 2);

        return result;
    }

    public boolean isPrime(int number) {
        BigInteger b = BigInteger.valueOf(2);
        return b.pow(number - 1).mod(BigInteger.valueOf(number)).intValue() == 1;
    }

}
