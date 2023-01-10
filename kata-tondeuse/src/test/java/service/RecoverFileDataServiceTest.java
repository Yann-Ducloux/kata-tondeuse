package service;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
        FileData fileDataExpected = new FileData();
        CoordinateMax coordinateMax = new CoordinateMax();
        coordinateMax.setxMax(5);
        coordinateMax.setyMax(5);
        List<Mower> mowers = new ArrayList<Mower>();

        Mower mowerFirst = new Mower();
        Position positionFirst = new Position();
        positionFirst.setX(1);
        positionFirst.setY(2);
        List<Instruction> instructionsFirst = new ArrayList<>();
        instructionsFirst.add(Instruction.G);
        instructionsFirst.add(Instruction.A);
        instructionsFirst.add(Instruction.G);
        instructionsFirst.add(Instruction.A);
        instructionsFirst.add(Instruction.G);
        instructionsFirst.add(Instruction.A);
        instructionsFirst.add(Instruction.G);
        instructionsFirst.add(Instruction.A);
        instructionsFirst.add(Instruction.A);
        mowerFirst.setPosition(positionFirst);
        mowerFirst.setDirection(Direction.N);
        mowerFirst.setInstructions(instructionsFirst);
        mowers.add(mowerFirst);

        Mower mowerSecond = new Mower();
        Position positionSecond = new Position();
        positionSecond.setX(3);
        positionSecond.setY(3);
        List<Instruction> instructionsSecond = new ArrayList<>();
        instructionsSecond.add(Instruction.A);
        instructionsSecond.add(Instruction.A);
        instructionsSecond.add(Instruction.D);
        instructionsSecond.add(Instruction.A);
        instructionsSecond.add(Instruction.A);
        instructionsSecond.add(Instruction.D);
        instructionsSecond.add(Instruction.A);
        instructionsSecond.add(Instruction.D);
        instructionsSecond.add(Instruction.D);
        instructionsSecond.add( Instruction.A);
        mowerSecond.setPosition(positionSecond);
        mowerSecond.setDirection(Direction.E);
        mowerSecond.setInstructions(instructionsSecond);
        mowers.add(mowerSecond);

        fileDataExpected.setCoordinateMax(coordinateMax);
        fileDataExpected.setMowers(mowers);

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
        FileData fileDataActual = recoverFileDataService.recoverData(file);

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