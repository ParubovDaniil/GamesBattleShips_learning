import java.awt.Graphics;
import java.util.ArrayList;

class Shots {
    private final int CELL_SIZE;
    private ArrayList<Shot> shots;

    Shots(int cellSize) {
        CELL_SIZE = cellSize;
        shots = new ArrayList<Shot>();
    }

    void add(int x, int y, boolean shot) {
        shots.add(new Shot(x, y, shot));
    }

    boolean hitSamePlace(int x, int y) { // контролируем то что бы сохранялись отметки что бы не стрелять на одну и ту же клетку
        for (Shot shot : shots)
            if (shot.getX() == x && shot.getY() == y && shot.isShot())
                return true;
        return false;
    }

    Shot getLabel(int x, int y) {
        for (Shot label : shots)
            if (label.getX() == x && label.getY() == y && (!label.isShot()))
                return label;
        return null;
    }

    void removeLabel(Shot label) {
        shots.remove(label);
    }

    void paint(Graphics g) {
        for (Shot shot : shots) shot.paint(g, CELL_SIZE);
    }
}
