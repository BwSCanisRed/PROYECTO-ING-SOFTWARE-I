package co.ucentral.sistemas.citasmedicas;

import co.ucentral.sistemas.citasmedicas.entidades.*;
import co.ucentral.sistemas.citasmedicas.repositorios.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootApplication
@Log4j2
public class CitasmedicasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CitasmedicasApplication.class, args);
		System.out.println("Cargado exitosamente");
	}

	@Autowired
	RepositorioRol repositorioRol;
	@Autowired
	RepositorioConsultor repositorioConsultor;
	@Autowired
	RepositorioMedico repositorioMedico;
	@Autowired
	RepositorioAfiliado repositorioAfiliado;
	@Autowired
	RepositorioRegistro repositorioRegistro;

	@Override
	public void run(String... args) throws Exception {

		Registro registro1 = new Registro("Cédula",1001346667, new Date(2015-1900, 1-1, 23),"Jennifer Lopez Vanegas","3118490299","Calle 55","Femenino","jlopezv6@ucentral.edu.co","123");
		repositorioRegistro.save(registro1);

		Rol rol1 = new Rol("Consultor");
		repositorioRol.save(rol1);
		Rol rol2 = new Rol("Medico");
		repositorioRol.save(rol2);
		Rol rol3 = new Rol("Afiliado");
		repositorioRol.save(rol3);

		Consultor consultor1 = new Consultor(1001346667,"Jennifer Lopez Vanegas",true,rol1);
		repositorioConsultor.save(consultor1);

		Medico medico1 = new Medico(79976478,"Luis Alberto Montenegro Avila",true,rol2);
		repositorioMedico.save(medico1);

		Afiliado afiliado1 = new Afiliado(54678954,"Luz Angela Lopez Aparicio",true,rol3);
		repositorioAfiliado.save(afiliado1);
	}



}
