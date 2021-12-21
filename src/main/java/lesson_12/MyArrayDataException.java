package lesson_12;

public class MyArrayDataException extends NumberFormatException{
    private final int wrongRows;
    private final int wrongColumns;

    public MyArrayDataException(String s, int row, int columns) {
        super(s + String.format(". Ошибка в строке " +row +" колонке " +columns));
        this.wrongRows = row;
        this.wrongColumns = columns;
    }

    public int getWrongRows() {
            return wrongRows;
        }

        public int getWrongColumns() {
            return wrongColumns;
        }

    }
