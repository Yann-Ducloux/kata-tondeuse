package file;

import model.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCreateUtils {

    private static final String FILE_NAME = "mower.txt";
    static List<String> contentFile() {
        List<String> document = new ArrayList<String>();
        document.add("5 5");
        document.add("1 2 N");
        document.add("GAGAGAGAA");
        document.add("3 3 E");
        document.add("AADAADADDA");
        return document;
    }
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
        Position position = new Position(1,2);
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
        return new Mower(position, Direction.N, instructions);
    }

    static Mower getMowerSecond() {
        Position positionSecond = new Position(3,3);
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
        return new Mower(positionSecond, Direction.E, instructionsSecond);
    }

    static Dimension getDimension() {
        Dimension dimension = new Dimension(5, 5);
        return dimension;
    }


    static Lawn getFileData() {
        List<Mower> mowers = new ArrayList<Mower>();
        mowers.add(FileCreateUtils.getMowerFirst());
        mowers.add(FileCreateUtils.getMowerSecond());
        return new Lawn(FileCreateUtils.getDimension(), mowers);
    }
}
