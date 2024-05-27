package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.RolDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosRol;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladoresRol{

    ServiciosRol serviciosRol;

    public ControladoresRol(ServiciosRol serviciosRol) {
        this.serviciosRol = serviciosRol;
    }

    @GetMapping({  "/rol/{identificacion}"})
    public String consultarTodos(Model model, @PathVariable int identificacion) {
        model.addAttribute("identificacion", identificacion);
        model.addAttribute("listarol",this.serviciosRol.buscarTodos());
        return "rol";
    }

    @GetMapping("/rol/nuevo")
    public String mostrarFormulario(Model model){
        RolDto rolDto = new RolDto();
        model.addAttribute("elrol", rolDto);
        return "form_rol";
    }
    @PostMapping("/crearol")
    public String registrarRol(@ModelAttribute("elrol") RolDto rolDto) {
        serviciosRol.crear(rolDto);
        return "redirect:/roles";
    }
}