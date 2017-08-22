package nl.dev4all.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem21 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Problem21 problem = new Problem21();
        problem.solve();

        long duration = System.currentTimeMillis() - start;

        System.out.println();
        System.out.println("Done in " + duration + "ms");
    }

    public void solve() {
        int total = 0;
        int max = 10000;

        List<Integer> pairs = new ArrayList();

        for (int i = 1; i < max; i++) {
            int sum1 = getSumOfDivisors(i);
            int sum2 = getSumOfDivisors(sum1);

            if (sum2 == i && sum1 != sum2 && !pairs.contains(sum2)) {
                pairs.add(sum1);
                pairs.add(sum2);

                //System.out.println(i);
                //System.out.println(sum1);
                //System.out.println(sum2);
                //System.out.println();
            }
        }

        for (Integer n : pairs) {
            total += n;
        }

        System.out.println(total);
    }

    private int getSumOfDivisors(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        
        return sum;
    }
}
