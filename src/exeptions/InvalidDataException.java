package exeptions;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException() {
        super("Не потдерживаемый формат данных");
    }
}
