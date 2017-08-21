package nl.dev4all.piramid;

public class Row {

    private int number;
    private int[] values;

    public Row() {
    }

    public Row(int number, int[] values) {
        this.number = number;
        this.values = values;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public Row clone() {
        Row row = new Row();

        row.setNumber(this.getNumber());
        row.setValues(this.getValues());

        return row;
    }
}
