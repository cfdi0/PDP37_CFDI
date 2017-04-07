package com.axa.modelos;

public class Politica {

	private int idPolitica;
	private int idPlantilla;
	private Campo campo;
	private Conjunto conjunto;

	public Politica() {
		super();
	}

	public Politica(int idPolitica, int idPlantilla, Campo campo, Conjunto conjunto) {
		super();
		this.idPolitica = idPolitica;
		this.idPlantilla = idPlantilla;
		this.campo = campo;
		this.conjunto = conjunto;
	}

	public int getIdPolitica() {
		return idPolitica;
	}

	public void setIdPolitica(int idPolitica) {
		this.idPolitica = idPolitica;
	}

	public int getIdPlantilla() {
		return idPlantilla;
	}

	public void setIdPlantilla(int idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	public Campo getCampo() {
		return campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	public Conjunto getConjunto() {
		return conjunto;
	}

	public void setConjunto(Conjunto conjunto) {
		this.conjunto = conjunto;
	}

	@Override
	public String toString() {
		return "Politica [idPolitica=" + idPolitica + ", idPlantilla=" + idPlantilla + ", campo=" + campo
				+ ", conjunto=" + conjunto + "]";
	}
}
