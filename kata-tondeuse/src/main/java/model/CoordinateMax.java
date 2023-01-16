package model;

/**
 * The type Coordinate max.
 *
 * @author Yann Ducloux
 * Défini la dimension de la pelouse.
 */
public class CoordinateMax {
    /**
     * The X max.
     */
    int xMax;
    /**
     * The Y max.
     */
    int yMax;

    public CoordinateMax(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }

    /**
     * Sets max.
     *
     * @param xMax the x max
     */
    public void setxMax(int xMax) {
        this.xMax = xMax;
    }

    /**
     * Sets max.
     *
     * @param yMax the y max
     */
    public void setyMax(int yMax) {
        this.yMax = yMax;
    }

    /**
     * Gets max.
     *
     * @return the max
     */
    public int getxMax() {
        return xMax;
    }

    /**
     * Gets max.
     *
     * @return the max
     */
    public int getyMax() {
        return yMax;
    }
}
