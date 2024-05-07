package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.MedicoDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosMedico;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladoresMedico {

    @Autowired
    ServiciosMedico serviciosMedico;

    @GetMapping({  "/rol_medico"})
    public String consultarTodos(Model model){
        model.addAttribute("listamedicos",this.serviciosMedico.buscarTodos());
        return "medico";
    }

    @GetMapping("/medico/nuevo")
    public String mostrarFormulario(Model model){
        MedicoDto medicoDto = new MedicoDto();
        model.addAttribute("elmedico", medicoDto);
        return "form_medico";
    }
    @PostMapping("/crearmedico")
    public String registrarMedico(@ModelAttribute("elmedico") MedicoDto medicoDto) {
        serviciosMedico.crear(medicoDto);
        return "redirect:/rol_medico";
    }
}