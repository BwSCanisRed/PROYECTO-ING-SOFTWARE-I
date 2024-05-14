package co.ucentral.sistemas.citasmedicas.operaciones;
import co.ucentral.sistemas.citasmedicas.entidades.Sede;

import java.util.List;
import java.util.Optional;

public interface OperacionesSede {
    public Sede crear(Sede sede);
    public Sede modificar(Sede sede);
    public void borrar(Sede sede);
    public List<Sede> buscarTodos();
    public Optional<Sede> buscarID(Integer pkEntidad);
}
