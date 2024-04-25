package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.SedeDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosSede;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladoresSede{

    @Autowired
    ServiciosSede serviciosSede;

    @GetMapping({  "/cntsede"})
    public String consultarTodos(Model model){
        model.addAttribute("listasede",this.serviciosSede.buscarTodos());
        return "sede";
    }

    @GetMapping("/sede/nuevo")
    public String mostrarFormulario(Model model){
        SedeDto sedeDto = new SedeDto();
        model.addAttribute("lasede", sedeDto);
        return "crear_sede";
    }
    @PostMapping("/sede")
    public String registrarSede(@ModelAttribute("lasede") SedeDto sedeDto) {
        serviciosSede.crear(sedeDto);
        return "redirect:/cntsede";
    }
}