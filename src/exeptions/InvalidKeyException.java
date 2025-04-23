package exeptions;

public class InvalidKeyException extends RuntimeException {
    public InvalidKeyException() {
        super("Неверное значение ключа");
    }
}
