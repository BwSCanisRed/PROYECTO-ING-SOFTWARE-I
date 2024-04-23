package co.ucentral.sistemas.citasmedicas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MedicoDto {

    private int identificacion;
    private String tipo_identificacion;
    private String nombre;
    private String rol;
    private String celular;
    private String direccion;
    private Boolean estado;
    private int id_consultorio;
    private int id_especialidad;
    private int id_sede;
    private String correo;
    private String contraseña;

}
