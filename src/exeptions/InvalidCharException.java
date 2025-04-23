package exeptions;

public class InvalidCharException extends RuntimeException{
    public InvalidCharException() {
        super("В тексте не читаемый сивол(ы)");
    }
}
