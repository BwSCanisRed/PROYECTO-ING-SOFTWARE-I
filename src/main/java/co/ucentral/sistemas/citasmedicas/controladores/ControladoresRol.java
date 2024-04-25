package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.RolDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosRol;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladoresRol{

    @Autowired
    ServiciosRol serviciosRol;

    @GetMapping({  "/cntrol"})
    public String consultarTodos(Model model){
        model.addAttribute("listarol",this.serviciosRol.buscarTodos());
        return "rol";
    }

    @GetMapping("/rol/nuevo")
    public String mostrarFormulario(Model model){
        RolDto rolDto = new RolDto();
        model.addAttribute("elrol", rolDto);
        return "crear_rol";
    }
    @PostMapping("/rol")
    public String registrarRol(@ModelAttribute("elrol") RolDto rolDto) {
        serviciosRol.crear(rolDto);
        return "redirect:/cntrol";
    }
}