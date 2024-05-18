package co.ucentral.sistemas.citasmedicas.utilidades.test;

import co.ucentral.sistemas.citasmedicas.dto.AfiliadoDto;
import co.ucentral.sistemas.citasmedicas.entidades.Afiliado;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioAfiliado;
import co.ucentral.sistemas.citasmedicas.servicios.ServiciosAfiliado;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiciosAfiliadoTest {

    @InjectMocks
    ServiciosAfiliado serviciosAfiliado;

    @Mock
    RepositorioAfiliado repositorioAfiliado;
/*
    @Test
    void crearTest() {
        Afiliado afiliado = new Afiliado();
        when(repositorioAfiliado.save(afiliado)).thenReturn(afiliado);

        Afiliado result = serviciosAfiliado.crear(afiliado);

        verify(repositorioAfiliado, times(1)).save(afiliado);
        assertEquals(afiliado, result);
    }*/
/*
    @Test
    void modificarTest() {
        Afiliado afiliado = new Afiliado();
        afiliado.setId(1);
        when(repositorioAfiliado.findById(1)).thenReturn(Optional.of(afiliado));
        when(repositorioAfiliado.save(afiliado)).thenReturn(afiliado);

        Afiliado result = serviciosAfiliado.modificar(afiliado);

        verify(repositorioAfiliado, times(1)).save(afiliado);
        assertEquals(afiliado, result);
    }*/
/*
    @Test
    void borrarTest() {
        Afiliado afiliado = new Afiliado();
        afiliado.setId(1);
        when(repositorioAfiliado.findById(1)).thenReturn(Optional.of(afiliado));

        serviciosAfiliado.borrar(1);

        verify(repositorioAfiliado, times(1)).deleteById(1);
    }

    @Test
    void buscarTodosTest() {
        Afiliado afiliado1 = new Afiliado();
        Afiliado afiliado2 = new Afiliado();
        List<Afiliado> afiliados = Arrays.asList(afiliado1, afiliado2);
        when(repositorioAfiliado.findAll()).thenReturn(afiliados);

        List<AfiliadoDto> result = serviciosAfiliado.buscarTodos();

        verify(repositorioAfiliado, times(1)).findAll();
        assertEquals(afiliados, result);
    }

    @Test
    void buscarIDTest() {
        Afiliado afiliado = new Afiliado();
        afiliado.setId(1);
        when(repositorioAfiliado.findById(1)).thenReturn(Optional.of(afiliado));

        Optional<Afiliado> result = serviciosAfiliado.buscarID(1);

        verify(repositorioAfiliado, times(1)).findById(1);
        assertTrue(result.isPresent());
        assertEquals(afiliado, result.get());
    }*/
}