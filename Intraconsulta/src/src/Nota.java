package src;

import java.util.Objects;

public class Nota {
	@SuppressWarnings("unused")
	private Integer idNota;
	private Integer notafinal;
	private Integer primerParcial;
	private Integer segundoParcial;
	private Integer recuperatorioPrimero;
	private Integer recuperatorioSegundo;
	@SuppressWarnings("unused")
	private Integer identificador;
	
	private static Integer contador = 0;
	
	public Nota() {
		this.idNota = contador++;
		this.primerParcial = 0;
		this.segundoParcial = 0;
		this.recuperatorioPrimero = 0;
		this.recuperatorioSegundo = 0;
		this.notafinal = 0;
	}
	@Override
	public int hashCode() {
		return Objects.hash(notafinal, primerParcial, recuperatorioPrimero, recuperatorioSegundo, segundoParcial);
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
		return Objects.equals(notafinal, other.notafinal) && Objects.equals(primerParcial, other.primerParcial)
				&& Objects.equals(recuperatorioPrimero, other.recuperatorioPrimero)
				&& Objects.equals(recuperatorioSegundo, other.recuperatorioSegundo)
				&& Objects.equals(segundoParcial, other.segundoParcial);
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
	public Nota setNotas(Integer identificador, Integer parcial) {
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
			identificador = 0;
			break;
		}
	return this;
	}	
}