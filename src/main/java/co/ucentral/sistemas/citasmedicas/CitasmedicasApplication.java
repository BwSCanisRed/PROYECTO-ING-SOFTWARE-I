package co.ucentral.sistemas.citasmedicas;

import co.ucentral.sistemas.citasmedicas.entidades.Cita;
import co.ucentral.sistemas.citasmedicas.entidades.Especialidad;
import co.ucentral.sistemas.citasmedicas.entidades.Medico;
import co.ucentral.sistemas.citasmedicas.entidades.Sede;
import co.ucentral.sistemas.citasmedicas.repositorios.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
	RepositorioAfiliado repositorioAfiliado;

	@Autowired
	RepositorioCita repositorioCita;

	@Autowired
	RepositorioConsultor repositorioConsultor;

	@Autowired
	RepositorioSede repositorioSede;

	@Autowired
	RepositorioConsultorio repositorioConsultorio;

	@Autowired
	RepositorioEspecialidad repositorioEspecialidad;

	@Autowired
	RepositorioFactura repositorioFactura;

	@Autowired
	RepositorioMedico repositorioMedico;

	@Autowired
	RepositorioRegistro repositorioRegistro;

	@Autowired
	RepositorioRol repositorioRol;
	@Override
	public void run(String... args) throws Exception {
/** creacion de las sedes **/
		Sede sede1 = new Sede(1, "Sede 1", "CALLE 68 # 25 - 03", 25);
		Sede sede2 = new Sede(2, "Sede 2", "CARRERA 26 # 45 - 32", 25);
		Sede sede3 = new Sede(3, "Sede 3", "CARRERA 85 # 30 - 6 ", 25);
		Sede sede4 = new Sede(4, "Sede 4", "CALLE 1A # 81D - 24", 25);
		Sede sede5 = new Sede(5, "Sede 5", "CARRERA 5 # 23 - 8", 25);

		repositorioSede.save(sede1);
		repositorioSede.save(sede2);
		repositorioSede.save(sede3);
		repositorioSede.save(sede4);
		repositorioSede.save(sede5);
/*
* creacion de algunos medicos
* */
		Medico medico1 = new Medico(11111,"Antonio Bandera",2,true,1,1,sede1,1);
		repositorioMedico.save(medico1);
		Medico medico2 = new Medico(22222,"Gabriela Molina",2,true,2,2,sede2,2);
		repositorioMedico.save(medico2);
		Medico medico3 = new Medico(33333,"Carlos Rodriguez",2,true,2,2,sede3,3);
		repositorioMedico.save(medico3);
		/*
		 * creacion de las especialidades
		 * */

		Especialidad especialidad1 = new Especialidad(10,"Medicina General");
		repositorioEspecialidad.save(especialidad1);
		Especialidad especialidad2 = new Especialidad(20,"Odontologia");
		repositorioEspecialidad.save(especialidad2);
		Especialidad especialidad3 = new Especialidad(30,"Optometria");
		repositorioEspecialidad.save(especialidad3);




		// Definir el formato de fecha y hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Crear una lista para almacenar las citas
		List<Cita> citas = new ArrayList<>();

		// Definir la hora de inicio de las citas
		LocalDateTime horaInicio = LocalDateTime.parse("2024-05-08 08:00:00", formatter);

		// Crear 10 citas con 20 minutos de diferencia entre cada una
		for (int i = 0; i < 20; i++) {
			// Agregar el desplazamiento de tiempo (20 minutos * i) a la hora de inicio
			LocalDateTime fechaCita = horaInicio.plusMinutes(20 * i);

			// Crear la cita y agregarla a la lista
			if (i % 2 == 0) {
				Cita cita = new Cita(i + 1, fechaCita, especialidad1, "Proceso",medico1);
				repositorioCita.save(cita);
			} else if (i % 3 == 0) {
				Cita cita = new Cita(i + 1, fechaCita, especialidad2, "Proceso",medico2);
				repositorioCita.save(cita);
			}else{
				Cita cita = new Cita(i + 1, fechaCita,especialidad3, "Proceso",medico3);
				repositorioCita.save(cita);
			}

		}

		// Imprimir las citas
		for (Cita cita : citas) {
			System.out.println(cita);
		}
	}
}
