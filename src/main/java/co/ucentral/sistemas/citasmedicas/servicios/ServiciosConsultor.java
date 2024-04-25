package co.ucentral.sistemas.citasmedicas.servicios;
import co.ucentral.sistemas.citasmedicas.dto.ConsultorDto;
import co.ucentral.sistemas.citasmedicas.entidades.Consultor;
import co.ucentral.sistemas.citasmedicas.operaciones.OperacionesConsultor;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioConsultor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ServiciosConsultor implements OperacionesConsultor {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    RepositorioConsultor repositorioConsultor;
    @Override
    public ConsultorDto crear(ConsultorDto consultorDto) {
        if (consultorDto != null){
            Consultor consultor =   repositorioConsultor.save(modelMapper.map(consultorDto, Consultor.class));
            return modelMapper.map(consultor, ConsultorDto.class);
        }

        else
            return null;
    }
    @Override
    public ConsultorDto modificar(ConsultorDto consultorDto) {
        if (this.repositorioConsultor.existsById(consultorDto.getIdentificacion()))
            return this.crear(consultorDto);
        else
            return null;
    }
    @Override
    public void borrar(ConsultorDto consultorDto) {this.repositorioConsultor.delete(modelMapper.map(consultorDto, Consultor.class));}
    @Override
    public void borrar(Integer pkEntidad) {this.repositorioConsultor.deleteById(pkEntidad);}
    @Override
    public List<ConsultorDto> buscarTodos() {
        TypeToken<List<ConsultorDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(this.repositorioConsultor.findAll(), typeToken.getType());
    }
    @Override
    public ConsultorDto buscarID(Integer pkEntidad) {
        return modelMapper.map(this.buscarID(pkEntidad), ConsultorDto.class);
    }
}
