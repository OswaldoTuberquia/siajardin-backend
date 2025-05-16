package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.RolException;
import co.edu.umb.academia.siajardin.model.Rol;
import java.util.List;

public interface RolService {

    public List<Rol> listarRoles() throws RolException;
}
