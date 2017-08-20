package nl.dev4all.numbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author boy
 */
public class NumberUtil {

    private final int DEFAULT_ITERATIONS = 50;
    private final int DEFAULT_SCALE = 0; // number of decimals
    private final BigDecimal TWO = new BigDecimal("2");

    public boolean isEvenlyDivisibleBy_1_to_20(BigInteger x) {
        String[] factors = new String[]{"19", "18", "17", "16", "15", "14", "13", "12", "11"};

        for (String str : factors) {
            BigInteger factor = new BigInteger(str);

            if (x.mod(factor) != BigInteger.ZERO) {
                return false;
            }
        }

        return true;
    }

    private BigDecimal getInitialRootApproximation(BigDecimal n) {
        BigInteger integerPart = n.toBigInteger();
        int length = integerPart.toString().length();
        if ((length % 2) == 0) {
            length--;
        }
        length /= 2;
        BigDecimal guess = BigDecimal.ONE.movePointRight(length);

        return guess;
    }

    /*
     * Herons method.
     * @see http://en.wikipedia.org/wiki/Methods_of_computing_square_roots
     */
    public BigDecimal getSquareRoot(BigDecimal n) {
        if (n.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal initialGuess = getInitialRootApproximation(n);
        BigDecimal lastGuess = BigDecimal.ZERO;
        BigDecimal guess = new BigDecimal(initialGuess.toString());        

        int iterations = 0;
        boolean more = true;

        while (more) {
            lastGuess = guess;
            guess = n.divide(guess, DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
            guess = guess.add(lastGuess);
            guess = guess.divide(TWO, DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);

            if (++iterations >= DEFAULT_ITERATIONS) {
                more = false;
            }
        }

        return guess;
    }

    public boolean isPalindrome(Integer n) {
        if (n == null || n < 1)
            throw new IllegalArgumentException();

        String numbers = n.toString();
        int len = numbers.length();

        for (int i=0; i < len; i++) {
            if (numbers.charAt(i) != numbers.charAt(len-1-i))
                return false;
        }

        return true;
    }

    public Integer getLargestFactoredPalinDrome(int min, int max) {
        /* Loop factors from max to min and make list of all the palindromes */
        List<Integer> palinDromes = new ArrayList();
        for (int i=max; i > min; i--) {
            for (int j=max; j > min; j--) {
                if (i < j)
                    continue;

                int val = i * j;

                if (isPalindrome(val)) {
                    palinDromes.add(val);
                    break;
                }
            }
        }

        /* Sort List and display last (biggest) value */
        Collections.sort(palinDromes);
        return palinDromes.get(palinDromes.size()-1);
    }

    public int getLargestProductOfConsecutiveN(int con, String n) {
        int product = 0;

        for (int i=0; i < n.length() - con; i++) {
            int tmp = 1;

            for (int j=0; j < con; j++) {
                int number = Character.digit(n.charAt(i+j),10);
                tmp = tmp * number;
            }

            if (product < tmp)
                product = tmp;
        }

        return product;
    }

    private boolean isWholeNumber(double n) {
        int x = (int) n;

        if (n % x != 0) {
            return false;
        }

        return true;
    }

    public int getSumOfStringOfNumbers(String n) {
        int sum = 0;

        for (int i=0; i < n.length(); i++) {
            int number = Character.digit(n.charAt(i),10);

            sum += number;

        }

        return sum;
    }

    public BigInteger getFacultyN(int n) {
        BigInteger fac = BigInteger.ONE;

        for (int i=n; i > 0; i--) {
            fac = fac.multiply(new BigInteger(Integer.toString(i)));
        }

        return fac;
    }

    public int[][] convertStringToNumberGrid(String seperator, String gridString, int sizeHor, int sizeVer) {
        int[][] grid = new int[sizeHor][sizeVer];

        String[] arr = gridString.split(seperator);

        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = new Integer(arr[i]);

            grid[x][y] = val;

            if (x > sizeHor-2) {
                x = 0;
                y++;
            } else {
                x++;
            }
        }

        return grid;
    }
}
