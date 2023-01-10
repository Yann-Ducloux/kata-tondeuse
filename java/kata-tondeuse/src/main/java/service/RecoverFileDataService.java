package service;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yann DUCLOUX
 * Service qui gére la récupération des information à partir d'un fichier.
 */
public class RecoverFileDataService {
    public FileData recoverData(File file) throws IOException {
        FileData fileData = new FileData();
        CoordinateMax coordinateMax = new CoordinateMax();
        coordinateMax.setxMax(5);
        coordinateMax.setyMax(5);
        List<Tondeuse> tondeuses = new ArrayList<Tondeuse>();

        Tondeuse tondeuseFirst = new Tondeuse();
        Position positionFirst = new Position();
        positionFirst.setX(1);
        positionFirst.setY(2);
        Instruction[] instructionsFirst = {Instruction.LEFT, Instruction.MOVE, Instruction.LEFT,
                Instruction.MOVE, Instruction.LEFT, Instruction.MOVE,
                Instruction.LEFT, Instruction.MOVE, Instruction.MOVE};
        tondeuseFirst.setPosition(positionFirst);
        tondeuseFirst.setDirection(Direction.NORTH);
        tondeuseFirst.setInstructions(instructionsFirst);
        tondeuses.add(tondeuseFirst);

        Tondeuse tondeuseSecond = new Tondeuse();
        Position positionSecond = new Position();
        positionSecond.setX(1);
        positionSecond.setY(2);
        Instruction[] instructionsSecond = {Instruction.MOVE, Instruction.MOVE, Instruction.RIGHT,
                Instruction.MOVE, Instruction.MOVE, Instruction.RIGHT, Instruction.MOVE,
                Instruction.RIGHT, Instruction.RIGHT, Instruction.MOVE};
        tondeuseSecond.setPosition(positionSecond);
        tondeuseSecond.setDirection(Direction.NORTH);
        tondeuseSecond.setInstructions(instructionsSecond);
        tondeuses.add(tondeuseSecond);

        fileData.setCoordinateMax(coordinateMax);
        fileData.setTondeuses(tondeuses);
        return fileData;
    }
}
