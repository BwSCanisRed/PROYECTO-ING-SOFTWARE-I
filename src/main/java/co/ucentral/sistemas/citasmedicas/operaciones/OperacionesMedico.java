package co.ucentral.sistemas.citasmedicas.operaciones;
import co.ucentral.sistemas.citasmedicas.entidades.Medico;

import java.util.List;
import java.util.Optional;

public interface OperacionesMedico {

    public Medico crear(Medico medico);
    public Medico modificar(Medico medico);
    public void borrar(Medico medico);
    public void borrar(Integer pkEntidad);
    public List<Medico> buscarTodos();
    public Optional<Medico> buscarID(Integer pkEntidad);
}
