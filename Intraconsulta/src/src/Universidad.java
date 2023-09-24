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
	
	private Integer alumnosEnUnCurso(Curso curso) {
		Integer contador = 0;
		
		for (Curso_Alumno cursoAlumno : relacionCursoAlumno) { 
			if(cursoAlumno.getCurso().equals(curso)) {
				contador++;
			}
		}
		return contador;
	}

	
	public boolean cargarRelacionCursoAlumno (Curso_Alumno cursoAlumno) {
		if(!(relacionCursoAlumno.isEmpty()) && relacionCursoAlumno.contains(cursoAlumno)) {
			return false;
		}else {
			relacionCursoAlumno.add(cursoAlumno);
			return true;
		}
	}
	
	private boolean buscarQueEstenAprobadasTodasLasCorrelativasDeUnaMateria(Materia materia,ArrayList<Materia> materiasAprobadas) {
		if(materia.getCorrelativas().isEmpty()) {
			return true;
		}
		return materiasAprobadas.containsAll(materia.getCorrelativas());
	}
	
	public ArrayList<Materia> buscarMateriasAprobadasDelAlumno(Integer dniAlumno) {
		ArrayList<Materia> materiasAprobadas = new ArrayList<>();
		
		for(Curso_Alumno cursoAlumno : relacionCursoAlumno) {
			if((cursoAlumno.getNota().getNotafinal() != null) && (cursoAlumno.getNota().getNotafinal() >= 4) && (cursoAlumno.getAlumno().getDni() == dniAlumno)) {
				/// NO TIENE NOTA FINAL
				Materia materia = cursoAlumno.getCurso().getMateria();
				
				materiasAprobadas.add(materia);
			}
		}
		return materiasAprobadas;
	}
	
	
	
	public boolean inscribirUnAlumnoACurso(Integer dniAlumno, Integer idCurso, LocalDate hoy) {
		
		Alumno alumno = buscarAlumnoPorDni(dniAlumno);
		Curso curso = buscarCursoPorId(idCurso);
		Materia materia = buscarMateriaPorCurso(idCurso);
		Nota nota = new Nota();
		
		if(alumno != null && curso != null 
				&& buscarQueEstenAprobadasTodasLasCorrelativasDeUnaMateria(materia, buscarMateriasAprobadasDelAlumno(dniAlumno)) 
				&& (curso.getCicloLectivo().getFechaInicioInscripcion().isBefore(hoy) && curso.getCicloLectivo().getFechaFinalizacionInscripcion().isAfter(hoy)) 
				&& (alumnosEnUnCurso(curso) < (curso.getAula().getCantidadAlumnos())) 
				&& buscarTurnosCoincidentes(alumno, curso) 
				&& !(buscarMateriasAprobadasDelAlumno(dniAlumno).contains(materia))) {
	
			Curso_Alumno cursoAlumno = new Curso_Alumno(curso, alumno, nota);
			return cargarRelacionCursoAlumno(cursoAlumno);
		}
		return false;	
	}

	private boolean buscarTurnosCoincidentes(Alumno alumno, Curso curso) {
		for (Curso_Alumno cursoAlumno : relacionCursoAlumno) {
			if(cursoAlumno.getAlumno().equals(alumno) && cursoAlumno.getCurso().getTurno() == curso.getTurno()) {
				return false;
			}
		}
		return true;
	}

	private Curso_Alumno buscarCursoAlumno(Integer idCurso, Integer dniAlumno) {
		
		for(Curso_Alumno cursoAlumno : relacionCursoAlumno) {
			if((cursoAlumno.getCurso().getIdCurso() == idCurso) && (cursoAlumno.getAlumno().getDni() == dniAlumno)) {
				return cursoAlumno;
			}
		}			
		return null;
	}
	
//no carga nota final!!!!!!!!!!!!!!!!!!!!!!
	
	//automatizamos la asignacion de recuperatorios asumiendo que promocionar es el objetivo.
	public Integer contadorDeNotas(Nota nota) {
		if (nota != null) {
			if(nota.getPrimerParcial() == 0) {
				return 1;
			}
			if(nota.getSegundoParcial() == 0) {
				return 2;
			}
			if(nota.getPrimerParcial() != 0  && nota.getPrimerParcial() < 4) {
				return 3;
			}
			if(nota.getSegundoParcial() != 0 && nota.getSegundoParcial() < 4) {
				return 4;
			}
			if((nota.getPrimerParcial() < 7 && nota.getPrimerParcial() >= 4) && (nota.getSegundoParcial() >= 7)) {
				return 3;
			}
			if((nota.getSegundoParcial() < 7 && nota.getSegundoParcial() >= 4) && (nota.getPrimerParcial() >= 7)) {
				return 4;
			}
			if((nota.getPrimerParcial() >= 4 && nota.getSegundoParcial() >= 4) && (nota.getRecueperatorioPrimero() != 0 || nota.getRecueperatorioSegundo() != 0)) {
				return 5;
			}
			if((nota.getPrimerParcial() >= 7 && nota.getSegundoParcial() >= 7)) {
				return 5;
			}
		}
		return null;
	}
	
	
	public boolean registrarNota(Integer idCurso, Integer dniAlumno, Integer numero) {
		
		Curso_Alumno cursoAlumno = buscarCursoAlumno(idCurso,dniAlumno);
		Nota nota = cursoAlumno.getNota();
		Integer identificador = contadorDeNotas(cursoAlumno.getNota());
		boolean promociona = buscarQueEstenAprobadasTodasLasCorrelativasDeUnaMateria(cursoAlumno.getCurso().getMateria(),buscarMateriasAprobadasDelAlumno(dniAlumno));
		
		if((numero >= 1 && numero <= 10)) {
			
			if(identificador != 5) {
				cursoAlumno.setNota(nota.setNotas(identificador, numero));
				return true;
				
			}if(identificador == 5 && promociona){
				cursoAlumno.setNota(nota.setNotas(identificador, numero));
				return true;
				
			}if(identificador == 5 && !promociona && numero < 7){
				cursoAlumno.setNota(nota.setNotas(identificador, numero));
				return true;
			}
		}return false;
		
	}

	private Materia buscarMateriaPorCurso(Integer idCurso) {
		for(Curso curso : cursos) {
			if(curso.getIdCurso() == idCurso) {
				return curso.getMateria();
			}
		}
		return null;
	}

	//No sabiamos si la consigna obtenerNota debia devolver una Nota o un Integer asi que hicimos los dos metodos
	public Nota obtenerNota(Integer idAlumno, Integer idMateria) {
		
		for(Curso_Alumno cursoAlumno : relacionCursoAlumno) {
			if((cursoAlumno.getCurso().getMateria().getIdMateria() == idMateria) && (cursoAlumno.getAlumno().getIdAlumno() == idAlumno)) {
				return cursoAlumno.getNota();
			}
		}			
		return null;
	}
	
	//No sabiamos si la consigna obtenerNota debia devolver una Nota o un Integer asi que hicimos los dos metodos
	public Integer obtenerNotaFinal(Integer idAlumno, Integer idMateria) {	
		if(obtenerNota(idAlumno, idMateria) != null) {
			return obtenerNota(idAlumno, idMateria).getNotafinal();
		}return 0;
	}
	
	
	//Este método nos permite reiniciar los contadores que autoincrementan los IDs en las clases.
	//Lo hicimos ya que queremos que en cada test unitario, los objetos se identifiquen empezando por el 0.
	public void reiniciarContadores() { 
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
