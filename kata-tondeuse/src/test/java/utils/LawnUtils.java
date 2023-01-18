package utils;

import model.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LawnUtils {

    private static final String FILE_NAME = "mower.txt";

    public static File fileOfLawn() throws IOException {

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


    public static List<String> contentFileOfLawn() {
        List<String> document = new ArrayList<String>();
        document.add("5 5");
        document.add("1 2 N");
        document.add("GAGAGAGAA");
        document.add("3 3 E");
        document.add("AADAADADDA");
        return document;
    }

    static Mower mowerFirstBeginPosition() {
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

    static Mower mowerSecondBeginPosition() {
        Position position = new Position(3,3);
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.A);
        instructions.add(Instruction.A);
        instructions.add(Instruction.D);
        instructions.add(Instruction.A);
        instructions.add(Instruction.A);
        instructions.add(Instruction.D);
        instructions.add(Instruction.A);
        instructions.add(Instruction.D);
        instructions.add(Instruction.D);
        instructions.add( Instruction.A);
        return new Mower(position, Direction.E, instructions);
    }

    public static Lawn lawnFinal() {
        List<Mower> mowers = new ArrayList<Mower>();
        mowers.add(LawnUtils.mowerFirstBeginPosition());
        mowers.add(LawnUtils.mowerSecondBeginPosition());
        return new Lawn(LawnUtils.dimensionOfLawn(), mowers);
    }


    static Mower MowerFirstPositionFinal() {
        Position position = new Position(1,3);
        List<Instruction> instructions = new ArrayList<>();
        return new Mower(position, Direction.N, instructions);
    }

    static Mower MowerSecondPositionFinal() {
        Position positionSecond = new Position(5,1);
        List<Instruction> instructionsSecond = new ArrayList<>();
        return new Mower(positionSecond, Direction.E, instructionsSecond);
    }


    public static List<Mower> mowersPositionFinal() {
        List<Mower> mowers = new ArrayList<Mower>();
        mowers.add(LawnUtils.MowerFirstPositionFinal());
        mowers.add(LawnUtils.MowerSecondPositionFinal());
        return mowers;
    }

    static Dimension dimensionOfLawn() {
        Dimension dimension = new Dimension(5, 5);
        return dimension;
    }
}
