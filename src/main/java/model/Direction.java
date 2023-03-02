package model;

/**
 * The enum Direction.
 *
 * @author Yann Ducloux
 * Défini la direction.
 */
public enum Direction {

    NORTH("N") {
        public Direction turnLeft() {
            return Direction.WEST;
        }
        public Direction turnRight() {
            return Direction.EAST;
        }
    },

    WEST("W") {
        public Direction turnLeft() {
            return Direction.SOUTH;
        }
        public Direction turnRight() {
            return Direction.NORTH;
        }
    },

    SOUTH("S") {
        public Direction turnLeft() {
            return Direction.EAST;
        }
        public Direction turnRight() {
            return Direction.WEST;
        }
    },

    EAST("E") {
        public Direction turnLeft() {
            return Direction.NORTH;
        }
        public Direction turnRight() {
            return Direction.SOUTH;
        }
    };
    private String code;
    Direction(String code) {
        this.code = code;

    }

    @Override
    public String toString() {
        return this.code;
    }

    public static Direction convertToCommand(String instruction) {
        for (Direction direction : Direction.values()) {
            if (direction.toString().equalsIgnoreCase(instruction)) {
                return direction;
            }
        }
        return null;
    }
    public abstract Direction turnLeft();
    public abstract Direction turnRight();
}
