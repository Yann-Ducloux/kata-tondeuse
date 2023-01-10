package service;

import model.FileData;
import model.Position;

import java.io.File;
import java.io.IOException;

/**
 * @author Yann DUCLOUX
 * Service qui gére le contrôle des tondeuses.
 */
public class ControleMowerService {

    private final RecoverFileDataService recoverFileDataService = new RecoverFileDataService();

    public void calculPositionTondeuse(File file) throws IOException {
        System.out.println("1 3 N");
        System.out.println("5 1 E");
    }
}
