package nl.dev4all.problems;

import nl.dev4all.numbers.NumberUtil;

/**
 * @author boy
 */
public class Problem_4 {
    /*
     * A palindromic number reads the same both ways. The largest palindrome made from the product of
     * two 2-digit numbers is 9009 = 91 × 99.
     * Find the largest palindrome made from the product of two 3-digit numbers.
     */
    public Problem_4() {
        NumberUtil numberUtil = new NumberUtil();
        int min = 99;
        int max = 999;

        Integer answer = numberUtil.getLargestFactoredPalinDrome(min, max);
        System.out.println(answer);
    }
}
