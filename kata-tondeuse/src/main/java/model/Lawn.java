package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Lown.
 *
 * @author Yann Ducloux
 * Défini les données du fichier.
 */
public class Lawn {
    private static final String SPACE = " ";
    private static final String EMPTY_FIELD = "";
    CoordinateMax coordinateMax;
    List<Mower> mowers;

    public Lawn(CoordinateMax coordinateMax, List<Mower> mowers) {
        this.coordinateMax = coordinateMax;
        this.mowers = mowers;
    }

    public CoordinateMax getCoordinateMax() {
        return coordinateMax;
    }

    public List<Mower> getMowers() {
        return mowers;
    }


    public static Lawn execute(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        String[] lineCoordinateMax = line.split(SPACE);
        List<Mower> mowers = new ArrayList<Mower>();
        CoordinateMax coordinateMax = new CoordinateMax(Integer.parseInt(lineCoordinateMax[0]), Integer.parseInt(lineCoordinateMax[1]));

        while ((line = bufferedReader.readLine()) != null) {
            String localisationMower = line;
            String[] splitLocalisationMower = localisationMower.split(SPACE);

            Position position = new Position(Integer.parseInt(splitLocalisationMower[0]), Integer.parseInt(splitLocalisationMower[1]));
            Direction direction = Direction.valueOf(splitLocalisationMower[2]);

            line = bufferedReader.readLine();
            List<Instruction> instructions = Stream.of(line.split(EMPTY_FIELD))
                    .map (elem ->  Instruction.valueOf(elem))
                    .collect(Collectors.toList());
            mowers.add(new Mower(position, direction, instructions));
        }
        return new Lawn(coordinateMax, mowers);
    }

}
