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
		//Agregamos un alumno a la universidad. El metodo registrarAlumno verifica que no este duplicado y lo asigna.
			
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
		
		String nombreUniversidad = "Unlam";
    	Universidad unlam = new Universidad (nombreUniversidad);
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
		//Intentamos agregar 2 ciclo lectivo con las mismas fechas y verificamos que no se pueda registrar debido a que serian valores duplicados.

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
		//Intentamos agregar un aula a la universidad. El método registrarAula verifica que no este duplicado pero como ya se reistro no lo asigna.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
        Aula aula = new Aula(30);
        
        assertTrue (unlam.registraAula(aula));
        assertFalse (unlam.registraAula(aula));
	}
	
	@Test
	public void crearCurso() {
		//Agregamos un curso a la universidad. El método registrarCurso verifica que no este duplicado y lo asigna.
    	
        Universidad unlam = new Universidad ("Unlam");
        unlam.reiniciarContadores();
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        
        assertTrue (unlam.registraCurso(curso));
	}
	
	@Test
	public void noCrearCursoSiYaExiste() {
		//Intentamos agregar un curso a la universidad. El método registrarCurso verifica que no este duplicado pero como ya se reistro no lo asigna.
		
		Universidad unlam = new Universidad ("Unlam");
		unlam.reiniciarContadores();
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        
        assertTrue (unlam.registraCurso(curso));
        assertFalse (unlam.registraCurso(curso));
	}
	
	@Test
	public void crear2Curso() {
		//Agregamos dos curso a la universidad. El método registrarCurso verifica que no esten duplicados y los asigna.
		
		Universidad unlam = new Universidad ("Unlam");
		unlam.reiniciarContadores();
    	CicloLectivo cicloLectivo1 = new CicloLectivo(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13));
    	Materia materia1 = new Materia("PB2");
        Curso curso1 = new Curso(1, cicloLectivo1, materia1);
        
        CicloLectivo cicloLectivo2 = new CicloLectivo(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13));
    	Materia materia2 = new Materia("PB2");
        Curso curso2 = new Curso(1, cicloLectivo2, materia2);
        
        assertTrue (unlam.registraCurso(curso1));
        assertTrue (unlam.registraCurso(curso2));
	}
	
	
	
	@Test//asignarDocentesAComision()
	public void agregarRelacionProfesorCurso() {
		//Agregamos un objeto CursoProfesor a el array relacionCursoProfesor de la universidad. El método cargarRelacionCursoProfesor verifica que no este duplicado y se lo asigna.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        Curso_Profe cursoProfesor = new Curso_Profe(curso, profesor);
    	
    	assertTrue (unlam.cargarRelacionCursoProfesor(cursoProfesor));
	}
	
	@Test//asignarDocentesAComision()
	public void noAgregarRelacionProfesorCursoSiYaExiste() {
		//Intentamos agregar un objeto CursoProfesor a el array relacionCursoProfesor de la universidad. El método cargarRelacionCursoProfesor verifica que no este duplicado pero como ya se reistro no lo asigna.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
    	CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        Curso_Profe cursoProfesor = new Curso_Profe(curso, profesor);
    	
    	assertTrue (unlam.cargarRelacionCursoProfesor(cursoProfesor));
    	assertFalse (unlam.cargarRelacionCursoProfesor(cursoProfesor));
	}
	
	@Test//asignarProfesorALaComision(idComision, dniDocente)
	public void asignarProfesorACurso() {
		//Asignamos un profesor a un curso de la universidad. El método cargarCursoProfesor verifica que el profesor y el curso pertenezcan a la universidad.
		//Carga un profesor cada 20 alumnos.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
        CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registrarProfesor(profesor));
    	
    	assertTrue (unlam.cargarCursoProfesor(curso.getIdCurso(), profesor.getDni()));
	}
	
	@Test
	public void noAsignarProfesorACursoSiSuperaLos20Alumnos() {
				
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
        CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13));
    	Materia materia = new Materia("PB2");
    	Alumno alumno = new Alumno (42817472,"Lucas", "Lilla", LocalDate.of(2022, 2, 28), LocalDate.of(2000, 10, 24)); 
        Aula aula = new Aula(20);
        LocalDate hoy = LocalDate.of(2023, 3, 10);
        Curso curso = new Curso(1, cicloLectivo, materia);
        Curso_Alumno cursoAlumno = new Curso_Alumno();
        
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registrarProfesor(profesor));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
    	
    	assertTrue (unlam.cargarCursoProfesor(curso.getIdCurso(), profesor.getDni()));	   
       
        assertTrue (unlam.cargarRelacionCursoAlumno(cursoAlumno));
        
        
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
	}
	
	@Test//asignarProfesorALaComision(idComision, dniDocente)
	public void noAsignarProfesorACursoSiYaExiste() {
		//Intentamos agregar un profesor a un curso de la universidad. El método cargarCursoProfesor verifica que el profesor y el curso pertenezcan a la universidad.
		//Carga un profesor cada 20 alumnos.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
        CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registrarProfesor(profesor));
    	
    	assertTrue (unlam.cargarCursoProfesor(curso.getIdCurso(), profesor.getDni()));
    	assertFalse (unlam.cargarCursoProfesor(curso.getIdCurso(), profesor.getDni()));
	}
	
	@Test//asignarProfesorAlaComision(idComision, dniDocente)
	public void noAsignarProfesorACursoSiNoExisteElCurso() {
		//Intentamos agregar un profesor a un curso de la universidad. El método cargarCursoProfesor verifica que el profesor y el curso pertenezcan a la universidad.
		//Carga un profesor cada 20 alumnos.
		
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Profesor profesor = new Profesor (42653314,"Mora", "Castelli");
        CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13));
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
        CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13));
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
        CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 3, 3), LocalDate.of(2023, 3, 13));
    	Materia materia = new Materia("PB2");
        Curso curso = new Curso(1, cicloLectivo, materia);
        Aula aula = new Aula(30);
        
        assertTrue (unlam.registraAula(aula));        
        assertFalse (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
    }
		
	@Test
	public void inscribirAlumnoACurso() {
		
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
	public void noInscribirAlAlumnoSiEstaFueraDeLaFechaDEInscripcion() {
		
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
    	Universidad unlam = new Universidad ("Unlam");
    	unlam.reiniciarContadores();
    	Materia materia = new Materia("PB2");
        Alumno alumno = new Alumno(42817472,"Lucas", "Lilla", LocalDate.now(), LocalDate.of(2000, 10, 24)); 
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
	
	//******************************************************************************************//
	
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
        LocalDate hoy = LocalDate.of(2023, 3, 10);
              
        assertTrue (unlam.registrarAlumno(alumno));
        assertTrue (unlam.registrarMateria(materia));
        assertTrue (unlam.registrarCicloLectivo(cicloLectivo));
        assertTrue (unlam.registraCurso(curso));
        assertTrue (unlam.registraAula(aula));
        assertTrue (unlam.asignarAulaACurso(curso.getIdCurso(), aula.getIdAula()));
        assertTrue (unlam.inscribirUnAlumnoACurso(alumno.getDni(), curso.getIdCurso(), hoy));
        
        assertTrue (unlam.registrarNota(curso.getIdCurso(),alumno.getDni(),notaPrimerParcial));

	}
	
	@Test
	public void buscarLasMateriasAprobadasDeUnAlumno() {
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
        Nota nota = new Nota();
        nota.setPrimerParcial(9);
        nota.setSegundoParcial(9);
        nota.setNotafinal(9);
              
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
        
        assertEquals ( unlam.obtenerNota(alumno.getIdAlumno(), materia1.getIdMateria()), nota);
	}
	
	@Test
	public void buscarDosNotasPorMateria() {
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
        Nota nota = new Nota();
        nota.setPrimerParcial(9);
        nota.setSegundoParcial(9);
        nota.setNotafinal(9);
              
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
        
        assertEquals ( unlam.obtenerNota(alumno.getIdAlumno(), materia1.getIdMateria()), unlam.obtenerNota(alumno.getIdAlumno(), materia2.getIdMateria()));
	}
	
	@Test
	public void buscarNotaFinalPorMateria() {
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
        Nota nota = new Nota();
        nota.setNotafinal(9);
              
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
        
        assertEquals ( unlam.obtenerNotaFinal(alumno.getIdAlumno(), materia1.getIdMateria()), nota.getNotafinal());
	}
	
	@Test
	public void cargarCuatrimestreYObtenerMateriasQueFaltanCursarParaUnAlumno() {
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
