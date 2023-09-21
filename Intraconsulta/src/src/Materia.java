package src;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


public class Materia {
	private Integer idMateria;
	private String nombreMateria;
	private ArrayList<Materia> correlativas;
	
	private static Integer contador = 0;
		
	public Materia(String nombreMateria) {
		this.nombreMateria = nombreMateria;
		this.correlativas = new ArrayList<>();
		this.setIdMateria(contador++);
	}
		
	@Override
	public int hashCode() {
		return Objects.hash(nombreMateria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(nombreMateria, other.nombreMateria);
	}

	public String getNombre() {
		return nombreMateria;
	}
	public void setNombre(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}
	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}
	
	public static void setContador(Integer contador) {
		Materia.contador = contador;
	}
	
}
