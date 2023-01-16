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


    /**
     * l'espace.
     */
    private static final String SPACE = " ";

    /**
     * l'emplacement vide.
     */
    private static final String EMPTY_FIELD = "";
    /**
     * The Coordinate max.
     */
    CoordinateMax coordinateMax;
    /**
     * The Mowers.
     */
    List<Mower> mowers;

    /**
     * Sets coordinate max.
     *
     * @param coordinateMax the coordinate max
     */
    public void setCoordinateMax(CoordinateMax coordinateMax) {
        this.coordinateMax = coordinateMax;
    }

    /**
     * Sets mowers.
     *
     * @param mowers the mowers
     */
    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }

    /**
     * Gets coordinate max.
     *
     * @return the coordinate max
     */
    public CoordinateMax getCoordinateMax() {
        return coordinateMax;
    }

    /**
     * Gets mowers.
     *
     * @return the mowers
     */
    public List<Mower> getMowers() {
        return mowers;
    }


    public static Lawn execute(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        String[] lineCoordinateMax = line.split(SPACE);
        Lawn lawn = new Lawn();
        List<Mower> mowers = new ArrayList<Mower>();
        CoordinateMax coordinateMax = new CoordinateMax(Integer.parseInt(lineCoordinateMax[0]), Integer.parseInt(lineCoordinateMax[1]));
        lawn.setCoordinateMax(coordinateMax);

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

        lawn.setMowers(mowers);
        return lawn;
    }

}
