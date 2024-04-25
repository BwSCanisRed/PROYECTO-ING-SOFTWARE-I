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

@Service
public class ServiciosMedico implements OperacionesMedico {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    RepositorioMedico repositorioMedico;
    @Override
    public MedicoDto crear(MedicoDto medicoDto) {
        if (medicoDto != null){
            Medico medico =   repositorioMedico.save(modelMapper.map(medicoDto, Medico.class));
            return modelMapper.map(medico, MedicoDto.class);
        }

        else
            return null;

    }
    @Override
    public MedicoDto modificar(MedicoDto medicoDto) {
        if (this.repositorioMedico.existsById(medicoDto.getIdentificacion()))
            return this.crear(medicoDto);
        else
            return null;
    }
    @Override
    public void borrar(MedicoDto medicoDto) {
        this.repositorioMedico.delete(modelMapper.map(medicoDto, Medico.class));
    }
    @Override
    public void borrar(Integer pkEntidad) {this.repositorioMedico.deleteById(pkEntidad);}
    @Override
    public List<MedicoDto> buscarTodos() {
        TypeToken<List<MedicoDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(this.repositorioMedico.findAll(), typeToken.getType());
    }
    @Override
    public MedicoDto buscarID(Integer pkEntidad) {
        return modelMapper.map(this.buscarID(pkEntidad), MedicoDto.class);
    }
}
