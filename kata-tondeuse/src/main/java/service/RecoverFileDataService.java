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
        List<Mower> mowers = new ArrayList<Mower>();
        CoordinateMax coordinateMax = new CoordinateMax(Integer.parseInt(lineCoordinateMax[0]), Integer.parseInt(lineCoordinateMax[1]));
        fileData.setCoordinateMax(coordinateMax);

        while ((line = bufferedReader.readLine()) != null) {
            String localisationMower = line;
            String[] splitLocalisationMower = localisationMower.split(SPACE);

            Mower mower = new Mower();
            Position position = new Position();
            position.setX(Integer.parseInt(splitLocalisationMower[0]));
            position.setY(Integer.parseInt(splitLocalisationMower[1]));
            mower.setPosition(position);
            mower.setDirection(Direction.valueOf(splitLocalisationMower[2]));

            line = bufferedReader.readLine();
            List<Instruction> instructions = Stream.of(line.split(EMPTY_FIELD))
                    .map (elem ->  Instruction.valueOf(elem))
                    .collect(Collectors.toList());

            mower.setInstructions(instructions);
            mowers.add(mower);
        }

        fileData.setMowers(mowers);
        return fileData;
    }
}
