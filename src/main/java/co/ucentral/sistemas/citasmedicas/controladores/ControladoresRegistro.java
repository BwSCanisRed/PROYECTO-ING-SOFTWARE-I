package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.AfiliadoDto;
import co.ucentral.sistemas.citasmedicas.dto.MedicoDto;
import co.ucentral.sistemas.citasmedicas.dto.RegistroDto;
import co.ucentral.sistemas.citasmedicas.entidades.Afiliado;
import co.ucentral.sistemas.citasmedicas.entidades.Consultor;
import co.ucentral.sistemas.citasmedicas.entidades.Medico;
import co.ucentral.sistemas.citasmedicas.entidades.Registro;
import co.ucentral.sistemas.citasmedicas.repositorios.*;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosAfiliado;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosConsultor;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosMedico;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosRegistro;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
public class ControladoresRegistro {

    @Autowired
    ServiciosRegistro serviciosRegistro;
    @Autowired
    RepositorioMedico repositorioMedico;
    @Autowired
    RepositorioConsultor repositorioConsultor;
    @Autowired
    RepositorioAfiliado repositorioAfiliado;
    @Autowired
    RepositorioRegistro repositorioRegistro;

    @GetMapping({"/registro"})
    public String consultarTodos(Model model) {
        model.addAttribute("listaregistro", this.serviciosRegistro.buscarTodos());
        return "usuarios";
    }

    @GetMapping("/registro/nuevo")
    public String mostrarFormulario(Model model) {
        RegistroDto registroDto = new RegistroDto();
        model.addAttribute("elregistro", registroDto);
        return "form_registro";
    }

    @PostMapping("/crearegistro")
    public String registrarRegistro(@ModelAttribute("elregistro") RegistroDto registroDto) {
        serviciosRegistro.crear(registroDto);
        return "redirect:/registro";
    }

    @GetMapping("/iniciosesion")
    public String mostrarFormularioInicioSesion(Model model) {
        model.addAttribute("elregistro", new RegistroDto());
        return "iniciar_sesion";
    }

    @PostMapping("/sesion")
    public String iniciarSesion(@ModelAttribute("elregistro") RegistroDto registroDto, @RequestParam("idUsuario") int idUsuario, @RequestParam("contrasenia") String contrasenia) {

        Registro registro = repositorioRegistro.findByIdUsuarioAndContrasenia(idUsuario, contrasenia);

        if (registro != null && serviciosRegistro.validarCredenciales(idUsuario,contrasenia)) {

            Medico medico = repositorioMedico.findByIdentificacion(idUsuario);
            Consultor consultor = repositorioConsultor.findByIdentificacion(idUsuario);
            Afiliado afiliado = repositorioAfiliado.findByIdentificacion(idUsuario);

            if (medico != null || afiliado != null || consultor != null) {

                if (medico != null) {
                    return "redirect:/rol_medico";
                } else if (afiliado != null) {
                    return "redirect:/rol_afiliado";
                } else {
                    return "redirect:/rol_consultor";
                }
            } else {
                //model.addAttribute("error", "Usuario no encontrado");
                return "redirect:/iniciosesion";
            }
        } else {
            //model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "redirect:/iniciosesion";
        }
    }
}
