package model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The enum Instruction.
 *
 * @author Yann Ducloux
 * Défini l'instructrion.
 */
public enum Instruction {
    GAUCHE("G"),
    DROITE("D"),
    AVANCER("A");
    String instructionString;

    Instruction(String instructionString) {
        this.instructionString = instructionString;
    }

    private static final String EMPTY_FIELD = "";
    public static List<Instruction> transcription(String instructionString) {
        return Stream.of(instructionString.split(EMPTY_FIELD))
                .map (Instruction::convertToInstruction)
                .collect(Collectors.toList());
    }

    private static Instruction convertToInstruction(String instructionString) {
        for (Instruction instruction : Instruction.values()) {
            if (instruction.instructionString.equalsIgnoreCase(instructionString)) {
                return instruction;
            }
        }
        return null;
    }

    public static Mower executeInstructions(Mower mower, Dimension dimension) {
        List<Instruction> instructions = mower.getInstructions();
        for (int i = 0; i < instructions.size(); i++) {
            switch (instructions.get(i)) {
                case GAUCHE ->  mower.nextDirection(mower.getDirection().turnLeft());
                case DROITE ->  mower.nextDirection(mower.getDirection().turnRight());
                case AVANCER -> mower.getPosition().nextPosition(mower.getDirection(), dimension);
            }
        }
        return mower;
    }

}
