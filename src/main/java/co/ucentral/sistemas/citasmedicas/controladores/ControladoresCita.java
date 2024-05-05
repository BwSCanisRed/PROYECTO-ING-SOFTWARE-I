package co.ucentral.sistemas.citasmedicas.controladores;

import co.ucentral.sistemas.citasmedicas.entidades.Cita;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosCita;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "agendarcitas"; // Nombre de la vista Thymeleaf
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