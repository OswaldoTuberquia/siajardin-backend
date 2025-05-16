package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.EstadoException;
import co.edu.umb.academia.siajardin.model.Estado;
import co.edu.umb.academia.siajardin.repo.EstadoJpaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoJpaRepository repo;

    @Transactional(readOnly = true)
    @Override
    public List<Estado> listarEstado() throws EstadoException {
        return repo.findAll();
    }

}
