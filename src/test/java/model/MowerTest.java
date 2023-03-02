package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * The mower test.
 *
 * @author Yann Ducloux
 * Défini le test de la classe mower.
 */
class MowerTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void lastPosition() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 2), Direction.NORTH, instruction("GAGAGAGAA")),
                        mower(position(3, 3), Direction.EAST, instruction("AADAADADDA"))
                        )));

        //THEN
        assertThat(mowersActual, is(mowers(
                                        mower(position(1, 3), Direction.NORTH, instruction("GAGAGAGAA")),
                                        mower(position(5,1), Direction.EAST, instruction("AADAADADDA")))));
    }


    @Test
    void lastPositionTurnLeft1Time() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 3), Direction.NORTH, instruction("G")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(1, 3), Direction.WEST, instruction("G")))));
    }


    @Test
    void lastPositionTurnLeft2Time() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 3), Direction.NORTH, instruction("GG")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(1, 3), Direction.SOUTH, instruction("GG")))));
    }


    @Test
    void lastPositionTurnLeft3Time() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 3), Direction.NORTH, instruction("GGG")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(1, 3), Direction.EAST, instruction("GGG")))));
    }


    @Test
    void lastPositionTurnLeft4Time() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 3), Direction.NORTH, instruction("GGGG")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(1, 3), Direction.NORTH, instruction("GGGG")))));
    }


    @Test
    void lastPositionTurnRight1Time() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 3), Direction.NORTH, instruction("D")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(1, 3), Direction.EAST, instruction("D")))));
    }


    @Test
    void lastPositionTurnRight2Time() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 3), Direction.NORTH, instruction("DD")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(1, 3), Direction.SOUTH, instruction("DD")))));
    }


    @Test
    void lastPositionTurnRight3Time() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 3), Direction.NORTH, instruction("DDD")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(1, 3), Direction.WEST, instruction("DDD")))));
    }


    @Test
    void lastPositionTurnRight4Time() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 3), Direction.NORTH, instruction("DDDD")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(1, 3), Direction.NORTH, instruction("DDDD")))));
    }


    @Test
    void lastPositionNextPositionNorth() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 3), Direction.NORTH, instruction("A")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(1, 4), Direction.NORTH, instruction("A")))));
    }


    @Test
    void lastPositionNextPositionNorthInBorder() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 5), Direction.NORTH, instruction("A")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(1, 5), Direction.NORTH, instruction("A")))));
    }

    @Test
    void lastPositionNextPositionNorthInBorderExecuteNextCommand() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 5), Direction.NORTH, instruction("AGA")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(0, 5), Direction.WEST, instruction("AGA")))));
    }

    @Test
    void lastPositionNextPositionSouth() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 3), Direction.SOUTH, instruction("A")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(1, 2), Direction.SOUTH, instruction("A")))));
    }


    @Test
    void lastPositionNextPositionSouthInBorder() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 0), Direction.SOUTH, instruction("A")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(1, 0), Direction.SOUTH, instruction("A")))));
    }

    @Test
    void lastPositionNextPositionSouthInBorderExecuteNextCommand() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 0), Direction.SOUTH, instruction("ADA")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(0, 0), Direction.WEST, instruction("ADA")))));
    }

    @Test
    void lastPositionNextPositionEast() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(1, 3), Direction.EAST, instruction("A")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(2, 3), Direction.EAST, instruction("A")))));
    }


    @Test
    void lastPositionNextPositionEastInBorder() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(5, 3), Direction.EAST, instruction("A")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(5, 3), Direction.EAST, instruction("A")))));
    }

    @Test
    void lastPositionNextPositionEastInBorderExecuteNextCommand() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(5, 3), Direction.EAST, instruction("AGA")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(5, 4), Direction.NORTH, instruction("AGA")))));
    }

    @Test
    void lastPositionNextPositionWest() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(3, 3), Direction.WEST, instruction("A")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(2, 3), Direction.WEST, instruction("A")))));
    }


    @Test
    void lastPositionNextPositionWestInBorderExecuteNextCommand() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(0, 3), Direction.WEST, instruction("ADA")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(0, 4), Direction.NORTH, instruction("ADA")))));
    }

    @Test
    void lastPositionNextPositionWestInBorder() {
        //GIVEN
        Mower mower = new Mower();

        //WHEN
        List<Mower> mowersActual = mower.lastPosition(lawn(dimension(5,5),
                mowers(
                        mower(position(0, 3), Direction.WEST, instruction("A")))));
        //THEN
        assertThat(mowersActual, is(mowers(
                mower(position(0, 3), Direction.WEST, instruction("A")))));
    }
    private Lawn lawn(Dimension dimension, List<Mower> mowers) {
        return new Lawn(dimension, mowers);
    }

    private Dimension dimension(int x, int y) {
        return new Dimension(x, y);
    }


    private List<Mower> mowers(Mower... mowers) {
        List<Mower> mowerList = new ArrayList<>();
        if(mowers != null) {
            mowerList.addAll(Arrays.asList(mowers));
        }
        return mowerList;
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

}