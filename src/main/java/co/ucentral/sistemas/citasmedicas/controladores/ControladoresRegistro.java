package co.ucentral.sistemas.citasmedicas.controladores;
import co.ucentral.sistemas.citasmedicas.dto.AfiliadoDto;
import co.ucentral.sistemas.citasmedicas.dto.RegistroDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosAfiliado;
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

    @GetMapping({  "/usuarios_registrados"})
    public String consultarTodos(Model model){
        model.addAttribute("listaregistro",this.serviciosRegistro.buscarTodos());
        return "usuarios";
    }

    @GetMapping("/registro/nuevo")
    public String mostrarFormulario(Model model){
        RegistroDto registroDto = new RegistroDto();
        model.addAttribute("elregistro", registroDto);
        return "form_registro";
    }
    @PostMapping("/crearegistro")
    public String registrarRegistro(@ModelAttribute("elregistro") RegistroDto registroDto) {
        serviciosRegistro.crear(registroDto);
        return "redirect:/usuarios_registrados";
    }

    @GetMapping({  "/inicio_sesion"})
    public String mostrarFormulario(){
        return "iniciar_sesion";
    }

    /*@PostMapping("/iniciar_sesion")
    public String iniciarSesion(Model model, String idUsuario, String contraseña) {
        // Comprobar si el usuario y la contraseña son válidos
        if (ServiciosRegistro.validarCredenciales(idUsuario, contraseña)) {
            // Si las credenciales son válidas, redirigir a la página de inicio
            return "redirect:/index";
        } else {
            // Si las credenciales no son válidas, mostrar un mensaje de error
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "iniciar_sesion";
        }
    }*/

}