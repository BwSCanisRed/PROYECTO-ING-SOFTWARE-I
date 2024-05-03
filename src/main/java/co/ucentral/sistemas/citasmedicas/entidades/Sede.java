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
    @Column(name = "Sed_id", nullable = false)
    private int id_sede;

    @Column(name = "Sed_descripcion", nullable = false)
    private String nombre;

    @Column(name = "Sed_direccion", nullable = true)
    private String direccion;

    @Column(name = "Sed_nconsultorios", nullable = false)
    private int nconsultorios;

    @OneToMany(targetEntity = Consultorio.class, fetch = FetchType.LAZY, mappedBy =  "sede")
    private List<Consultorio> consultorios ;

    @OneToMany(targetEntity = Medico.class, fetch = FetchType.LAZY, mappedBy =  "sede")
    private List<Medico> medicos ;
}