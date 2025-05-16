package co.edu.umb.academia.siajardin.util;

import co.edu.umb.academia.siajardin.exceptions.UsuarioException;
import co.edu.umb.academia.siajardin.model.Usuario;
import co.edu.umb.academia.siajardin.security.JwtService;
import co.edu.umb.academia.siajardin.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsExtractJwt {

    private final Logger log = LoggerFactory.getLogger(UserDetailsExtractJwt.class);
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioService service;

    public Usuario getUserDetailSession(HttpServletRequest request) throws Exception {
        try {
            String authHeader = request.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return null;
            }
            String jwt = authHeader.substring(7);
            String userEmail = jwtService.extractUsername(jwt);
            Usuario userDto = service.buscarUsuarioPorCorreo(userEmail.trim());
            if (userDto != null) {
                return userDto;
            }
            return null;
        } catch (UsuarioException ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            log.error(errors.toString());
            throw new Exception(errors.toString());
        }
    }

}
