package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.SedeDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosSede;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladoresSede{
    ServiciosSede serviciosSede;

    public ControladoresSede(ServiciosSede serviciosSede) {
        this.serviciosSede = serviciosSede;
    }

    @GetMapping({  "/sede/{identificacion}"})
    public String consultarTodos(Model model, @PathVariable int identificacion) {
        model.addAttribute("identificacion", identificacion);
        model.addAttribute("listasede",this.serviciosSede.buscarTodos());
        return "sede";
    }

    @GetMapping("/sede/nuevo")
    public String mostrarFormulario(Model model){
        SedeDto sedeDto = new SedeDto();
        model.addAttribute("lasede", sedeDto);
        return "form_sede";
    }
    @PostMapping("/crearsede")
    public String registrarSede(@ModelAttribute("lasede") SedeDto sedeDto) {
        serviciosSede.crear(sedeDto);
        return "redirect:/sedes";
    }
}