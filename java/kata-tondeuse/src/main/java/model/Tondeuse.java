package model;

import java.util.Arrays;

public class Tondeuse {
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
