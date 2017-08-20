package nl.dev4all.problems;

/**
 *
 * @author boy
 */
public class Problem_9 {
    /*
    A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a2 + b2 = c2

    For example, 32 + 42 = 9 + 16 = 25 = 52.

    There exists exactly one Pythagorean triplet for which a + b + c = 1000.
    Find the product abc.
     */

    public Problem_9() {
        for (int c = 999; c > 2; c--) {
            for (int b = 2; b < c; b++) {
                for (int a = 1; a < b; a++) {

                    /* Only check when the sum is 1000 */
                    if (a + b + c == 1000) {    

                        /* Check to see if a2 + b2 = c2 */
                        if (a*a+b*b == c*c) {
                            System.out.println(a * b * c);
                            return;
                        }
                    }
                }
            }
        }
    }
}