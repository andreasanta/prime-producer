package com.andreasanta.PrimeProducer.strategies;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class SieveOfAtkin implements IPrimeGenerationStratregy {

    public List<Integer> generate(int toNumber) {

        BitSet primeList = new BitSet(toNumber + 1);

        // Set number 2 and 3 as primes
        if (toNumber >= 2)
            primeList.set(2, true);

        if (toNumber >= 3)
            primeList.set(3, true);

        int equationRoot = (int) Math.ceil(Math.sqrt(toNumber));

        for (int x = 1; x < equationRoot; ++x) {

            int x2 = (int) Math.pow(x, 2);

            for (int y = 1; y < equationRoot; ++y) {

                int y2 = (int) Math.pow(y, 2);

                // Equation 1
                int n = 4 * x2 + y2;
                if (n <= toNumber && (n % 12 == 1 || n % 12 == 5))
                    primeList.set(n, !primeList.get(n));

                // Equation 2
                n = 3 * x2 + y2;
                if (n <= toNumber && n % 12 == 7)
                    primeList.set(n, !primeList.get(n));

                // Equation 3
                n = 3 * x2 - y2;
                if ((x > y) && (n <= toNumber) && (n % 12 == 11))
                    primeList.set(n, !primeList.get(n));
            }

        }

        // Sift out multiples of its square and composites
        for (int i = 5; i <= equationRoot; ++i)
            if (primeList.get(i)) {
                int i2 = (int) Math.pow(i, 2);
                for (int j = i2; j < toNumber; j += i2)
                    primeList.set(j, false);
            }

        List<Integer> primeNumbers = new LinkedList<Integer>();
        IntStream.rangeClosed(2, toNumber).forEach(x -> {
            if (primeList.get(x))
                primeNumbers.add(x);
        });

        return primeNumbers;
    }

}
