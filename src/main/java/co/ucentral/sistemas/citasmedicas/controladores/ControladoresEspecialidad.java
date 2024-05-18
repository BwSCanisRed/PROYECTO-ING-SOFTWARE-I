package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.EspecialidadDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosEspecialidad;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladoresEspecialidad {

    ServiciosEspecialidad serviciosEspecialidad;

    public ControladoresEspecialidad(ServiciosEspecialidad serviciosEspecialidad) {
        this.serviciosEspecialidad = serviciosEspecialidad;
    }

    @GetMapping({  "/especialidades"})
    public String consultarTodos(Model model){
        model.addAttribute("listaespecialidad",this.serviciosEspecialidad.buscarTodos());
        return "especialidad";
    }

    @GetMapping("/especialidad/nuevo")
    public String mostrarFormulario(Model model){
        EspecialidadDto especialidadDto = new EspecialidadDto();
        model.addAttribute("laespecialidad", especialidadDto);
        return "form_especialidad";
    }
    @PostMapping("/crearespecialidad")
    public String registrarEspecialidad(@ModelAttribute("laespecialidad") EspecialidadDto especialidadDto) {
        serviciosEspecialidad.crear(especialidadDto);
        return "redirect:/especialidades";
    }
}
