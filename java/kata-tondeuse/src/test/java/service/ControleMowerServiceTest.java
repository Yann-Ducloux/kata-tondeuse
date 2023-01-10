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
        this.controleMowerService.calculPositionMower(file);

        //THEN
        String[] valueReturn= outputStreamCaptor.toString().split("\r\n");
        assertEquals(numberOfTondeuseExpected, valueReturn.length);
        assertEquals(pointFinalForFirstTondeuseExpected, valueReturn[0]);
        assertEquals(pointFinalForSecondeTondeuseExpected, valueReturn[1]);
    }
}