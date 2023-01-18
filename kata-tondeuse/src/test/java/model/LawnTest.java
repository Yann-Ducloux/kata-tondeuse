package model;

import org.junit.jupiter.api.Test;
import utils.LawnUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LawnTest {

    @Test
    void execute() throws IOException {
        //GIVEN
        Lawn lawnExpected = LawnUtils.lawnFinal();

        //WHEN
        Lawn lawnActual = Lawn.execute(LawnUtils.fileOfLawn());

        //THEN
        assertTrue(lawnExpected.getCoordinateMax().equals(lawnActual.getCoordinateMax()));
        assertEquals(lawnExpected.getMowers().size(), lawnActual.getMowers().size());
        for(int i = 0; i< lawnExpected.getMowers().size(); i++) {
            assertEquals(lawnExpected.getMowers().get(i).getDirection()
                    , lawnActual.getMowers().get(i).getDirection());
            assertEquals(lawnExpected.getMowers().get(i).getInstructions().size()
                    , lawnActual.getMowers().get(i).getInstructions().size());
            for (int j = 0; j < lawnExpected.getMowers().get(i).getInstructions().size(); j++) {
                assertEquals(lawnExpected.getMowers().get(i).getInstructions().get(j)
                        , lawnActual.getMowers().get(i).getInstructions().get(j));
            }
            assertEquals(lawnExpected.getMowers().get(i).getPosition().getX()
                    , lawnActual.getMowers().get(i).getPosition().getX());
            assertEquals(lawnExpected.getMowers().get(i).getPosition().getY()
                    , lawnActual.getMowers().get(i).getPosition().getY());
        }
    }
}