package com.axa.modelos;

public class Conjunto {

	private int id;
	private String nombre;
	private String descripcion;
	private String tipo;

	public Conjunto() {
		super();
	}

	public Conjunto(String nombre, String descripcion, String tipo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}

	public Conjunto(int id, String nombre, String descripcion, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Conjunto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + "]";
	}

}
