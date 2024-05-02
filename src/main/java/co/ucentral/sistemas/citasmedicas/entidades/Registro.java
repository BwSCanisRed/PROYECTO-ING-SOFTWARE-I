package co.ucentral.sistemas.citasmedicas.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Registros")
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
    private String contraseña;

    @OneToOne(mappedBy = "registro", cascade = CascadeType.PERSIST)
    private Afiliado afiliado;

    @OneToOne(mappedBy = "registro", cascade = CascadeType.PERSIST)
    private Medico medico;

    @OneToOne(mappedBy = "registro", cascade = CascadeType.PERSIST)
    private Consultor consultor;

}
