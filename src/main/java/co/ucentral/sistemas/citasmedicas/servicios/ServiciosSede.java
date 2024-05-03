package co.ucentral.sistemas.citasmedicas.servicios;

import co.ucentral.sistemas.citasmedicas.dto.SedeDto;
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

    private final ModelMapper modelMapper;

    @Autowired
    private final RepositorioSede repositorioSede;

    public ServiciosSede(ModelMapper modelMapper, RepositorioSede repositorioSede) {
        this.modelMapper = modelMapper;
        this.repositorioSede = repositorioSede;
    }

    @Override
    public SedeDto crear(SedeDto sedeDto) {
        Sede sede = repositorioSede.save(modelMapper.map(sedeDto, Sede.class));
        return modelMapper.map(sede, SedeDto.class);
    }

    @Override
    public SedeDto modificar(SedeDto sedeDto) {
        if (repositorioSede.existsById(sedeDto.getId_sede())) {
            return crear(sedeDto);
        } else {
            return null;
        }
    }

    @Override
    public void borrar(SedeDto sedeDto) {
        repositorioSede.delete(modelMapper.map(sedeDto, Sede.class));
    }
    @Override
    public List<SedeDto> buscarTodos() {
        TypeToken<List<SedeDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repositorioSede.findAll(), typeToken.getType());
    }

    @Override
    public SedeDto buscarID(Integer pkSede) {
        return modelMapper.map(repositorioSede.findById(pkSede).orElse(null), SedeDto.class);
    }
}