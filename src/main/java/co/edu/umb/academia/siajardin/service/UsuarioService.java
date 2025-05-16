package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.UsuarioException;
import co.edu.umb.academia.siajardin.model.Usuario;

public interface UsuarioService {

    public Usuario buscarUsuarioPorCorreoAndClave(String correo, String clave) throws UsuarioException;

    public Usuario buscarUsuarioPorCorreo(String correo) throws UsuarioException;
}
