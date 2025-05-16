package co.edu.umb.academia.siajardin.api;

import co.edu.umb.academia.siajardin.exceptions.ProcesoException;
import co.edu.umb.academia.siajardin.model.Proceso;
import co.edu.umb.academia.siajardin.service.ProcesoService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "*")
public class ProcesosController {

    Logger log = LoggerFactory.getLogger(ProcesosController.class);

    @Autowired
    private ProcesoService procesosService;

    @GetMapping({"/procesos"})
    public ResponseEntity<List<Proceso>> getCalendarios() throws ProcesoException {
        try {
            return new ResponseEntity<>(procesosService.listarProcesos(), HttpStatus.OK);
        } catch (ProcesoException ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            log.error(errors.toString());
            return new ResponseEntity<>(new ArrayList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
