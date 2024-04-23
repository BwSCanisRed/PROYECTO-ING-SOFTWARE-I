package co.ucentral.sistemas.citasmedicas.operaciones;

import co.ucentral.sistemas.citasmedicas.dto.MedicoDto;
import java.util.List;

public interface OperacionesMedico {

    public MedicoDto crear(MedicoDto entrenador);
    public MedicoDto modificar(MedicoDto entrenador);
    public void borrar(MedicoDto entrenador);

    public void borrar(Long pkEntidad);

    public List<MedicoDto> buscarTodos();
    public MedicoDto buscarID(Integer pkEntidad);
}
