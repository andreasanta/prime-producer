package com.andreasanta.PrimeProducer.strategies;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelSieveOfEratosthenes implements IPrimeGenerationStratregy {

    public List<Integer> generate(int toNumber) {

        // Initialize the list with trues
        BitSet primeList = new BitSet(toNumber + 1);
        primeList.set(0, toNumber + 1, true);

        // Loop over numbers < sqrt(limit) and mark multiples as false
        IntStream.rangeClosed(2, (int) (Math.sqrt(toNumber))).parallel().forEach(m -> {
            synchronized (primeList) {
                if (primeList.get(m)) {
                    for (int i = m * 2; i <= toNumber; i += m) {
                        primeList.set(i, false);
                    }
                }
            }
        });

        List<Integer> primeNumbers = new LinkedList<Integer>();
        IntStream.rangeClosed(2, toNumber).forEach(x -> {
            if (primeList.get(x))
                primeNumbers.add(x);
        });

        return primeNumbers;
    }

}
