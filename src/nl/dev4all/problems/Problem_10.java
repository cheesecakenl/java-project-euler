package nl.dev4all.problems;

import nl.dev4all.primes.Sieve;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author boy
 */
public class Problem_10 {

    /*
    The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
    Find the sum of all the primes below two million.
     */
    public Problem_10() {
        int max = 2000000;
        Sieve sieve = new Sieve(max);
        List<Integer> primes = sieve.getPrimeNumbersUpToN(max);

        /* Answer is too large for 32-bit integer */
        BigInteger sum = BigInteger.ZERO;
        for (Integer i : primes) {
            sum = sum.add(new BigInteger(i.toString()));
        }

        System.out.println(sum);
    }
}
