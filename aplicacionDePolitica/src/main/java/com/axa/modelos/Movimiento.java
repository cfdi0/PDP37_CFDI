package com.axa.modelos;

import java.util.Date;

public class Movimiento {

	private int id;
	private String nombre;
	private String descripcion;
	private Campo campoOriginal;
	private Campo campoFinal;
	private Date fechaModificacion;
	private int idConjunto;

	public Movimiento() {
		super();
	}

	public Movimiento(int id, String nombre, String descripcion, Campo campoOriginal, Campo campoFinal,
			Date fechaModificacion, int idConjunto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.campoOriginal = campoOriginal;
		this.campoFinal = campoFinal;
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

	public Campo getCampoOriginal() {
		return campoOriginal;
	}

	public void setCampoOriginal(Campo campoOriginal) {
		this.campoOriginal = campoOriginal;
	}

	public Campo getCampoFinal() {
		return campoFinal;
	}

	public void setCampoFinal(Campo campoFinal) {
		this.campoFinal = campoFinal;
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
		return "Movimiento [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", campoOriginal="
				+ campoOriginal + ", campoFinal=" + campoFinal + ", fechaModificacion=" + fechaModificacion
				+ ", idConjunto=" + idConjunto + "]";
	}
}
