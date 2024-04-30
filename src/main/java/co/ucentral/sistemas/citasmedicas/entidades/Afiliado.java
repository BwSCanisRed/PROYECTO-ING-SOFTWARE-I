package co.ucentral.sistemas.citasmedicas.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Afiliados")
@ToString
@Entity
public class Afiliado {

    @Id
    @Column(name = "afi_id", nullable = false)
    private int identificacion;

    @Column(name = "afi_nombre", nullable = false)
    private String nombre;

    @Column(name = "afi_estado", nullable = false)
    private Boolean estado;

    @Column(name = "rol_id", nullable = false)
    private int id_rol;

    @Column(name = "reg_id", nullable = true)
    private int id_registro;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Registro registro;
}