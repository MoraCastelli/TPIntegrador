package src;

import java.util.ArrayList;

public class Curso_Profe {
	private Integer idCursoProfesor;
	private Curso curso;
	private ArrayList<Profesor> profesor;
	
	private static Integer contador = 0;
	
	public Curso_Profe(Curso curso, ArrayList<Profesor> profesor) {
		super();
		this.curso = curso;
		this.profesor = profesor;
		this.idCursoProfesor = contador++;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public ArrayList<Profesor> getProfesor() {
		return profesor;
	}
	public void setProfesor(ArrayList<Profesor> profesor) {
		this.profesor = profesor;
	}
	
	
}
