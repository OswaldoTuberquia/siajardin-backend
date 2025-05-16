package co.edu.umb.academia.siajardin.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private boolean estado;
    private String mensaje;
    private Object objeto;
}

