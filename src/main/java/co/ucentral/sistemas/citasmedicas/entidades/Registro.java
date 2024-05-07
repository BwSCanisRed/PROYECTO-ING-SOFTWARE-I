package co.ucentral.sistemas.citasmedicas.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Registros",uniqueConstraints = @UniqueConstraint(columnNames = {"reg_correo","reg_idusuario"}))
@ToString
@Entity
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reg_id", nullable = false)
    private int id_registro;

    @Column(name = "reg_fecha", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha_registro;

    @Column(name = "reg_tipoid", nullable = false)
    private String tipo_identificacion;

    @Column(name = "reg_idusuario", nullable = false)
    private int id_usuario;

    @Column(name = "reg_nombre", nullable = false)
    private String nombre;

    @Column(name = "reg_fechanac")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "reg_celular", nullable = false)
    private String celular;

    @Column(name = "reg_direccion", nullable = false)
    private String direccion;

    @Column(name = "reg_genero", nullable = false)
    private String genero;

    @Column(name = "reg_correo", nullable = false)
    private String correo;

    @Column(name = "reg_contraseña", nullable = false)
    private String contrasena;

    @OneToOne(mappedBy = "registro", cascade = CascadeType.PERSIST)
    private Afiliado afiliado;

    @OneToOne(mappedBy = "registro", cascade = CascadeType.PERSIST)
    private Medico medico;

    @OneToOne(mappedBy = "registro", cascade = CascadeType.PERSIST)
    private Consultor consultor;

    public Registro(int id_usuario,String contrasena) {
        this.id_usuario = id_usuario;
        this.contrasena = contrasena;
    }

    @Getter
    @Column
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "rol_usuarios", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> rol;

}
