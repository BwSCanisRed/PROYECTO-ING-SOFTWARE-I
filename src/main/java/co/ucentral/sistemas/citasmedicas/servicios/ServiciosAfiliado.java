package co.ucentral.sistemas.citasmedicas.servicios;
import co.ucentral.sistemas.citasmedicas.dto.AfiliadoDto;
import co.ucentral.sistemas.citasmedicas.entidades.Afiliado;
import co.ucentral.sistemas.citasmedicas.operaciones.OperacionesAfiliado;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioAfiliado;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiciosAfiliado implements OperacionesAfiliado {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    RepositorioAfiliado repositorioAfiliado;

    @Override
    public Afiliado crear(Afiliado afiliado) {
        if (afiliado != null){
            return repositorioAfiliado.save(afiliado);
        }
        else
            return null;
    }

    @Override
    public Afiliado modificar(Afiliado afiliado) {
        if (this.repositorioAfiliado.existsById(afiliado.getIdentificacion()))
            return this.crear(afiliado);
        else
            return null;
    }

    @Override
    public void borrar(Afiliado afiliado) {this.repositorioAfiliado.delete(modelMapper.map(afiliado, Afiliado.class));}

    @Override
    public void borrar(Integer pkEntidad) {this.repositorioAfiliado.deleteById(pkEntidad);}

    @Override
    public List<Afiliado> buscarTodos() {
        TypeToken<List<AfiliadoDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(this.repositorioAfiliado.findAll(), typeToken.getType());
    }

    @Override
    public Optional<Afiliado> buscarID(Integer pkEntidad) {
        return repositorioAfiliado.findById(pkEntidad);
    }
}
