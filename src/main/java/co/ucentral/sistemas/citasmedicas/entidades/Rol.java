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

@Table(name = "Roles")
@ToString
@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "rol_id", nullable = false)
    private int id_rol;

    @Column(name = "rol_nombre", nullable = false)
    private String nombre;


    @OneToMany(targetEntity = Afiliado.class, fetch = FetchType.LAZY, mappedBy =  "rol")
    private List<Afiliado> afiliados ;

    @OneToMany(targetEntity = Medico.class, fetch = FetchType.LAZY, mappedBy =  "rol")
    private List<Medico> medicos ;

    @OneToMany(targetEntity = Consultor.class, fetch = FetchType.LAZY, mappedBy =  "rol")
    private List<Consultor> consultor ;
}
