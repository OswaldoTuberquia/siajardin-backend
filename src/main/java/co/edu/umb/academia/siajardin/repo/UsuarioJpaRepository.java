package co.edu.umb.academia.siajardin.repo;

import co.edu.umb.academia.siajardin.exceptions.UsuarioException;
import co.edu.umb.academia.siajardin.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario, Long> {

    public Usuario findFirstByCorreoAndClave(String correo, String Clave) throws UsuarioException;

    public Usuario findFirstByCorreo(String correo) throws UsuarioException;
}
