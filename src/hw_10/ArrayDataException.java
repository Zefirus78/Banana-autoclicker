package hw_10;

public class ArrayDataException extends Exception{
    private int row;
    private int column;

    public ArrayDataException(String message,int row, int column) {
        super(message);
        this.row = row;
        this.column = column;
    }
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
