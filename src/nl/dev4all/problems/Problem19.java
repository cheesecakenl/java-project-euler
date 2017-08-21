package nl.dev4all.problems;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Problem19 {

    public void solve() {
        Calendar start = new GregorianCalendar();
        start.set(1901, 1, 1);

        Calendar end = new GregorianCalendar();
        end.set(2000, 12, 31);

        int total = 0;

        while (true) {
            if (start.getTime().after(end.getTime())) {
                break;
            }

            int dayOfMonth = start.get(Calendar.DAY_OF_MONTH);
            int dayOfTheWeek = start.get(Calendar.DAY_OF_WEEK);

            if (dayOfMonth == 1 && dayOfTheWeek == 7) {
                total++;
            }

            // add one day
            start.add(Calendar.DATE, 1);
        }

        System.out.println(total);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Problem19 problem = new Problem19();
        problem.solve();

        long duration = System.currentTimeMillis() - start;

        System.out.println();
        System.out.println("Done in " + duration + "ms");
    }
}
