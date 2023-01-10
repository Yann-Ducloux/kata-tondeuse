package model;

/**
 * @author Yann Ducloux
 * Défini la direction.
 */
public enum Direction {
    N, W, S, E;
    private char direction;

    Direction() {

    }
    public Direction turnLeft(Direction direction) {
        switch(direction) {
            case N:
                return Direction.W;
            case W:
                return Direction.S;
            case S:
                return Direction.E;
            case E:
                return Direction.N;
            default:
                return null;
        }
    }
    public Direction turnRight(Direction direction) {
        switch(direction) {
            case N:
                return Direction.E;
            case E:
                return Direction.S;
            case S:
                return Direction.W;
            case W:
                return Direction.N;
            default:
                return null;
        }
    }
}
