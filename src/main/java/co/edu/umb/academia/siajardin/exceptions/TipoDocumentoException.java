package co.edu.umb.academia.siajardin.exceptions;

public class TipoDocumentoException extends Exception {

    private static final long serialVersionUID = 1L;

    public TipoDocumentoException(String message) {
        super(message);
    }

    public TipoDocumentoException(String message, Throwable cause) {
        super(message, cause);

    }
}
