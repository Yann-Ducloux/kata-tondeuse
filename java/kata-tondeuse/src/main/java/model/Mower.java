package model;

/**
 * @author Yann Ducloux
 * Défini la tondeuse.
 */
public class Mower {
    Position position;
    Direction direction;
    Instruction[] instructions;

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setInstructions(Instruction[] instructions) {
        this.instructions = instructions;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public Instruction[] getInstructions() {
        return instructions;
    }
}
