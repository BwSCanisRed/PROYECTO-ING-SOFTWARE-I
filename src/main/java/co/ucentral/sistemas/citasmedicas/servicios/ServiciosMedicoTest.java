package co.ucentral.sistemas.citasmedicas.servicios;

import co.ucentral.sistemas.citasmedicas.entidades.Medico;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioMedico;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiciosMedicoTest {

    @InjectMocks
    ServiciosMedico serviciosMedico;

    @Mock
    RepositorioMedico repositorioMedico;

    @Test
    void crearTest() {
        Medico medico = new Medico();
        when(repositorioMedico.save(medico)).thenReturn(medico);

        Medico result = serviciosMedico.crear(medico);

        verify(repositorioMedico, times(1)).save(medico);
        assertEquals(medico, result);
    }

    @Test
    void modificarTest() {
        Medico medico = new Medico();
        medico.setIdentificacion(1);
        when(repositorioMedico.findById(1)).thenReturn(Optional.of(medico));
        when(repositorioMedico.save(medico)).thenReturn(medico);

        Medico result = serviciosMedico.modificar(medico);

        verify(repositorioMedico, times(1)).save(medico);
        assertEquals(medico, result);
    }

    @Test
    void borrarTest() {
        Medico medico = new Medico();
        medico.setIdentificacion(1);
        when(repositorioMedico.findById(1)).thenReturn(Optional.of(medico));

        serviciosMedico.borrar(1);

        verify(repositorioMedico, times(1)).deleteById(1);
    }

    @Test
    void buscarTodosTest() {
        Medico medico1 = new Medico();
        Medico medico2 = new Medico();
        List<Medico> medicos = Arrays.asList(medico1, medico2);
        when(repositorioMedico.findAll()).thenReturn(medicos);

        List<Medico> result = serviciosMedico.buscarTodos();

        verify(repositorioMedico, times(1)).findAll();
        assertEquals(medicos, result);
    }

    @Test
    void buscarIDTest() {
        Medico medico = new Medico();
        medico.setIdentificacion(1);
        when(repositorioMedico.findById(1)).thenReturn(Optional.of(medico));

        Optional<Medico> result = serviciosMedico.buscarID(1);

        verify(repositorioMedico, times(1)).findById(1);
        assertTrue(result.isPresent());
        assertEquals(medico, result.get());
    }
}
