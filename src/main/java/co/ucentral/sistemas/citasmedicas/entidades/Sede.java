package co.ucentral.sistemas.citasmedicas.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

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
    private int nconsultorios;

    @Column(name = "con_id", nullable = false)
    private String id_consultorios;

    @OneToMany(targetEntity = Consultorio.class, fetch = FetchType.LAZY, mappedBy =  "sede")
    private List<Consultorio> consultorios ;

    @OneToMany(targetEntity = Medico.class, fetch = FetchType.LAZY, mappedBy =  "sede")
    private List<Medico> medicos ;

    public Sede(int id_sede, String nombre, String direccion, int nconsultorios) {
    }
}