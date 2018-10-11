package objectTask;

import java.util.Arrays;

public class Drawing implements Printable {
    private char[][] massive;
    private int lines;
    private int columns;

    public Drawing(int lines, int columns, char symbol) {
        this.lines = lines;
        this.columns = columns;
        this.massive = new char[lines][columns];
        for (int i = 0; i < lines; i++)
            Arrays.fill(this.massive[i], symbol);
    }

    public int getLines() {
        return lines;
    }

    public int getColumns() {
        return columns;
    }

    public char getPoint(int line, int column) {
        return massive[line][column];
    }

    @Override
    public void print() {
        for (char[] line : massive) {
            for (char element : line)
                System.out.print(element + " ");
            System.out.println();
        }
    }

    public void setPoint(int line, int column, char symbol) {
        massive[line][column] = symbol;
    }

    public void drawVerticalLine(int column, int line1, int line2, char symbol) {
        if (line2 < line1) {
            int t = line2;
            line2 = line1;
            line1 = t;
        }
        for (int i = line1; i <= line2; i++)
            setPoint(i, column, symbol);
    }

    public void drawHorizontalLine(int line, int column1, int column2, char symbol) {
        if (column2 < column1) {
            int t = column2;
            column2 = column1;
            column1 = t;
        }
        for (int i = column1; i <= column2; i++)
            setPoint(line, i, symbol);
    }

    public void drawRectangle(int line1, int column1, int line2, int column2, char symbol) {
        drawVerticalLine(column1, line1, line2, symbol);
        drawVerticalLine(column2, line1, line2, symbol);
        drawHorizontalLine(line1, column1, column2, symbol);
        drawHorizontalLine(line2, column1, column2, symbol);
    }

    public void drawLine(int line1, int column1, int line2, int column2, char symbol) {
        if (column1 == column2 & line1 == line2) {
            setPoint(line1, column1, symbol);
            return;
        }

        if (column1 == column2) {
            drawVerticalLine(column1, line1, line2, symbol);
            return;
        }

        if (line1 == line2) {
            drawHorizontalLine(line1, column1, column2, symbol);
            return;
        }

        if (column1 > column2) {
            int lineTime = line1;
            line1 = line2;
            line2 = lineTime;

            int columnTime = column1;
            column1 = column2;
            column2 = columnTime;
        }

        int deltaX = Math.abs(column2 - column1);
        int deltaY = Math.abs(line2 - line1);
        int error = 0;
        int deltaErr = deltaY;
        int y = line1;
        int dirY = line2 - line1;
        if (dirY > 0)
            dirY = 1;
        if (dirY < 0)
            dirY = -1;
        for (int x = column1; x <= column2; x++) {
            setPoint(y, x, symbol);
            error = error + deltaErr;
            if (2 * error >= deltaX) {
                y = y + dirY;
                error = error - deltaX;
            }
        }
    }

    public void addNumeracia() {
        for (int i = 0; i < lines; i++)
            setPoint(i, 0, (char) (i % 10 + '0'));
        for (int i = 0; i < columns; i++)
            setPoint(0, i, (char) (i % 10 + '0'));
    }

    public void drawCircle(int l0, int c0, int r, char symbol) {
        for (int i = 0; i < lines; i++)
            for (int j = 0; j < columns; j++) {
                int di = l0 - i;
                int dj = c0 - j;
                if (di * di + dj * dj <= r * r)
                    setPoint(i, j, symbol);
            }
    }

    public void draw(int l0, int c0, Drawing d) {
        int lineD = d.getLines();
        int columnD = d.getColumns();
        if (columns - c0 < columnD || lines - l0 < lineD) {
            System.out.println("ошибка, нужный рисунок не помещается на холсте. ");
            return;
        }

        for (int i = 0; i < lineD; i++)
            for (int j = 0; j < columnD; j++)
                setPoint(i + l0, j + c0, d.getPoint(i, j));
    }
}
