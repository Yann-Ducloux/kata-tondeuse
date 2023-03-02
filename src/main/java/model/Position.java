package model;

import java.util.Objects;

/**
 * The type Position.
 *
 * @author Yann Ducloux
 * Défini la Position.
 */
public class Position extends Coordinate{

    public Position(int x, int y) {
        super(x, y);
    }

    public void nextPosition(Direction direction, Dimension dimension) {
        switch(direction){
            case N -> yIncrease(dimension);
            case S -> yDecrease();
            case E -> xIncrease(dimension);
            case W -> xDecrease();
        }

    }

    private void xDecrease() {
        if(this.x > 0) {
            this.x--;
        }
    }

    private void xIncrease(Dimension dimension) {
        if(dimension.xInZone(this.x)) {
                this.x++;
            }
    }

    private void yDecrease() {
        if(this.y > 0) {
                this.y--;
            }
    }

    private void yIncrease(Dimension dimension) {
        if(dimension.yInZone(this.y)) {
            this.y++;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return x +" " + y;
    }
}
