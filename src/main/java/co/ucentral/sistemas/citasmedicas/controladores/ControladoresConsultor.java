package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.ConsultorDto;
import co.ucentral.sistemas.citasmedicas.entidades.Cita;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioRegistro;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosCita;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosConsultor;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosRegistro;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Log4j2
@Controller
public class ControladoresConsultor {

    private final ServiciosCita serviciosCita;
    ServiciosConsultor serviciosConsultor;
    ServiciosRegistro serviciosRegistro;
    RepositorioRegistro repositorioRegistro;

    public ControladoresConsultor(ServiciosConsultor serviciosConsultor, ServiciosRegistro serviciosRegistro, RepositorioRegistro repositorioRegistro, ServiciosCita serviciosCita) {
        this.serviciosConsultor = serviciosConsultor;
        this.serviciosRegistro = serviciosRegistro;
        this.repositorioRegistro = repositorioRegistro;
        this.serviciosCita = serviciosCita;
    }

    @GetMapping("/inicioConsultor/{identificacion}")
    public String iniciioConsultor(@PathVariable int identificacion, Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("identificacion", identificacion);
        return "inicioConsultor";
    }

    @GetMapping({"/GenerarInforme/{identificacion}"})
    public String GenerarInforme( Model model,@PathVariable int identificacion,  RedirectAttributes redirectAttributes) {
        List<Cita> citas = serviciosCita.buscarTodos();
        redirectAttributes.addAttribute("identificacion", identificacion);
        model.addAttribute("citas", citas);
        return "Informe";
    }


    @GetMapping("/consultor/nuevo")
    public String mostrarFormulario(Model model){
        ConsultorDto consultorDto = new ConsultorDto();
        model.addAttribute("elconsultor", consultorDto);
        return "form_consultor";
    }
    @PostMapping("/crearconsultor")
    public String registrarConsultor(@ModelAttribute("elconsultor") ConsultorDto consultorDto) {
        serviciosConsultor.crear(consultorDto);
        return "redirect:/inicioConsultor";
    }
}