package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.ConsultorDto;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioRegistro;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosConsultor;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosRegistro;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Log4j2
@Controller
public class ControladoresConsultor {

    ServiciosConsultor serviciosConsultor;
    ServiciosRegistro serviciosRegistro;
    RepositorioRegistro repositorioRegistro;

    public ControladoresConsultor(ServiciosConsultor serviciosConsultor, ServiciosRegistro serviciosRegistro, RepositorioRegistro repositorioRegistro) {
        this.serviciosConsultor = serviciosConsultor;
        this.serviciosRegistro = serviciosRegistro;
        this.repositorioRegistro = repositorioRegistro;
    }

    @GetMapping({  "/inicioConsultor"})
    public String consultarTodos(Model model){
        List<ConsultorDto> listaconsultores = this.serviciosConsultor.buscarTodos();

        for (ConsultorDto consultorDto : listaconsultores) {
            ConsultorDto consultorConRegistro = serviciosConsultor.obtenerIdRegistro(consultorDto);
            if (consultorConRegistro != null) {
                consultorDto.setRegistro(consultorConRegistro.getRegistro());
            }else{
                consultorDto.setRegistro(null);
            }
        }
        model.addAttribute("listaconsultores",listaconsultores);
        return "consultor";
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