package co.edu.umb.academia.siajardin.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userAuthenticatedAppDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private boolean success;
    private String message;
    private String token;
    private String email;
    private String names;
    private String rol;
    private int idusuario;
}
