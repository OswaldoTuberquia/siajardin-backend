package co.edu.umb.academia.siajardin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "procesos_x_calendario")
public class ProcesoCalendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    ProcesoCalendarioPK procesoCalendarioPk;
}
