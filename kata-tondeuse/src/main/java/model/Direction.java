package model;

/**
 * The enum Direction.
 *
 * @author Yann Ducloux
 * Défini la direction.
 */
public enum Direction {

    /**
     * le nord.
     */
    N() {
        public Direction turnLeft() {
            return Direction.W;
        }
        public Direction turnRight() {
            return Direction.E;
        }
    },

    /**
     * l'ouest.
     */
    W() {
        public Direction turnLeft() {
            return Direction.S;
        }
        public Direction turnRight() {
            return Direction.N;
        }
    },

    /**
     * le sud.
     */
    S() {
        public Direction turnLeft() {
            return Direction.E;
        }
        public Direction turnRight() {
            return Direction.W;
        }
    },

    /**
     * l'est.
     */
    E() {
        public Direction turnLeft() {
            return Direction.N;
        }
        public Direction turnRight() {
            return Direction.S;
        }
    };
    Direction() {

    }

    /**
     * calcul la direction quand on tourne à gauche.
     *
     * @return the direction
     */
    public abstract Direction turnLeft();

    /**
     * calcul la direction quand on tourne à droite.
     *
     * @return the direction
     */
    public abstract Direction turnRight();
}
