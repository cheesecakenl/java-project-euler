package nl.dev4all.problems;

import nl.dev4all.numbers.NumberUtil;

import java.math.BigInteger;

/**
 *
 * @author boy
 */
public class Problem_16 {

    /*
    2 to the 15th = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
    What is the sum of the digits of the number 2 to the 1000th?
    */
    public Problem_16() {

        BigInteger TWO = new BigInteger("2");
        BigInteger sum = new BigInteger("2");

        for (int i=0; i < 999; i++) {
            sum = sum.multiply(TWO);
        }

        NumberUtil numberUtil = new NumberUtil();
        int answer = numberUtil.getSumOfStringOfNumbers(sum.toString());

        System.out.println(answer);
    }
}
