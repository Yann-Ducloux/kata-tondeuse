package model;

import exception.InstructionEmptyException;
import exception.InstructionNullException;
import exception.LetterUnknownException;

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
    private String code;

    Instruction(String code) {
        this.code = code;
    }

    private static final String EMPTY_FIELD = "";
    public static List<Instruction> transcription(String instructionString) {
        if(instructionString == null) {
            throw new InstructionNullException();
        }
        if(instructionString.isEmpty()) {
            throw new InstructionEmptyException();
        }
        return Stream.of(instructionString.split(EMPTY_FIELD))
                .map (Instruction::convertToInstruction)
                .collect(Collectors.toList());
    }

    private static Instruction convertToInstruction(String instructionString) {
        for (Instruction instruction : Instruction.values()) {
            if (instruction.code.equalsIgnoreCase(instructionString)) {
                return instruction;
            }
        }
        throw new LetterUnknownException();
    }

    public static Mower executeInstructions(Mower mower, Dimension dimension) {
        List<Instruction> instructions = mower.getInstructions();
        for (int i = 0; i < instructions.size(); i++) {
            switch (instructions.get(i)) {
                case GAUCHE ->  mower.nextDirection(mower.turnLeft());
                case DROITE ->  mower.nextDirection(mower.turnRight());
                case AVANCER -> mower.nextPosition(mower.getDirection(), dimension);
            }
        }
        return mower;
    }

}
