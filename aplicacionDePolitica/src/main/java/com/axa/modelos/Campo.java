package com.axa.modelos;

public class Campo {

	private int id;
	private String nombre;
	private String descripcion;
	private String etiqueta;
	private String emisor;

	public Campo() {
		super();
	}

	public Campo(String nombre, String descripcion, String etiqueta, String emisor) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.etiqueta = etiqueta;
		this.emisor = emisor;
	}

	public Campo(int id, String nombre, String descripcion, String etiqueta, String emisor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.etiqueta = etiqueta;
		this.emisor = emisor;
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

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	@Override
	public String toString() {
		return "Campo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", etiqueta=" + etiqueta
				+ ", emisor=" + emisor + "]";
	}

}
