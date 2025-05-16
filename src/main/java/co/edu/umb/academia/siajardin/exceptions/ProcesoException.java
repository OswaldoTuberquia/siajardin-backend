package co.edu.umb.academia.siajardin.exceptions;

public class ProcesoException extends Exception {

    private static final long serialVersionUID = 1L;

    public ProcesoException(String message) {
        super(message);
    }

    public ProcesoException(String message, Throwable cause) {
        super(message, cause);

    }
}
