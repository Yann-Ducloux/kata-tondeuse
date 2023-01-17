package model;

/**
 * The type Position.
 *
 * @author Yann Ducloux
 * Défini la Position.
 */
public class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void calculPosition(Direction direction, Dimension dimension) {
        switch(direction){
            case N:
                if(dimension.YInZone(this.y)) {
                    this.y++;
                }
                break;
            case S:
                if(this.y > 0) {
                    this.y--;
                }
                break;
            case E:
                if(dimension.XInZone(this.x)) {
                    this.x++;
                }
                break;
            case W:
                if(this.x > 0) {
                    this.x--;
                }
                break;
        }

    }
}
