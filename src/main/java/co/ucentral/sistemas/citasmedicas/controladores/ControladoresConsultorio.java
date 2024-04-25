package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.ConsultorioDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosConsultorio;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladoresConsultorio{

    @Autowired
    ServiciosConsultorio serviciosConsultorio;

    @GetMapping({  "/cntconsultorio"})
    public String consultarTodos(Model model){
        model.addAttribute("listaconsultorio",this.serviciosConsultorio.buscarTodos());
        return "consultorio";
    }

    @GetMapping("/consultorio/nuevo")
    public String mostrarFormulario(Model model){
        ConsultorioDto consultorioDto = new ConsultorioDto();
        model.addAttribute("elconsultorio", consultorioDto);
        return "crear_consultorio";
    }
    @PostMapping("/consultorio")
    public String registrarConsultorio(@ModelAttribute("elconsultorio") ConsultorioDto consultorioDto) {
        serviciosConsultorio.crear(consultorioDto);
        return "redirect:/cntconsultorio";
    }
}