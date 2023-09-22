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
	
///////////////////////////////////////////////////////////////////////////
	
	public Curso_Profe cargarCursoProfesor(Integer idCurso, Integer dniProfesor) {
		Profesor profesor = buscarProfesorPorDni(dniProfesor);
		Curso curso = buscarCursoPorId(idCurso);
		Integer contador = 0;
		
		if(profesor != null && curso != null) {
			for (Curso_Alumno cursoAlumno : relacionCursoAlumno) {
				if(cursoAlumno.getCurso().equals(curso)) {
					contador++;
					//hasta aca llegamos
				}
			}
		}
		 Curso_Profe cursoProfesor = new Curso_Profe(curso, profesor);
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
			if(materia.getCorrelativas().contains(materiaCorrelativa)) {
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
			return materia.getCorrelativas().remove(materiaCorrelativa);
		}
		return false;
	}

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

	private Integer buscarTurnoCurso(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	


	

	
	
	
	
}
