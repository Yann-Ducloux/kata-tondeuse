package file;

import model.Lawn;
import model.MowerUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    @Test
    void execute() throws IOException {
        //GIVEN
        List<String> documentExpected = FileCreateUtils.contentFile();
        ReadFile readFile= new ReadFile();

        //WHEN
        List<String> documentActual = readFile.execute(FileCreateUtils.createFile());

        //THEN
        assertEquals(documentExpected.size(), documentActual.size());
        for (int i=0; i<documentExpected.size(); i++) {
            assertEquals(documentExpected.get(i), documentActual.get(i));
        }
    }

    @Test
    void transciption() {
        //GIVEN
        List<String> document = FileCreateUtils.contentFile();
        ReadFile readFile = new ReadFile();
        Lawn lawnExpected = FileCreateUtils.getFileData();

        //WHEN
        Lawn lawnActual = readFile.transciption(document);

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