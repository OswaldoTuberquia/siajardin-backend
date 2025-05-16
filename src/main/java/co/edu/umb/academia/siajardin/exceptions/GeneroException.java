package co.edu.umb.academia.siajardin.exceptions;

public class GeneroException extends Exception {

    private static final long serialVersionUID = 1L;

    public GeneroException(String message) {
        super(message);
    }

    public GeneroException(String message, Throwable cause) {
        super(message, cause);

    }
}
