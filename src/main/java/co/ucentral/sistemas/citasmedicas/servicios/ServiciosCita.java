package co.ucentral.sistemas.citasmedicas.servicios;
import co.ucentral.sistemas.citasmedicas.dto.CitaDto;
import co.ucentral.sistemas.citasmedicas.entidades.Cita;
import co.ucentral.sistemas.citasmedicas.operaciones.OperacionesCita;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioCita;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiciosCita implements OperacionesCita {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    RepositorioCita repositorioCita;

    @Override
    public CitaDto crear(CitaDto citaDto) {
        if (citaDto != null){
            Cita cita =   repositorioCita.save(modelMapper.map(citaDto, Cita.class));
            return modelMapper.map(cita, CitaDto.class);
        }

        else
            return null;
    }

    @Override
    public CitaDto modificar(CitaDto citaDto) {
        if (this.repositorioCita.existsById(citaDto.getId_cita()))
            return this.crear(citaDto);
        else
            return null;
    }

    @Override
    public void borrar(CitaDto citaDto) {this.repositorioCita.delete(modelMapper.map(citaDto, Cita.class));}

    @Override
    public void borrar(Integer pkEntidad) {this.repositorioCita.deleteById(pkEntidad);}

    @Override
    public List<Cita> buscarTodos() {
        return repositorioCita.findAll();
    }

    @Override
    public CitaDto buscarID(Integer pkEntidad) {
        return modelMapper.map(this.buscarID(pkEntidad), CitaDto.class);
    }
}
