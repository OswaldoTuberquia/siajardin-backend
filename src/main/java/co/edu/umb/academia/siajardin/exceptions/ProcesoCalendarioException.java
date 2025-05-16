package co.edu.umb.academia.siajardin.exceptions;

public class ProcesoCalendarioException extends Exception {

    private static final long serialVersionUID = 1L;

    public ProcesoCalendarioException(String message) {
        super(message);
    }

    public ProcesoCalendarioException(String message, Throwable cause) {
        super(message, cause);

    }
}
