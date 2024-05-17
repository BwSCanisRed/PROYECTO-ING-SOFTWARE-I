package co.ucentral.sistemas.citasmedicas.servicios;
import co.ucentral.sistemas.citasmedicas.dto.AfiliadoDto;
import co.ucentral.sistemas.citasmedicas.dto.RegistroDto;
import co.ucentral.sistemas.citasmedicas.entidades.Afiliado;
import co.ucentral.sistemas.citasmedicas.entidades.Registro;
import co.ucentral.sistemas.citasmedicas.operaciones.OperacionesAfiliado;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioAfiliado;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioRegistro;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioRol;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public  class ServiciosAfiliado implements OperacionesAfiliado {
   private ModelMapper modelMapper = new ModelMapper();
  @Autowired
   RepositorioAfiliado repositorioAfiliado;
   @Autowired
    RepositorioRegistro repositorioRegistro;
    @Autowired
    RepositorioRol repositorioRol;

    @Override
    public AfiliadoDto crear(AfiliadoDto afiliadoDto) {
        if (afiliadoDto != null){
            Afiliado afiliado =   repositorioAfiliado.save(modelMapper.map(afiliadoDto, Afiliado.class));
            return modelMapper.map(afiliado, AfiliadoDto.class);
        }

        else
            return null;
    }

    @Override
    public AfiliadoDto modificar(AfiliadoDto afiliadoDto) {
        if (this.repositorioAfiliado.existsById(afiliadoDto.getIdentificacion()))
            return this.crear(afiliadoDto);
        else
            return null;
    }

    @Override
    public void borrar(AfiliadoDto afiliadoDto) {this.repositorioAfiliado.delete(modelMapper.map(afiliadoDto, Afiliado.class));}

    @Override
    public void borrar(Integer pkEntidad) {this.repositorioAfiliado.deleteById(pkEntidad);}

    @Override
    public List<AfiliadoDto> buscarTodos() {
        TypeToken<List<AfiliadoDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(this.repositorioAfiliado.findAll(), typeToken.getType());
    }

    @Override
    public Afiliado buscarID(Integer pkEntidad) {
        Optional<Afiliado> afiliadoOptional = repositorioAfiliado.findById(pkEntidad);
        if (afiliadoOptional.isPresent()) {
            Afiliado afiliado = afiliadoOptional.get();
            return afiliado;
        } else {
            return null;
        }
    }

    public AfiliadoDto obtenerIdRegistro(AfiliadoDto afiliadoDto) {
        Registro registro = repositorioRegistro.findByIdUsuario(afiliadoDto.getIdentificacion());

        if (registro != null) {
            RegistroDto registroDto = modelMapper.map(registro, RegistroDto.class);
            afiliadoDto.setRegistro(registroDto);

           return afiliadoDto;
        } else {
            return null;
       }
    }
}
