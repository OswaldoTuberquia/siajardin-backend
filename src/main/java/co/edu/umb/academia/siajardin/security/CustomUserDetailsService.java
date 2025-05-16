package co.edu.umb.academia.siajardin.security;

import co.edu.umb.academia.siajardin.exceptions.UsuarioException;
import co.edu.umb.academia.siajardin.model.Usuario;
import co.edu.umb.academia.siajardin.service.UsuarioService;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Usuario userDto = service.buscarUsuarioPorCorreo(username.trim());
            if (userDto != null) {
                Collection<GrantedAuthority> authorities = new ArrayList<>();
                return new User(userDto.getCorreo().trim(),
                        userDto.getClave().trim(), authorities);
            }
        } catch (UsuarioException ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            log.error(errors.toString());
        }
        return null;
    }

}
