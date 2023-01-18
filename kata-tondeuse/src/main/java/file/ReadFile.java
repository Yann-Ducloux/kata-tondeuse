package file;

import model.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ReadFile {
    private static final String SPACE = " ";
    private static final String EMPTY_FIELD = "";
    public List<String> execute(File file) throws IOException {
        return FileUtils.readLines(file, StandardCharsets.UTF_8);
    }

    public Lawn transcription(List<String> contentFile) {

        List<Mower> mowers = new ArrayList<Mower>();
        String[] lineCoordinateMax = contentFile.get(0).split(SPACE);
        Dimension dimension = new Dimension(Integer.parseInt(lineCoordinateMax[0]), Integer.parseInt(lineCoordinateMax[1]));
        for (int i=1;i<contentFile.size();i=i+2) {
            String localisationMower = contentFile.get(i);
            String[] splitLocalisationMower = localisationMower.split(SPACE);
            Position position = new Position(Integer.parseInt(splitLocalisationMower[0]), Integer.parseInt(splitLocalisationMower[1]));
            Direction direction = Direction.valueOf(splitLocalisationMower[2]);

            List<Instruction> instructions = Stream.of(contentFile.get(i+1).split(EMPTY_FIELD))
                    .map (elem ->  Instruction.valueOf(elem))
                    .collect(Collectors.toList());
            mowers.add(new Mower(position, direction, instructions));
        }
        return new Lawn(dimension, mowers);
    }
}
