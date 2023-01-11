package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Yann DUCLOUX
 * Service qui test le service qui gére le contrôle des tondeuses.
 */
class ControleMowerServiceTest {
    /**
     * le saut de ligne.
     */
    private static final String LINE_BREAK = "\n";
    /**
     * the controle Mower Service.
     */
    private final ControleMowerService controleMowerService = new ControleMowerService();
    /**
     * the standard out.
     */
    private final PrintStream standardOut = System.out;
    /**
     * the output Stream Captor.
     */
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void calculPositionMowerTest() throws IOException {
        //GIVEN
        String pointFinalForFirstMowerExpected = "1 3 N";
        String pointFinalForSecondeMowerExpected = "5 1 E";
        int numberOfMowerExpected = 2;

        //WHEN
        this.controleMowerService.calculPositionMower(MowerUtils.createFile());

        //THEN
        String[] lineSystemOutPrintln = outputStreamCaptor.toString().split(LINE_BREAK);
        assertEquals(numberOfMowerExpected, lineSystemOutPrintln.length);
        assertEquals(pointFinalForFirstMowerExpected, lineSystemOutPrintln[0]);
        assertEquals(pointFinalForSecondeMowerExpected, lineSystemOutPrintln[1]);
    }
}