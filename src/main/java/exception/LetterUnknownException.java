package exception;

public class LetterUnknownException extends RuntimeException {
    public LetterUnknownException() {
        super("The instructions have a letter unknown");
    }
}