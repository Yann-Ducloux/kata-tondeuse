package application;

import file.ReadFile;
import model.Lawn;
import model.Mower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.LawnUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * The application test.
 *
 * @author Yann Ducloux
 * Défini le test de l'ensemble de l'application.
 */
public class ApplicationTest {

    private static final String LINE_BREAK = System.getProperty("line.separator");
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void transcriptionAndLastPositionTest() throws IOException {
        //GIVEN
        ReadFile readFile = new ReadFile();
        Mower mower = new Mower();

        //WHEN
        Lawn lawn = readFile.transcription(LawnUtils.fileOfLawn());
        mower.lastPosition(lawn);

        //THEN
        String[] lineSystemOutPrintln = outputStreamCaptor.toString().split(LINE_BREAK);
        assertEquals(2, lineSystemOutPrintln.length);
        assertEquals("1 3 N", lineSystemOutPrintln[0]);
        assertEquals("5 1 E", lineSystemOutPrintln[1]);
    }
}
