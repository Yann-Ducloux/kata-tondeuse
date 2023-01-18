package main;

import file.ReadFile;
import model.Lawn;
import model.Mower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.LawnUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class mainTest {

    private static final String LINE_BREAK = System.getProperty("line.separator");
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void mainTest() throws IOException {
        //GIVEN
        ReadFile readFile = new ReadFile();
        Mower mower = new Mower();
        String pointFinalForFirstMowerExpected = "1 3 N";
        String pointFinalForSecondMowerExpected = "5 1 E";
        int numberOfMowerExpected = 2;

        //WHEN
        List<String> document = readFile.execute(LawnUtils.fileOfLawn());
        Lawn lawn = readFile.transcription(document);
        mower.lastPosition(lawn);

        //THEN
        String[] lineSystemOutPrintln = outputStreamCaptor.toString().split(LINE_BREAK);
        assertEquals(numberOfMowerExpected, lineSystemOutPrintln.length);
        assertEquals(pointFinalForFirstMowerExpected, lineSystemOutPrintln[0]);
        assertEquals(pointFinalForSecondMowerExpected, lineSystemOutPrintln[1]);
    }
}
