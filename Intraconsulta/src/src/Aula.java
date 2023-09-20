package src;

import java.util.Objects;

public class Aula {
	private Integer idAula;
	private Integer cantidadAlumnos;
	
	private static Integer contador = 0;
	
	public Aula(Integer capacidad, Integer cod_aula) {
		this.cantidadAlumnos = capacidad;
		this.idAula = contador++;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cantidadAlumnos, idAula);
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
		return Objects.equals(cantidadAlumnos, other.cantidadAlumnos) && Objects.equals(idAula, other.idAula);
	}
	
	public Integer getCapacidad() {
		return cantidadAlumnos;
	}
	public void setCapacidad(Integer capacidad) {
		this.cantidadAlumnos = capacidad;
	}
	
	
}
