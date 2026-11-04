package teste01.testandoSpring.infrastructure.exception;

public class ConflictException extends RuntimeException {       //exceção de conflito
    public ConflictException(String message) {
        super(message);
    }
}
