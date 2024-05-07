package co.ucentral.sistemas.citasmedicas.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Citas")
@ToString
@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cit_id", nullable = false)
    private int id_cita;

    @Column(name = "cit_fecha", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha;

    @Column(name = "es_id", nullable = false)
    private int id_especialidad;

    @Column(name = "sed_id", nullable = false)
    private int id_sede;

    @Column(name = "cit_estado", nullable = true)
    private String estado;

    @ManyToOne(targetEntity = Medico.class)
    @JoinColumn(name = "med_id")
    private Medico medico;

    @ManyToOne(targetEntity = Afiliado.class)
    @JoinColumn(name = "afi_id")
    private Afiliado afiliado;

    @OneToOne(targetEntity = Factura.class)
    @JoinColumn(name = "fac_id")
    private Factura factura;

}