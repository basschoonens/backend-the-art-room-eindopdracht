package nl.novi.theartroom.exception;

public class BadRequestException extends RuntimeException {

    //TODO toevoegen aan mijn ExceptionController
    private static final long serialVersionUID = 1L;
    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }
}