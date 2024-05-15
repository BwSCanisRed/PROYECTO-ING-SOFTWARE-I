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
@ToString
@Table(name = "Consultorios")
@Entity
public class Consultorio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "con_serial", nullable = false)
    private Integer serial;

    @Column(name = "con_id", nullable = false)
    private Integer idConsultorio;

    @Column(name = "con_nombre")
    private String nombre;

    //@OneToMany(targetEntity = Medico.class, fetch = FetchType.LAZY, mappedBy =  "consultorio")
    //private List<Medico> medicos;

    @ManyToOne(targetEntity = Sede.class)
    @JoinColumn(name = "sed_id")
    private Sede sede;

    public Consultorio(int idConsultorio, String nombre, Sede sede) {
        this.idConsultorio = idConsultorio;
        this.nombre = nombre;
        this.sede = sede;
    }
}