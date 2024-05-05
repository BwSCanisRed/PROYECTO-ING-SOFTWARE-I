package co.ucentral.sistemas.citasmedicas.operaciones;
import co.ucentral.sistemas.citasmedicas.dto.SedeDto;
import co.ucentral.sistemas.citasmedicas.entidades.Sede;

import java.util.List;

public interface OperacionesSede {
    public SedeDto crear(SedeDto sedeDto);
    public SedeDto modificar(SedeDto sedeDto);
    public void borrar(SedeDto sedeDto);
    public List<Sede> buscarTodos();
    public SedeDto buscarID(Integer pkEntidad);
}
