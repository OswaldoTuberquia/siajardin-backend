package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.GeneroException;
import co.edu.umb.academia.siajardin.model.Genero;
import co.edu.umb.academia.siajardin.repo.GeneroJpaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneroServiceImpl implements GeneroService {
    
    @Autowired
    private GeneroJpaRepository repo;

    @Transactional(readOnly = true)
    @Override
    public List<Genero> listarGenero() throws GeneroException {
        return repo.findAll();
    }
    
}
