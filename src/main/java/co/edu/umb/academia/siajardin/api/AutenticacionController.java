package co.edu.umb.academia.siajardin.api;

import co.edu.umb.academia.siajardin.dto.LoginDTO;
import co.edu.umb.academia.siajardin.dto.userAuthenticatedAppDto;
import co.edu.umb.academia.siajardin.model.Usuario;
import co.edu.umb.academia.siajardin.security.CustomUserDetailsService;
import co.edu.umb.academia.siajardin.security.JwtService;
import co.edu.umb.academia.siajardin.service.UsuarioService;
import static co.edu.umb.academia.siajardin.util.Constants.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "*")
public class AutenticacionController {

    Logger log = LoggerFactory.getLogger(AutenticacionController.class);

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private JwtService jwtTokenUtil;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @PostMapping("/login")
    public ResponseEntity<userAuthenticatedAppDto> doAuth(
            @RequestBody LoginDTO logindto) throws Exception {
        userAuthenticatedAppDto userDto = new userAuthenticatedAppDto(false, "bad request", null, null, null, null, N_ZERO);
        try {
            if (logindto != null) {
                if (logindto.getUsername() == null || logindto.getUsername().isEmpty()) {
                    userDto.setMessage("username not present in body");
                    return new ResponseEntity<>(userDto, HttpStatus.BAD_REQUEST);
                }
                if (logindto.getPassword() == null || logindto.getPassword().isEmpty()) {
                    userDto.setMessage("password not present in body");
                    return new ResponseEntity<>(userDto, HttpStatus.BAD_REQUEST);
                }
                Usuario usuarioDto = usuarioService.buscarUsuarioPorCorreoAndClave(logindto.getUsername().trim(), logindto.getPassword().trim());
                if (usuarioDto != null) {
                    if (bcryptEncoder.matches(logindto.getPassword().trim(),
                            bcryptEncoder.encode(usuarioDto.getClave().trim()))) {
                        if (usuarioDto.getEstado().getId() == N_INACTIVO_2) {
                            userDto.setMessage(S_USUARIO_INACTIVO);
                            return new ResponseEntity<>(userDto, HttpStatus.UNAUTHORIZED);
                        }

                        if (usuarioDto.getEstado().getId() == N_BLOQUEADO_3) {
                            userDto.setMessage(S_USUARIO_BLOQUEADO);
                            return new ResponseEntity<>(userDto, HttpStatus.UNAUTHORIZED);
                        }
                        String rol = usuarioDto.getRol().getDescripcion().trim();
                        Map<String, Object> claims = new HashMap();
                        claims.put("email", usuarioDto.getCorreo().trim());
                        claims.put("names", usuarioDto.getNombre().trim() + " " + usuarioDto.getApellido().trim());
                        claims.put("rol", rol);
                        String jwtToken = this.jwtTokenUtil
                                .generateToken(
                                        claims,
                                        userDetailsService
                                                .loadUserByUsername(
                                                        usuarioDto.getCorreo().trim()));
                        userDto.setSuccess(true);
                        userDto.setMessage("Authorized");
                        userDto.setToken(jwtToken);
                        userDto.setEmail(usuarioDto.getCorreo().trim());
                        userDto.setNames(usuarioDto.getNombre().trim() + " " + usuarioDto.getApellido().trim());
                        userDto.setRol(rol);
                        userDto.setIdusuario((int) usuarioDto.getId());
                        //genera respuesta
                        return new ResponseEntity<>(userDto, HttpStatus.OK);
                    } else {
                        userDto.setMessage(S_USUARIO_CLAVE_INVALIDA);
                        return new ResponseEntity<>(userDto, HttpStatus.UNAUTHORIZED);
                    }
                }
                userDto.setMessage(S_USUARIO_NO_AUTORIZADO);
                return new ResponseEntity<>(userDto, HttpStatus.UNAUTHORIZED);
            }
        } catch (AuthenticationException ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            log.error(errors.toString());
            userDto.setMessage(errors.toString());
            return new ResponseEntity<>(userDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(userDto, HttpStatus.BAD_REQUEST);
    }
}
