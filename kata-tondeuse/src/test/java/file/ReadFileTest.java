package file;

import model.Lawn;
import org.junit.jupiter.api.Test;
import utils.LawnUtils;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    @Test
    void execute() throws IOException {
        //GIVEN
        List<String> documentExpected = LawnUtils.contentFileOfLawn();
        ReadFile readFile= new ReadFile();

        //WHEN
        List<String> documentActual = readFile.execute(LawnUtils.fileOfLawn());

        //THEN
        assertEquals(documentExpected.size(), documentActual.size());
        for (int i=0; i<documentExpected.size(); i++) {
            assertEquals(documentExpected.get(i), documentActual.get(i));
        }
    }

    @Test
    void transcription() {
        //GIVEN
        List<String> document = LawnUtils.contentFileOfLawn();
        ReadFile readFile = new ReadFile();
        Lawn lawnExpected = LawnUtils.lawnFinal();

        //WHEN
        Lawn lawnActual = readFile.transcription(document);

        //THEN
        assertTrue(lawnExpected.getCoordinateMax().equals(lawnActual.getCoordinateMax()));
        assertEquals(lawnExpected.getMowers().size(), lawnActual.getMowers().size());
        for(int i = 0; i< lawnExpected.getMowers().size(); i++) {
            assertTrue(lawnExpected.getMowers().get(i).getDirection().equals(
                    lawnActual.getMowers().get(i).getDirection()));
            assertEquals(lawnExpected.getMowers().get(i).getInstructions().size()
                    , lawnActual.getMowers().get(i).getInstructions().size());
            for (int j = 0; j < lawnExpected.getMowers().get(i).getInstructions().size(); j++) {
                assertEquals(lawnExpected.getMowers().get(i).getInstructions().get(j)
                        , lawnActual.getMowers().get(i).getInstructions().get(j));
            }
            assertTrue(lawnExpected.getMowers().get(i).getPosition().equals(
                    lawnActual.getMowers().get(i).getPosition()));
        }
    }
}