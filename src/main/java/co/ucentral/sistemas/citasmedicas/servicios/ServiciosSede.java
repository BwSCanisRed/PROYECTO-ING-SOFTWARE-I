package co.ucentral.sistemas.citasmedicas.servicios;
import co.ucentral.sistemas.citasmedicas.dto.MedicoDto;
import co.ucentral.sistemas.citasmedicas.dto.SedeDto;
import co.ucentral.sistemas.citasmedicas.entidades.Medico;
import co.ucentral.sistemas.citasmedicas.entidades.Sede;
import co.ucentral.sistemas.citasmedicas.operaciones.OperacionesSede;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioSede;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosSede implements OperacionesSede {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    RepositorioSede repositorioSede;

    @Override
    public SedeDto crear(SedeDto sedeDto) {
        if (sedeDto != null){
            Sede sede =   repositorioSede.save(modelMapper.map(sedeDto, Sede.class));
            return modelMapper.map(sede, SedeDto.class);
        }

        else
            return null;
    }

    @Override
    public SedeDto modificar(SedeDto sedeDto) {
        if (this.repositorioSede.existsById(sedeDto.getId_sede()))
            return this.crear(sedeDto);
        else
            return null;
    }

    @Override
    public void borrar(SedeDto sedeDto) {this.repositorioSede.delete(modelMapper.map(sedeDto, Sede.class));}

    @Override
    public void borrar(Integer pkEntidad) {this.repositorioSede.deleteById(pkEntidad);}

    @Override
    public List<SedeDto> buscarTodos() {
        TypeToken<List<SedeDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(this.repositorioSede.findAll(), typeToken.getType());
    }

    @Override
    public SedeDto buscarID(Integer pkEntidad) {

        Sede sede = this.repositorioSede.findById(pkEntidad).orElse(null);
        if (sede != null) {
            return modelMapper.map(sede, SedeDto.class);
        } else {
            return null;
        }
    }
}
