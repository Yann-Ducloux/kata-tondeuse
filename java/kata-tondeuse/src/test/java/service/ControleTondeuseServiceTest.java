package service;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControleTondeuseServiceTest {
    String FILE_NAME = "tondeuse.txt";
    private final ControleTondeuseService controleTondeuseService = new ControleTondeuseService();
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
        List<Tondeuse> tondeuses = new ArrayList<Tondeuse>();

        Tondeuse tondeuseFirst = new Tondeuse();
        Position positionFirst = new Position();
        positionFirst.setX(1);
        positionFirst.setY(2);
        Instruction[] instructionsFirst = {Instruction.G, Instruction.A, Instruction.G,
                Instruction.A, Instruction.G, Instruction.A,
                Instruction.G, Instruction.A, Instruction.A};
        tondeuseFirst.setPosition(positionFirst);
        tondeuseFirst.setDirection(Direction.N);
        tondeuseFirst.setInstructions(instructionsFirst);
        tondeuses.add(tondeuseFirst);

        Tondeuse tondeuseSecond = new Tondeuse();
        Position positionSecond = new Position();
        positionSecond.setX(3);
        positionSecond.setY(3);
        Instruction[] instructionsSecond = {Instruction.A, Instruction.A, Instruction.D,
                Instruction.A, Instruction.A, Instruction.D, Instruction.A,
                Instruction.D, Instruction.D, Instruction.A};
        tondeuseSecond.setPosition(positionSecond);
        tondeuseSecond.setDirection(Direction.E);
        tondeuseSecond.setInstructions(instructionsSecond);
        tondeuses.add(tondeuseSecond);

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
        this.controleTondeuseService.calculPositionTondeuse(file);

        //THEN
        String[] valueReturn= outputStreamCaptor.toString().split("\r\n");
        assertEquals(numberOfTondeuseExpected, valueReturn.length);
        assertEquals(pointFinalForFirstTondeuseExpected, valueReturn[0]);
        assertEquals(pointFinalForSecondeTondeuseExpected, valueReturn[1]);
    }
}