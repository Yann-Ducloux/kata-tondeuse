package model;

import java.util.Objects;

/**
 * The type Coordinate max.
 *
 * @author Yann Ducloux
 * Défini la dimension de la pelouse.
 */
public class Dimension {
    int x;
    int y;

    public Dimension(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean YInZone(int y) {
        return y < this.y;
    }
    public boolean XInZone(int x) {
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
