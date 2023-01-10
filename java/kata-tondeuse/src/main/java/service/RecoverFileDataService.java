package service;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yann DUCLOUX
 * Service qui gére la récupération des information à partir d'un fichier.
 */
public class RecoverFileDataService {
    public FileData recoverData(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        String[] lineCoordinateMax = line.split(" ");
        FileData fileData = new FileData();
        List<Tondeuse> tondeuses = new ArrayList<Tondeuse>();
        CoordinateMax coordinateMax = new CoordinateMax();
        coordinateMax.setxMax(Integer.parseInt(lineCoordinateMax[0]));
        coordinateMax.setyMax(Integer.parseInt(lineCoordinateMax[0]));
        fileData.setCoordinateMax(coordinateMax);
        while ((line = bufferedReader.readLine()) != null) {
            String localisationTondeuse = line;
            String[] splitLocalisationTondeuse = localisationTondeuse.split(" ");

            Tondeuse tondeuse = new Tondeuse();
            Position position = new Position();
            position.setX(Integer.parseInt(splitLocalisationTondeuse[0]));
            position.setY(Integer.parseInt(splitLocalisationTondeuse[1]));
            tondeuse.setPosition(position);
            tondeuse.setDirection(Direction.valueOf(splitLocalisationTondeuse[2]));

            line = bufferedReader.readLine();
            String[] splitInstruction = line.split("");

            Instruction[] instructions = new Instruction[splitInstruction.length];
            for (int i = 0; i < splitInstruction.length; i++) {
                instructions[i] = Instruction.valueOf(splitInstruction[i]);
            }
            tondeuse.setInstructions(instructions);
            tondeuses.add(tondeuse);
        }
        fileData.setTondeuses(tondeuses);
        return fileData;
    }
}
