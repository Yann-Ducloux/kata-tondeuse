package service;

import model.*;

import java.io.File;
import java.io.IOException;

/**
 * The type Controle mower service.
 *
 * @author Yann DUCLOUX
 * Service qui gére le contrôle des tondeuses.
 */
public class ControleMowerService {

    private final RecoverFileDataService recoverFileDataService = new RecoverFileDataService();

    /**
     * Calculer la position final des tondeuses.
     *
     * @param file the file
     * @throws IOException the io exception
     */
    public void calculPositionMower(File file) throws IOException {
        FileData fileData = recoverFileDataService.recoverData(file);
        CoordinateMax coordinateMax = fileData.getCoordinateMax();
        for (Mower mower: fileData.getMowers()) {
            Instruction[] instructions = mower.getInstructions();
            for (int i = 0; i < instructions.length; i++) {
                switch (instructions[i]) {
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
