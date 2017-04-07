package com.axa.modelos;

import java.util.Date;

public class Adicion {
	private int id;
	private String nombre;
	private String descripcion;
	private String etiqueta;
	private String valor;
	private Date fechaModificacion;
	private int idConjunto;

	public Adicion() {
		super();
	}

	public Adicion(String nombre, String descripcion, String etiqueta, String valor, Date fechaModificacion,
			int idConjunto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.etiqueta = etiqueta;
		this.valor = valor;
		this.fechaModificacion = fechaModificacion;
		this.idConjunto = idConjunto;
	}

	public Adicion(int id, String nombre, String descripcion, String etiqueta, String valor, Date fechaModificacion,
			int idConjunto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.etiqueta = etiqueta;
		this.valor = valor;
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

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
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
		return "Adicion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", etiqueta="
				+ etiqueta + ", valor=" + valor + ", fechaModificacion=" + fechaModificacion + ", idConjunto="
				+ idConjunto + "]";
	}

}
