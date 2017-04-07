package com.axa.modelos;

import java.util.Date;

public class Transformacion {

	private int id;
	private String nombre;
	private String descripcion;
	private String valorOriginal;
	private String valorFinal;
	private Date fechaModificacion;
	private int idConjunto;

	public Transformacion() {
		super();
	}

	public Transformacion(String nombre, String descripcion, String valorOriginal, String valorFinal,
			Date fechaModificacion, int idConjunto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorOriginal = valorOriginal;
		this.valorFinal = valorFinal;
		this.fechaModificacion = fechaModificacion;
		this.idConjunto = idConjunto;
	}

	public Transformacion(int id, String nombre, String descripcion, String valorOriginal, String valorFinal,
			Date fechaModificacion, int idConjunto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorOriginal = valorOriginal;
		this.valorFinal = valorFinal;
		this.fechaModificacion = fechaModificacion;
		this.idConjunto = idConjunto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(String valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public String getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(String valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public int getIdConjunto() {
		return idConjunto;
	}

	public void setIdConjunto(int idConjunto) {
		this.idConjunto = idConjunto;
	}

	@Override
	public String toString() {
		return "Transformacion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", valorOriginal="
				+ valorOriginal + ", valorFinal=" + valorFinal + ", fechaModificacion=" + fechaModificacion
				+ ", idConjunto=" + idConjunto + "]";
	}

}
