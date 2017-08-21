package nl.dev4all.problems;

/*
    Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
    By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
*/
public class Problem2 {

    public void solve() {
        int max = 4000000;
        int sum = 0;

        int term1 = 1;
        int term2 = 2;

        for (int i = 0; ; i++) {
            int value = term1 + term2;

            if (value > max) {
                break;
            }

            if (value % 2 == 0) {
                sum += value;
            }

            term1 = term2;
            term2 = value;
        }

        System.out.println(sum + 2);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Problem2 problem = new Problem2();
        problem.solve();

        long duration = System.currentTimeMillis() - start;

        System.out.println("Done in " + duration + "ms");
    }
}