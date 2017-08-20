package nl.dev4all.problems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author boy
 */
public class Problem_14 {

    private long startNumber = 0;
    private int biggestSize = 0;

    /*
    The following iterative sequence is defined for the set of positive integers:

    n → n/2 (n is even)
    n → 3n + 1 (n is odd)

    Using the rule above and starting with 13, we generate the following sequence:
    13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

    It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
    Although it has not been proved yet (Collatz Problem), it is thought that all starting
    numbers finish at 1.

    Which starting number, under one million, produces the longest chain?

    NOTE: Once the chain starts the terms are allowed to go above one million.
     */
    public Problem_14() {

        for (int i = 1; i < 1000000; i++) {
            doSequence(new Long(i));
        }

        System.out.println(startNumber);
    }

    private void doSequence(Long n) {
        List<Long> list = new ArrayList();

        list.add(n);

        /* Check as long as value is not 1 */
        while (list.get(list.size() - 1) > 1) {
            long current = list.get(list.size() - 1);
            long newValue = 0;
            
            if (current % 2 == 0) {
                newValue = current / 2;
            } else {
                newValue = current * 3 + 1;
            }

            list.add(newValue);
        }
        
        if (biggestSize < list.size()) {
            biggestSize = list.size();
            startNumber = list.get(0);            
        }

        list.clear();
    }
}
