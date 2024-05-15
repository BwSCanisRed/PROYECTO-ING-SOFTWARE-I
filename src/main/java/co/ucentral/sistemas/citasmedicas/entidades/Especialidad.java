package co.ucentral.sistemas.citasmedicas.entidades;
import co.ucentral.sistemas.citasmedicas.dto.MedicoDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Especialidades")
@ToString
@Entity
public class Especialidad {

    @Getter
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "es_id", nullable = false)
    private Integer idEspecialidad;

    @Column(name = "es_descripcion", nullable = true)
    private String nombre;

    //@OneToMany(targetEntity = Medico.class, fetch = FetchType.LAZY, mappedBy =  "especialidad")
    //private List<MedicoDto> medicos ;

    public Especialidad(String nombre) {
        this.nombre = nombre;
    }
}

