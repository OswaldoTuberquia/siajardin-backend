package co.edu.umb.academia.siajardin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
    @SequenceGenerator(name = "usuario_id_seq", allocationSize = 1)
    private long id;
    @Column(unique = true)
    private String correo;
    private String clave;
    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id")
    private TipoDocumento tipodocumento;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    private Rol rol;
    @ManyToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estado;
    @ManyToOne
    @JoinColumn(name = "id_genero", referencedColumnName = "id")
    private Genero genero;
    private int reset;
    private String hash_reset;
    private java.sql.Timestamp fecha_creacion;
    private java.sql.Timestamp fecha_actualizacion;
}
