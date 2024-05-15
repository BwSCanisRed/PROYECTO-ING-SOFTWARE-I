package co.ucentral.sistemas.citasmedicas.entidades;

import co.ucentral.sistemas.citasmedicas.dto.AfiliadoDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

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
        private int idUsuario;

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
        private String contrasenia;

        @OneToOne(mappedBy = "registro", cascade = CascadeType.PERSIST)
        private Afiliado afiliado;

        @OneToOne(mappedBy = "registro", cascade = CascadeType.PERSIST)
        private Medico medico;

        @OneToOne(mappedBy = "registro", cascade = CascadeType.PERSIST)
        private Consultor consultor;

        /*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(name = "rol_usuarios",
            joinColumns = @JoinColumn(name= "id_usuario", referencedColumnName = "reg_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rol_id"))
        private Collection<Rol> rolCollection;*/

    public Registro(int idUsuario,String contrasenia) {
        this.idUsuario = idUsuario;
        this.contrasenia = contrasenia;
    }

    public Registro(String tipo_identificacion, int idUsuario, Date fechaNacimiento,String nombre, String celular, String direccion, String genero, String correo, String contrasenia) {
        //this.fecha_registro = LocalDateTime.now();
        this.tipo_identificacion = tipo_identificacion;
        this.idUsuario = idUsuario;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.celular = celular;
        this.direccion = direccion;
        this.genero = genero;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    /*public Registro(int id_registro, LocalDateTime fecha_registro, String tipo_identificacion, String nombre, Date fechaNacimiento, String celular, String direccion, String genero, String correo, String contrasenia, Collection<Rol> roles) {
        this.id_registro = id_registro;
        this.fecha_registro = fecha_registro;
        this.tipo_identificacion = tipo_identificacion;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.direccion = direccion;
        this.genero = genero;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.roles = roles;
    }*/

    /*@Getter
    @Column
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "rol_usuarios", joinColumns = @JoinColumn(name = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> rol;*/

}
