package co.ucentral.sistemas.citasmedicas.operaciones;
import co.ucentral.sistemas.citasmedicas.dto.CitaDto;
import co.ucentral.sistemas.citasmedicas.entidades.Cita;

import java.util.List;
import java.util.Optional;

public interface OperacionesCita {
    public CitaDto crear(CitaDto citaDto);
    public Cita modificar(Cita cita);
    public void borrar(CitaDto citaDto);
    public void borrar(Integer pkEntidad);
    public List<Cita> buscarTodos();
    public Optional<Cita> buscarID(Integer pkEntidad);
}
