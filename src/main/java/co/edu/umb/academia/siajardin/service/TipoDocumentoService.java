package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.TipoDocumentoException;
import co.edu.umb.academia.siajardin.model.TipoDocumento;
import java.util.List;

public interface TipoDocumentoService {

    public List<TipoDocumento> listarTipoDocumento() throws TipoDocumentoException;
}
