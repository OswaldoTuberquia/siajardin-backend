package co.edu.umb.academia.siajardin.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @NotNull(message = "el usuario no puede ser nullo")
    @NotEmpty(message = "el usuario no puede ser vacio")
    private String username;
    @NotNull(message = "la clave no puede ser nulla")
    @NotEmpty(message = "la clave no puede ser vacia")
    private String password;
}
