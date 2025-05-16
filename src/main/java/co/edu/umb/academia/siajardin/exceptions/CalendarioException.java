package co.edu.umb.academia.siajardin.exceptions;

public class CalendarioException extends Exception {

    private static final long serialVersionUID = 1L;

    public CalendarioException(String message) {
        super(message);
    }

    public CalendarioException(String message, Throwable cause) {
        super(message, cause);

    }
}
