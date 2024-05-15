package co.ucentral.sistemas.citasmedicas.entidades;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Sedes")
@ToString
@Entity
public class Sede {

    @Getter
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "sed_id", nullable = false)
    private Integer id_sede;

    @Column(name = "sed_descripcion", nullable = false)
    private String nombre;

    @Column(name = "sed_direccion", nullable = true)
    private String direccion;

    @Column(name = "sed_nconsultorios", nullable = true)
    private Integer nconsultorios;

    public void setId_sede(int i) {
    }

//    public int getId_sede() {
//         return 0;
//    }

    public Sede(String nombre, String direccion, Integer nconsultorios) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nconsultorios = nconsultorios;
    }
}