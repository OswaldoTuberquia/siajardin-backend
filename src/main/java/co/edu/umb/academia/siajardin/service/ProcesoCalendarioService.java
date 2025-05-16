package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.ProcesoCalendarioException;
import co.edu.umb.academia.siajardin.model.ProcesoCalendario;
import java.util.List;

public interface ProcesoCalendarioService {

    public List<ProcesoCalendario> listarProcesoCalendario() throws ProcesoCalendarioException;

    public void guardarProcesoCalendario(ProcesoCalendario procesoCalendario) throws ProcesoCalendarioException;
}
