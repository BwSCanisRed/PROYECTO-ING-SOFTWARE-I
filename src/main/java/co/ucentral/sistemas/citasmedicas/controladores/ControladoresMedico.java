package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.*;
import co.ucentral.sistemas.citasmedicas.entidades.Consultorio;
import co.ucentral.sistemas.citasmedicas.entidades.Especialidad;
import co.ucentral.sistemas.citasmedicas.entidades.Medico;
import co.ucentral.sistemas.citasmedicas.entidades.Rol;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioConsultorio;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioMedico;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioRegistro;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosConsultorio;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosEspecialidad;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosMedico;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosSede;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Log4j2
@Controller
public class ControladoresMedico {

    @Autowired
    ServiciosMedico serviciosMedico;
    @Autowired
    ServiciosEspecialidad serviciosEspecialidad;
    @Autowired
    ServiciosSede serviciosSede;
    @Autowired
    ServiciosConsultorio serviciosConsultorio;
    @Autowired
    RepositorioRegistro repositorioRegistro;
    @Autowired
    RepositorioConsultorio repositorioConsultorio;
    @Autowired
    RepositorioMedico repositorioMedico;

    @GetMapping({  "/rol_medico"})
    public String consultarTodos(Model model){
        List<MedicoDto> listamedicos = this.serviciosMedico.buscarTodos();
        model.addAttribute("listamedicos", listamedicos);
        return "medico";
    }

    @GetMapping("/medico/nuevo")
    public String mostrarFormulario(Model model) {
        MedicoDto medicoDto = new MedicoDto();

        List<SedeDto> listasede = serviciosSede.buscarTodos();
        model.addAttribute("listasede", listasede);
        List<EspecialidadDto> listaespecialidad = serviciosEspecialidad.buscarTodos();
        model.addAttribute("listaespecialidad", listaespecialidad);
        List<ConsultorioDto> listaconsultorio = serviciosConsultorio.buscarTodos();
        model.addAttribute("listaconsultorio", listaconsultorio);

        model.addAttribute("elmedico", medicoDto);
        return "form_medico";
    }
    @PostMapping("/crearmedico")
    public String registrarMedico(@ModelAttribute("elmedico") MedicoDto medicoDto) {

        ConsultorioDto consultorio = medicoDto.getConsultorio();
        SedeDto sede = medicoDto.getSede();
        EspecialidadDto especialidad = medicoDto.getEspecialidad();

        if (consultorio != null && consultorio.getIdConsultorio() != null &&
                sede != null && sede.getId_sede() != null && especialidad != null && especialidad.getIdEspecialidad() != null) {

            ConsultorioDto consultorioExistente = serviciosConsultorio.buscarIdConsultorio(consultorio.getIdConsultorio());
            SedeDto sedeExistente = serviciosSede.buscarID(sede.getId_sede());
            EspecialidadDto especialidadExistente = serviciosEspecialidad.buscarID(especialidad.getIdEspecialidad());

            if (consultorioExistente != null && sedeExistente != null && especialidadExistente != null) {

                medicoDto.setConsultorio(consultorioExistente);
                medicoDto.setEspecialidad(especialidadExistente);
                medicoDto.setSede(sedeExistente);

                serviciosMedico.crear(medicoDto);
                return "redirect:/rol_medico";
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}