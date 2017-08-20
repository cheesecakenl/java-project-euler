package nl.dev4all.problems;

public class Problem_15 {

    public Problem_15() {
        int size = 20;
        long[][] rows = new long[size-1][size+1];

        for (int j = 0; j < size+1; j++) {
            rows[0][j] = j+1L;
        }

        for (int i = 1; i < size-1; i++) {
            for (int j = 0; j < size+1; j++) {
                long result =0;
                for (int k = 0; k < j+1; k++) {
                    result += rows[i-1][k];
                }
                rows[i][j] = result;

            }
        }

        System.out.println(rows[size-2][size]*2);
    }
}
