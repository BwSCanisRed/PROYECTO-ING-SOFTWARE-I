package co.ucentral.sistemas.citasmedicas.controladores;

import co.ucentral.sistemas.citasmedicas.entidades.Cita;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosCita;
import lombok.extern.log4j.Log4j2;
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

    @GetMapping({"/Agendar"})
    public String listarCitas(Model model) {
        model.addAttribute("listaCitasT", serviciosCita.buscarTodos());
        for(Cita laCita: serviciosCita.buscarTodos()){
            System.out.println( laCita );
        }
        System.out.println("paso por aca");
        return "agendarcitas";
    }


    @GetMapping("/Agendar/Confirmacion/{id_cita}")
    public String buscarCitaPorId(@PathVariable("id_cita") int idCita, Model model) {
        // Utiliza el idCita recibido para buscar la cita en el servicio
        Optional<Cita> citaOptional = serviciosCita.buscarID(idCita);
        // Verifica si se encontró la cita con el ID dado
        if (citaOptional.isPresent()) {
            // Si se encuentra la cita, agrégala al modelo para poder mostrar la información en la vista
            Cita cita = citaOptional.get();
            model.addAttribute("cita", cita);
            System.out.println(cita);
            return "confirmacion"; // Devuelve el nombre de la vista para mostrar la información de la cita
        } else {
            // Si no se encuentra la cita, puedes redirigir a una página de error o manejarlo de otra forma
            return "error"; // Por ejemplo, podrías tener una vista llamada "error" para mostrar un mensaje de error
        }
    }
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