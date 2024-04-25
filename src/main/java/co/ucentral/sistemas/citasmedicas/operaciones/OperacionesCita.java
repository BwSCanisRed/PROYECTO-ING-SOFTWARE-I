package co.ucentral.sistemas.citasmedicas.operaciones;
import co.ucentral.sistemas.citasmedicas.dto.CitaDto;
import java.util.List;

public interface OperacionesCita {
    public CitaDto crear(CitaDto citaDto);
    public CitaDto modificar(CitaDto citaDto);
    public void borrar(CitaDto citaDto);
    public void borrar(Integer pkEntidad);
    public List<CitaDto> buscarTodos();
    public CitaDto buscarID(Integer pkEntidad);
}
