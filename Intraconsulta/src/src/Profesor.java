package src;

import java.util.Objects;

public class Profesor {
	private Integer idProfesor;
	private Integer dniProfesor;
	private String nombreProfesor;
	private String apellidoProfesor;
	
	private static Integer contador = 0;
	
	public Profesor(Integer dni, String nombre, String apellido) {
		this.dniProfesor = dni;
		this.nombreProfesor = nombre;
		this.apellidoProfesor = apellido;
		this.setIdProfesor(contador++);
	}
	@Override
	public int hashCode() {
		return Objects.hash(dniProfesor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(dniProfesor, other.dniProfesor);
	}
	public Integer getDni() {
		return dniProfesor;
	}
	public void setDni(Integer dni) {
		this.dniProfesor = dni;
	}
	public String getNombre() {
		return nombreProfesor;
	}
	public void setNombre(String nombre) {
		this.nombreProfesor = nombre;
	}
	public String getApellido() {
		return apellidoProfesor;
	}
	public void setApellido(String apellido) {
		this.apellidoProfesor = apellido;
	}
	public Integer getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}
	public static void setContador(Integer contador) {
		Profesor.contador = contador;
	}
}