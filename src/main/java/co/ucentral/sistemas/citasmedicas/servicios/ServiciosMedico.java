package co.ucentral.sistemas.citasmedicas.servicios;

import co.ucentral.sistemas.citasmedicas.dto.MedicoDto;
import co.ucentral.sistemas.citasmedicas.operaciones.OperacionesMedico;

import java.util.List;

public class ServiciosMedico implements OperacionesMedico {
    @Override
    public MedicoDto crear(MedicoDto entrenador) {
        return null;
    }

    @Override
    public MedicoDto modificar(MedicoDto entrenador) {
        return null;
    }

    @Override
    public void borrar(MedicoDto entrenador) {

    }

    @Override
    public void borrar(Long pkEntidad) {

    }

    @Override
    public List<MedicoDto> buscarTodos() {
        return null;
    }

    @Override
    public MedicoDto buscarID(Integer pkEntidad) {
        return null;
    }
}
