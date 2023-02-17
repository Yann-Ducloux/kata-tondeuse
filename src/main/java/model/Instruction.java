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

    /**
     * Gauche.
     */
    G,
    /**
     * Droite.
     */
    D,
    /**
     * Avancer.
     */
    A;

    Instruction() {
    }

    private static final String EMPTY_FIELD = "";
    public static List<Instruction> transcription(String instructionString) {
        return Stream.of(instructionString.split(EMPTY_FIELD))
                .map (Instruction::valueOf)
                .collect(Collectors.toList());
    }

    public static Mower executeInstructions(Mower mower, Dimension dimension) {
        List<Instruction> instructions = mower.getInstructions();
        for (int i = 0; i < instructions.size(); i++) {
            switch (instructions.get(i)) {
                case G:
                    mower.nextDirection(mower.getDirection().turnLeft());
                    break;
                case D:
                    mower.nextDirection(mower.getDirection().turnRight());
                    break;
                case A:
                    mower.getPosition().nextPosition(mower.getDirection(), dimension);
                    break;
            }
        }
        return mower;
    }

}
