package co.ucentral.sistemas.citasmedicas.servicios;

import co.ucentral.sistemas.citasmedicas.dto.RegistroDto;
import co.ucentral.sistemas.citasmedicas.entidades.*;
import co.ucentral.sistemas.citasmedicas.operaciones.OperacionesRegistro;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioAfiliado;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioConsultor;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioMedico;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioRegistro;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosRegistro implements OperacionesRegistro {

    private ModelMapper modelMapper = new ModelMapper();
    private RepositorioRegistro RepositorioRegistro;

    @Autowired
    RepositorioRegistro repositorioRegistro;
    @Autowired
    RepositorioConsultor repositorioConsultor;
    @Autowired
    RepositorioMedico repositorioMedico;
    @Autowired
    RepositorioAfiliado repositorioAfiliado;
    public ServiciosRegistro(RepositorioRegistro repositorioRegistro) {
        this.repositorioRegistro = repositorioRegistro;
    }

    @Override
    public RegistroDto crear(RegistroDto registroDto) {
        Consultor consultor = repositorioConsultor.findByIdentificacionAndNombre(registroDto.getIdUsuario(), registroDto.getNombre());
        Medico medico = repositorioMedico.findByIdentificacionAndNombre(registroDto.getIdUsuario(), registroDto.getNombre());
        Afiliado afiliado = repositorioAfiliado.findByIdentificacionAndNombre(registroDto.getIdUsuario(), registroDto.getNombre());

        if (consultor != null || medico != null || afiliado != null) {
            if (repositorioRegistro.existsByIdUsuario(registroDto.getIdUsuario())) {
                return null;
            } else {
                Registro registro = repositorioRegistro.save(modelMapper.map(registroDto, Registro.class));
                return modelMapper.map(registro, RegistroDto.class);
            }
        } else {
            return null;
        }
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

    public boolean validarCredenciales(Integer idUsuario, String contrasenia) {
        Registro registro = repositorioRegistro.findByIdUsuarioAndContrasenia(idUsuario, contrasenia);
        return registro != null;
    }

    /*@Override
    public Registro guardar(RegistroDto registroDto){
        Registro registro= new Registro(registroDto.getId_registro(),registroDto.getFecha_registro(),
                registroDto.getTipo_identificacion(), registroDto.getNombre(),
                registroDto.getFechaNacimiento(),registroDto.getCelular(), registroDto.getDireccion(),
                registroDto.getGenero(),registroDto.getCorreo(),registroDto.getContrasenia(), List.of(new Rol("Consultor")));
        return RepositorioRegistro.save(registro);
    }*/


}
