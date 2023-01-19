package file;

import model.*;
import org.junit.jupiter.api.Test;
import utils.LawnUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * The read file test.
 *
 * @author Yann Ducloux
 * Défini le test de la classe readFile.
 */
class ReadFileTest {
    @Test
    void transcription() throws IOException {
        //GIVEN
        ReadFile readFile = new ReadFile();

        //WHEN
        Lawn lawnActual = readFile.transcription(LawnUtils.fileOfLawn());

        //THEN
        assertThat(lawnActual, is(lawn(
                                dimension(5, 5),
                                mower(position(1, 2), Direction.N, instruction("GAGAGAGAA")),
                                mower(position(3, 3), Direction.E, instruction("AADAADADDA"))
        )));
    }

    private List<Instruction> instruction(String instructionsString) {
        return Instruction.transcription(instructionsString);
    }

    private Mower mower(Position position, Direction direction, List<Instruction>  instruction) {
       return  new Mower(position, direction, instruction);
    }

    private Position position(int x, int y) {
       return new Position(x, y);
    }

    private Lawn lawn(Dimension dimension, Mower ... mowers) {
        List<Mower> mowerList = new ArrayList<>();
        if(mowers != null) {
            for (Mower mower: mowers) {
                mowerList.add(mower);
            }
        }
        Lawn lawn = new Lawn(dimension, mowerList);
        return lawn;
    }

    private Dimension dimension(int x, int y) {
        return new Dimension(x, y);
    }


}