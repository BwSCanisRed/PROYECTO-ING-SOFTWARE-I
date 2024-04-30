package co.ucentral.sistemas.citasmedicas.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MedicoDto {

    private int identificacion;
    private String nombre;
    private String rol;
    private Boolean estado;
    private int id_consultorio;
    private int id_especialidad;
    private int id_sede;
    private int id_registro;

}
