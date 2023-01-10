package model;

import java.util.List;

/**
 * The type Mower.
 *
 * @author Yann Ducloux Défini la tondeuse.
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
    List<Instruction> instructions;

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
     * Gets instructions.
     *
     * @return the instructions
     */
    public List<Instruction> getInstructions() {
        return instructions;
    }

    /**
     * Sets instructions.
     *
     * @param instructions the instructions
     */
    public void setInstructions(List<Instruction> instructions) {
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


    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + direction;
    }
}
