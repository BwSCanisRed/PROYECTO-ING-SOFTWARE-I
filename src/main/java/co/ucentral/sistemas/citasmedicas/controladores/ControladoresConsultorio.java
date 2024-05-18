package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.ConsultorioDto;
import co.ucentral.sistemas.citasmedicas.dto.SedeDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosConsultorio;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosEspecialidad;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosSede;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Log4j2
@Controller
public class ControladoresConsultorio{

    ServiciosConsultorio serviciosConsultorio;
    ServiciosSede serviciosSede;
    ServiciosEspecialidad serviciosEspecialidad;

    public ControladoresConsultorio(ServiciosConsultorio serviciosConsultorio, ServiciosSede serviciosSede, ServiciosEspecialidad serviciosEspecialidad) {
        this.serviciosConsultorio = serviciosConsultorio;
        this.serviciosSede = serviciosSede;
        this.serviciosEspecialidad = serviciosEspecialidad;
    }

    @GetMapping({  "/consultorios"})
    public String consultarTodos(Model model){
        model.addAttribute("listaconsultorio",this.serviciosConsultorio.buscarTodos());
        return "consultorio";
    }

    @GetMapping("/consultorio/nuevo")
    public String mostrarFormulario(Model model){
        ConsultorioDto consultorioDto = new ConsultorioDto();
        List<SedeDto> listasede = serviciosSede.buscarTodos();
        model.addAttribute("listasede", listasede);

        model.addAttribute("elconsultorio", consultorioDto);
        return "form_consultorio";
    }
    @PostMapping("/crearconsultorio")
    public String registrarConsultorio(@ModelAttribute("elconsultorio") ConsultorioDto consultorioDto) {
        serviciosConsultorio.crear(consultorioDto);
        return "redirect:/consultorios";
    }
}