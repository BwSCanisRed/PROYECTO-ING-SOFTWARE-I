package co.ucentral.sistemas.citasmedicas;

import co.ucentral.sistemas.citasmedicas.entidades.*;
import co.ucentral.sistemas.citasmedicas.repositorios.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
	@Autowired
	RepositorioSede repositorioSede;
	@Autowired
	RepositorioEspecialidad repositorioEspecialidad;
	@Autowired
	RepositorioConsultorio repositorioConsultorio;

	@Autowired
	RepositorioCita repositorioCita;

	@Override
	public void run(String... args) throws Exception {

		Rol rol1 = new Rol("Consultor");
		repositorioRol.save(rol1);
		Rol rol2 = new Rol("Medico");
		repositorioRol.save(rol2);
		Rol rol3 = new Rol("Afiliado");
		repositorioRol.save(rol3);

		Sede sede1 = new Sede("Centro oriente","Carrera 10 #123-45, Bogotá, Cundinamarca",23);
		repositorioSede.save(sede1);
		Sede sede2 = new Sede("Zona sur occidental","Calle 20 #456, Bogotá, Cundinamarca",41);
		repositorioSede.save(sede2);
		Sede sede3 = new Sede("Zona nororiental","Avenida 30 #789, Bogotá, Cundinamarca",20);
		repositorioSede.save(sede3);
		Sede sede4 = new Sede("Zona noroccidental","Carrera 40 #101, Bogotá, Cundinamarca",20);
		repositorioSede.save(sede4);
		Sede sede5 = new Sede("Zona sur","Calle 50 #202, Bogotá, Cundinamarca",20);
		repositorioSede.save(sede5);
		Sede sede6 = new Sede("Zona norte","Avenida 60 #303, Bogotá, Cundinamarca",21);
		repositorioSede.save(sede6);

		Especialidad especialidad1 = new Especialidad("Medicina general");
		repositorioEspecialidad.save(especialidad1);
		Especialidad especialidad2 = new Especialidad("Odontologia");
		repositorioEspecialidad.save(especialidad2);
		Especialidad especialidad3 = new Especialidad("Terapia fisica");
		repositorioEspecialidad.save(especialidad3);
		Especialidad especialidad4 = new Especialidad("Medicina interna");
		repositorioEspecialidad.save(especialidad4);
		Especialidad especialidad5 = new Especialidad("Radiologia");
		repositorioEspecialidad.save(especialidad5);
		Especialidad especialidad6 = new Especialidad("Pedriatia");
		repositorioEspecialidad.save(especialidad6);

		Consultorio consultorio1 = new Consultorio(1,"Medicina general",sede1);
		repositorioConsultorio.save(consultorio1);
		Consultorio consultorio2 = new Consultorio(2,"Odontologia",sede2);
		repositorioConsultorio.save(consultorio2);
		Consultorio consultorio3 = new Consultorio(3,"Terapia fisica",sede3);
		repositorioConsultorio.save(consultorio3);
		Consultorio consultorio4 = new Consultorio(4,"Medicina interna",sede4);
		repositorioConsultorio.save(consultorio4);
		Consultorio consultorio5 = new Consultorio(5,"Radiologia",sede5);
		repositorioConsultorio.save(consultorio5);
		Consultorio consultorio6 = new Consultorio(5,"Pedriatia",sede6);
		repositorioConsultorio.save(consultorio6);

		Consultor consultor1 = new Consultor(1001346667,"Jennifer Lopez Vanegas",true);
		repositorioConsultor.save(consultor1);

		Medico medico1 = new Medico(79976478,"Luis Alberto Montenegro Avila",true,especialidad1,consultorio1,sede1);
		repositorioMedico.save(medico1);
		Medico medico2 = new Medico(1071789472,"Luisa Castellanos",true,especialidad2,consultorio2,sede2);
		repositorioMedico.save(medico1);
		Medico medico3 = new Medico(795443845,"Adolfo Martinez",true,especialidad3,consultorio3,sede3);
		repositorioMedico.save(medico1);

		Afiliado afiliado1 = new Afiliado(54678954,"Luz Angela Lopez Aparicio",true);
		repositorioAfiliado.save(afiliado1);

		Registro registro1 = new Registro("Cedula de Ciudadanía ",1001346667, new Date(2015-1900, 1-1, 23),"Jennifer Lopez Vanegas","3024445556","Calle 55","Femenino","jlopezv6@ucentral.edu.co","123");
		repositorioRegistro.save(registro1);

		// Definir el formato de fecha y hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Crear una lista para almacenar las citas
		List<Cita> citas = new ArrayList<>();

		// Definir la hora de inicio de las citas
		LocalDateTime horaInicio = LocalDateTime.parse("2024-05-15 08:00:00", formatter);

		// Crear 10 citas con 20 minutos de diferencia entre cada una
		for (int i = 0; i < 20; i++) {
			// Agregar el desplazamiento de tiempo (20 minutos * i) a la hora de inicio
			LocalDateTime fechaCita = horaInicio.plusMinutes(20 * i);

			// Crear la cita y agregarla a la lista
			if (i % 2 == 0) {
				Cita cita = new Cita(i + 1, fechaCita, especialidad1, "Proceso",medico1,null);
				repositorioCita.save(cita);
			} else if (i % 3 == 0) {
				Cita cita = new Cita(i + 1, fechaCita, especialidad2, "Proceso",medico2,null);
				repositorioCita.save(cita);
			}else{
				Cita cita = new Cita(i + 1, fechaCita,especialidad3, "Proceso",medico3,null);
				repositorioCita.save(cita);
			}

		}

		// Imprimir las citas
		for (Cita cita : citas) {
			System.out.println(cita);
		}
	}
}

