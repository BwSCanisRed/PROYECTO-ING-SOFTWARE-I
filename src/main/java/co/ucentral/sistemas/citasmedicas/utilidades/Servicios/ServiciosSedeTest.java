package co.ucentral.sistemas.citasmedicas.utilidades.Servicios;

import co.ucentral.sistemas.citasmedicas.entidades.Sede;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioSede;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiciosSedeTest {
/*
    @InjectMocks
    ServiciosSede serviciosSede;

    @Mock
    RepositorioSede repositorioSede;

    @Test
    void crearTest() {
        Sede sede = new Sede();
        when(repositorioSede.save(sede)).thenReturn(sede);

        Sede result = serviciosSede.crear(sede);

        verify(repositorioSede, times(1)).save(sede);
        assertEquals(sede, result);
    }

    @Test
    void modificarTest() {
        Sede sede = new Sede();
        sede.setId_sede(1);
        when(repositorioSede.findById(1)).thenReturn(Optional.of(sede));
        when(repositorioSede.save(sede)).thenReturn(sede);

        Sede result = serviciosSede.modificar(sede);

        verify(repositorioSede, times(1)).save(sede);
        assertEquals(sede, result);
    }

    @Test
    void borrarTest() {
        Sede sede = new Sede();
        sede.setId_sede(1);
        when(repositorioSede.findById(1)).thenReturn(Optional.of(sede));

        serviciosSede.borrar(sede);

        verify(repositorioSede, times(1)).delete(sede);
    }

    @Test
    void buscarTodosTest() {
        Sede sede1 = new Sede();
        Sede sede2 = new Sede();
        List<Sede> sedes = Arrays.asList(sede1, sede2);
        when(repositorioSede.findAll()).thenReturn(sedes);

        List<Sede> result = serviciosSede.buscarTodos();

        verify(repositorioSede, times(1)).findAll();
        assertEquals(sedes, result);
    }

    @Test
    void buscarIDTest() {
        Sede sede = new Sede();
        sede.setId_sede(1);
        when(repositorioSede.findById(1)).thenReturn(Optional.of(sede));

        Optional<Sede> result = serviciosSede.buscarID(1);

        verify(repositorioSede, times(1)).findById(1);
        assertTrue(result.isPresent());
        assertEquals(sede, result.get());
    }*/
}
