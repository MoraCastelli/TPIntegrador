package src;

public class Curso_Alumno {
	private Integer idCursoAlumno;
	private Alumno alumno;
	private Nota nota;
	private Curso curso;
	
	private static Integer contador = 0;
	
	public Curso_Alumno(Curso curso) {
		this.alumno = alumno;
		this.nota = nota;
		this.curso = curso;
		this.idCursoAlumno = contador++;
	}

	public Alumno getAlumnos() {
		return alumno;
	}

	public void setAlumnos(Alumno alumnos) {
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

//	public boolean registraAlumno(Alumno alumno, Universidad universidad) {
//		if(universidad.getAlumnos().contains(alumno)) {
//				if(alumno.contains(alumno)) {
//					return false;
//				}else {
//					//alumno.add(alumno);
//					return true;
//			}
//		}
//		return false;
//	}
	
}
