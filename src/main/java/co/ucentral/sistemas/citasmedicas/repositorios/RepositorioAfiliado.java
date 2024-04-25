package co.ucentral.sistemas.citasmedicas.repositorios;
import co.ucentral.sistemas.citasmedicas.entidades.Afiliado;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioAfiliado extends CrudRepository<Afiliado, Integer>, JpaSpecificationExecutor<Afiliado> {
}