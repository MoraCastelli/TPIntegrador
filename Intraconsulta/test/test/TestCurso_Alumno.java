package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.Alumno;
import src.Aula;
import src.CicloLectivo;
import src.Curso;
import src.Curso_Alumno;
import src.Materia;
import src.Universidad;

public class TestCurso_Alumno {
	
	@Test
	public void relacionarCursoConCurso_Alumno() {
		
		String nombreUni = "Unlam";
    	Universidad unlam = new Universidad (nombreUni);
    	Integer turno = 1;
    	Integer dia = 1;
    	Integer capacidad = 30;
        Integer codigoAula = 15;
        String nombreMat = "PB2";
        Integer codigoMat = 1;
    	CicloLectivo cicloLectivo = new CicloLectivo(1,20230606);
    	Materia materia = new Materia(nombreMat, codigoMat);
        Aula aula = new Aula(capacidad, codigoAula);
        Curso curso = new Curso(turno, dia, cicloLectivo, materia, aula);
        Curso_Alumno cursoAlumno = new Curso_Alumno(curso);
        assertNotNull(cursoAlumno);
	}
	
	@Test
	public void cargarAlumnoEnCurso_Alumno() {
		
		String nombreUni = "Unlam";
    	Universidad unlam = new Universidad (nombreUni);
    	
    	Integer turno = 1;
    	Integer dia = 1;
    	Integer capacidad = 30;
        Integer codigoAula = 15;
        String nombreMat = "PB2";
        Integer codigoMat = 1;
        
    	CicloLectivo cicloLectivo = new CicloLectivo(1,20230606);
    	Materia materia = new Materia(nombreMat, codigoMat);
        Aula aula = new Aula(capacidad, codigoAula);
        Curso curso = new Curso(turno, dia, cicloLectivo, materia, aula);
        
        boolean resultado = unlam.registraCurso(curso);
        Curso_Alumno cursoAlumno = new Curso_Alumno(curso);
        
        String nombreAlumno = "Lucas1";
    	String apellidoAlumno = "Lilla";
        Integer dni = 42817472;
        Alumno alumno = new Alumno (dni,nombreAlumno, apellidoAlumno);
        boolean alumno1Registrado = unlam.registraAlumno(alumno);
        
        assertTrue(resultado);
        assertTrue(alumno1Registrado);
        assertTrue(cursoAlumno.registraAlumno(alumno, unlam));
	}
	
}
