package model;

import java.util.Objects;

/**
 * The Dimension.
 *
 * @author Yann Ducloux
 * Défini la dimension de la pelouse.
 */
public class Dimension extends Coordinate{
    public Dimension(int x, int y) {
        super(x, y);
    }

    public boolean yInZone(int y) {
        return y < this.y;
    }
    public boolean xInZone(int x) {
        return x < this.x;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimension that = (Dimension) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
