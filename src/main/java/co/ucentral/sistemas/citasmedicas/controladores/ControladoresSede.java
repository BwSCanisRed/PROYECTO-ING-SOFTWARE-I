package co.ucentral.sistemas.citasmedicas.controladores;

import co.ucentral.sistemas.citasmedicas.dto.SedeDto;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosSede;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
public class ControladoresSede {

    @Autowired
    private ServiciosSede serviciosSede;

    @GetMapping({"/Agendar"})
    public String listarSedes(Model model) {
        List<SedeDto> sedes = serviciosSede.buscarTodos();
        model.addAttribute("sedes", sedes);
        System.out.println("SAnti Puto");
        return "agendarcitas"; // Nombre de la vista Thymeleaf
    }

  /*  @GetMapping("/nuevo")
    public String mostrarFormularioNuevaSede(Model model) {
        SedeDto sedeDto = new SedeDto();
        model.addAttribute("sedeDto", sedeDto);
        return "crear_sede"; // Nombre de la vista Thymeleaf para el formulario de creación
    }

    @PostMapping
    public String crearSede(@ModelAttribute("sedeDto") SedeDto sedeDto) {
        serviciosSede.crear(sedeDto);
        return "redirect:/sedes"; // Redirige a la lista de sedes después de la creación
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarSede(@PathVariable("id") int id, Model model) {
        SedeDto sedeDto = serviciosSede.buscarID(id);
        model.addAttribute("sedeDto", sedeDto);
        return "editar_sede"; // Nombre de la vista Thymeleaf para el formulario de edición
    }

    @PostMapping("/editar/{id}")
    public String editarSede(@PathVariable("id") int id, @ModelAttribute("sedeDto") SedeDto sedeDto) {
        sedeDto.setId_sede(id); // Asegura que el ID de la sede sea el correcto
        serviciosSede.modificar(sedeDto);
        return "redirect:/sedes"; // Redirige a la lista de sedes después de la edición
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarSede(@PathVariable("id") int id) {
        serviciosSede.borrar(id);
        return "redirect:/sedes"; // Redirige a la lista de sedes después de la eliminación
    }*/
}