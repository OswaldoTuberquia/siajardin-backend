package co.edu.umb.academia.siajardin.exceptions;

public class RolException extends Exception {

    private static final long serialVersionUID = 1L;

    public RolException(String message) {
        super(message);
    }

    public RolException(String message, Throwable cause) {
        super(message, cause);

    }
}
