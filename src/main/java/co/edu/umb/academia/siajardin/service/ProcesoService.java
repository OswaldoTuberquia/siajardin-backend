package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.ProcesoException;
import co.edu.umb.academia.siajardin.model.Proceso;
import java.util.List;

public interface ProcesoService {

    public List<Proceso> listarProcesos() throws ProcesoException;
}
