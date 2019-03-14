package model;

public class Tile {

    public enum Value {
        EMPTY(""),
        X("x"),
        O("o");

        String text;

        Value(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    private Value value;
    private int rowIndex;
    private int columnIndex;

    Tile(int rowIndex, int columnIndex) {
        this.value = Value.EMPTY;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    private int getRowIndex() {
        return rowIndex;
    }

    private int getColumnIndex() {
        return columnIndex;
    }

    Value getValue() {
        return value;
    }

    void setValue(Value value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return this.value == Value.EMPTY;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
