package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;
import src.Universidad;
import src.Materia;
import src.Alumno;
import src.Profesor;
import src.Aula;
import src.CicloLectivo;
import src.Curso;
import src.Curso_Profe;
import src.Nota;

public class TestUniversidad {
	
	@Test
	public void agregarMateria() {
		//Agregamos una materia a la universidad.
		//El metodo registrarMateria verifica que no este duplicada y la asigna.
		
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
		//Intentamos agregar 2 veces la misma materia a la universidad y verificamos que no se pueda registrar.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Materia materia = new Materia ("PB2");
        boolean resultado = unlam.registrarMateria(materia);
        resultado = unlam.registrarMateria(materia);
        
        assertFalse (resultado);
	}

	@Test
	public void noAgregarMateriaSiTieneElMismoNombre() {
		//Intentamos agregar 2 materias con mismo nombre, pero distinto ID y verificamos que no se pueda registrar.
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
		//Agregamos un alumno a la universidad.
		//El metodo registrarAlumno verifica que no este duplicado y lo asigna.
			
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24));
        
        assertTrue (unlam.registrarAlumno(alumno));
	}
	
	@Test
	public void noAgregarAlumnoSiYaExiste() {
		//Intentamos agregar 2 veces el mismo alumno a la universidad y verificamos que no se pueda registrar.
		//Comparamos por el DNI del alumno.
		//Agreagamos un tercer alumno con los mismos atributos, pero cambiando el DNI. Verificamos que se pueda agregar. 
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Alumno alumno = new Alumno (42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24));
        Alumno alumno2 = new Alumno (42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24));
        Alumno alumno3 = new Alumno (42817473,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24));
        
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
		//Intentamos agregar 2 veces el mismo profesor a la universidad y verificamos que no se pueda registrar.
		//Comparamos por el DNI del profesor.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
        
        assertTrue (unlam.registrarProfesor(profesor)); 
        assertFalse (unlam.registrarProfesor(profesor));
	}
	
	@Test
	public void noAgregarProfesorSiTienenElMismoDni() {
		//Intentamos agregar 2 profesores con mismo DNI pero distinto nombre y verificamos que no se pueda registrar.
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
		//Intentamos agregar 2 ciclo lectivo con las mismas fechas y 
		//verificamos que no se pueda registrar debido a que serian valores duplicados.

    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	CicloLectivo cicloLectivo1 = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	 	
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertFalse (unlam.registrarCicloLectivo(cicloLectivo1));
	}
	
	@Test
	public void agregarAula() {
		//Agregamos un aula a la universidad. El método registrarAula verifica que no este duplicado y lo asigna.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Aula aula = new Aula(30);
        
        assertTrue (unlam.registraAula(aula));
	}
	
	@Test
	public void noAgregarAulaSiYaExiste() {
		//Intentamos agregar un aula a la universidad.
		//El método registrarAula verifica que no este duplicado pero como ya se reistro no lo asigna.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Aula aula = new Aula(30);
        
        assertTrue (unlam.registraAula(aula));
        assertFalse (unlam.registraAula(aula));
	}
	
	@Test
	public void crearCurso() {
		//Agregamos un curso a la universidad.
		//El método registrarCurso verifica que no este duplicado y lo asigna.
    	
        Universidad unlam = new Universidad ("Unlam");
        unlam.reiniciarContadores();
        CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        
        assertTrue (unlam.registraCurso(curso));
	}
	
	@Test
	public void noCrearCursoSiYaExiste() {
		//Intentamos agregar un curso a la universidad.
		//El método registrarCurso verifica que no este duplicado pero como ya se reistro no lo asigna.
		
		Universidad unlam = new Universidad ("Unlam");
		unlam.reiniciarContadores();
		CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        
        assertTrue (unlam.registraCurso(curso));
        assertFalse (unlam.registraCurso(curso));
	}
	
	@Test
	public void crear2Curso() {
		//Agregamos dos curso a la universidad.
		//El método registrarCurso verifica que no esten duplicados y los asigna.
		
		Universidad unlam = new Universidad ("Unlam");
		unlam.reiniciarContadores();
		CicloLectivo cicloLectivo1 = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Materia materia1 = new Materia("PB2");
        Curso curso1 = new Curso(1, cicloLectivo1, materia1);
        
        CicloLectivo cicloLectivo2 = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Materia materia2 = new Materia("PB2");
        Curso curso2 = new Curso(1, cicloLectivo2, materia2);
        
        assertTrue (unlam.registraCurso(curso1));
        assertTrue (unlam.registraCurso(curso2));
	}
	
	@Test//asignarDocentesAComision()
	public void agregarRelacionProfesorCurso() {
		//Agregamos un objeto CursoProfesor a el array relacionCursoProfesor de la universidad.
		//El método cargarRelacionCursoProfesor verifica que no este duplicado y se lo asigna.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        Curso_Profe cursoProfesor = new Curso_Profe(curso, profesor);
    	
    	assertTrue (unlam.cargarRelacionCursoProfesor(cursoProfesor));
	}
	
	@Test//asignarDocentesAComision()
	public void noAgregarRelacionProfesorCursoSiYaExiste() {
		//Intentamos agregar un objeto CursoProfesor a el array relacionCursoProfesor de la universidad.
		//El método cargarRelacionCursoProfesor verifica que no este duplicado pero como ya se reistro no lo asigna.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        Curso_Profe cursoProfesor = new Curso_Profe(curso, profesor);
    	
    	assertTrue (unlam.cargarRelacionCursoProfesor(cursoProfesor));
    	assertFalse (unlam.cargarRelacionCursoProfesor(cursoProfesor));
	}
	
	@Test//asignarProfesorALaComision(idComision, dniDocente)
	public void asignarProfesorACurso() {
		//Asignamos un profesor a un curso de la universidad.
		//El método cargarCursoProfesor verifica que el profesor y el curso pertenezcan a la universidad.
		//Carga un profesor si hay menos de 20 alumnos.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registrarProfesor(profesor));
    	
    	assertTrue (unlam.cargarCursoProfesor(curso.getIdCurso(), profesor.getDni()));
	}
	
	@Test
	public void noAsignarProfesorACursoSiSuperaLos20Alumnos() {
		//Intentamos asignar un profesor a un curso de la universidad.
		//El método cargarCursoProfesor verifica que el profesor y el curso pertenezcan a la universidad.
		//Carga un profesor si hay menos de 20 alumnos y como no cumple, no carga al profesor.
				
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Materia materia = new Materia("PB2");
        Aula aula = new Aula(25);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        Curso curso = new Curso(1, cicloLectivo, materia);
        
        Alumno alumno1 = new Alumno (428174721,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno2 = new Alumno (428174722,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno3 = new Alumno (428174723,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno4 = new Alumno (428174724,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno5 = new Alumno (428174752,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno6 = new Alumno (428174726,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno7 = new Alumno (428748752,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno8 = new Alumno (428174452,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno9 = new Alumno (428177542,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno10 = new Alumno (428174727,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno11 = new Alumno (428174728,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno12 = new Alumno (428174729,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno13 = new Alumno (428147210,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno14 = new Alumno (428747211,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno15 = new Alumno (428747212,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno16 = new Alumno (428177213,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno17 = new Alumno (428147214,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno18 = new Alumno (428747215,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno19 = new Alumno (428174716,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno20 = new Alumno (428174217,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Alumno alumno21 = new Alumno (428174718,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 

        assertTrue (unlam.registrarAlumno(alumno1));
        assertTrue (unlam.registrarAlumno(alumno2));
        assertTrue (unlam.registrarAlumno(alumno3));
        assertTrue (unlam.registrarAlumno(alumno4));
        assertTrue (unlam.registrarAlumno(alumno5));
        assertTrue (unlam.registrarAlumno(alumno6));
        assertTrue (unlam.registrarAlumno(alumno7));
        assertTrue (unlam.registrarAlumno(alumno8));
        assertTrue (unlam.registrarAlumno(alumno9));
        assertTrue (unlam.registrarAlumno(alumno10));
        assertTrue (unlam.registrarAlumno(alumno11));
        assertTrue (unlam.registrarAlumno(alumno12));
        assertTrue (unlam.registrarAlumno(alumno13));
        assertTrue (unlam.registrarAlumno(alumno14));
        assertTrue (unlam.registrarAlumno(alumno15));
        assertTrue (unlam.registrarAlumno(alumno16));
        assertTrue (unlam.registrarAlumno(alumno17));
        assertTrue (unlam.registrarAlumno(alumno18));
        assertTrue (unlam.registrarAlumno(alumno19));
        assertTrue (unlam.registrarAlumno(alumno20));
        assertTrue (unlam.registrarAlumno(alumno21));
        
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registrarProfesor(profesor));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
    	
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno1.getDni(), curso.getIdCurso(), hoy)); 
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno2.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno3.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno4.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno5.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno6.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno7.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno8.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno9.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno10.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno11.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno12.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno13.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno14.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno15.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno16.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno17.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno18.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno19.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno20.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno21.getDni(), curso.getIdCurso(), hoy));
        
        assertFalse (unlam.cargarCursoProfesor(curso.getIdCurso(), profesor.getDni()));
	}
	
	@Test//asignarProfesorALaComision(idComision, dniDocente)
	public void noAsignarProfesorACursoSiYaExiste() {
		//Intentamos agregar un profesor a un curso de la universidad.
		//El método cargarCursoProfesor verifica que el profesor y el curso pertenezcan a la universidad.
		//Carga un profesor si hay menos de 20 alumnos.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registrarProfesor(profesor));
    	
    	assertTrue (unlam.cargarCursoProfesor(curso.getIdCurso(), profesor.getDni()));
    	assertFalse (unlam.cargarCursoProfesor(curso.getIdCurso(), profesor.getDni()));
	}
	
	@Test//asignarProfesorAlaComision(idComision, dniDocente)
	public void noAsignarProfesorACursoSiNoExisteElCurso() {
		//Intentamos agregar un profesor a un curso de la universidad.
		//El método cargarCursoProfesor verifica que el profesor y el curso pertenezcan a la universidad.
		//Carga un profesor si hay menos de 20 alumnos.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        
        assertTrue (unlam.registrarProfesor(profesor));    	
    	assertFalse (unlam.cargarCursoProfesor(curso.getIdCurso(), profesor.getDni()));
	}
	
	@Test
	public void asignarMateriaCorrelativa() {
		//Asignamos una materia correlativa a una materia de la universidad. 
		//El método asignarCorrelativa verifica que la materia y su correlativa pertenezcan a la universidad.
		//Tambien verifica que la materia correlativa no este duplicada.

    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Materia materia = new Materia ("PB2");
        Materia materiaCorrelativa = new Materia ("PB1");
        
        assertTrue(unlam.registrarMateria(materia));
        assertTrue(unlam.registrarMateria(materiaCorrelativa));
        
        assertTrue (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
	}
	
	@Test
	public void noAsignarMateriaCorrelativaSiNoExisteLaMateriaEnLaUniversidad() {
		//Intentamos asignar una materia correlativa a una materia de la universidad. 
		//El método asignarCorrelativa verifica que la materia y su correlativa pertenezcan a la universidad y 
		//como no la materia no pertenece a la universidad, no carga la correlativa.
		//Tambien verifica que la materia correlativa no este duplicada.
		
		Universidad unlam = new Universidad ("Unlam");
		unlam.reiniciarContadores();
        Materia materia = new Materia ("PB2");
        Materia materiaCorrelativa = new Materia ("PB1");
        
        assertFalse (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
	}
	
	@Test
	public void noAsignarMateriaCorrelativaSiNoExisteLaMateriaCorrelativaEnLaUniversidad() {
		//Intentamos asignar una materia correlativa a una materia de la universidad. 
		//El método asignarCorrelativa verifica que la materia y su correlativa pertenezcan a la universidad y 
		//como no la correlativa no pertenece a la universidad, no carga la correlativa.
		//Tambien verifica que la materia correlativa no este duplicada.
		
		Universidad unlam = new Universidad ("Unlam");
		unlam.reiniciarContadores();
        Materia materia = new Materia ("PB2");
        Materia materiaCorrelativa = new Materia ("PB1");
        assertTrue(unlam.registrarMateria(materia));
        
        assertFalse (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
	}
	
	@Test
	public void noAsignarMateriaCorrelativaSiYaExiste() {
		//Intentamos asignar una materia correlativa a una materia de la universidad. 
		//El método asignarCorrelativa verifica que la materia y su correlativa pertenezcan a la universidad.
		//Tambien verifica que la materia correlativa no este duplicada y como lo esta no la asigna.
		
		Universidad unlam = new Universidad ("Unlam");
		unlam.reiniciarContadores();
        Materia materia = new Materia ("PB2");
        Materia materiaCorrelativa = new Materia ("PB1");
        
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarMateria(materiaCorrelativa));
        assertTrue (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
        assertFalse (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
	}
	
	@Test
	public void eliminarCorrelativa() {
		//Eliminamos una materia correlativa de una materia perteneciente la universidad. 
		//El método asignarCorrelativa verifica que la materia y su correlativa pertenezcan a la universidad.
		//Tambien verifica que la materia a eliminar ya haya sido asignada previamente.
		
		Universidad unlam = new Universidad ("Unlam");
		unlam.reiniciarContadores();
        Materia materia = new Materia ("PB2");
        Materia materiaCorrelativa = new Materia ("PB1");
        
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarMateria(materiaCorrelativa));
        assertTrue (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
        assertTrue (unlam.eliminarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));     
	}
	
	@Test
	public void noEliminarCorrelativaSiNoExisteLaMateriaEnLaUniversidad() {
		//Intentamos eliminar una materia correlativa de una materia perteneciente la universidad. 
		//El método asignarCorrelativa verifica que la materia y su correlativa pertenezcan a la universidad y como no cumple no la elimina.
		//Tambien verifica que la materia a eliminar ya haya sido asignada previamente.
		
		Universidad unlam = new Universidad ("Unlam");
		unlam.reiniciarContadores();
        Materia materia = new Materia ("PB2");
        Materia materiaCorrelativa = new Materia ("PB1");
        
        assertFalse (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
        assertFalse (unlam.eliminarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
	}
	
	@Test
	public void noEliminarCorrelativaSiNoTiene() {
		//Intentamos eliminar una materia correlativa de una materia perteneciente la universidad. 
		//El método asignarCorrelativa verifica que la materia y su correlativa pertenezcan a la universidad.
		//Tambien verifica que la materia a eliminar ya haya sido asignada previamente y como esto no se cumple no se elimina.
		
		Universidad unlam = new Universidad ("Unlam");
		unlam.reiniciarContadores();
        Materia materia = new Materia ("PB2");
        Materia materiaCorrelativa = new Materia ("PB1");
        
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarMateria(materiaCorrelativa));
        
        assertFalse (unlam.eliminarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));    
	}
	
	@Test
    public void asignarAulaAlCurso() {
		//Agregar un aula a un curso de la universidad.
		//El método asignarAulaACurso verifica que el aula y el curso pertenezcan a la universidad.
		//Carga un alumnos hasta la capacidad maxima del aula.
        
        Universidad unlam = new Universidad ("Unlam");
        unlam.reiniciarContadores();
        CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(30);
        
        assertTrue (unlam.registraCurso(curso));        
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
    }
		
	@Test
    public void noAsignarAulaAlCursoSiElCursoNoExiste() {
		//Intentamos agregar un aula a un curso de la universidad.
		//El método asignarAulaACurso verifica que el aula y el curso pertenezcan a la universidad pero como no cumple no lo agrega.
        
        Universidad unlam = new Universidad ("Unlam");
        unlam.reiniciarContadores();
        CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(30);
        
        assertTrue (unlam.registraAula(aula));        
        assertFalse (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
    }
		
	@Test
	public void inscribirAlumnoACurso() {
		//Inscribimos un alumno a un curso de la universidad.
		//El metodo inscribirUnAlumnoACurso verifica que: - El alumno y el curso existan en la universidad.
		//												  - El alumno tenga aprobadas todas las correlativas.
		//												  - La inscripcion este en fecha.
		//												  - No supere la capacidad maxima de alumnos permitidos en el aula.
		//												  - El alumno no este inscripto a otro curso en el mismo dia y turno.
		//												  - El alumno no haya aprobado la materia previamente.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");    	  
        Alumno alumno = new Alumno (42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
     
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
 	}
	
	@Test
	public void noInscribirAlAlumnoSiNoEstaRegistradoElCursoEnLaUniversidad() {
		//Intentamos inscribir un alumno a un curso de la universidad, como el mismo no esta cargado no lo incribe.
		//El metodo inscribirUnAlumnoACurso verifica que: - El alumno y el curso existan en la universidad.
		//												  - El alumno tenga aprobadas todas las correlativas.
		//												  - La inscripcion este en fecha.
		//												  - No supere la capacidad maxima de alumnos permitidos en el aula.
		//												  - El alumno no este inscripto a otro curso en el mismo dia y turno.
		//												  - El alumno no haya aprobado la materia previamente.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");    	  
        Alumno alumno = new Alumno (42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Curso curso = new Curso(1, cicloLectivo, materia);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
                
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
            
        assertFalse (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
	}
	
	@Test
	public void noInscribirAlAlumnoSiNoTieneAprobadasTodasLasCorrelativas() {
		//Inscribimos un alumno a un curso de la universidad.
		//El metodo inscribirUnAlumnoACurso verifica que: - El alumno y el curso existan en la universidad.
		//												  - El alumno tenga aprobadas todas las correlativas y como no cumple no lo inscribe.
		//												  - La inscripcion este en fecha.
		//												  - No supere la capacidad maxima de alumnos permitidos en el aula.
		//												  - El alumno no este inscripto a otro curso en el mismo dia y turno.
		//												  - El alumno no haya aprobado la materia previamente.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");
    	Materia materiaCorrelativa = new Materia ("PB1");
    	Alumno alumno = new Alumno (42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));
    	Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
                
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarMateria(materiaCorrelativa));
        assertTrue (unlam.asignarCorrelativa(materia.getIdMateria(), materiaCorrelativa.getIdMateria()));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
            
        assertFalse (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
	}
	
	@Test
	public void noInscribirAlAlumnoSiEstaFueraDeLaFechaDeInscripcion() {
		//Inscribimos un alumno a un curso de la universidad.
		//El metodo inscribirUnAlumnoACurso verifica que: - El alumno y el curso existan en la universidad.
		//												  - El alumno tenga aprobadas todas las correlativas.
		//												  - La inscripcion este en fecha y como no cumple no lo inscribe.
		//												  - No supere la capacidad maxima de alumnos permitidos en el aula.
		//												  - El alumno no este inscripto a otro curso en el mismo dia y turno.
		//												  - El alumno no haya aprobado la materia previamente.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");    	  
        Alumno alumno = new Alumno (42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));	
        Curso curso = new Curso(1, cicloLectivo, materia);
                
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
            
        assertFalse (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), LocalDate.now()));
	}
	
	@Test
	public void noInscribirAlAlumnoSiSuperaLaCapacidadMaximaDelAula() {
		//Inscribimos un alumno a un curso de la universidad.
		//El metodo inscribirUnAlumnoACurso verifica que: - El alumno y el curso existan en la universidad.
		//												  - El alumno tenga aprobadas todas las correlativas.
		//												  - La inscripcion este en fecha.
		//												  - No supere la capacidad maxima de alumnos permitidos en el aula y como no cumple no lo inscribe.
		//												  - El alumno no este inscripto a otro curso en el mismo dia y turno.
		//												  - El alumno no haya aprobado la materia previamente.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");
    	Alumno alumno = new Alumno (42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
    	Alumno alumno2 = new Alumno (42653314,"Mora", "Castelli", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 6, 29));
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));	
        Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(1);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
                
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarAlumno(alumno2));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
            
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        assertFalse (unlam.inscribirUnAlumnoACurso(alumno2.getDni(), curso.getIdCurso(), hoy));
	}
	
	@Test
	public void noInscribirAlAlumnoSiYaEstaInscriptoAOtroCursoElMismoDiaYTurno() {
		//Inscribimos un alumno a un curso de la universidad.
		//El metodo inscribirUnAlumnoACurso verifica que: - El alumno y el curso existan en la universidad.
		//												  - El alumno tenga aprobadas todas las correlativas.
		//												  - La inscripcion este en fecha.
		//												  - No supere la capacidad maxima de alumnos permitidos en el aula.
		//												  - El alumno no este inscripto a otro curso en el mismo dia y turno y como no cumple no lo inscribe.
		//												  - El alumno no haya aprobado la materia previamente.

    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");
    	Materia materia2 = new Materia("BD1");
    	Alumno alumno = new Alumno (42653314,"Mora", "Castelli", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 6, 29));
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));	
        Curso curso = new Curso(1, cicloLectivo, materia);
        Curso curso2 = new Curso(1, cicloLectivo, materia2);
        Aula aula = new Aula(10);
        Aula aula2 = new Aula(10);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
                
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraCurso(curso2));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.registraAula(aula2));
        assertTrue (unlam.asignarAulaACurso(curso2.getIdCurso(), aula2.getIdAula()));
        
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        assertFalse (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso2.getIdCurso(), hoy));
	}
	
	@Test
	public void noInscribirAlAlumnoSiYaAproboLaMateriaPreviamente() {
		//Inscribimos un alumno a un curso de la universidad.
		//El metodo inscribirUnAlumnoACurso verifica que: - El alumno y el curso existan en la universidad.
		//												  - El alumno tenga aprobadas todas las correlativas.
		//												  - La inscripcion este en fecha.
		//												  - No supere la capacidad maxima de alumnos permitidos en el aula.
		//												  - El alumno no este inscripto a otro curso en el mismo dia y turno.
		//												  - El alumno no haya aprobado la materia previamente y como no cumple no lo inscribe.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));	
    	Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(),9));
     
        assertFalse (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
	}
	
	@Test
	public void registrarNotaPrimerParcial() {
		//Registramos la nota de un alumno inscripto en la universidad.
		//El metodo registrarNota verifica que: - La nota debe estar entre 1 y 10.
		//										- Si el alumno no cuenta con todas la correlativas aprobadas la nota no podra ser mayor/igual a 7.
		//										- Las notas pueden ser del tipo PrimerParcial, SegundoParcial, RecuperatorioPrimerParcial, RecuperatorioSegundoParcial y Final.
		//										- No se pueda cargar dos recuperatorios.
		//										- Tenga aprobadas todas las notas parciales para cargar la nota final.
				
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");    	  
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24));
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));  
        Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        Nota nota = new Nota();
        nota.setPrimerParcial(7);
        nota.setSegundoParcial(0);
        nota.setRecueperatorioPrimero(0);
        nota.setRecueperatorioSegundo(0);
        nota.setNotafinal(0);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(),7));
        
        assertEquals (unlam.obtenerNota(alumno.getIdAlumno(), materia.getIdMateria()), nota);
	}
	
	@Test
	public void registrarNotaSegundoParcial() {
		//Registramos la nota de un alumno inscripto en la universidad.
		//El metodo registrarNota verifica que: - La nota debe estar entre 1 y 10.
		//										- Si el alumno no cuenta con todas la correlativas aprobadas la nota no podra ser mayor/igual a 7.
		//										- Las notas pueden ser del tipo PrimerParcial, SegundoParcial, RecuperatorioPrimerParcial, RecuperatorioSegundoParcial y Final.
		//										- No se pueda cargar dos recuperatorios.
		//										- Tenga aprobadas todas las notas parciales para cargar la nota final.
				
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");    	  
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24));
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15)); 
        Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        Nota nota = new Nota();
        nota.setPrimerParcial(7);
        nota.setSegundoParcial(7);
        nota.setRecueperatorioPrimero(0);
        nota.setRecueperatorioSegundo(0);
        nota.setNotafinal(0);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 7));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 7));
        
        assertEquals (unlam.obtenerNota(alumno.getIdAlumno(), materia.getIdMateria()), nota);
	}
	
	@Test
	public void registrarNotaRecuperatorioPrimerParcial() {
		//Registramos la nota de un alumno inscripto en la universidad.
		//El metodo registrarNota verifica que: - La nota debe estar entre 1 y 10.
		//										- Si el alumno no cuenta con todas la correlativas aprobadas la nota no podra ser mayor/igual a 7.
		//										- Las notas pueden ser del tipo PrimerParcial, SegundoParcial, RecuperatorioPrimerParcial, RecuperatorioSegundoParcial y Final.
		//										- No se pueda cargar dos recuperatorios.
		//										- Tenga aprobadas todas las notas parciales para cargar la nota final.
				
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");    	  
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24));
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15)); 
        Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        Nota nota = new Nota();
        nota.setPrimerParcial(2);
        nota.setSegundoParcial(7);
        nota.setRecueperatorioPrimero(7);
        nota.setRecueperatorioSegundo(0);
        nota.setNotafinal(0);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 2));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 7));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 7));
        
        assertEquals (unlam.obtenerNota(alumno.getIdAlumno(), materia.getIdMateria()), nota);
	}
	
	@Test
	public void registrarNotaRecuperatorioSegundoParcial() {
		//Registramos la nota de un alumno inscripto en la universidad.
		//El metodo registrarNota verifica que: - La nota debe estar entre 1 y 10.
		//										- Si el alumno no cuenta con todas la correlativas aprobadas la nota no podra ser mayor/igual a 7.
		//										- Las notas pueden ser del tipo PrimerParcial, SegundoParcial, RecuperatorioPrimerParcial, RecuperatorioSegundoParcial y Final.
		//										- No se pueda cargar dos recuperatorios.
		//										- Tenga aprobadas todas las notas parciales para cargar la nota final.
				
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");    	  
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24));
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15)); 
        Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        Nota nota = new Nota();
        nota.setPrimerParcial(7);
        nota.setSegundoParcial(2);
        nota.setRecueperatorioPrimero(0);
        nota.setRecueperatorioSegundo(7);
        nota.setNotafinal(0);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 7));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 2));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 7));
        
        assertEquals (unlam.obtenerNota(alumno.getIdAlumno(), materia.getIdMateria()), nota);
	}
	
	@Test
	public void registrarNotaFinal() {
		//Registramos la nota de un alumno inscripto en la universidad.
		//El metodo registrarNota verifica que: - La nota debe estar entre 1 y 10.
		//										- Si el alumno no cuenta con todas la correlativas aprobadas la nota no podra ser mayor/igual a 7.
		//										- Las notas pueden ser del tipo PrimerParcial, SegundoParcial, RecuperatorioPrimerParcial, RecuperatorioSegundoParcial y Final.
		//										- No se pueda cargar dos recuperatorios.
		//										- Tenga aprobadas todas las notas parciales para cargar la nota final.
				
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");    	  
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24));
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15)); 
        Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        Nota nota = new Nota();
        nota.setPrimerParcial(7);
        nota.setSegundoParcial(8);
        nota.setRecueperatorioPrimero(0);
        nota.setRecueperatorioSegundo(0);
        nota.setNotafinal(9);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 7));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 8));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 9));
        
        assertEquals (unlam.obtenerNota(alumno.getIdAlumno(), materia.getIdMateria()), nota);
	}
	
	@Test
	public void noRegistrarNotaSiElValorNoEstaEnElRango() {
		//Registramos la nota de un alumno inscripto en la universidad.
		//El metodo registrarNota verifica que: - La nota debe estar entre 1 y 10.
		//										- Si el alumno no cuenta con todas la correlativas aprobadas la nota no podra ser mayor/igual a 7.
		//										- Las notas pueden ser del tipo PrimerParcial, SegundoParcial, RecuperatorioPrimerParcial, RecuperatorioSegundoParcial y Final.
		//										- No se pueda cargar dos recuperatorios.
		//										- Tenga aprobadas todas las notas parciales para cargar la nota final.
				
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");    	  
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24));
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15)); 
        Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        
        assertFalse (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 50));
	}
	
	@Test
	public void noRegistrarNotaDeDosRecuperatorios() {
		//Registramos la nota de un alumno inscripto en la universidad.
		//El metodo registrarNota verifica que: - La nota debe estar entre 1 y 10.
		//										- Si el alumno no cuenta con todas la correlativas aprobadas la nota no podra ser mayor/igual a 7.
		//										- Las notas pueden ser del tipo PrimerParcial, SegundoParcial, RecuperatorioPrimerParcial, RecuperatorioSegundoParcial y Final.
		//										- No se pueda cargar dos recuperatorios.
		//										- Tenga aprobadas todas las notas parciales para cargar la nota final.
				
		Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");    	  
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24));
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15)); 
        Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        Nota nota = new Nota();
        nota.setPrimerParcial(2);
        nota.setSegundoParcial(6);
        nota.setRecueperatorioPrimero(7);
        nota.setRecueperatorioSegundo(0);
        nota.setNotafinal(7);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 2));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 6));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 7));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 7));
        
        assertEquals (unlam.obtenerNota(alumno.getIdAlumno(), materia.getIdMateria()), nota);
	}
	
	@Test
	public void noRegistrarNotaFinalSiNoEstanAprobadosLosParciales() {
		//Registramos la nota de un alumno inscripto en la universidad.
		//El metodo registrarNota verifica que: - La nota debe estar entre 1 y 10.
		//										- Si el alumno no cuenta con todas la correlativas aprobadas la nota no podra ser mayor/igual a 7.
		//										- Las notas pueden ser del tipo PrimerParcial, SegundoParcial, RecuperatorioPrimerParcial, RecuperatorioSegundoParcial y Final.
		//										- No se pueda cargar dos recuperatorios.
		//										- Tenga aprobadas todas las notas parciales para cargar la nota final.
				
		Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");    	  
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24));
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15)); 
        Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        Nota nota = new Nota();
        nota.setPrimerParcial(2);
        nota.setSegundoParcial(2);
        nota.setRecueperatorioPrimero(0);
        nota.setRecueperatorioSegundo(0);
        nota.setNotafinal(0);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 2));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 2));
        assertFalse (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(), 2));
        
        assertEquals (unlam.obtenerNota(alumno.getIdAlumno(), materia.getIdMateria()), nota);
	}
	
	@Test
	public void buscarLasMateriasAprobadasDeUnAlumno() {
		//Buscamos las materias que aprobo un alumno registrado a la universidad.
		//Y nos devuelve un arreglo con las materias que contengan una nota final mayor/igual a 4.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia1 = new Materia("PB2");
    	Materia materia2 = new Materia("BD1");   
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24)); //Cambiar el NOW, la fecha de ingreso es cuando el alumno entra a la universidad, no cuando se inscribe al curso.
    	CicloLectivo cicloLectivo1 = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));	
    	CicloLectivo cicloLectivo2 = new CicloLectivo(LocalDate.of(2023, 7, 20), LocalDate.of(2023, 7, 25), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 12, 1));	
    	Curso curso1 = new Curso(1, cicloLectivo1, materia1);
        Curso curso2 = new Curso(2, cicloLectivo2, materia2);
        Aula aula1 = new Aula(20);
        Aula aula2 = new Aula(20);
        ArrayList<Materia> grupoMaterias = new ArrayList<>();
        grupoMaterias.add(materia1);
        grupoMaterias.add(materia2);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        LocalDate ayer = LocalDate.of(2023, 7, 21);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia1));
        assertTrue (unlam.registrarMateria(materia2));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo1));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo2));
        assertTrue (unlam.registraCurso(curso1));
        assertTrue (unlam.registraCurso(curso2));
        assertTrue (unlam.registraAula(aula1));
        assertTrue (unlam.registraAula(aula2));
        assertTrue (unlam.asignarAulaACurso(curso1.getIdCurso(), aula1.getIdAula()));
        assertTrue (unlam.asignarAulaACurso(curso2.getIdCurso(), aula2.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso1.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso2.getIdCurso(), ayer));
        assertTrue (unlam.registrarNota(curso1.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso1.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso1.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso2.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso2.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso2.getIdCurso(),alumno.getDni(),9));
        
        assertEquals (unlam.buscarMateriasAprobadasDelAlumno(alumno.getDni()), grupoMaterias);
	} 
	
	@Test
	public void buscarNotaPorMateria() {
		//Busca la nota que tiene un alumno en una materia siempre que ambos esten registrados previamente a la universidad.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");
    	Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24));
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));	
    	Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        Nota nota = new Nota();
        nota.setPrimerParcial(9);
        nota.setSegundoParcial(9);
        nota.setNotafinal(9);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(),9));
        
        assertEquals (unlam.obtenerNota(alumno.getIdAlumno(),materia.getIdMateria()), nota);
	}
	
	@Test
	public void buscarNotaFinalPorMateria() {
		//Busca la nota FINAL que tiene un alumno en una materia siempre que ambos esten registrados previamente a la universidad.
		
		Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");
    	Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24));
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));	
    	Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        Nota nota = new Nota();
        nota.setPrimerParcial(9);
        nota.setSegundoParcial(9);
        nota.setNotafinal(9);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(),9));
        
        assertEquals (unlam.obtenerNotaFinal(alumno.getIdAlumno(), materia.getIdMateria()), nota.getNotafinal());
	}
	
	@Test
	public void obtenerMateriasQueFaltanCursarParaUnAlumno() {
		//Devuelve un arreglo de las materias ingresadas en la universidad MENOS las que el alumno ya curso.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia1 = new Materia("PB2");
    	Materia materia2 = new Materia("BD1");
    	Materia materia3 = new Materia("Disenio");
    	Materia materia4 = new Materia("Ingles");  
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24)); //Cambiar el NOW, la fecha de ingreso es cuando el alumno entra a la universidad, no cuando se inscribe al curso.
    	CicloLectivo cicloLectivo1 = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));	
    	CicloLectivo cicloLectivo2 = new CicloLectivo(LocalDate.of(2023, 7, 20), LocalDate.of(2023, 7, 25), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 12, 1));	
    	Curso curso1 = new Curso(1, cicloLectivo1, materia1);
        Curso curso2 = new Curso(2, cicloLectivo2, materia2);
        Aula aula1 = new Aula(20);
        Aula aula2 = new Aula(20);
        ArrayList<Materia> grupoMaterias = new ArrayList<>();
        grupoMaterias.add(materia3);
        grupoMaterias.add(materia4);
        ArrayList<Materia> grupoMaterias2 = new ArrayList<>();
        grupoMaterias2.add(materia1);
        grupoMaterias2.add(materia2);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        LocalDate ayer = LocalDate.of(2023, 7, 21);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia1));
        assertTrue (unlam.registrarMateria(materia2));
        assertTrue (unlam.registrarMateria(materia3));
        assertTrue (unlam.registrarMateria(materia4));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo1));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo2));
        assertTrue (unlam.registraCurso(curso1));
        assertTrue (unlam.registraCurso(curso2));
        assertTrue (unlam.registraAula(aula1));
        assertTrue (unlam.registraAula(aula2));
        assertTrue (unlam.asignarAulaACurso(curso1.getIdCurso(), aula1.getIdAula()));
        assertTrue (unlam.asignarAulaACurso(curso2.getIdCurso(), aula2.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso1.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso2.getIdCurso(), ayer));
        assertTrue (unlam.registrarNota(curso1.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso1.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso1.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso2.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso2.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso2.getIdCurso(),alumno.getDni(),9));
        
        assertEquals (grupoMaterias, unlam.obtenerMateriasQueFaltanCursarParaUnAlumno(alumno.getIdAlumno()));
        assertNotEquals (grupoMaterias2, unlam.obtenerMateriasQueFaltanCursarParaUnAlumno(alumno.getIdAlumno()));
	}
	
	@Test
	public void verPromedio() {
		//Devuelve el promedio sumando el valor de la nota final de las 
		//materias que el alumno aprobo y lo divide por la cantidad total de estas.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia1 = new Materia("PB2");
    	Materia materia2 = new Materia("BD1");
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24)); //Cambiar el NOW, la fecha de ingreso es cuando el alumno entra a la universidad, no cuando se inscribe al curso.
    	CicloLectivo cicloLectivo1 = new CicloLectivo(LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15));	
    	CicloLectivo cicloLectivo2 = new CicloLectivo(LocalDate.of(2023, 7, 20), LocalDate.of(2023, 7, 25), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 12, 1));	
    	Curso curso1 = new Curso(1, cicloLectivo1, materia1);
        Curso curso2 = new Curso(2, cicloLectivo2, materia2);
        Aula aula1 = new Aula(20);
        Aula aula2 = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        LocalDate ayer = LocalDate.of(2023, 7, 21);
        Double valorComparativo = 7.5;
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia1));
        assertTrue (unlam.registrarMateria(materia2));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo1));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo2));
        assertTrue (unlam.registraCurso(curso1));
        assertTrue (unlam.registraCurso(curso2));
        assertTrue (unlam.registraAula(aula1));
        assertTrue (unlam.registraAula(aula2));
        assertTrue (unlam.asignarAulaACurso(curso1.getIdCurso(), aula1.getIdAula()));
        assertTrue (unlam.asignarAulaACurso(curso2.getIdCurso(), aula2.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso1.getIdCurso(), hoy));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso2.getIdCurso(), ayer));
        assertTrue (unlam.registrarNota(curso1.getIdCurso(),alumno.getDni(),9));
        assertTrue (unlam.registrarNota(curso1.getIdCurso(),alumno.getDni(),8));
        assertTrue (unlam.registrarNota(curso1.getIdCurso(),alumno.getDni(),8));
        assertTrue (unlam.registrarNota(curso2.getIdCurso(),alumno.getDni(),7));
        assertTrue (unlam.registrarNota(curso2.getIdCurso(),alumno.getDni(),7));
        assertTrue (unlam.registrarNota(curso2.getIdCurso(),alumno.getDni(),7));
        
        assertEquals (unlam.calcularPromedio(alumno.getIdAlumno()), valorComparativo);
	}
}