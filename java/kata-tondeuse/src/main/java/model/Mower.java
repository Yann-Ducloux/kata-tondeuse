package model;

/**
 * The type Mower.
 *
 * @author Yann Ducloux
 * Défini la tondeuse.
 */
public class Mower {
    /**
     * The Position.
     */
    Position position;
    /**
     * The Direction.
     */
    Direction direction;
    /**
     * The Instructions.
     */
    Instruction[] instructions;

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Sets direction.
     *
     * @param direction the direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Sets instructions.
     *
     * @param instructions the instructions
     */
    public void setInstructions(Instruction[] instructions) {
        this.instructions = instructions;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Get instructions instruction [ ].
     *
     * @return the instruction [ ]
     */
    public Instruction[] getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + direction;
    }
}
