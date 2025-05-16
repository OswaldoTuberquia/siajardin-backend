package co.edu.umb.academia.siajardin.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProcesoCalendarioPK {

    @ManyToOne
    @JoinColumn(name = "id_calendario", referencedColumnName = "id")
    private Calendario calendario;
    @ManyToOne
    @JoinColumn(name = "id_proceso", referencedColumnName = "id")
    private Proceso proceso;
}
