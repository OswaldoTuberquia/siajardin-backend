package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.ProcesoCalendarioException;
import co.edu.umb.academia.siajardin.model.ProcesoCalendario;
import co.edu.umb.academia.siajardin.repo.ProcesoCalendarioJpaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcesoCalendarioServiceImpl implements ProcesoCalendarioService {
    
    @Autowired
    private ProcesoCalendarioJpaRepository repo;

    @Transactional(readOnly =  true)
    @Override
    public List<ProcesoCalendario> listarProcesoCalendario() throws ProcesoCalendarioException {
        return repo.findAll();
    }

    @Transactional
    @Override
    public void guardarProcesoCalendario(ProcesoCalendario procesoCalendario) throws ProcesoCalendarioException {
        repo.saveAndFlush(procesoCalendario);
    }
    
}
