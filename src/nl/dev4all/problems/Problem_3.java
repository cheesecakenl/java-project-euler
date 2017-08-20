package nl.dev4all.problems;

import nl.dev4all.numbers.NumberUtil;
import nl.dev4all.primes.PrimeUtil;
import nl.dev4all.primes.Sieve;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author boy
 */
public class Problem_3 {

    private BigDecimal input = new BigDecimal("600851475143");

    public Problem_3() {
        PrimeUtil primeUtil = new PrimeUtil();
        NumberUtil numberUtil = new NumberUtil();

        /* Get square root of input first */
        BigInteger sqrt = numberUtil.getSquareRoot(input).toBigInteger();

        /* Use Sieve of Eratosthenes to get primes up to square root */
        Sieve sieve = new Sieve(sqrt.intValue());
        List<Integer> primes = sieve.getPrimeNumbersUpToN(sqrt.intValue());

        /* Reverse List to check largest first */
        Collections.reverse(primes);
        Integer largest = primeUtil.getLargestPrimeFactorForInt(primes, input.toBigInteger());

        System.out.println(largest);
    }
}
