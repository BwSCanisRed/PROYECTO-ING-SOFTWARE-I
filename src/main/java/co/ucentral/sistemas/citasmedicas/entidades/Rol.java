package co.ucentral.sistemas.citasmedicas.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Roles")
@ToString
@Entity
public class Rol {

    @Id
    @Column(name = "rol_id", nullable = false)
    private int id_rol;

    @Column(name = "rol_nombre", nullable = false)
    private String nombre;
}
