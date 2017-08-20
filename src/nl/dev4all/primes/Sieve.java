package nl.dev4all.primes;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 *
 * @author boy
 */
public class Sieve {

    private BitSet sieve;

    /*
     * Sieve of Eratosthenes
     * @see http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     */
    public Sieve(int size) {
        sieve = new BitSet((size + 1) / 2);
    }

    public boolean is_composite(int k) {
        assert k >= 3 && (k % 2) == 1;
        return sieve.get((k - 3) / 2);
    }

    public void set_composite(int k) {
        assert k >= 3 && (k % 2) == 1;
        sieve.set((k - 3) / 2);
    }

    public List<Integer> getPrimeNumbersUpToN(int max) {
        Sieve mySieve = new Sieve(max + 1); // +1 to include max itself
        for (int i = 3; i * i <= max; i += 2) {
            if (mySieve.is_composite(i)) {
                continue;
            }

            // We increment by 2*i to skip even multiples of i
            for (int multiple_i = i * i; multiple_i <= max; multiple_i += 2 * i) {
                mySieve.set_composite(multiple_i);
            }
        }

        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);

        for (int i = 3; i <= max; i += 2) {
            if (!mySieve.is_composite(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

    /* test sieve */
    public static void main(String[] args) {
        int max = 100;
        Sieve sieve = new Sieve(max);
        List<Integer> primes = sieve.getPrimeNumbersUpToN(max);

        for (Integer i : primes) {
            System.out.println(i);
        }
    }
}
