package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.ConsultorDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosConsultor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladoresConsultor {

    @Autowired
    ServiciosConsultor serviciosConsultor;

    @GetMapping({  "/cntconsultor"})
    public String consultarTodos(Model model){
        model.addAttribute("listaaconsultores",this.serviciosConsultor.buscarTodos());
        return "consultor";
    }

    @GetMapping("/consultor/nuevo")
    public String mostrarFormulario(Model model){
        ConsultorDto consultorDto = new ConsultorDto();
        model.addAttribute("elconsultor", consultorDto);
        return "crear_consultor";
    }
    @PostMapping("/consultor")
    public String registrarConsultor(@ModelAttribute("elconsultor") ConsultorDto consultorDto) {
        serviciosConsultor.crear(consultorDto);
        return "redirect:/cntafiliado";
    }
}