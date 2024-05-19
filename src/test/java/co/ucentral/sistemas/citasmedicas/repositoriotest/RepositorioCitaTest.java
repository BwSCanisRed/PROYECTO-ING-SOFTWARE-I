package co.ucentral.sistemas.citasmedicas.repositoriotest;

import co.ucentral.sistemas.citasmedicas.entidades.Cita;
import co.ucentral.sistemas.citasmedicas.repositorios.RepositorioCita;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RepositorioCitaTest {

    @Autowired
    private RepositorioCita repositorioCita;

    @Test
    void testGuardarYBuscarCita() {
        Cita cita = new Cita();
        // Configura los atributos de la cita...

        // Guarda la cita
        cita = repositorioCita.save(cita);

        // Busca la cita
       /* Cita citaBuscada = repositorioCita.findById(cita.getId()).orElse(null);

        // Verifica que la cita guardada y la cita buscada sean iguales
        assertEquals(cita, citaBuscada);*/
    }

    @Test
    void testBuscarPorAfiliado() {
        Cita cita = new Cita();
        // Configura los atributos de la cita...

        // Guarda la cita
        cita = repositorioCita.save(cita);

        // Busca las citas del afiliado
        List<Cita> citasBuscadas = repositorioCita.buscarPorAfiliado(cita.getAfiliado().getIdentificacion());

        // Verifica que la cita guardada esté en la lista de citas buscadas
        assertTrue(citasBuscadas.contains(cita));
    }

    @Test
    void testBuscarPorMedico() {
        Cita cita = new Cita();
        // Configura los atributos de la cita...

        // Guarda la cita
        cita = repositorioCita.save(cita);

        // Busca las citas del médico
        List<Cita> citasBuscadas = repositorioCita.buscarPorMedico(cita.getMedico().getIdentificacion());

        // Verifica que la cita guardada esté en la lista de citas buscadas
        assertTrue(citasBuscadas.contains(cita));
    }
}