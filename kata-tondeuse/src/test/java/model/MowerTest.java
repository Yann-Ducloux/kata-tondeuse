package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

    private static final String LINE_BREAK = System.getProperty("line.separator");
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void lastPosition() throws IOException {
        //GIVEN
        String pointFinalForFirstMowerExpected = "1 3 N";
        String pointFinalForSecondMowerExpected = "5 1 E";
        int numberOfMowerExpected = 2;
        Mower mower = new Mower();

        //WHEN
        mower.lastPosition(MowerUtils.getFileData());

        //THEN
        String[] lineSystemOutPrintln = outputStreamCaptor.toString().split(LINE_BREAK);
        assertEquals(numberOfMowerExpected, lineSystemOutPrintln.length);
        assertEquals(pointFinalForFirstMowerExpected, lineSystemOutPrintln[0]);
        assertEquals(pointFinalForSecondMowerExpected, lineSystemOutPrintln[1]);
    }
}