package service;

import model.*;

import java.io.File;
import java.io.IOException;

/**
 * @author Yann DUCLOUX
 * Service qui gére le contrôle des tondeuses.
 */
public class ControleMowerService {

    private final RecoverFileDataService recoverFileDataService = new RecoverFileDataService();

    public void calculPositionMower(File file) throws IOException {
        FileData fileData = recoverFileDataService.recoverData(file);
        CoordinateMax coordinateMax = fileData.getCoordinateMax();
        for (Mower mower: fileData.getMowers()) {
            Position position = mower.getPosition();
            Instruction[] instructions = mower.getInstructions();
            Direction direction = mower.getDirection();
            for (int i = 0; i < instructions.length; i++) {
                switch (instructions[i]) {
                    case G:
                        direction = direction.turnLeft(direction);
                        break;
                    case D:
                        direction = direction.turnRight(direction);
                        break;
                    case A:
                        position.calculPosition(direction, coordinateMax);
                        break;
                }
            }
            System.out.println(position.getX() + " " + position.getY() + " " + direction);
        }
    }
}
