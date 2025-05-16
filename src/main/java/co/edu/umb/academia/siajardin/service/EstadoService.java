package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.EstadoException;
import co.edu.umb.academia.siajardin.model.Estado;
import java.util.List;

public interface EstadoService {

    public List<Estado> listarEstado() throws EstadoException;
}
