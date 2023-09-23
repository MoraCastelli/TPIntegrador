package src;

import java.util.Objects;

public class Nota {
	private Integer idNota;
	private Integer notafinal;
	private Integer primerParcial;
	private Integer segundoParcial;
	private Integer recuperatorio; //YO HARIA UNA DIVISION Y PONDRIA PRIMERRECUPERATORIO Y SEGUNDO RECUPERATORIO
	
	private static Integer contador = 0;
	
	public Nota(Integer primerParcial, Integer segundoParcial, Integer recueperatorioPrimero, Integer recueperatorioSegundo) {
		super();
		this.primerParcial = primerParcial;
		this.segundoParcial = segundoParcial;
		if(recueperatorioPrimero != 0) {
			this.recuperatorio = recueperatorioPrimero;
		}else if(recueperatorioSegundo != 0) {
			this.recuperatorio = recueperatorioSegundo;
		}
		this.idNota = contador++;
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

	public Integer getRecueperatorio() {
		return recuperatorio;
	}

	public void setRecueperatorio(Integer recueperatorio) {
		this.recuperatorio = recueperatorio;
	}

	public static void setContador(Integer contador) {
		Nota.contador = contador;
	}
		
}
