package com.andreasanta.PrimeProducer.strategies;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class SieveOfSundaram implements IPrimeGenerationStratregy {

    public List<Integer> generate(int toNumber) {

        BitSet primeList = new BitSet(toNumber + 1);

        // Sundaram generates primes < 2x + 2, so we compensate
        int limit = (toNumber - 1) / 2;

        // Mark numbers in form m + j + 2mj as true, if 1 <= m <= j
        IntStream.rangeClosed(1, limit).forEach(m -> {
            for (int i = m; (m + i + 2 * i * m) <= limit; ++i)
                primeList.set(i + m + 2 * i * m, true);
        });

        List<Integer> primeNumbers = new LinkedList<Integer>();
        if (toNumber >= 2)
            primeNumbers.add(2);
        if (toNumber >= 3)
            primeNumbers.add(3);

        IntStream.rangeClosed(2, limit).forEach(x -> {
            if (!primeList.get(x))
                primeNumbers.add(2 * x + 1);
        });

        return primeNumbers;
    }

}
