package co.ucentral.sistemas.citasmedicas.operaciones;
import co.ucentral.sistemas.citasmedicas.dto.AfiliadoDto;
import co.ucentral.sistemas.citasmedicas.entidades.Afiliado;

import java.util.List;
import java.util.Optional;

public interface OperacionesAfiliado {

    public AfiliadoDto crear(AfiliadoDto afiliadoDto);
    public AfiliadoDto modificar(AfiliadoDto afiliadoDto);
    public void borrar(AfiliadoDto afiliadoDto);
    public void borrar(Integer pkEntidad);
    public List<AfiliadoDto> buscarTodos();
    public AfiliadoDto buscarID(Integer pkEntidad);
}