package model;

/**
 * The type Position.
 *
 * @author Yann Ducloux
 * Défini la Position.
 */
public class Position {
    /**
     * The X.
     */
    int x;
    /**
     * The Y.
     */
    int y;

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Calculer la prochaine position.
     *
     * @param direction     the direction
     * @param coordonneeMax the coordonnee max
     */
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
