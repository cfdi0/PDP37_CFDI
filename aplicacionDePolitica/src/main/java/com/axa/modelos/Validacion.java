package com.axa.modelos;

import java.util.Date;

public class Validacion {

	private int id;
	private String nombre;
	private String descripcion;
	private boolean obligatorio;
	private String regex;
	private Date fechaModificacion;
	private int idConjunto;

	public Validacion() {
		super();
	}

	public Validacion(String nombre, String descripcion, boolean obligatorio, String regex, Date fechaModificacion,
			int idConjunto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.obligatorio = obligatorio;
		this.regex = regex;
		this.fechaModificacion = fechaModificacion;
		this.idConjunto = idConjunto;
	}

	public Validacion(int id, String nombre, String descripcion, boolean obligatorio, String regex,
			Date fechaModificacion, int idConjunto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.obligatorio = obligatorio;
		this.regex = regex;
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

	public boolean isObligatorio() {
		return obligatorio;
	}

	public void setObligatorio(boolean obligatorio) {
		this.obligatorio = obligatorio;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
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

}
