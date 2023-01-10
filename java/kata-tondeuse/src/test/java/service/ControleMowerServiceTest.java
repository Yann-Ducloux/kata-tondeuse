package service;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Yann DUCLOUX
 * Service qui test le service qui gére le contrôle des tondeuses.
 */
class ControleMowerServiceTest {
    String FILE_NAME = "mower.txt";
    private final ControleMowerService controleMowerService = new ControleMowerService();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void calculPositionTondeuseTest() throws IOException {
        //GIVEN
        String pointFinalForFirstTondeuseExpected = "1 3 N";
        String pointFinalForSecondeTondeuseExpected = "5 1 E";
        int numberOfTondeuseExpected = 2;
        FileData fileDataExpected = new FileData();
        CoordinateMax coordinateMax = new CoordinateMax();
        coordinateMax.setxMax(5);
        coordinateMax.setyMax(5);
        List<Mower> tondeuses = new ArrayList<Mower>();

        Mower mowerFirst = new Mower();
        Position positionFirst = new Position();
        positionFirst.setX(1);
        positionFirst.setY(2);
        Instruction[] instructionsFirst = {Instruction.G, Instruction.A, Instruction.G,
                Instruction.A, Instruction.G, Instruction.A,
                Instruction.G, Instruction.A, Instruction.A};
        mowerFirst.setPosition(positionFirst);
        mowerFirst.setDirection(Direction.N);
        mowerFirst.setInstructions(instructionsFirst);
        tondeuses.add(mowerFirst);

        Mower mowerSecond = new Mower();
        Position positionSecond = new Position();
        positionSecond.setX(3);
        positionSecond.setY(3);
        Instruction[] instructionsSecond = {Instruction.A, Instruction.A, Instruction.D,
                Instruction.A, Instruction.A, Instruction.D, Instruction.A,
                Instruction.D, Instruction.D, Instruction.A};
        mowerSecond.setPosition(positionSecond);
        mowerSecond.setDirection(Direction.E);
        mowerSecond.setInstructions(instructionsSecond);
        tondeuses.add(mowerSecond);

        fileDataExpected.setCoordinateMax(coordinateMax);
        fileDataExpected.setTondeuses(tondeuses);

        String coordinate = "5 5";
        String directionFirst = "1 2 N";
        String instructionsLineFirst = "GAGAGAGAA";
        String directionSecond = "3 3 E";
        String instructionsLineSecond = "AADAADADDA";

        File file = new File(FILE_NAME);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(coordinate);
        writer.newLine();
        writer.write(directionFirst);
        writer.newLine();
        writer.write(instructionsLineFirst);
        writer.newLine();
        writer.write(directionSecond);
        writer.newLine();
        writer.write(instructionsLineSecond);

        writer.close();

        //WHEN
        this.controleMowerService.calculPositionTondeuse(file);

        //THEN
        String[] valueReturn= outputStreamCaptor.toString().split("\r\n");
        assertEquals(numberOfTondeuseExpected, valueReturn.length);
        assertEquals(pointFinalForFirstTondeuseExpected, valueReturn[0]);
        assertEquals(pointFinalForSecondeTondeuseExpected, valueReturn[1]);
    }
}