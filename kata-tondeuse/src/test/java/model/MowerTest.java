package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

    private static final String LINE_BREAK = System.getProperty("line.separator");
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void lastPosition() throws IOException {
        //GIVEN
        Mower mower = new Mower();
        List<Mower> mowersExpected = MowerUtils.getMowers();

        //WHEN
        List<Mower> mowersActual= mower.lastPosition(MowerUtils.getFileData());

        //THEN
        assertEquals(mowersExpected.size(), mowersActual.size());
        for (int i=0; i<mowersExpected.size(); i++) {
            assertTrue(mowersExpected.get(i).getPosition().equals(mowersActual.get(i).getPosition()));
            assertTrue(mowersExpected.get(i).getDirection().equals(mowersActual.get(i).getDirection()));
        }
    }
}