package src;

import java.util.ArrayList;

public class Curso_Alumno {
	private Integer idCursoAlumno;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Nota> nota;
	private Curso curso;
	
	private static Integer contador = 0;
	
	public Curso_Alumno(Curso curso) {
		this.alumnos = new ArrayList<>();
		this.nota = new ArrayList<>();
		this.curso = curso;
		this.idCursoAlumno = contador++;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public ArrayList<Nota> getNota() {
		return nota;
	}

	public void setNota(ArrayList<Nota> nota) {
		this.nota = nota;
	}
	
	public boolean registraAlumno(Alumno alumno, Universidad universidad) {
		if(universidad.getAlumnos().contains(alumno)) {
				if(alumnos.contains(alumno)) {
					return false;
				}else {
					alumnos.add(alumno);
					return true;
			}
		}
		return false;
	}
	
}
