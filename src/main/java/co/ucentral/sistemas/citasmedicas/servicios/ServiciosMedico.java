package co.ucentral.sistemas.citasmedicas.servicios;

import co.ucentral.sistemas.citasmedicas.dto.MedicoDto;
import co.ucentral.sistemas.citasmedicas.operaciones.OperacionesMedico;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioMedico;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosMedico implements OperacionesMedico {

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    RepositorioMedico repositorioMedico;

    @Override
    public MedicoDto crear(MedicoDto medico) {
        return null;
    }

    @Override
    public MedicoDto modificar(MedicoDto medico) {
        return null;
    }

    @Override
    public void borrar(MedicoDto medico) {

    }

    @Override
    public void borrar(Integer pkEntidad) {

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
