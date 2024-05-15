package co.ucentral.sistemas.citasmedicas.entidades;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Sedes")
@ToString
@Entity
public class Sede {

    @Getter
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "sed_id", nullable = false)
    private Integer id_sede;

    @Column(name = "sed_descripcion", nullable = false)
    private String nombre;

    @Column(name = "sed_direccion", nullable = true)
    private String direccion;

    @Column(name = "sed_nconsultorios", nullable = true)
    private Integer nconsultorios;

    //Quitar
    /*@Column(name = "con_id", nullable = false)
    private String id_consultorios;

    @OneToMany(targetEntity = Consultorio.class, fetch = FetchType.LAZY, mappedBy =  "sede")
    private List<Consultorio> consultorios ;

    @OneToMany(targetEntity = Medico.class, fetch = FetchType.LAZY, mappedBy =  "sede")
    private List<Medico> medicos ;*/

    public Sede(String nombre, String direccion, Integer nconsultorios) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nconsultorios = nconsultorios;
    }

}