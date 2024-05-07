package co.ucentral.sistemas.citasmedicas.entidades;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToOne(targetEntity = Registro.class)
    @JoinColumn(name = "reg_id")
    private Registro registro;

    @ManyToOne(targetEntity = Rol.class)
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @OneToMany(mappedBy = "afiliado", fetch = FetchType.LAZY)
    private List<Cita> cita;


}