package src;

import java.util.ArrayList;

public class Universidad {
	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<Profesor> profesores;
	private ArrayList<Aula> aulas;
	private ArrayList<Curso> cursos;
	private ArrayList<CicloLectivo> ciclosLectivos;
	//private ArrayList<Curso_Profe> relacionCursoProfe;
	private ArrayList<Curso_Alumno> relacionCursoAlumno;
	
	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.relacionCursoAlumno = new ArrayList<>();
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
		
		if(materias.contains(materia)) {
			return false;
		}else {
			materias.add(materia);
			return true;
		}
		
	}

	public boolean registraAlumno(Alumno alumno) {
	
		if(alumnos.contains(alumno)) {
			return false;
		}else {
			alumnos.add(alumno);
			return true;
		}
	}

	public boolean registraProfesor(Profesor profesor) {
		if(profesores.contains(profesor)) {
			return false;
		}else {
			profesores.add(profesor);
			return true;
		}
	}

	public boolean registraAula(Aula aula) {
		if(aulas.contains(aula)) {
			return false;
		}else {
			aulas.add(aula);
			return true;
		}
	}
	
	private boolean existeOtroCursoConMateriaCicloYTurnoIgual(Curso curso) {
		Materia materia = curso.getMateria();
		CicloLectivo cicloLectivo = curso.getCicloLectivo();
		Integer turno = curso.getTurno();
		
		for (Curso cursoRecorrido : cursos) {
			if ((cursoRecorrido.getMateria().getIdMateria() ==  materia.getIdMateria()) && (cursoRecorrido.getTurno() == turno) && (cursoRecorrido.getCicloLectivo().getIdCicloLectivo() == cicloLectivo.getIdCicloLectivo())) {
				return true;
			}
		}
		return false;
	}

	public boolean registraCurso(Curso curso) {
		
		if(cursos.contains(curso) || existeOtroCursoConMateriaCicloYTurnoIgual(curso)) {
			return false;
		}else {
			cursos.add(curso);
			return true;
		}
	}

	public boolean registraCicloLectivo(CicloLectivo cicloLectivo) {
		if(ciclosLectivos.contains(cicloLectivo)) {
			return false;
		}else {
			ciclosLectivos.add(cicloLectivo);
			return true;
		}
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
	
	private Alumno buscarAlumnoPorDni(Integer dniAlumno) {
		for (Alumno alumno : alumnos) {
			if (alumno.getDni() == dniAlumno) {
				return alumno;
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

//	public Curso_Alumno inscribirAlumnoACurso(Integer dniAlumno, Integer idCurso) {
//		Alumno alumno = buscarAlumnoPorDni(dniAlumno);
//		Curso curso = buscarCursoPorId(idCurso);
//		LocalDate hoy = LocalDate.now();
//		
//		// Verificar que el alumno y el curso este dado de alta
//		if(alumno != null && curso != null) {
//			Curso_Alumno cursoAlumno = new Curso_Alumno(curso);
//			
//			//No se puede inscribir Alumnos si este no tiene al 
//			//menos cursada todas las correlativas (Todas las correlativas Con nota >=4
//			if(alumno.getAprobadas().containsAll(curso.getMateria().getCorrelativas()) 
//					
//					//La inscripción no se puede realizar si esta fuera de fecha Inscripción
//					&& (curso.getCicloLectivo().getFechaInicioInscripcion().isAfter(hoy) && curso.getCicloLectivo().getFechaFinalizacionInscripcion().isBefore(hoy)) 
//					
//					//No se puede inscribir el alumno si excede la cantidad de alumnos permitos en el aula
//					&& (cursoAlumno.getAlumnos().size() < (curso.getAula().getCapacidad())) 
//					
//					// No se puede inscribir el Alumno si ya está inscripto a otro curso para el mismo día y Turno
//					//CONSIDERO QUE HAY QUE HACER UN ARRAY TIPO CURSO EN ALUMNO QUE GUARDE A QUE CURSOS SE INSCRIBIO
//					&& ()) {
//				
//				cursoAlumno.getAlumnos().add(alumno);
//			}
//			return cursoAlumno;
//		}
//		return null;
//	}

	
	
	
	
}
