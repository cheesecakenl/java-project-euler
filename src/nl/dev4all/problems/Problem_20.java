package nl.dev4all.problems;

import nl.dev4all.numbers.NumberUtil;

import java.math.BigInteger;

/**
 *
 * @author boy
 */
public class Problem_20 {

    /*
    n! means n × (n − 1) × ... × 3 × 2 × 1

    For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
    and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

    Find the sum of the digits in the number 100!
     */
    public Problem_20() {
        NumberUtil numberUtil = new NumberUtil();
        BigInteger n = numberUtil.getFacultyN(100);

        System.out.println(numberUtil.getSumOfStringOfNumbers(n.toString()));
    }
}
