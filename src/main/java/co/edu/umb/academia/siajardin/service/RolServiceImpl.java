package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.RolException;
import co.edu.umb.academia.siajardin.model.Rol;
import co.edu.umb.academia.siajardin.repo.RoljpaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RoljpaRepository repo;

    @Transactional(readOnly = true)
    @Override
    public List<Rol> listarRoles() throws RolException {
        return repo.findAll();
    }

}
