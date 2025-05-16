package co.edu.umb.academia.siajardin.exceptions;

public class UsuarioException extends Exception {

    private static final long serialVersionUID = 1L;

    public UsuarioException(String message) {
        super(message);
    }

    public UsuarioException(String message, Throwable cause) {
        super(message, cause);

    }
}
