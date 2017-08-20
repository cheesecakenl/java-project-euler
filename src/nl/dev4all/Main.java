package nl.dev4all;

import nl.dev4all.problems.Problem18;
import nl.dev4all.problems.Problem_15;

/**
 * @author boy
 */
public class Main {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Problem18 p = new Problem18();

        long duration = System.currentTimeMillis() - start;

        System.out.println("Done in " + duration + "ms");
    }
}
