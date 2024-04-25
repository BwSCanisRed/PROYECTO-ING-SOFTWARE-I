package co.ucentral.sistemas.citasmedicas.repositorios;
import co.ucentral.sistemas.citasmedicas.entidades.Consultor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioConsultor extends CrudRepository<Consultor, Integer>, JpaSpecificationExecutor<Consultor> {
}