package exception;

public class InstructionEmptyException extends RuntimeException {
    public InstructionEmptyException() {
        super("The instruction is empty");
    }
}