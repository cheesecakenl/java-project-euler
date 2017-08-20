package nl.dev4all.problems;

import java.math.BigDecimal;

/*
    * Riemann hypothesis
    * See: http://www.claymath.org/millennium-problems/riemann-hypothesis
    * ζ(s) = 1 + 1/2s + 1/3s + 1/4s + ...
    * s > 1 = convergent
    * s < 1 = divergent
*/
public class Problem_Riemann {
    private int precision = 100;
    private int rounding = BigDecimal.ROUND_HALF_UP;

    public Problem_Riemann(double s) {
        BigDecimal one = new BigDecimal("1");
        BigDecimal result = new BigDecimal("1");

        for (int i = 2; i < 1000; i++) {
            BigDecimal pow = new BigDecimal(Math.pow(i, s));
            BigDecimal div = one.divide(pow, precision, rounding);

            result = result.add(div);
        }

        System.out.println(result);
    }
}
