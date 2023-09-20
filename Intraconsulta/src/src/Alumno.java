package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Alumno {
	
	private Integer idAlumno;
	private Integer dniAlumno;
	private String nombreAlumno;
	private String apellidoAlumno;
	private LocalDate fechaIngreso;
	private LocalDate fechaNacimiento;
	
	private static Integer contador = 0;
	
	public Alumno(Integer dni, String nombre, String apellido, LocalDate fechaIngreso, LocalDate fechaNacimiento) {
		this.dniAlumno = dni;
		this.nombreAlumno = nombre;
		this.apellidoAlumno = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.setIdAlumno(contador++);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dniAlumno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dniAlumno, other.dniAlumno);
	}

	public Integer getDni() {
		return dniAlumno;
	}
	public void setDni(Integer dni) {
		this.dniAlumno = dni;
	}
	public String getNombre() {
		return nombreAlumno;
	}
	public void setNombre(String nombre) {
		this.nombreAlumno = nombre;
	}
	public String getApellido() {
		return apellidoAlumno;
	}
	public void setApellido(String apellido) {
		this.apellidoAlumno = apellido;
	}
	public Integer getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	
	
	
}
