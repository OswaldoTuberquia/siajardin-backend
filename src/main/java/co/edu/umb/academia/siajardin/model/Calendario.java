package co.edu.umb.academia.siajardin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
@Table(name = "calendario")
public class Calendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendario_id_seq")
    @SequenceGenerator(name = "calendario_id_seq", allocationSize = 1)
    private long id;
    private String descripcion;
    private java.sql.Date fecha_inicial;
    private java.sql.Date fecha_final;
    private int activo;
    private java.sql.Timestamp fecha_creacion;
    private java.sql.Timestamp fecha_actualizacion;
}
