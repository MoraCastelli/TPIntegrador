package src;

public class Profesor {
	private Integer idProfesor;
	private Integer dniProfesor;
	private String nombreProfesor;
	private String apellidoProfesor;
	
	private static Integer contador = 0;
	
	public Profesor(Integer dni, String nombre, String apellido) {
		super();
		this.dniProfesor = dni;
		this.nombreProfesor = nombre;
		this.apellidoProfesor = apellido;
		this.setIdProfesor(contador++);
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
	
	
}
