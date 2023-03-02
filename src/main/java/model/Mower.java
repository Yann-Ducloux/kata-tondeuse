package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Mower.
 *
 * @author Yann Ducloux Défini la tondeuse.
 */
public class Mower {
    private Position position;
    private Direction direction;
    private List<Instruction> instructions;

    public Mower(Position position, Direction direction, List<Instruction> instructions) {
        this.position = position;
        this.direction = direction;
        this.instructions = instructions;
    }

    public Mower() {

    }

    public void nextDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }


    @Override
    public String toString() {
        return position.toString() + " " + direction;
    }


    public List<Mower> lastPosition(Lawn lawn) {
        Dimension dimension = lawn.getDimension();
        List<Mower> mowers = new ArrayList<>();
        for (Mower mower: lawn.getMowers()) {
            mowers.add(Instruction.executeInstructions(mower, dimension));
            System.out.println(mower);
        }
        return mowers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return Objects.equals(position, mower.position) && direction == mower.direction && Objects.equals(instructions, mower.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction, instructions);
    }
}
