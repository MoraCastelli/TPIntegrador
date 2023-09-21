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
import src.Curso_Profe;
import src.Nota;

public class TestUniversidad {
	
	@Test
	public void agregarMateria() {
		//Agregamos una materia a la universidad. El método registrarMateria verifica que no esté duplicada y la asigna.
		
		reiniciarContadores();
		Universidad unlam = new Universidad ("Unlam");
        Materia materia = new Materia ("PB2");  
                
        assertTrue (unlam.registrarMateria(materia));
	}
	
	@Test
	public void agregarDosMaterias() {
		//Agregamos dos materias distintas a la universidad.
		
		reiniciarContadores();
		Universidad unlam = new Universidad ("Unlam");
        Materia materia = new Materia ("PB2");
        Materia materia2 = new Materia ("BD1");
        
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarMateria(materia2));
	}
	
	@Test
	public void noAgregarMateriaSiYaExiste() {
		//Agregamos 2 veces la misma materia a la universidad y verificamos que no se pueda registrar.
		
		reiniciarContadores();
    	Universidad unlam = new Universidad ("Unlam");
        Materia materia = new Materia ("PB2");
        boolean resultado = unlam.registrarMateria(materia);
        resultado = unlam.registrarMateria(materia);
        
        assertFalse (resultado);
	}

	//***********************************************************************//REVISAR LA COMPARACIÓN POR NOMBRE
	@Test
	public void noAgregarMateriaSiTieneElMismoNombre() {
		//Agregamos 2 materias con mismo nombre, pero distinto ID y verificamos que no se pueda registrar.
		//Comparamos por el nombre de la materia.
		
		reiniciarContadores();
    	Universidad unlam = new Universidad ("Unlam");
        Materia materia = new Materia ("PB2");
        Materia materia2 = new Materia ("PB2");
        boolean resultado = unlam.registrarMateria(materia);
        resultado = unlam.registrarMateria(materia2);
        
        assertFalse (resultado);
	}
	//***********************************************************************//
	
	@Test
	public void agregarAlumno() {
		//Agregamos un alumno a la universidad. El método registrarAlumno verifica que no esté duplicado y lo asigna.
		
		reiniciarContadores();		
    	Universidad unlam = new Universidad ("Unlam");
        Alumno alumno = new Alumno (42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24));
        
        assertTrue (unlam.registrarAlumno(alumno));
	}
	
	@Test
	public void noAgregarAlumnoSiYaExiste() {
		//Agreagamos 2 veces el mismo alumno a la universidad y verificamos que no se pueda registrar.
		//Comparamos por el DNI del alumno.
		//Agreagamos un tercer alumno con los mismos atributos, pero cambiando el DNI. Verificamos que se pueda agregar. 
		
		reiniciarContadores();	
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
        Alumno alumno = new Alumno (42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24));
        Alumno alumno2 = new Alumno (42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24));
        Alumno alumno3 = new Alumno (42817473,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24));
        
        assertTrue (unlam.registrarAlumno(alumno));
        assertFalse (unlam.registrarAlumno(alumno2));
        assertTrue (unlam.registrarAlumno(alumno3));
	}
	

	@Test
	public void agregarProfesor() {
		//Agregamos un profesor a la universidad. El método registrarProfesor verifica que no esté duplicado y lo asigna.
		
		reiniciarContadores();			
    	Universidad unlam = new Universidad ("Unlam");
        Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
        
        assertTrue (unlam.registrarProfesor(profesor));
	}
	
	@Test
	public void noAgreagarProfesorSiYaExiste() {
		//Agreagamos 2 veces el mismo profesor a la universidad y verificamos que no se pueda registrar.
		//Comparamos por el DNI del profesor.
		
		reiniciarContadores();	
    	Universidad unlam = new Universidad ("Unlam");
        Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
        boolean resultado = unlam.registrarProfesor(profesor);
        resultado = unlam.registrarProfesor(profesor);
        
        assertFalse (resultado);
	}
	
	//***********************************************************************//REVISAR REGISTRAR CICLO
	@Test
	public void agregarCicloLectivo() {
		
		reiniciarContadores();
    	Universidad unlam = new Universidad ("Unlam");
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
	}
	//***********************************************************************//
	
	@Test
	public void noCrearCicloLectivoSiYaExiste() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
    	CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
    	boolean resultado = unlam.registrarCicloLectivo(cicloLectivo);
    	resultado = unlam.registrarCicloLectivo(cicloLectivo);
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
        assertTrue (unlam.registrarAlumno(alumno));
       // assertTrue (unlam.inscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso()));
	}
	
	private void reiniciarContadores() { 
		//Este método nos permite reiniciar los contadores que autoincrementan los IDs en las clases.
		//Lo hicimos ya que queremos que en cada test unitario, los objetos se identifiquen empezando por el 0.
		Alumno.setContador(0);
		Aula.setContador(0);
		CicloLectivo.setContador(0);
		Curso_Alumno.setContador(0);
		Curso_Profe.setContador(0);
		Curso.setContador(0);
		Materia.setContador(0);
		Nota.setContador(0);
		Profesor.setContador(0);
	}
}
