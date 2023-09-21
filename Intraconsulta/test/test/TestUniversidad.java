package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;
import src.Universidad;
import src.Materia;
import src.Alumno;
import src.Profesor;
import src.Aula;
import src.CicloLectivo;
import src.Curso;
import src.Curso_Alumno;

public class TestUniversidad {
	
	@Test
	public void agregarMateria() {
		
		reiniciarContador();
		String nombreUniversidad = "Unlam";
		Universidad unlam = new Universidad (nombreUniversidad);
		String nombreMateria = "PB2";	
        Materia materia = new Materia (nombreMateria);      
        
        assertTrue (unlam.registrarMateria(materia));
	}
	
	private void reiniciarContador() {
		Materia.setContador(0);
	}

	@Test
	public void agregarDosMaterias() {
		
		String nombreUniversidad = "Unlam";
		Universidad unlam = new Universidad (nombreUniversidad);
		String nombreMateria = "PB2";	
        Materia materia = new Materia (nombreMateria);
        String nombreMateria2 = "BD1";
        Materia materia2 = new Materia (nombreMateria2);
        
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarMateria(materia2));
	}
	
	@Test
	public void noAgregarMateriaSiYaExiste() {

		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreMateria = "PB2";
        Materia materia = new Materia (nombreMateria);
        boolean resultado = unlam.registrarMateria(materia);
        resultado = unlam.registrarMateria(materia);
        
        assertFalse (resultado);
	}
	
	@Test
	public void agregarAlumno() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreAlumno = "Lucas";
    	String apellidoAlumno = "Lilla";
        Integer dni = 42817472;
        LocalDate fechaNacimiento = LocalDate.of(2000, 10, 24);
        LocalDate fechaIngreso = LocalDate.now();
        Alumno alumno = new Alumno (dni,nombreAlumno, apellidoAlumno, fechaIngreso, fechaNacimiento);
        assertTrue (unlam.registraAlumno(alumno));
	}
	
	@Test
	public void noAgregarAlumnoSiYaExiste() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
        Alumno alumno = new Alumno (42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24));
        Alumno alumno2 = new Alumno (42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24));
        Alumno alumno3 = new Alumno (42817473,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24));
        
        assertTrue (unlam.registraAlumno(alumno));
        assertFalse (unlam.registraAlumno(alumno2));
        assertTrue (unlam.registraAlumno(alumno3));
	}
	

	@Test
	public void crearDocente() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreProfesor = "Mora";
    	String apellidoProfesor = "Castelli";
        Integer dni = 42653314;
        Profesor profesor = new Profesor (dni,nombreProfesor, apellidoProfesor);
        assertTrue (unlam.registraProfesor(profesor));
	}
	
	@Test
	public void noCrearDocenteSiYaExiste() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreProfesor = "Mora";
    	String apellidoProfesor = "Castelli";
        Integer dni = 42653314;
        Profesor profesor = new Profesor (dni,nombreProfesor, apellidoProfesor);
        boolean resultado = unlam.registraProfesor(profesor);
        resultado = unlam.registraProfesor(profesor);
        assertFalse (resultado);
	}
	

	@Test
	public void agregarCicloLectivo() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
    	CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
    	
        assertTrue (unlam.registraCicloLectivo(cicloLectivo));
	}
	
	@Test
	public void noCrearCicloLectivoSiYaExiste() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
    	CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
    	boolean resultado = unlam.registraCicloLectivo(cicloLectivo);
    	resultado = unlam.registraCicloLectivo(cicloLectivo);
        assertFalse (resultado);
	}
	
	@Test
	public void agregarAula() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	Integer capacidad = 30;
        Integer codigo = 15;
        Aula aula = new Aula(capacidad, codigo);
        assertTrue (unlam.registraAula(aula));
	}
	
	@Test
	public void noAgregarAulaSiYaExiste() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	Integer capacidad = 30;
        Integer codigo = 15;
        Aula aula = new Aula(capacidad, codigo);
        boolean resultado = unlam.registraAula(aula);
        resultado = unlam.registraAula(aula);
        assertFalse (resultado);
	}
	
	@Test
	public void crearCurso() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	Integer turno = 1;
    	Integer capacidad = 30;
        Integer codigoAula = 15;
        String nombreMateria = "PB2";
        LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
    	CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
    	Materia materia = new Materia(nombreMateria);
        Aula aula = new Aula(capacidad, codigoAula);
        Curso curso = new Curso(turno, cicloLectivo, materia, aula);
        assertTrue (unlam.registraCurso(curso));
	}
	
	@Test
	public void crear2Curso() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	Integer turno = 1;
    	Integer capacidad = 30;
        Integer codigoAula = 15;
        String nombreMateria = "PB2";
        LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
    	CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
    	Materia materia = new Materia(nombreMateria);
        Aula aula = new Aula(capacidad, codigoAula);
        Curso curso = new Curso(turno, cicloLectivo, materia, aula);
        assertTrue (unlam.registraCurso(curso));
        
        Integer turno1 = 1;
    	Integer capacidad1 = 30;
        Integer codigoAula1 = 15;
        String nombreMateria1 = "PB2";
        LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion1 = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2023, 3, 13);
    	CicloLectivo cicloLectivo1 = new CicloLectivo(fechaInicioCicloLectivo1, fechaFinalizacionCicloLectivo1, fechaInicioInscripcion1, fechaFinalizacionInscripcion1);
    	Materia materia1 = new Materia(nombreMateria1);
        Aula aula1 = new Aula(capacidad1, codigoAula1);
        Curso curso1 = new Curso(turno1, cicloLectivo1, materia1, aula1);
       // assertFalse (unlam.registraCurso(curso1));
	}
	
	@Test
	public void noCrearCursoSiYaExiste() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	Integer turno = 1;
    	Integer capacidad = 30;
        Integer codigoAula = 15;
        String nombreMateria = "PB2";
        LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
    	CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
    	Materia materia = new Materia(nombreMateria);
        Aula aula = new Aula(capacidad, codigoAula);
        Curso curso = new Curso(turno, cicloLectivo, materia, aula);
        boolean resultado = unlam.registraCurso(curso);
        resultado = unlam.registraCurso(curso);
        assertFalse (resultado);
	}
	
	@Test
	public void asignarMateriaCorrelativa() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreMateria = "PB2";
    	String nombreCorrelativa = "PB1";
        Materia materia = new Materia (nombreMateria);
        Materia materiaCorrelativa = new Materia (nombreCorrelativa);
        boolean registro1 = unlam.registrarMateria(materia);
        boolean registro2 = unlam.registrarMateria(materiaCorrelativa);
        Integer idMateria = materia.getIdMateria();
        Integer idMateriaCorrelativa = materiaCorrelativa.getIdMateria();
        assertTrue (unlam.asignarCorrelativa(idMateria, idMateriaCorrelativa));
        assertTrue (registro1);
        assertTrue (registro2);
	}
	
	@Test
	public void noAsignarMateriaCorrelativaSiNoExisteLaMateriaEnLaUniversidad() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreMateria = "PB2";
    	String nombreCorrelativa = "PB1";
        Materia materia = new Materia (nombreMateria);
        Materia materiaCorrelativa = new Materia (nombreCorrelativa);
        Integer idMateria = materia.getIdMateria();
        Integer idMateriaCorrelativa = materiaCorrelativa.getIdMateria();
        assertFalse (unlam.asignarCorrelativa(idMateria, idMateriaCorrelativa));

	}
	
	@Test
	public void noAsignarMateriaCorrelativaSiYaExiste() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreMateria = "PB2";
    	String nombreCorrelativa = "PB1";
        Materia materia = new Materia (nombreMateria);
        Materia materiaCorrelativa = new Materia (nombreCorrelativa);
        boolean registro1 = unlam.registrarMateria(materia);
        boolean registro2 = unlam.registrarMateria(materiaCorrelativa);
        Integer idMateria = materia.getIdMateria();
        Integer idMateriaCorrelativa = materiaCorrelativa.getIdMateria();
        boolean resultado = unlam.asignarCorrelativa(idMateria, idMateriaCorrelativa);
        resultado = unlam.asignarCorrelativa(idMateria, idMateriaCorrelativa);
        assertFalse (resultado);
        assertTrue (registro1);
        assertTrue (registro2);
	}
	
	@Test
	public void eliminarCorrelativa() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreMateria = "PB2";
    	String nombreCorrelativa = "PB1";
        Materia materia = new Materia (nombreMateria);
        Materia materiaCorrelativa = new Materia (nombreCorrelativa);
        boolean registro1 = unlam.registrarMateria(materia);
        boolean registro2 = unlam.registrarMateria(materiaCorrelativa);
        Integer idMateria = materia.getIdMateria();
        Integer idMateriaCorrelativa = materiaCorrelativa.getIdMateria();
        assertTrue (unlam.asignarCorrelativa(idMateria, idMateriaCorrelativa));
        assertTrue (unlam.eliminarCorrelativa(idMateria, idMateriaCorrelativa));
        assertTrue (registro1);
        assertTrue (registro2);
	}
	
	@Test
	public void noEliminarCorrelativaSiNoExisteLaMateriaEnLaUniversidad() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreMateria = "PB2";
    	String nombreCorrelativa = "PB1";
        Materia materia = new Materia (nombreMateria);
        Materia materiaCorrelativa = new Materia (nombreCorrelativa);
        Integer idMateria = materia.getIdMateria();
        Integer idMateriaCorrelativa = materiaCorrelativa.getIdMateria();
        assertFalse (unlam.asignarCorrelativa(idMateria, idMateriaCorrelativa));
        assertFalse (unlam.eliminarCorrelativa(idMateria, idMateriaCorrelativa));
	}
	
	@Test
	public void noEliminarCorrelativaSiNoTiene() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreMateria = "PB2";
    	String nombreCorrelativa = "PB1";
        Materia materia = new Materia (nombreMateria);
        Materia materiaCorrelativa = new Materia (nombreCorrelativa);
        boolean registro1 = unlam.registrarMateria(materia);
        boolean registro2 = unlam.registrarMateria(materiaCorrelativa);
        Integer idMateria = materia.getIdMateria();
        Integer idMateriaCorrelativa = materiaCorrelativa.getIdMateria();
        assertFalse (unlam.eliminarCorrelativa(idMateria, idMateriaCorrelativa));
        assertTrue (registro1);
        assertTrue (registro2);
	}
	
	@Test
	public void inscribirAlumnoACurso() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	Integer turno = 1;
    	Integer capacidad = 30;
        Integer codigoAula = 15;
        String nombreMateria = "PB2";
        String nombreAlumno = "Lucas";
    	String apellidoAlumno = "Lilla";
        Integer dni = 42817472;
        LocalDate fechaNacimiento = LocalDate.of(2000, 10, 24);
        LocalDate fechaIngreso = LocalDate.now();
        Alumno alumno = new Alumno (dni,nombreAlumno, apellidoAlumno, fechaIngreso, fechaNacimiento);
        LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
    	CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
    	Materia materia = new Materia(nombreMateria);
        Aula aula = new Aula(capacidad, codigoAula);
        Curso curso = new Curso(turno, cicloLectivo, materia, aula);
        Curso_Alumno cursoAlumno = new Curso_Alumno(curso);
        assertTrue (unlam.registraAlumno(alumno));
       // assertTrue (unlam.inscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso()));
	}
}
