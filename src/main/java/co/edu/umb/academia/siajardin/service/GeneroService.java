package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.GeneroException;
import co.edu.umb.academia.siajardin.model.Genero;
import java.util.List;

public interface GeneroService {

    public List<Genero> listarGenero() throws GeneroException;
}
