package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The lawn utils
 *
 * @author Yann Ducloux
 * Défini la création de fichier pour les tests.
 */
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
}
