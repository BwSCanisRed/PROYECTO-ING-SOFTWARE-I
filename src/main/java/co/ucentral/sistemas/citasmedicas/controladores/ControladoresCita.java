package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.CitaDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosCita;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladoresCita {

    @Autowired
    ServiciosCita serviciosCita;

    @GetMapping({  "/cntcita"})
    public String consultarTodos(Model model){
        model.addAttribute("listacitas",this.serviciosCita.buscarTodos());
        return "cita";
    }

    @GetMapping("/cita/nuevo")
    public String mostrarFormulario(Model model){
        CitaDto citaDto = new CitaDto();
        model.addAttribute("lacita", citaDto);
        return "crear_cita";
    }
    @PostMapping("/cita")
    public String registrarCita(@ModelAttribute("lacita") CitaDto citaDto) {
        serviciosCita.crear(citaDto);
        return "redirect:/cntcita";
    }
}