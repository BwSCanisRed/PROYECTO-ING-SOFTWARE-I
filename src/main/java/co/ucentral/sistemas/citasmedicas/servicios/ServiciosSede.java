package co.ucentral.sistemas.citasmedicas.servicios;

import co.ucentral.sistemas.citasmedicas.entidades.Sede;
import co.ucentral.sistemas.citasmedicas.operaciones.OperacionesSede;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioSede;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Sede crear(Sede sede) {
        return null;
    }

    @Override
    public Sede modificar(Sede sede) {
        return null;
    }

    @Override
    public void borrar(Sede sede) {

    }

    @Override
    public List<Sede> buscarTodos() {
        return repositorioSede.findAll();
    }

    @Override
    public Optional<Sede> buscarID(Integer pkSede) {
        return repositorioSede.findById(pkSede);
    }
}