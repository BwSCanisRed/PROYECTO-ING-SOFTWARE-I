package co.ucentral.sistemas.citasmedicas.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Sedes")
@ToString
@Entity
public class Sede {

    @Id
    @Column(name = "sed_id", nullable = false)
    private int id_sede;

    @Column(name = "sed_descripcion", nullable = false)
    private String nombre;

    @Column(name = "sed_direccion", nullable = true)
    private String direccion;

    @Column(name = "sed_nconsultorios", nullable = false)
    private String nconsultorios;
}