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

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
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
        CoordinateMax coordinateMax = lawn.getCoordinateMax();
        for (Mower mower: lawn.getMowers()) {
            List<Instruction> instructions = mower.getInstructions();
            for (int i = 0; i < instructions.size(); i++) {
                switch (instructions.get(i)) {
                    case G:
                        mower.setDirection(mower.getDirection().turnLeft());
                        break;
                    case D:
                        mower.setDirection(mower.getDirection().turnRight());
                        break;
                    case A:
                        mower.getPosition().calculPosition(mower.getDirection(), coordinateMax);
                        break;
                }
            }
            System.out.println(mower.toString());
        }
    }
}
