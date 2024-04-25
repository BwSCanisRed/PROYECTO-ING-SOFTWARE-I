package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.RegistroDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosRegistro;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladoresRegistro{

    @Autowired
    ServiciosRegistro serviciosRegistro;

    @GetMapping({  "/cntregistro"})
    public String consultarTodos(Model model){
        model.addAttribute("listaregistro",this.serviciosRegistro.buscarTodos());
        return "registro";
    }

    @GetMapping("/registro/nuevo")
    public String mostrarFormulario(Model model){
        RegistroDto registroDto = new RegistroDto();
        model.addAttribute("elregistro", registroDto);
        return "crear_registro";
    }
    @PostMapping("/registro")
    public String registrarRegistro(@ModelAttribute("elregistro") RegistroDto registroDto) {
        serviciosRegistro.crear(registroDto);
        return "redirect:/cntregistro";
    }
}