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

    @Column(name = "med_tipoid", nullable = false)
    private String tipo_identificacion;

    @Column(name = "med_nombre", nullable = false)
    private String nombre;

    @Column(name = "rol_id", nullable = false)
    private String rol;

    @Column(name = "med_celular", nullable = false)
    private String celular;

    @Column(name = "med_direccion", nullable = false)
    private String direccion;

    @Column(name = "med_estado", nullable = false)
    private Boolean estado;

    @Column(name = "con_id", nullable = false)
    private int id_consultorio;

    @Column(name = "es_id", nullable = false)
    private int id_especialidad;

    @Column(name = "sed_id", nullable = false)
    private int id_sede;

    @Column(name = "med_correo", nullable = false)
    private String correo;

    @Column(name = "med_contraseña", nullable = false)
    private String contraseña;

}