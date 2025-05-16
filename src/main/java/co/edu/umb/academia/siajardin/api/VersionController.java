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
public class VersionController {
    @GetMapping({"/version"})
    public ResponseEntity<String> versionResponse(){
        return new ResponseEntity<>("API Siajardin Version 1.0.0",HttpStatus.OK);
    }
}
