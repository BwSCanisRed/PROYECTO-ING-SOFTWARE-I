package co.ucentral.sistemas.citasmedicas.repositorios;

import co.ucentral.sistemas.citasmedicas.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCita extends JpaRepository<Cita,Integer> {
}
