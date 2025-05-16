package co.edu.umb.academia.siajardin.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "*")
public class HealthcheckController {
    @GetMapping({"/healthcheck"})
    public ResponseEntity<String> healthchecker(){
        return new ResponseEntity<>("Up and Running :" + new java.util.Date().toString(),HttpStatus.OK);
    }
}
