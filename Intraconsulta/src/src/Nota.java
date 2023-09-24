package src;

import java.util.Objects;


public class Nota {
	private Integer idNota;
	private Integer notafinal = 0;
	private Integer primerParcial = 0;
	private Integer segundoParcial = 0;
	private Integer recuperatorioPrimero = 0;
	private Integer recuperatorioSegundo = 0;
	private Integer identificador = 0;
	
	private static Integer contador = 0;
	
	public Nota(Integer identificador, Integer parcial) {
		
		this.idNota = contador++;
		this.setIdentificador(identificador);
		
		switch (identificador) {
		case 1:
			this.primerParcial = parcial;
			break;
		case 2:
			this.segundoParcial = parcial;
			break;
		case 3:
			this.recuperatorioPrimero = parcial;
			break;
		case 4:
			this.recuperatorioSegundo = parcial;
			break;
		case 5:
			this.notafinal = parcial;

		default:
			this.primerParcial = 0;
			this.segundoParcial = 0;
			this.recuperatorioPrimero = 0;
			this.recuperatorioSegundo = 0;
			this.notafinal = 0;
			break;
		}
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idNota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(idNota, other.idNota);
	}
	
	public Integer getNotafinal() {
		return notafinal;
	}

	public void setNotafinal(Integer notafinal) {
		this.notafinal = notafinal;
	}

	public Integer getPrimerParcial() {
		return primerParcial;
	}

	public void setPrimerParcial(Integer primerParcial) {
		this.primerParcial = primerParcial;
	}

	public Integer getSegundoParcial() {
		return segundoParcial;
	}

	public void setSegundoParcial(Integer segundoParcial) {
		this.segundoParcial = segundoParcial;
	}

	public static void setContador(Integer contador) {
		Nota.contador = contador;
	}

	public Integer getRecueperatorioSegundo() {
		return recuperatorioSegundo;
	}

	public void setRecueperatorioSegundo(Integer recueperatorioSegundo) {
		this.recuperatorioSegundo = recueperatorioSegundo;
	}

	public Integer getRecueperatorioPrimero() {
		return recuperatorioPrimero;
	}

	public void setRecueperatorioPrimero(Integer recueperatorioPrimero) {
		this.recuperatorioPrimero = recueperatorioPrimero;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}
		
}
