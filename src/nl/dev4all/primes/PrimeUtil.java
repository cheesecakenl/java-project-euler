package nl.dev4all.primes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author boy
 */
public class PrimeUtil {

    public PrimeUtil() {
    }

    public BigInteger getLargestPrimeFactorForBigInt(List<BigInteger> primes, BigInteger n) {
        for (BigInteger x : primes) {
            if (n.mod(x) == BigInteger.ZERO)
                return x;
        }

        return BigInteger.ONE;
    }

    public Integer getLargestPrimeFactorForInt(List<Integer> primes, BigInteger n) {
        for (Integer x : primes) {
            BigInteger prime = new BigInteger(x.toString());

            if (n.mod(prime) == BigInteger.ZERO)
                return x;
        }

        return 1;
    }

    /* Find primes by halves. 1.5, 2.5, 3.5 etc... */
    public List<BigInteger> getPrimesBoy(Integer n) {

        List<BigInteger> primes = new ArrayList();
        List<BigDecimal> decimals = new ArrayList();

        BigDecimal firstDiv = new BigDecimal("1.5");
        BigDecimal start = new BigDecimal("2.5");
        BigDecimal TWO = new BigDecimal("2");

        BigDecimal max = new BigDecimal(n).divide(TWO);

        decimals.add(firstDiv);

        for (BigDecimal bigDec = start; bigDec.compareTo(max) < 0; bigDec = bigDec.add(BigDecimal.ONE)) {

            boolean divisible = false;
            for (int i=0; i < decimals.size(); i++) {
                BigDecimal[] remainders = bigDec.divideAndRemainder(decimals.get(i));
                if (remainders[1].compareTo(BigDecimal.ZERO) == 0) {
                    divisible = true;
                    break;
                }
            }

            if (!divisible) {
                BigInteger prime = bigDec.multiply(TWO).toBigInteger();
                primes.add(prime);
                decimals.add(bigDec);
            }
        }

        return primes;
    }
}
