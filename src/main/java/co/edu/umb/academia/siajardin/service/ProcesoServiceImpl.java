package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.ProcesoException;
import co.edu.umb.academia.siajardin.model.Proceso;
import co.edu.umb.academia.siajardin.repo.ProcesoJpaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcesoServiceImpl implements ProcesoService {

    @Autowired
    private ProcesoJpaRepository repo;

    @Transactional(readOnly = true)
    @Override
    public List<Proceso> listarProcesos() throws ProcesoException {
        return repo.findAll();
    }

}
