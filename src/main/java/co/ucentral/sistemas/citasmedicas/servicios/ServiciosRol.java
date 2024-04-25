package co.ucentral.sistemas.citasmedicas.servicios;
import co.ucentral.sistemas.citasmedicas.dto.RolDto;
import co.ucentral.sistemas.citasmedicas.entidades.Rol;
import co.ucentral.sistemas.citasmedicas.operaciones.OperacionesRol;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioRol;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiciosRol implements OperacionesRol {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    RepositorioRol repositorioRol;

    @Override
    public RolDto crear(RolDto rolDto) {
        if (rolDto != null){
            Rol rol =   repositorioRol.save(modelMapper.map(rolDto, Rol.class));
            return modelMapper.map(rol, RolDto.class);
        }

        else
            return null;
    }

    @Override
    public RolDto modificar(RolDto rolDto) {
        if (this.repositorioRol.existsById(rolDto.getId_rol()))
            return this.crear(rolDto);
        else
            return null;
    }

    @Override
    public void borrar(RolDto rolDto) {this.repositorioRol.delete(modelMapper.map(rolDto, Rol.class));}

    @Override
    public void borrar(Integer pkEntidad) {this.repositorioRol.deleteById(pkEntidad);}

    @Override
    public List<RolDto> buscarTodos() {
        TypeToken<List<RolDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(this.repositorioRol.findAll(), typeToken.getType());
    }

    @Override
    public RolDto buscarID(Integer pkEntidad) {
        return modelMapper.map(this.buscarID(pkEntidad), RolDto.class);
    }
}
