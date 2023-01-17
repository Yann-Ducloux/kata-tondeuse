package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    Dimension dimension;
    List<Mower> mowers;

    public Lawn(Dimension dimension, List<Mower> mowers) {
        this.dimension = dimension;
        this.mowers = mowers;
    }

    public Dimension getCoordinateMax() {
        return dimension;
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
        Dimension dimension = new Dimension(Integer.parseInt(lineCoordinateMax[0]), Integer.parseInt(lineCoordinateMax[1]));

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
        return new Lawn(dimension, mowers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lawn lawn = (Lawn) o;
        return Objects.equals(dimension, lawn.dimension) && Objects.equals(mowers, lawn.mowers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimension, mowers);
    }
}
