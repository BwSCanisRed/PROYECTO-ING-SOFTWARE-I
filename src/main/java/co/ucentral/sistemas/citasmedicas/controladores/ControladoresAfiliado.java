package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.AfiliadoDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosAfiliado;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
public class ControladoresAfiliado {


    @Autowired
    ServiciosAfiliado serviciosAfiliado;

    @GetMapping("/inicioAfiliado")
    public String inicioAfiliado() {
        return "inicioAfiliado";
    }

    @GetMapping({"/cliente"})
    public String cliente(RedirectAttributes redirectAttributes) {
        int identificacion = 1;
        redirectAttributes.addAttribute("identificacion", identificacion);
        return "redirect:/Agendar/{identificacion}";
    }

    @GetMapping({  "/cntafiliado"})
    public String consultarTodos(Model model){
        model.addAttribute("listaafiliados",this.serviciosAfiliado.buscarTodos());
        return "afiliado";
    }

    @GetMapping("/afiliado/nuevo")
    public String mostrarFormulario(Model model){
        AfiliadoDto afiliadoDto = new AfiliadoDto();
        model.addAttribute("elafiliado", afiliadoDto);
        return "crear_afiliado";
    }
   /* @PostMapping("/afiliado")
    public String registrarAfiliado(@ModelAttribute("elafiliado") AfiliadoDto afiliadoDto) {
        serviciosAfiliado.crear(afiliadoDto);
        return "redirect:/cntafiliado";
    }*/
}