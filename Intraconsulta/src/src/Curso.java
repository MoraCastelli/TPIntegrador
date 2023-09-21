package src;

import java.util.Objects;

public class Curso {
	private Integer idCurso;
	private Integer turnoDia;
	private CicloLectivo cicloLectivo;
	private Materia materia;
	private Aula aula;
	
	private static Integer contador = 0;
	
	public Curso(Integer turnoDia, CicloLectivo cicloLectivo, Materia materia, Aula aula) {
		this.turnoDia = turnoDia;
		this.cicloLectivo = cicloLectivo;
		this.materia = materia;
		this.aula = aula;
		this.setIdCurso(contador++);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idCurso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(idCurso, other.idCurso);
	}

	public Integer getTurno() {
		return turnoDia;
	}

	public void setTurno(Integer turnoDia) {
		this.turnoDia = turnoDia;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	
	
	
}
