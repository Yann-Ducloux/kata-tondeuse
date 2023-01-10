package model;

/**
 * @author Yann Ducloux
 * Défini la Position.
 */
public class Position {
    int x;
    int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void calculPosition(Direction direction, CoordinateMax coordonneeMax) {
        switch(direction){
            case N:
                if(this.y < coordonneeMax.getyMax()) {
                    this.y++;
                }
                break;
            case S:
                if(this.y > 0) {
                    this.y--;
                }
                break;
            case E:
                if(this.x < coordonneeMax.getxMax()) {
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
