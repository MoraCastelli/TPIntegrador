package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

public class Universidad {
	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<Profesor> profesores;
	private ArrayList<Aula> aulas;
	private ArrayList<Curso> cursos;
	private ArrayList<CicloLectivo> ciclosLectivos;
	private ArrayList<Curso_Profe> relacionCursoProfesor;
	private ArrayList<Curso_Alumno> relacionCursoAlumno;
	
	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.relacionCursoAlumno = new ArrayList<>();
		this.relacionCursoProfesor = new ArrayList<>();
		this.ciclosLectivos = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}

	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean registrarMateria(Materia materia) {
		
		if(!(materias.isEmpty()) && materias.contains(materia)) {
			return false;
		}else {
			materias.add(materia);
			return true;
		}
		
	}

	public boolean registrarAlumno(Alumno alumno) {
	
		if(!(alumnos.isEmpty()) && alumnos.contains(alumno)) {
			return false;
		}else {
			alumnos.add(alumno);
			return true;
		}
	}
	
	public boolean registrarCicloLectivo(CicloLectivo cicloLectivo) {
		if(!(ciclosLectivos.isEmpty()) && (ciclosLectivos.contains(cicloLectivo) || (seSuperponenFechas(cicloLectivo)))) {
			return false;
		}else {
			ciclosLectivos.add(cicloLectivo);
			return true;
		}
	}
	
	
	private boolean seSuperponenFechas(CicloLectivo cicloLectivo) {
		
		return !(ciclosLectivos.get(ciclosLectivos.size()-1).getFechaFinalizacionCicloLectivo().isBefore(cicloLectivo.getFechaInicioInscripcion()));
	}
	


	public boolean registrarProfesor(Profesor profesor) {
		if(!(profesores.isEmpty()) && profesores.contains(profesor)) {
			return false;
		}else {
			profesores.add(profesor);
			return true;
		}
	}

	public boolean registraAula(Aula aula) {
		if(!(aulas.isEmpty()) && aulas.contains(aula)) {
			return false;
		}else {
			aulas.add(aula);
			return true;
		}
	}
	
	public boolean registraCurso(Curso curso) {
		if(!(cursos.isEmpty()) && cursos.contains(curso)) {
			return false;
		}else {
			cursos.add(curso);
			return true;
		}
	}
	
	private Alumno buscarAlumnoPorDni(Integer dniAlumno) {
		for (Alumno alumno : alumnos) {
			if (alumno.getDni() == dniAlumno) {
				return alumno;
			}
		}
		return null;
	}
	
	private Profesor buscarProfesorPorDni(Integer dniProfesor) {
		for (Profesor profesor : profesores) {
			if (profesor.getDni() == dniProfesor) {
				return profesor;
			}
		}
		return null;
	}
	
	private Curso buscarCursoPorId(Integer idCurso) {
		for (Curso curso : cursos) {
			if(curso.getIdCurso() == idCurso) {
				return curso;
			}
		}
		return null;
	}
	
	public boolean cargarRelacionCursoProfesor (Curso_Profe cursoProfesor) {
		if(!(relacionCursoProfesor.isEmpty()) && relacionCursoProfesor.contains(cursoProfesor)) {
			return false;
		}else {
			relacionCursoProfesor.add(cursoProfesor);
			return true;
		}
	}
	
	public boolean cargarCursoProfesor(Integer idCurso, Integer dniProfesor) {
		Profesor profesor = buscarProfesorPorDni(dniProfesor);
		Curso curso = buscarCursoPorId(idCurso);
		Integer contador = 0;
		
		if(profesor != null && curso != null) {
			for (Curso_Alumno cursoAlumno : relacionCursoAlumno) {
				if(cursoAlumno.getCurso().equals(curso)) {
					contador++;
				}
			}
		}if(contador<=20) {
			Curso_Profe cursoProfesor = new Curso_Profe(curso, profesor);
			if(cargarRelacionCursoProfesor (cursoProfesor)) {
				 return true;
			}
        }
		return false;
	}
	
	private Materia buscarMateriaPorId(Integer idMateria) {
		for (Materia materia : materias) {
			if (materia.getIdMateria() == idMateria) {
				return materia;
			}
		}
		return null;
	}
	

	
	public boolean asignarCorrelativa(Integer idMateria, Integer idMateriaCorrelativa) {
		
		Materia materia = buscarMateriaPorId(idMateria);
		Materia materiaCorrelativa = buscarMateriaPorId(idMateriaCorrelativa);
		
		if(materia != null && materiaCorrelativa != null) {
			if(!(materia.getCorrelativas().isEmpty()) && materia.getCorrelativas().contains(materiaCorrelativa)) {
				return false;
			}else {
				materia.getCorrelativas().add(materiaCorrelativa);
				return true;
			}
		}
		return false;
	}

	public boolean eliminarCorrelativa(Integer idMateria, Integer idMateriaCorrelativa) {
		
		Materia materia = buscarMateriaPorId(idMateria);
		Materia materiaCorrelativa = buscarMateriaPorId(idMateriaCorrelativa);
		
		if(materia != null && materiaCorrelativa != null) {
			if(!(materia.getCorrelativas().isEmpty()) && materia.getCorrelativas().contains(materiaCorrelativa)) {
				return materia.getCorrelativas().remove(materiaCorrelativa);
			}
		}return false;
	}
	
	private Aula buscarAulaPorId(Integer idAula) {
		for (Aula aula : aulas) {
			if(aula.getIdAula() == idAula) {
				return aula;
			}
		}
		return null;
	}
	
	public boolean asignarAulaACurso(Integer idCurso, Integer idAula) {
		Aula aula = buscarAulaPorId(idAula);
		Curso curso = buscarCursoPorId(idCurso);
		Integer contador = 0;
		
		if(aula != null && curso != null) {
			for (Curso_Alumno cursoAlumno : relacionCursoAlumno) { 
				if(cursoAlumno.getCurso().equals(curso)) {
					contador++;
				}
			}
		}if(contador <= aula.getCantidadAlumnos()) {
			curso.setAula(aula);
			return true;
        }
		return false;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	//*****************A PARTIR DE ACA ES NUEVO CODIGO*********************//
	
	
	public boolean inscribirUnAlumnoACurso(Integer dniAlumno, Integer idCurso) {
		
		Alumno alumno = buscarAlumnoPorDni(dniAlumno);
		Curso curso = buscarCursoPorId(idCurso);	
		
		Nota nota = new Nota(0,0,0,0); //REVISAR ESTA LINEA, PORQUE HAY QUE PONER UNA NOTA POR DEFAULT
		
		if(alumno != null && curso != null) {
			Curso_Alumno cursoAlumno = new Curso_Alumno(curso, alumno, nota);
			if(cargarRelacionCursoAlumno(cursoAlumno)) {			
				return true;
			}	
		}
		return false;	
	}
	
	public boolean cargarRelacionCursoAlumno (Curso_Alumno cursoAlumno) {
		if(!(relacionCursoAlumno.isEmpty()) && relacionCursoAlumno.contains(cursoAlumno)) {
			return false;
		}else {
			relacionCursoAlumno.add(cursoAlumno);
			return true;
		}
	}
	
	private Curso_Alumno buscarCursoAlumno(Integer idCurso, Integer dniAlumno) {
		
		for(Curso_Alumno cursoAlumno : relacionCursoAlumno) {
			if((cursoAlumno.getCurso().getIdCurso() == idCurso) && (cursoAlumno.getAlumno().getIdAlumno() == dniAlumno)) {
				return cursoAlumno;
			}
		}			
		return null;
	}
	
	public boolean registrarNotaPrimerParcial(Integer idCurso, Integer dniAlumno, Integer notaPrimerParcial) {
		
		Curso_Alumno cursoAlumno = buscarCursoAlumno(idCurso,dniAlumno);
		Nota nota = cursoAlumno.getNota();
		
		if(notaPrimerParcial >= 1 && notaPrimerParcial <= 10) {
			nota.setPrimerParcial(notaPrimerParcial);
			cursoAlumno.setNota(nota);
			return true;
		}	
		return false;
	}
	
	public boolean registrarNotaSegundoParcial(Integer idCurso, Integer dniAlumno, Integer notaSegundoParcial) {
		
		Curso_Alumno cursoAlumno = buscarCursoAlumno(idCurso,dniAlumno);
		Nota nota = cursoAlumno.getNota();
		
		if(notaSegundoParcial >= 1 && notaSegundoParcial <= 10) {
			nota.setSegundoParcial(notaSegundoParcial);
			cursoAlumno.setNota(nota);
			return true;
		}	
		return false;
	}
	
	public boolean registrarNotaPrimerRecuperatorio(Integer idCurso, Integer dniAlumno, Integer notaPrimerRecuperatorio) {
		
		Curso_Alumno cursoAlumno = buscarCursoAlumno(idCurso,dniAlumno);
		Nota nota = cursoAlumno.getNota();
		
		if(notaPrimerRecuperatorio >= 1 && notaPrimerRecuperatorio <= 10 && nota.getRecueperatorio() == null) {
		//if(notaPrimerRecuperatorio >= 1 && notaPrimerRecuperatorio <= 10 && (nota.getPrimerRecueperatorio() == null && nota.getSegundoRecuperatorio() == null) {
			nota.setRecueperatorio(notaPrimerRecuperatorio);
			//nota.setPrimerRecuperatorio(notaPrimerRecuperatorio);
			cursoAlumno.setNota(nota);
			return true;
		}	
		return false;
	}
	
	public boolean registrarNotaSegundoRecuperatorio(Integer idCurso, Integer dniAlumno, Integer notaSegundoRecuperatorio) {
		
		Curso_Alumno cursoAlumno = buscarCursoAlumno(idCurso,dniAlumno);
		Nota nota = cursoAlumno.getNota();
		
		if(notaSegundoRecuperatorio >= 1 && notaSegundoRecuperatorio <= 10 && nota.getRecueperatorio() == null) {
		//if(notaSegundoRecuperatorio >= 1 && notaSegundoRecuperatorio <= 10 && (nota.getPrimerRecueperatorio() == null && nota.getSegundoRecuperatorio() == null) {
			nota.setRecueperatorio(notaSegundoRecuperatorio);
			//nota.setSegundoRecuperatorio(notaSegundoRecuperatorio);
			cursoAlumno.setNota(nota);
			return true;
		}	
		return false;
	}
	
	public boolean registrarNotaFinal(Integer idCurso, Integer dniAlumno, Integer notaFinal) {
		
		Curso_Alumno cursoAlumno = buscarCursoAlumno(idCurso,dniAlumno);
		Nota nota = cursoAlumno.getNota();
		Materia materia = buscarMateriaPorCurso(idCurso);
		//Alumno alumno = cursoAlumno.getAlumno();
		ArrayList<Materia> materiasAprobadas = buscarMateriasAprobadasDelAlumno(dniAlumno);
		boolean promociona = buscarQueEstenAprobadasTodasLasCorrelativasDeUnaMateria(materia,materiasAprobadas);
		
		if(notaFinal >= 1 && notaFinal <= 10 && (nota.getPrimerParcial() >= 4 && nota.getSegundoParcial() >= 4) && (promociona)) { //HAY QUE HACER UN SWITCH CASE CON TODAS LAS POSIBILIDADES
			nota.setNotafinal(notaFinal);
			cursoAlumno.setNota(nota);
			return true;
		}	
		return false;
	}

	private ArrayList<Materia> buscarMateriasAprobadasDelAlumno(Integer dniAlumno) {
		ArrayList<Materia> materiasAprobadas = new ArrayList<>();
		for(Curso_Alumno cursoAlumno : relacionCursoAlumno) {
			if(!(cursoAlumno.getNota().getNotafinal() == null) && (cursoAlumno.getNota().getNotafinal() >= 7)) {
				Materia materia = buscarMateriaPorCurso(cursoAlumno.getCurso().getIdCurso());
				materiasAprobadas.add(materia);
			}
		}
		return materiasAprobadas;
	}

	private Materia buscarMateriaPorCurso(Integer idCurso) {
		for(Curso curso : cursos) {
			if(curso.getIdCurso() == idCurso) {
				return curso.getMateria();
			}
		}
		return null;
	}
	
	private boolean buscarQueEstenAprobadasTodasLasCorrelativasDeUnaMateria(Materia materia,ArrayList<Materia> materiasAprobadas) {
		if(materia.getCorrelativas().isEmpty()) {
			return true;
		}
		return materiasAprobadas.containsAll(materia.getCorrelativas());
	}

	//**********************************************************************************************//
	public Curso_Alumno inscribirAlumnoACurso(Integer dniAlumno, Integer idCurso) {
		Alumno alumno = buscarAlumnoPorDni(dniAlumno);
		Curso curso = buscarCursoPorId(idCurso);
		LocalDate hoy = LocalDate.now();
		
		// Verificar que el alumno y el curso este dado de alta
		if(alumno != null && curso != null) {
			Curso_Alumno cursoAlumno = new Curso_Alumno(curso);
			
			//No se puede inscribir Alumnos si este no tiene al 
			//menos cursada todas las correlativas (Todas las correlativas Con nota >=4)
			if(alumno.getAprobadas().containsAll(curso.getMateria().getCorrelativas()) 
					
					//La inscripción no se puede realizar si esta fuera de fecha Inscripción
					&& (curso.getCicloLectivo().getFechaInicioInscripcion().isAfter(hoy) && curso.getCicloLectivo().getFechaFinalizacionInscripcion().isBefore(hoy)) 
					
					//No se puede inscribir el alumno si excede la cantidad de alumnos permitos en el aula
					&& (curso.getAlumnosMateria(curso.getMateria()).size() < (curso.getAula().getCapacidad())) 
					
					// No se puede inscribir el Alumno si ya está inscripto a otro curso para el mismo día y Turno
					&& !(curso.getTurno().equals(buscarTurnoCurso(alumno)))) {
				
				cursoAlumno.getAlumnos().add(alumno);
			}
			return cursoAlumno;
		}
		return null;
	}

	

	


	

	
	
	
	
}
