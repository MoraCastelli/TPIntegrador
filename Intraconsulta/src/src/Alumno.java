package src;

import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno {
	
	private ArrayList<Materia> aprobadas;
	private Integer idAlumno;
	private Integer dniAlumno;
	private String nombreAlumno;
	private String apellidoAlumno;
	private LocalDate fechaIngreso;
	private LocalDate fechaNacimiento;
	
	private static Integer contador = 0;
	
	public Alumno(Integer dni, String nombre, String apellido, LocalDate fechaIngreso, LocalDate fechaNacimiento) {
		this.aprobadas =  new ArrayList<>();
		this.dniAlumno = dni;
		this.nombreAlumno = nombre;
		this.apellidoAlumno = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.setIdAlumno(contador++);
	}
	public ArrayList<Materia> getAprobadas() {
		return aprobadas;
	}
	public void setAprobadas(ArrayList<Materia> aprobadas) {
		this.aprobadas = aprobadas;
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
