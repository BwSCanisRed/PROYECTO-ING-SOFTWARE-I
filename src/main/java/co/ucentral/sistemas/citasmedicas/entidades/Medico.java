package co.ucentral.sistemas.citasmedicas.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Medicos")
@ToString
@Entity
public class Medico {

    @Id
    @Column(name = "med_id", nullable = false)
    private int identificacion;

    @Column(name = "med_nombre", nullable = false)
    private String nombre;

    @Column(name = "rol_id", nullable = false)
    private int rol;

    @Column(name = "med_estado", nullable = false)
    private Boolean estado;

    @Column(name = "con_id", nullable = true)
    private int id_consultorio;

    @Column(name = "es_id", nullable = false)
    private int id_especialidad;

    @OneToOne
    @JoinColumn(name = "sed_id")
    private Sede sede;

    @Column(name = "reg_id", nullable = true)
    private int id_registro;


}