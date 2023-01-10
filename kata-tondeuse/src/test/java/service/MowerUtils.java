package service;

import model.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MowerUtils {

    /**
     * le nom du fichier.
     */
    private static final String FILE_NAME = "mower.txt";

    static File createFile() throws IOException {

        String coordinate = "5 5";
        String direction = "1 2 N";
        String instructionsLine = "GAGAGAGAA";
        String directionSecond = "3 3 E";
        String instructionsLineSecond = "AADAADADDA";

        File file = new File(FILE_NAME);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(coordinate);
        writer.newLine();
        writer.write(direction);
        writer.newLine();
        writer.write(instructionsLine);
        writer.newLine();
        writer.write(directionSecond);
        writer.newLine();
        writer.write(instructionsLineSecond);

        writer.close();
        return file;
    }
    
    static Mower getMowerFirst() {
        Mower mower = new Mower();
        Position position = new Position();
        position.setX(1);
        position.setY(2);
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.G);
        instructions.add(Instruction.A);
        instructions.add(Instruction.G);
        instructions.add(Instruction.A);
        instructions.add(Instruction.G);
        instructions.add(Instruction.A);
        instructions.add(Instruction.G);
        instructions.add(Instruction.A);
        instructions.add(Instruction.A);
        mower.setPosition(position);
        mower.setDirection(Direction.N);
        mower.setInstructions(instructions);
        return mower;
    }

    static Mower getMowerSecond() {
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
        return mowerSecond;
    }

    static CoordinateMax getCoordinateMax() {
        CoordinateMax coordinateMax = new CoordinateMax();
        coordinateMax.setxMax(5);
        coordinateMax.setyMax(5);
        return coordinateMax;
    }
}
