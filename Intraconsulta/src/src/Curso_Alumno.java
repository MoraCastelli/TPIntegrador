package src;

import java.util.Objects;

public class Curso_Alumno {
	private Integer idCursoAlumno;
	private Alumno alumno;
	private Nota nota = new Nota(0,0,0,0);
	private Curso curso;
	
	private static Integer contador = 0;
	
	public Curso_Alumno(Curso curso, Alumno alumno) {
		this.curso = curso;
		this.alumno = alumno;
		this.idCursoAlumno = contador++;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idCursoAlumno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso_Alumno other = (Curso_Alumno) obj;
		return Objects.equals(idCursoAlumno, other.idCursoAlumno);
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public static void setContador(Integer contador) {
		Curso_Alumno.contador = contador;
	}
	
}
