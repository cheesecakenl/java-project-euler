package nl.dev4all.piramid;

import java.util.ArrayList;
import java.util.List;

public class NumberPiramid {
    List<Row> rows = new ArrayList();

    public void addRow(Row row) {
        rows.add(row);
    }

    public List<Row> getRows() {
        return rows;
    }
}
