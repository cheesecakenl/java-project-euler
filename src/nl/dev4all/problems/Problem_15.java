package nl.dev4all.problems;

import java.math.BigInteger;

/*
    Project Euler Problem 15. Lattice paths. See https://projecteuler.net/problem=15
 */
public class Problem_15 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Problem_15 problem = new Problem_15();
        problem.solve();

        long duration = System.currentTimeMillis() - start;

        System.out.println();
        System.out.println("Done in " + duration + "ms");
    }

    /*
        Formula for solving Lattice path with two possible steps

        (n+m)!
        ------
        n!*m!
    */
    public void solve() {
        long n = 20;
        long m = 20;

        BigInteger a = factorial(n + m);
        BigInteger b = factorial(n);
        BigInteger c = factorial(m);
        BigInteger d = b.multiply(c);

        System.out.println(a.divide(d));
    }

    private BigInteger factorial(long n) {
        BigInteger total = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            total = total.multiply(BigInteger.valueOf(i));
        }

        return total;
    }
}