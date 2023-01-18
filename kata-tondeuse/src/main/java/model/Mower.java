package model;

import java.io.IOException;
import java.util.List;

/**
 * The type Mower.
 *
 * @author Yann Ducloux Défini la tondeuse.
 */
public class Mower {
    Position position;
    Direction direction;
    List<Instruction> instructions;

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
        return position.getX() + " " + position.getY() + " " + direction;
    }


    public void lastPosition(Lawn lawn) throws IOException {
        Dimension dimension = lawn.getCoordinateMax();
        for (Mower mower: lawn.getMowers()) {
            List<Instruction> instructions = mower.getInstructions();
            for (int i = 0; i < instructions.size(); i++) {
                switch (instructions.get(i)) {
                    case G:
                        mower.nextDirection(mower.getDirection().turnLeft());
                        break;
                    case D:
                        mower.nextDirection(mower.getDirection().turnRight());
                        break;
                    case A:
                        mower.getPosition().nextPosition(mower.getDirection(), dimension);
                        break;
                }
            }
            System.out.println(mower.toString());
        }
    }
}
