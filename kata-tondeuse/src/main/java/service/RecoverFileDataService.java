package service;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Recover file data service.
 *
 * @author Yann DUCLOUX
 * Service qui gére la récupération des information à partir d'un fichier.
 */
public class RecoverFileDataService {
    
    /**
     * l'espace.
     */
    private static final String SPACE = " ";

    /**
     * l'emplacement vide.
     */
    private static final String EMPTY_FIELD = "";

    /**
     * récupere les différentes information du fichier.
     *
     * @param file the file
     * @return the file data
     * @throws IOException the io exception
     */
    public FileData recoverData(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        String[] lineCoordinateMax = line.split(SPACE);
        FileData fileData = new FileData();
        List<Mower> tondeuses = new ArrayList<Mower>();
        CoordinateMax coordinateMax = new CoordinateMax();
        coordinateMax.setxMax(Integer.parseInt(lineCoordinateMax[0]));
        coordinateMax.setyMax(Integer.parseInt(lineCoordinateMax[1]));
        fileData.setCoordinateMax(coordinateMax);

        while ((line = bufferedReader.readLine()) != null) {
            String localisationTondeuse = line;
            String[] splitLocalisationTondeuse = localisationTondeuse.split(SPACE);

            Mower mower = new Mower();
            Position position = new Position();
            position.setX(Integer.parseInt(splitLocalisationTondeuse[0]));
            position.setY(Integer.parseInt(splitLocalisationTondeuse[1]));
            mower.setPosition(position);
            mower.setDirection(Direction.valueOf(splitLocalisationTondeuse[2]));

            line = bufferedReader.readLine();
            List<Instruction> instructions = Stream.of(line.split(EMPTY_FIELD))
                    .map (elem ->  Instruction.valueOf(elem))
                    .collect(Collectors.toList());

            mower.setInstructions(instructions);
            tondeuses.add(mower);
        }

        fileData.setMowers(tondeuses);
        return fileData;
    }
}