package src;

import java.util.Objects;

public class Curso_Profe {
	@SuppressWarnings("unused")
	private Integer idCursoProfesor;
	private Curso curso;
	private Profesor profesor;
	
	private static Integer contador = 0;
	
	public Curso_Profe(Curso curso, Profesor profesor) {
		super();
		this.curso = curso;
		this.profesor = profesor;
		this.idCursoProfesor = contador++;
	}

	@Override
	public int hashCode() {
		return Objects.hash(curso, profesor);
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
		return Objects.equals(curso, other.curso) && Objects.equals(profesor, other.profesor);
	}



	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public static void setContador(Integer contador) {
		Curso_Profe.contador = contador;
	}	
	
}
