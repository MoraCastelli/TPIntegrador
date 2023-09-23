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
		//Agregamos una materia a la universidad. El metodo registrarMateria verifica que no este duplicada y la asigna.
		
		
		Universidad unlam = new Universidad ("Unlam");
		unlam.reiniciarContadores();
        Materia materia = new Materia ("PB2");  
                
        assertTrue (unlam.registrarMateria(materia));
	}
	
	@Test
	public void agregarDosMaterias() {
		//Agregamos dos materias distintas a la universidad.
		
		
		Universidad unlam = new Universidad ("Unlam");
		unlam.reiniciarContadores();
        Materia materia = new Materia ("PB2");
        Materia materia2 = new Materia ("BD1");
        
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarMateria(materia2));
	}
	
	@Test
	public void noAgregarMateriaSiYaExiste() {
		//Agregamos 2 veces la misma materia a la universidad y verificamos que no se pueda registrar.
		
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Materia materia = new Materia ("PB2");
        boolean resultado = unlam.registrarMateria(materia);
        resultado = unlam.registrarMateria(materia);
        
        assertFalse (resultado);
	}

	
	@Test
	public void noAgregarMateriaSiTieneElMismoNombre() {
		//Agregamos 2 materias con mismo nombre, pero distinto ID y verificamos que no se pueda registrar.
		//Comparamos por el ID, si es distinto comparamos por el nombre de la materia. 
		//Asi nos aseguramos que no existan 2 materias con el mismo nombre a pesar de tener otro ID.  
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Materia materia = new Materia ("PB2");
        Materia materia2 = new Materia ("PB2");
        boolean resultado = unlam.registrarMateria(materia);
        resultado = unlam.registrarMateria(materia2);
        
        assertFalse (resultado);
	}
	
	
	@Test
	public void agregarAlumno() {
		//Agregamos un alumno a la universidad. El metodo registrarAlumno verifica que no este duplicado y lo asigna.
			
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24));
        
        assertTrue (unlam.registrarAlumno(alumno));
	}
	
	@Test
	public void noAgregarAlumnoSiYaExiste() {
		//Agreagamos 2 veces el mismo alumno a la universidad y verificamos que no se pueda registrar.
		//Comparamos por el DNI del alumno.
		//Agreagamos un tercer alumno con los mismos atributos, pero cambiando el DNI. Verificamos que se pueda agregar. 
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	unlam.reiniciarContadores();
        Alumno alumno = new Alumno (42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24));
        Alumno alumno2 = new Alumno (42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24));
        Alumno alumno3 = new Alumno (42817473,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24));
        
        assertTrue (unlam.registrarAlumno(alumno));
        assertFalse (unlam.registrarAlumno(alumno2));
        assertTrue (unlam.registrarAlumno(alumno3));
	}
	

	@Test
	public void agregarProfesor() {
		//Agregamos un profesor a la universidad. El metodo registrarProfesor verifica que no este duplicado y lo asigna.
			
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
        
        assertTrue (unlam.registrarProfesor(profesor));
	}
	
	@Test
	public void noAgreagarProfesorSiYaExiste() {
		//Agreagamos 2 veces el mismo profesor a la universidad y verificamos que no se pueda registrar.
		//Comparamos por el DNI del profesor.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
        
        assertTrue (unlam.registrarProfesor(profesor)); 
        assertFalse (unlam.registrarProfesor(profesor));
	}
	
	@Test
	public void noAgregarProfesorSiTienenElMismoDni() {
		//Agreagamos 2 profesores con mismo DNI pero distinto nombre y verificamos que no se pueda registrar.
		//Comparamos por el DNI del profesor.
			
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
        Profesor profesor1 = new Profesor (42653314,"Maria", "LaPaz");
        
        assertTrue (unlam.registrarProfesor(profesor));
        assertFalse (unlam.registrarProfesor(profesor1));
	}
	
	@Test
	public void agregarCicloLectivo() {
		//Agregamos un ciclo lectivo a la universidad. El método registrarCicloLectivo verifica que no este duplicado y lo asigna.
		

    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	 	
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        
	}
	
	@Test
	public void noCrearCicloLectivoSiSeSuperponenLasFechas() {
		

    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	CicloLectivo cicloLectivo1 = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	 	
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertFalse (unlam.registrarCicloLectivo(cicloLectivo1));
	}
	
	@Test
	public void agregarAula() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	Integer capacidad = 30;
        Aula aula = new Aula(capacidad);
        assertTrue (unlam.registraAula(aula));
	}
	
	@Test
	public void noAgregarAulaSiYaExiste() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	Integer capacidad = 30;
        Aula aula = new Aula(capacidad);
        assertTrue (unlam.registraAula(aula));
        assertFalse (unlam.registraAula(aula));
	}
	
	@Test
	public void crearCurso() {
		String nombreUniversidad = "Unlam";
    	Integer turno = 1;
        String nombreMateria = "PB2";
        LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
        
        Universidad unlam = new Universidad (nombreUniversidad);
    	CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
    	Materia materia = new Materia(nombreMateria);
        Curso curso = new Curso(turno, cicloLectivo, materia);
        //REGISTRAR: aula, materia, cicloLectivo
        assertTrue (unlam.registraCurso(curso));
	}
	
	@Test
	public void crear2Curso() {
		String nombreUniversidad = "Unlam";
    	Integer turno = 1;
        String nombreMateria = "PB2";
        LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
        
        Universidad unlam = new Universidad (nombreUniversidad);
    	CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
    	Materia materia = new Materia(nombreMateria);
        Curso curso = new Curso(turno, cicloLectivo, materia);
        assertTrue (unlam.registraCurso(curso));
        
        Integer turno1 = 1;
        String nombreMateria1 = "PB2";
        LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion1 = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2023, 3, 13);
    	CicloLectivo cicloLectivo1 = new CicloLectivo(fechaInicioCicloLectivo1, fechaFinalizacionCicloLectivo1, fechaInicioInscripcion1, fechaFinalizacionInscripcion1);
    	Materia materia1 = new Materia(nombreMateria1);
        Curso curso1 = new Curso(turno1, cicloLectivo1, materia1);
        assertTrue (unlam.registraCurso(curso1));
        
      //REGISTRAR: aula, materia, cicloLectivo
	}
	
	@Test
	public void noCrearCursoSiYaExiste() {
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	Integer turno = 1;
    	Integer capacidad = 30;
        String nombreMateria = "PB2";
        LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
    	CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
    	Materia materia = new Materia(nombreMateria);
        Curso curso = new Curso(turno, cicloLectivo, materia);
        boolean resultado = unlam.registraCurso(curso);
        resultado = unlam.registraCurso(curso);
        assertFalse (resultado);
	}
	
	@Test//asignarDocentesAComision()
	public void agregarRelacionProfesorCurso() {
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
    	Integer turno = 1;
        String nombreMateria = "PB2";
        LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
    	CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
    	Materia materia = new Materia(nombreMateria);
        Curso curso = new Curso(turno, cicloLectivo, materia);
        Curso_Profe cursoProfesor = new Curso_Profe(curso, profesor);
    	
    	assertTrue (unlam.cargarRelacionCursoProfesor(cursoProfesor));
    	assertFalse (unlam.cargarRelacionCursoProfesor(cursoProfesor));
    	
	}
	
	@Test//asignarProfesorAlaComision(idComision, dniDocente)
	public void agregarProfesorACurso() {
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
    	Integer turno = 1;
        String nombreMateria = "PB2";
        LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
    	CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
    	Materia materia = new Materia(nombreMateria);
        Curso curso = new Curso(turno, cicloLectivo, materia);
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registrarProfesor(profesor));
    	
    	assertTrue (unlam.cargarCursoProfesor(curso.getIdCurso(), profesor.getDni()));
    	assertFalse (unlam.cargarCursoProfesor(curso.getIdCurso(), profesor.getDni()));
    	
	}
	
	@Test
    public void asignarProfesorAlCurso() {
        
        Universidad unlam = new Universidad ("Unlam");
        
        Integer turno = 1;
        String nombreMateria = "PB2";
        LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
        CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
        Materia materia = new Materia(nombreMateria);
        Curso curso = new Curso(turno, cicloLectivo, materia);
        assertTrue (unlam.registraCurso(curso));    
        
        Profesor profesor = new Profesor (42653314,"Mora", "Castelli");     
        assertTrue (unlam.registrarProfesor(profesor));
        
        Integer idCurso = 0;
        Integer dniProfesor = 42653314;
        
        assertTrue(unlam.cargarCursoProfesor(idCurso, dniProfesor));
    }
	
	//AGREGAR MAS TESTERS//
	
	@Test
	public void asignarMateriaCorrelativa() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreMateria = "PB2";
    	String nombreCorrelativa = "PB1";
    	
        Materia materia = new Materia (nombreMateria);
        Materia materiaCorrelativa = new Materia (nombreCorrelativa);
        
        assertTrue(unlam.registrarMateria(materia));
        assertTrue(unlam.registrarMateria(materiaCorrelativa));
        
        assertTrue (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
	}
	
	@Test
	public void noAsignarMateriaCorrelativaSiNoExisteLaMateriaEnLaUniversidad() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreMateria = "PB2";
    	String nombreCorrelativa = "PB1";
    	
        Materia materia = new Materia (nombreMateria);
        Materia materiaCorrelativa = new Materia (nombreCorrelativa);
        
        assertFalse (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));

	}
	
	@Test
	public void noAsignarMateriaCorrelativaSiYaExiste() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreMateria = "PB1";
    	String nombreCorrelativa = "PB2";
    	
        Materia materia = new Materia (nombreMateria);
        Materia materiaCorrelativa = new Materia (nombreCorrelativa);
        
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarMateria(materiaCorrelativa));
        assertTrue (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
        assertFalse (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
        
	}
	
	@Test
	public void eliminarCorrelativa() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreMateria = "PB2";
    	String nombreCorrelativa = "PB1";
    	
        Materia materia = new Materia (nombreMateria);
        Materia materiaCorrelativa = new Materia (nombreCorrelativa);
        
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarMateria(materiaCorrelativa));
        assertTrue (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
        assertTrue (unlam.eliminarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
        
	}
	
	@Test
	public void noEliminarCorrelativaSiNoExisteLaMateriaEnLaUniversidad() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreMateria = "PB2";
    	String nombreCorrelativa = "PB1";
    	
        Materia materia = new Materia (nombreMateria);
        Materia materiaCorrelativa = new Materia (nombreCorrelativa);
        
        assertFalse (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
        assertFalse (unlam.eliminarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
	}
	
	@Test
	public void noEliminarCorrelativaSiNoTiene() {
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
    	String nombreMateria = "PB2";
    	String nombreCorrelativa = "PB1";
    	
        Materia materia = new Materia (nombreMateria);
        Materia materiaCorrelativa = new Materia (nombreCorrelativa);
        
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarMateria(materiaCorrelativa));
        
        assertFalse (unlam.eliminarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
        
	}
	
	///HACER MAS TESTS///
	
	@Test
    public void asignarAulaAlCurso() {
        
        Universidad unlam = new Universidad ("Unlam");
        
        Integer turno = 1;
        Integer capacidad = 30;
        String nombreMateria = "PB2";
        LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
        LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
        LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 3);
        LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 13);
        
        CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
        Materia materia = new Materia(nombreMateria);
        Aula aula = new Aula(capacidad);
        Curso curso = new Curso(turno, cicloLectivo, materia);
        
        assertTrue (unlam.registraCurso(curso));        
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
    }
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	//**********************A PARTIR DE ACA SON LOS NUEVOS TESTS*******************************//
	
	@Test
	public void inscribirAlumnoACurso() {
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");    	  
        Alumno alumno = new Alumno (42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24)); //Cambiar el NOW, la fecha de ingreso es cuando el alumno entra a la universidad, no cuando se inscribe al curso.
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));	
    	Integer turno = 1;
        Curso curso = new Curso(turno, cicloLectivo, materia);
        Aula aula = new Aula(20);
        
        //Curso_Alumno cursoAlumno = new Curso_Alumno(curso);
        
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso()));
 
	}
	
	@Test
	public void registrarNotaParcial() {
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");    	  
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24)); //Cambiar el NOW, la fecha de ingreso es cuando el alumno entra a la universidad, no cuando se inscribe al curso.
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));	
    	Integer turno = 1;   
        Curso curso = new Curso(turno, cicloLectivo, materia);
        Integer notaPrimerParcial = 7;
        Aula aula = new Aula(20);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso()));
        
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getIdAlumno(),notaPrimerParcial));

	}

}
