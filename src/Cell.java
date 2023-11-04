import java.awt.Color;
import java.awt.Graphics;

class Cell { // класс ячейка
    private final Color RED = Color.red;
    private int x, y; // координаты ячейки
    private Color color;//цвет ячейки

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
        color = Color.gray; // default color цвет по умолчанию
    }

    int getX() { return x; }
    int getY() { return y; }

    boolean checkHit(int x, int y) {//метод для проверки попадания по цели после нажатия
        if (this.x == x && this.y == y) {
            color = RED; // change color if hit
            return true;
        }
        return false;
    }

    boolean isAlive() {
        return color != RED; // judged by color
    }

    void paint(Graphics g, int cellSize, boolean hide) {
        if (!hide || (hide && color == RED)) {
            g.setColor(color);
            g.fill3DRect(x*cellSize + 1, y*cellSize + 1, cellSize - 2, cellSize - 2, true);
        }
    }
}
