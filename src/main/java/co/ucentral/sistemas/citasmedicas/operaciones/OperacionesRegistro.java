package co.ucentral.sistemas.citasmedicas.operaciones;
import co.ucentral.sistemas.citasmedicas.dto.RegistroDto;
import co.ucentral.sistemas.citasmedicas.entidades.Registro;

import java.util.List;

public interface OperacionesRegistro {
    public RegistroDto crear(RegistroDto registroDto);
    public RegistroDto modificar(RegistroDto registroDto);
    public void borrar(RegistroDto registroDto);
    public void borrar(Integer pkEntidad);
    public List<RegistroDto> buscarTodos();
    public RegistroDto buscarID(Integer pkEntidad);
    public boolean validarCredenciales(Integer id_usuario, String contrasenia);
    //public Registro guardar(RegistroDto registroDto);

}
