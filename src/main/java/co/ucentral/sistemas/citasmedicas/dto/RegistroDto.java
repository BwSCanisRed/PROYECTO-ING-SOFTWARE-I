package co.ucentral.sistemas.citasmedicas.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroDto {

    private int id_registro;
    private LocalDateTime fecha_registro;
    private String tipo_identificacion;
    private int id_usuario;
    private String nombre;
    private Date fechaNacimiento;
    private String celular;
    private String direccion;
    private String genero;
    private String correo;
    private String contraseña;
}
