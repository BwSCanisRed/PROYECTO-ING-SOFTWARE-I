package co.ucentral.sistemas.citasmedicas.controladores;

import co.ucentral.sistemas.citasmedicas.dto.AfiliadoDto;
import co.ucentral.sistemas.citasmedicas.dto.CitaDto;
import co.ucentral.sistemas.citasmedicas.entidades.Afiliado;
import co.ucentral.sistemas.citasmedicas.entidades.Cita;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosAfiliado;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosCita;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Log4j2
@Controller
public class ControladoresCita {

    @Autowired
    ServiciosCita serviciosCita;
    @Autowired
    ServiciosAfiliado serviciosAfiliado;
    @Autowired
   private ModelMapper modelMapper;

    @GetMapping("/Agendar/{identificacion}")
   public String listarCitas(Model model, @PathVariable int identificacion) {
       Afiliado afiliado = serviciosAfiliado.buscarID(identificacion);
        if (afiliado != null) {
          for (Cita laCita : serviciosCita.obtenerCitasDisponibles()) {
                System.out.println(laCita);
           }
           System.out.println("paso por aquí");
            model.addAttribute("identificacion", identificacion);
           model.addAttribute("listaCitasT", serviciosCita.obtenerCitasDisponibles());
            model.addAttribute("afiliado", afiliado);
           System.out.println(afiliado);
            System.out.println(identificacion);
            return "agendarcitas";
       } else {
           // Manejar el caso en el que no se encuentre el afiliado con el ID dado
            return "error"; // Por ejemplo, redirigir a una página de error
        }
   }

  @GetMapping("/Agendar/Confirmacion/{idCita}/{identificacion}")
    public String buscarCitaPorId(@PathVariable int idCita, @PathVariable int identificacion, Model model) {
       Cita cita = serviciosCita.buscarID(idCita);

       if (cita != null) {
           Afiliado afiliado = serviciosAfiliado.buscarID(identificacion);

           if (afiliado != null) {
               cita.setEstado("Programada");
               cita.setAfiliado(afiliado);
              serviciosCita.modificar(modelMapper.map(cita, Cita.class));
               System.out.println(cita);
               model.addAttribute("cita", cita);
               model.addAttribute("identificacion", identificacion);
               model.addAttribute("afiliado", afiliado);
               return "confirmacion";
           } else {
               return "error";
           }
        } else {
           return "error";
       }
    }


    @GetMapping("/MisCitas/{identificacion}")
    public String mostrarCitasAgendadas(@PathVariable int identificacion, Model model){
        List<Cita> citas = serviciosCita.buscarPorAfiliado(identificacion);
        model.addAttribute("citas", citas);
        return "misCitas";
    }

    @GetMapping("/MisCitasMedico/{identificacion}")
    public String mostrarCitasAgendadasMedico(@PathVariable int identificacion, Model model){
        List<Cita> citas = serviciosCita.buscarPorMedico(identificacion);
        model.addAttribute("citas", citas);
        return "misCitasMedico";
    }


    @GetMapping("/CancelarCita/{idCita}")
    public String cancelarCita(@PathVariable int idCita, Model model){
        Cita cita = serviciosCita.buscarID(idCita);
        if (cita != null) {
            cita.setEstado("Cancelada");
            serviciosCita.modificar(cita);
            return "redirect:/MisCitas/" + cita.getAfiliado().getIdentificacion();
        } else {
            // Manejar el caso en el que no se encuentre la cita con el ID dado
            return "error"; // Por ejemplo, redirigir a una página de error
        }
    }
}