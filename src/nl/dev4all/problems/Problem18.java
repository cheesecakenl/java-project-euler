package nl.dev4all.problems;

import nl.dev4all.input.InputUtil;

import java.math.BigInteger;
import java.util.List;

public class Problem18 {
    /*
        By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

            3
           7 4
          2 4 6
         8 5 9 3

        That is, 3 + 7 + 4 + 9 = 23.

        Find the maximum total from top to bottom of the triangle below:
    */
    public void solve() {
        List<BigInteger> numbers = InputUtil.readInput("input/input_problem_18.txt", " ");

        for (BigInteger n : numbers) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Problem18 problem = new Problem18();
        problem.solve();

        long duration = System.currentTimeMillis() - start;

        System.out.println("Done in " + duration + "ms");
    }
}
