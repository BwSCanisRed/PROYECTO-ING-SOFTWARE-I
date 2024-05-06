package co.ucentral.sistemas.citasmedicas.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Especialidades")
@ToString
@Entity
public class Especialidad {

    @Id
    @Column(name = "es_id", nullable = false)
    private int id_especialidad;

    @Column(name = "es_descripcion", nullable = true)
    private String nombre_especialidad;

}

