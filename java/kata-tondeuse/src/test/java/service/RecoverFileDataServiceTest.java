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

class RecoverFileDataServiceTest {
    private final RecoverFileDataService recoverFileDataService = new RecoverFileDataService();
    String FILE_NAME = "tondeuse.txt";
    @Test
    public void recoverFileDataTest() throws IOException {
        //GIVEN
        FileData fileDataExpected = new FileData();
        CoordinateMax coordinateMax = new CoordinateMax();
        coordinateMax.setxMax(5);
        coordinateMax.setyMax(5);
        List<Tondeuse> tondeuses = new ArrayList<Tondeuse>();

        Tondeuse tondeuseFirst = new Tondeuse();
        Position positionFirst = new Position();
        positionFirst.setX(1);
        positionFirst.setY(2);
        Instruction[] instructionsFirst = {Instruction.G, Instruction.A, Instruction.G,
                Instruction.A, Instruction.G, Instruction.A,
                Instruction.G, Instruction.A, Instruction.A};
        tondeuseFirst.setPosition(positionFirst);
        tondeuseFirst.setDirection(Direction.N);
        tondeuseFirst.setInstructions(instructionsFirst);
        tondeuses.add(tondeuseFirst);

        Tondeuse tondeuseSecond = new Tondeuse();
        Position positionSecond = new Position();
        positionSecond.setX(3);
        positionSecond.setY(3);
        Instruction[] instructionsSecond = {Instruction.A, Instruction.A, Instruction.D,
                Instruction.A, Instruction.A, Instruction.D, Instruction.A,
                Instruction.D, Instruction.D, Instruction.A};
        tondeuseSecond.setPosition(positionSecond);
        tondeuseSecond.setDirection(Direction.E);
        tondeuseSecond.setInstructions(instructionsSecond);
        tondeuses.add(tondeuseSecond);

        fileDataExpected.setCoordinateMax(coordinateMax);
        fileDataExpected.setTondeuses(tondeuses);

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

        assertEquals(fileDataExpected.getTondeuses().size(), fileDataActual.getTondeuses().size());
        for(int i = 0; i<fileDataExpected.getTondeuses().size(); i++) {
            assertEquals(fileDataExpected.getTondeuses().get(i).getDirection()
                    , fileDataActual.getTondeuses().get(i).getDirection());
            assertEquals(fileDataExpected.getTondeuses().get(i).getInstructions().length
                    , fileDataActual.getTondeuses().get(i).getInstructions().length);
            for (int j = 0; j < fileDataExpected.getTondeuses().get(i).getInstructions().length; j++) {
                assertEquals(fileDataExpected.getTondeuses().get(i).getInstructions()[j]
                        , fileDataActual.getTondeuses().get(i).getInstructions()[j]);
            }
            assertEquals(fileDataExpected.getTondeuses().get(i).getPosition().getX()
                    , fileDataActual.getTondeuses().get(i).getPosition().getX());
            assertEquals(fileDataExpected.getTondeuses().get(i).getPosition().getY()
                    , fileDataActual.getTondeuses().get(i).getPosition().getY());
        }
    }
}