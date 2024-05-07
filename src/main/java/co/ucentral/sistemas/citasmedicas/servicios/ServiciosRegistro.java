package co.ucentral.sistemas.citasmedicas.servicios;
import co.ucentral.sistemas.citasmedicas.dto.RegistroDto;
import co.ucentral.sistemas.citasmedicas.entidades.Registro;
import co.ucentral.sistemas.citasmedicas.operaciones.OperacionesRegistro;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioRegistro;
import org.hibernate.Remove;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosRegistro implements OperacionesRegistro {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    RepositorioRegistro repositorioRegistro;

    @Override
    public RegistroDto crear(RegistroDto registroDto) {
        if (registroDto != null){
            Registro registro =   repositorioRegistro.save(modelMapper.map(registroDto, Registro.class));
            return modelMapper.map(registro, RegistroDto.class);
        }

        else
            return null;
    }

    @Override
    public RegistroDto modificar(RegistroDto registroDto) {
        if (this.repositorioRegistro.existsById(registroDto.getId_registro()))
            return this.crear(registroDto);
        else
            return null;
    }

    @Override
    public void borrar(RegistroDto registroDto) {this.repositorioRegistro.delete(modelMapper.map(registroDto, Registro.class));}

    @Override
    public void borrar(Integer pkEntidad) {this.repositorioRegistro.deleteById(pkEntidad);}

    @Override
    public List<RegistroDto> buscarTodos() {
        TypeToken<List<RegistroDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(this.repositorioRegistro.findAll(), typeToken.getType());
    }

    @Override
    public RegistroDto buscarID(Integer pkEntidad) {
        return modelMapper.map(this.buscarID(pkEntidad), RegistroDto.class);
    }

    @Override
    public RegistroDto findById_usuario(Integer id_usuario) {
        return RegistroDto.findById_usuario(id_usuario);
    }


}
