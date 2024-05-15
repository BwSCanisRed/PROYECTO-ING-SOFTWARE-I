package co.ucentral.sistemas.citasmedicas.repositorios;
import co.ucentral.sistemas.citasmedicas.entidades.Afiliado;
import co.ucentral.sistemas.citasmedicas.entidades.Consultor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioAfiliado extends CrudRepository<Afiliado, Integer>, JpaSpecificationExecutor<Afiliado> {
    Afiliado findByIdentificacionAndNombre(int identificacion, String nombre);

    Afiliado findByIdentificacion(Integer identificacion);

}
