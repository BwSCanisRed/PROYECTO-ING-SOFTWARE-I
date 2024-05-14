package co.ucentral.sistemas.citasmedicas.servicios;

import co.ucentral.sistemas.citasmedicas.dto.MedicoDto;
import co.ucentral.sistemas.citasmedicas.entidades.Medico;
import co.ucentral.sistemas.citasmedicas.operaciones.OperacionesMedico;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioMedico;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosMedico implements OperacionesMedico {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    RepositorioMedico repositorioMedico;

    @Override
    public Medico crear(Medico medico) {
        return null;
    }

    @Override
    public Medico modificar(Medico medico) {
        return null;
    }

    @Override
    public void borrar(Medico medico) {

    }

    @Override
    public void borrar(Integer pkEntidad) {this.repositorioMedico.deleteById(pkEntidad);}
    @Override
    public List<Medico> buscarTodos() {
        TypeToken<List<MedicoDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(this.repositorioMedico.findAll(), typeToken.getType());
    }
    @Override
    public Optional<Medico> buscarID(Integer pkEntidad) {
        return repositorioMedico.findById(pkEntidad);
    }
}
