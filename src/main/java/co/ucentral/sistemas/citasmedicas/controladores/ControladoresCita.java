package co.ucentral.sistemas.citasmedicas.controladores;

import co.ucentral.sistemas.citasmedicas.dto.AfiliadoDto;
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
        Optional<Afiliado> afiliadoOptional = serviciosAfiliado.buscarID(identificacion);
        if (afiliadoOptional.isPresent()) {
            Afiliado afiliado = afiliadoOptional.get();
            for (Cita laCita : serviciosCita.buscarTodos()) {
                System.out.println(laCita);
            }
            System.out.println("paso por aquí");
            model.addAttribute("identificacion", identificacion);
            model.addAttribute("listaCitasT", serviciosCita.buscarTodos());
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
        Optional<Cita> citaOptional = serviciosCita.buscarID(idCita);

        if (citaOptional.isPresent()) {
            Cita cita = citaOptional.get();
            Optional<Afiliado> afiliadoOptional = serviciosAfiliado.buscarID(identificacion);

            if (afiliadoOptional.isPresent()) {
                Afiliado afiliado = afiliadoOptional.get();
                cita.setEstado("Programada");
                cita.setAfiliado(afiliado);
                serviciosCita.modificar(cita);
                model.addAttribute("cita", cita);
                model.addAttribute("identificacion", identificacion);
                model.addAttribute("afiliado", afiliado);
                System.out.println(cita);
                System.out.println(afiliado);

                return "confirmacion";

            } else {

                return "error";
            }
        } else {

            return "error";
        }
    }


/*
    @GetMapping("/Agendar/Confirmacion/{id_cita}")
    public String confirmarCita(@PathVariable("id_cita") int idCita, Model model) {
        // Utiliza el idCita recibido para buscar la cita en el servicio
        Optional<Cita> citaOptional = serviciosCita.buscarID(idCita);
        // Verifica si se encontró la cita con el ID dado
        if (citaOptional.isPresent()) {
            // Si se encuentra la cita, asignarla al afiliado actual (asumiendo que tienes una forma de obtener el afiliado actual)
            Afiliado afiliadoActual = obtenerAfiliadoActual(); // Implementa este método para obtener el afiliado actual
            Cita cita = citaOptional.get();
            cita.setAfiliado(afiliadoActual);
            // Guardar la cita actualizada en la base de datos
            serviciosCita.guardarCita(cita);

            // Agrégala al modelo para poder mostrar la información en la vista
            model.addAttribute("cita", cita);
            System.out.println(cita);
            return "confirmacion"; // Devuelve el nombre de la vista para mostrar la información de la cita
        } else {
            // Si no se encuentra la cita, puedes redirigir a una página de error o manejarlo de otra forma
            return "error"; // Por ejemplo, podrías tener una vista llamada "error" para mostrar un mensaje de error
        }
    }*/

/*
    @GetMapping("/cita/nuevo")
    public String mostrarFormulario(Model model){
        CitaDto citaDto = new CitaDto();
        model.addAttribute("lacita", citaDto);
        return "crear_cita";
    }
    @PostMapping("/cita")
    public String registrarCita(@ModelAttribute("lacita") CitaDto citaDto) {
        serviciosCita.crear(citaDto);
        return "redirect:/cntcita";
    }*/
}