package nl.dev4all.problems;

import nl.dev4all.input.InputUtil;
import nl.dev4all.piramid.NumberPiramid;
import nl.dev4all.piramid.Row;

public class Problem67 {

    private static boolean DEBUG_MODE = true;

    public void solve() {
        NumberPiramid piramid = InputUtil.createNumberPiramid("input/input_problem_67.txt", " ");

        int top = piramid.getRows().get(0).getValues()[0];

        int rows = piramid.getRows().size();

        Row newRow = new Row();
        newRow.setNumber(rows);

        int[] bottomRowValues = piramid.getRows().get(rows-1).getValues();
        newRow.setValues(bottomRowValues);

        NumberPiramid newPiramid = new NumberPiramid();

        for (int i = rows-1; i >= 0 ; i--) {
            if (i-2 < 0) {
                break;
            }

            int[] currentValues = newRow.getValues();
            int[] valuesRowAbove = piramid.getRows().get(i-1).getValues();

            int[] newValues = new int[valuesRowAbove.length];

            for (int j = 0; j < currentValues.length; j++) {
                int aboveValue;

                int newIndex;
                if (j == 0) {
                    newIndex = 0;
                } else if (j == currentValues.length-1){
                    newIndex = j-1;
                } else {
                    newIndex = j;
                }

                aboveValue = valuesRowAbove[newIndex];

                int currentValue1;
                int currentValue2;

                if (j == currentValues.length-1) {
                    currentValue1 = currentValues[j];
                    currentValue2 = 0;
                } else {
                    currentValue1 = currentValues[j];
                    currentValue2 = currentValues[j+1];
                }

                int sum1 = aboveValue + currentValue1;
                int sum2 = aboveValue + currentValue2;

                if (sum1 > newValues[newIndex]) {
                    newValues[newIndex] = sum1;
                }
                if (sum2 > newValues[newIndex]) {
                    newValues[newIndex] = sum2;
                }
            }

            newRow.setNumber(i-1);
            newRow.setValues(newValues);

            newPiramid.addRow(newRow.clone());
        }

        int size = newPiramid.getRows().size();

        int value1 = newPiramid.getRows().get(size-1).getValues()[0];
        int value2 = newPiramid.getRows().get(size-1).getValues()[1];

        if (value1 + top >= value2 + top) {
            System.out.println(value1 + top);
        } else {
            System.out.println(value2 + top);
        }

        if (DEBUG_MODE) {
            System.out.println();
            System.out.println("Piramid");
            System.out.println("=======");

            System.out.println(top);
            for (int i = newPiramid.getRows().size(); i > 0; i--) {
                Row row = newPiramid.getRows().get(i-1);

                for(int value : row.getValues()) {
                    System.out.print(value + " ");
                }

                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Problem67 problem = new Problem67();
        problem.solve();

        long duration = System.currentTimeMillis() - start;

        System.out.println();
        System.out.println("Done in " + duration + "ms");
    }
}
