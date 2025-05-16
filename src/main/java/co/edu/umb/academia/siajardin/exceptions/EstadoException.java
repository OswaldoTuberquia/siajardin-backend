package co.edu.umb.academia.siajardin.exceptions;

public class EstadoException extends Exception {

    private static final long serialVersionUID = 1L;

    public EstadoException(String message) {
        super(message);
    }

    public EstadoException(String message, Throwable cause) {
        super(message, cause);

    }
}
