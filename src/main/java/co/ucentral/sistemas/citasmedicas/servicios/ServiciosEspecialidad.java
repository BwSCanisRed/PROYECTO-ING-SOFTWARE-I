package co.ucentral.sistemas.citasmedicas.servicios;

import co.ucentral.sistemas.citasmedicas.dto.EspecialidadDto;
import co.ucentral.sistemas.citasmedicas.dto.MedicoDto;
import co.ucentral.sistemas.citasmedicas.entidades.Especialidad;
import co.ucentral.sistemas.citasmedicas.entidades.Medico;
import co.ucentral.sistemas.citasmedicas.operaciones.OperacionesEspecialidad;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioEspecialidad;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosEspecialidad implements OperacionesEspecialidad {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    RepositorioEspecialidad repositorioEspecialidad;

    @Override
    public EspecialidadDto crear(EspecialidadDto especialidadDto) {
        if (especialidadDto != null){
            Especialidad especialidad =   repositorioEspecialidad.save(modelMapper.map(especialidadDto, Especialidad.class));
            return modelMapper.map(especialidad, EspecialidadDto.class);
        }

        else
            return null;
    }

    @Override
    public EspecialidadDto modificar(EspecialidadDto especialidadDto) {
        if (this.repositorioEspecialidad.existsById(especialidadDto.getIdEspecialidad()))
            return this.crear(especialidadDto);
        else
            return null;
    }

    @Override
    public void borrar(EspecialidadDto especialidadDto) {this.repositorioEspecialidad.delete(modelMapper.map(especialidadDto, Especialidad.class));}

    @Override
    public void borrar(Integer pkEntidad) {this.repositorioEspecialidad.deleteById(pkEntidad);}

    @Override
    public List<EspecialidadDto> buscarTodos() {
        TypeToken<List<EspecialidadDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(this.repositorioEspecialidad.findAll(), typeToken.getType());
    }

    @Override
    public EspecialidadDto buscarID(Integer pkEntidad) {
        Especialidad especialidad = this.repositorioEspecialidad.findById(pkEntidad).orElse(null);
        if (especialidad != null) {
            return modelMapper.map(especialidad, EspecialidadDto.class);
        } else {
            return null;
        }
    }
}
