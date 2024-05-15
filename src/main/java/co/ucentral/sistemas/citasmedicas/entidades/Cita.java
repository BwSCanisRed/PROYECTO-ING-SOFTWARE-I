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

    @ManyToOne
    @JoinColumn(name = "es_id")
    private Especialidad especialidad;

    @Column(name = "cit_estado", nullable = true)
    private String estado;
    @ManyToOne
    @JoinColumn(name = "med_id",nullable = true)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "Afi_id",nullable = true)
    private Afiliado afiliado;

}