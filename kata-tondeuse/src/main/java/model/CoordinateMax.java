package model;

import java.util.Objects;

/**
 * The type Coordinate max.
 *
 * @author Yann Ducloux
 * Défini la dimension de la pelouse.
 */
public class CoordinateMax {
    int xMax;
    int yMax;

    public CoordinateMax(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }
    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateMax that = (CoordinateMax) o;
        return xMax == that.xMax && yMax == that.yMax;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xMax, yMax);
    }
}
