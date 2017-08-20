package nl.dev4all.problems;

import nl.dev4all.primes.Sieve;

import java.util.List;

/**
 *
 * @author boy
 */
public class Problem_7 {

    /*
     * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
     * What is the 10001st prime number?
     */
    public Problem_7() {

        /* Use Sieve of Eratosthenes to get about 10.0000 primes */
        int max = 125000;

        Sieve sieve = new Sieve(max);
        List<Integer> primes = sieve.getPrimeNumbersUpToN(max);

        System.out.println(primes.get(10000));
    }
}
