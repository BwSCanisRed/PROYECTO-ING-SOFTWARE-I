package co.ucentral.sistemas.citasmedicas.entidades;

import co.ucentral.sistemas.citasmedicas.dto.AfiliadoDto;
import co.ucentral.sistemas.citasmedicas.dto.ConsultorDto;
import co.ucentral.sistemas.citasmedicas.dto.MedicoDto;
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
    private List<AfiliadoDto> afiliados ;

    @OneToMany(targetEntity = Medico.class, fetch = FetchType.LAZY, mappedBy =  "rol")
    private List<MedicoDto> medicos ;

    @OneToMany(targetEntity = Consultor.class, fetch = FetchType.LAZY, mappedBy =  "rol")
    private List<ConsultorDto> consultor ;

    public Rol(String nombre) {
        this.nombre = nombre;
    }
}
