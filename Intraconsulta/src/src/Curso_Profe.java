package src;

import java.util.ArrayList;
import java.util.Objects;

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
		
	@Override
	public int hashCode() {
		return Objects.hash(idCursoProfesor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso_Profe other = (Curso_Profe) obj;
		return Objects.equals(idCursoProfesor, other.idCursoProfesor);
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

	public static void setContador(Integer contador) {
		Curso_Profe.contador = contador;
	}	
	
}
