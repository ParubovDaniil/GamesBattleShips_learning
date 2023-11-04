import java.awt.Graphics;
import java.util.ArrayList;

class Ship {
    private ArrayList<Cell> cells = new ArrayList<Cell>();

    Ship(int x, int y, int length, int position) {
        for (int i = 0; i < length; i++)
            cells.add(
                    new Cell(x + i * ((position == 1)? 0 : 1),
                            y + i * ((position == 1)?1:0)));
    }

    // is ship outside the boundary of the field, которое задаётся определёнными границами?
    boolean isOutOfField(int bottom, int top) {
        for (Cell cell : cells)
            if (cell.getX() < bottom || cell.getX() > top ||
                    cell.getY() < bottom || cell.getY() > top)
                return true;
        return false;
    }

    boolean isOverlayOrTouch(Ship ctrlShip) { // is ship overlay or touch other ships
        for (Cell cell : cells)
            if (ctrlShip.isOverlayOrTouchCell(cell))
                return true;
        return false;
    }

    boolean isOverlayOrTouchCell(Cell ctrlCell) {
        for (Cell cell : cells)
            for (int dx = -1; dx < 2; dx++)
                for (int dy = -1; dy < 2; dy++)
                    if (ctrlCell.getX() == cell.getX() + dx &&
                            ctrlCell.getY() == cell.getY() + dy)
                        return true;
        return false;
    }

    boolean checkHit(int x, int y) { // попали ли мы в корабль?
        for (Cell cell : cells)//перебираем корабль по ячейкам и каждую ячейку проверямем
            if (cell.checkHit(x, y))
                return true;
        return false;
    }

    boolean isAlive() { // жив ли корабль?
        for (Cell cell : cells)
            if (cell.isAlive())
                return true;// если есть хотя бы одна живая ячейка то true
        return false;
    }

    void paint(Graphics g, int cellSize, boolean hide) { // перебираем по ячейкам и рисуется ячейка
        for (Cell cell : cells)
            cell.paint(g, cellSize, hide);
    }
}
