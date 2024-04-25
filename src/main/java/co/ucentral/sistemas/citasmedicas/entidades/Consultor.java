package co.ucentral.sistemas.citasmedicas.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Consultores")
@ToString
@Entity
public class Consultor {

    @Id
    @Column(name = "c_id", nullable = false)
    private int identificacion;

    @Column(name = "c_nombre", nullable = false)
    private String nombre;

    @Column(name = "c_estado", nullable = false)
    private Boolean estado;

    @Column(name = "rol_id", nullable = false)
    private int id_rol;

    @Column(name = "reg_id", nullable = true)
    private int id_registro;
}