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

@Table(name = "Consultorios")
@ToString
@Entity
public class Consultorio {

    @Id
    @Column(name = "con_id", nullable = false)
    private int id_consultorio;

    @Column(name = "con_descripcion", nullable = true)
    private String nombre;

    @OneToMany(targetEntity = Medico.class, fetch = FetchType.LAZY, mappedBy =  "consultorio")
    private List<Medico> medicos ;

    @ManyToOne(targetEntity = Sede.class)
    @JoinColumn(name = "sed_id")
    private Sede sede;
}