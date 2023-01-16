package service;

import model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
     * @param fileData the fileData
     * @throws IOException the io exception
     */
    public void calculPositionMower(FileData fileData) throws IOException {
        CoordinateMax coordinateMax = fileData.getCoordinateMax();
        for (Mower mower: fileData.getMowers()) {
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
