package co.edu.umb.academia.siajardin.api;

import co.edu.umb.academia.siajardin.dto.CalendarioDTO;
import co.edu.umb.academia.siajardin.dto.ResponseDTO;
import co.edu.umb.academia.siajardin.exceptions.CalendarioException;
import co.edu.umb.academia.siajardin.model.Calendario;
import co.edu.umb.academia.siajardin.service.CalendarioService;
import co.edu.umb.academia.siajardin.util.CommonFunctions;
import static co.edu.umb.academia.siajardin.util.Constants.S_UNABLE_TO_PROCESS_INPUT;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "*")
public class CalendarioController {

    Logger log = LoggerFactory.getLogger(CalendarioController.class);

    @Autowired
    private CalendarioService calendarioService;

    @GetMapping({"/calendarios"})
    public ResponseEntity<List<CalendarioDTO>> getCalendarios() throws CalendarioException {
        try {
            return new ResponseEntity<>(calendarioService.listarCalendarios(), HttpStatus.OK);
        } catch (CalendarioException ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            log.error(errors.toString());
            return new ResponseEntity<>(new ArrayList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping({"/calendarios"})
    public ResponseEntity<ResponseDTO> guardarCalendario(@RequestBody CalendarioDTO calendarioDto
    ) throws CalendarioException {
        ResponseDTO dto = new ResponseDTO(false, S_UNABLE_TO_PROCESS_INPUT, null);
        try {
            if (calendarioDto != null) {
                Calendario calendarioEntity = new Calendario();
                calendarioEntity.setId(0);
                calendarioEntity.setDescripcion(calendarioDto.descripcion().trim());
                calendarioEntity.setFecha_inicial(java.sql.Date.valueOf(calendarioDto.fechainicial()));
                calendarioEntity.setFecha_final(java.sql.Date.valueOf(calendarioDto.fechafinal()));
                calendarioEntity.setActivo(((calendarioDto.estado().equalsIgnoreCase("Activo")) ? 1 : 0));
                calendarioEntity.setFecha_creacion(java.sql.Timestamp.valueOf(CommonFunctions.getCurrentDateTime()));
                calendarioService.guardarCalendario(calendarioEntity);

                dto.setEstado(true);
                dto.setMensaje("Calendario correctamente creado");
                return new ResponseEntity<>(dto, HttpStatus.OK);

            }
        } catch (CalendarioException ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            log.error(errors.toString());
            dto.setMensaje(errors.toString());
            return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

}
