package src;

public class Nota {
	private Integer idNota;
	private Integer primerParcial;
	private Integer segundoParcial;
	private Integer recueperatorio;
	
	private static Integer contador = 0;
	
	public Nota(Integer primerParcial, Integer segundoParcial, Integer recueperatorioPrimero, Integer recueperatorioSegundo) {
		super();
		this.primerParcial = primerParcial;
		this.segundoParcial = segundoParcial;
		if(recueperatorioPrimero != 0) {
			this.recueperatorio = recueperatorioPrimero;
		}else if(recueperatorioSegundo != 0) {
			this.recueperatorio = recueperatorioSegundo;
		}
		this.idNota = contador++;
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
		return recueperatorio;
	}

	public void setRecueperatorio(Integer recueperatorio) {
		this.recueperatorio = recueperatorio;
	}
	
	
}
