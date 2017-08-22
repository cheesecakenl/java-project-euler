package nl.dev4all.problems;

import nl.dev4all.input.InputUtil;

import java.util.Collections;
import java.util.List;

public class Problem22 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Problem22 problem = new Problem22();
        problem.solve();

        long duration = System.currentTimeMillis() - start;

        System.out.println();
        System.out.println("Done in " + duration + "ms");
    }

    public void solve() {
        List<String> names = InputUtil.getListOfNames("input/p022_names.txt", ",", "\"");

        Collections.sort(names);

        int score = 0;
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            int pos = i+1;
            score += getScore(name) * pos;
        }

        System.out.println(score);
    }

    private int getScore(String name) {
        int score = 0;

        char[] ch = name.toCharArray();
        for (char c : ch) {
            int temp = (int) c;
            int temp_integer = 64; // for upper case
            if (temp <= 90 & temp >= 65) {
                score += temp - temp_integer;
            }
        }

        return score;
    }
}