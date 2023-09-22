package src;

import java.util.Objects;

public class Aula {
	private Integer idAula;
	private Integer cantidadAlumnos;
	
	private static Integer contador = 0;
	
	public Aula(Integer cantidadAlumnos) {
		this.cantidadAlumnos = cantidadAlumnos;
		this.idAula = contador++;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idAula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(idAula, other.idAula);
	}

	

	public Integer getIdAula() {
		return idAula;
	}

	public void setIdAula(Integer idAula) {
		this.idAula = idAula;
	}

	public Integer getCantidadAlumnos() {
		return cantidadAlumnos;
	}
	public void setCantidadAlumnos(Integer capacidad) {
		this.cantidadAlumnos = capacidad;
	}
	
	public static void setContador(Integer contador) {
		Aula.contador = contador;
	}
	
}
