package co.ucentral.sistemas.citasmedicas.operaciones;
import co.ucentral.sistemas.citasmedicas.entidades.Afiliado;

import java.util.List;
import java.util.Optional;

public interface OperacionesAfiliado {

    public Afiliado crear(Afiliado afiliado);
    public Afiliado modificar(Afiliado afiliado);
    public void borrar(Afiliado afiliadoD);
    public void borrar(Integer pkEntidad);
    public List<Afiliado> buscarTodos();
    public Optional<Afiliado> buscarID(int pkEntidad);
}
