package nl.dev4all;

import nl.dev4all.problems.Problem_15;

/**
 * @author boy
 */
public class Main {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Problem_15 p = new Problem_15();

        long duration = System.currentTimeMillis() - start;

        System.out.println("Done in " + duration + "ms");
    }
}
