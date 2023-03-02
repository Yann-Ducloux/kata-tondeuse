package exception;

public class InstructionNullException extends RuntimeException {
    public InstructionNullException() {
            super("this instruction is null");
     }
}