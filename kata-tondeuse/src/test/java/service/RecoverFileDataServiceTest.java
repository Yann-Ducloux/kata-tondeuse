package service;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Yann DUCLOUX
 * Service qui test le service qui gére la récupération des information à partir d'un fichier.
 */
class RecoverFileDataServiceTest {
    private final RecoverFileDataService recoverFileDataService = new RecoverFileDataService();
    /**
     * le nom du fichier.
     */
    private static final String FILE_NAME = "mower.txt";
    @Test
    public void recoverFileDataTest() throws IOException {
        //GIVEN
        FileData fileDataExpected = MowerUtils.getFileData();

        //WHEN
        FileData fileDataActual = recoverFileDataService.recoverData(MowerUtils.createFile());

        //THEN
        assertEquals(fileDataExpected.getCoordinateMax().getxMax(),
                fileDataActual.getCoordinateMax().getxMax());
        assertEquals(fileDataExpected.getCoordinateMax().getyMax(),
                fileDataActual.getCoordinateMax().getyMax());

        assertEquals(fileDataExpected.getMowers().size(), fileDataActual.getMowers().size());
        for(int i = 0; i<fileDataExpected.getMowers().size(); i++) {
            assertEquals(fileDataExpected.getMowers().get(i).getDirection()
                    , fileDataActual.getMowers().get(i).getDirection());
            assertEquals(fileDataExpected.getMowers().get(i).getInstructions().size()
                    , fileDataActual.getMowers().get(i).getInstructions().size());
            for (int j = 0; j < fileDataExpected.getMowers().get(i).getInstructions().size(); j++) {
                assertEquals(fileDataExpected.getMowers().get(i).getInstructions().get(j)
                        , fileDataActual.getMowers().get(i).getInstructions().get(j));
            }
            assertEquals(fileDataExpected.getMowers().get(i).getPosition().getX()
                    , fileDataActual.getMowers().get(i).getPosition().getX());
            assertEquals(fileDataExpected.getMowers().get(i).getPosition().getY()
                    , fileDataActual.getMowers().get(i).getPosition().getY());
        }
    }
}