package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.UsuarioException;
import co.edu.umb.academia.siajardin.model.Usuario;
import co.edu.umb.academia.siajardin.repo.UsuarioJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioJpaRepository repo;

    @Transactional(readOnly = true)
    @Override
    public Usuario buscarUsuarioPorCorreoAndClave(String correo, String clave) throws UsuarioException {
        return repo.findFirstByCorreoAndClave(correo, clave);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario buscarUsuarioPorCorreo(String correo) throws UsuarioException {
        return repo.findFirstByCorreo(correo);
    }

}
