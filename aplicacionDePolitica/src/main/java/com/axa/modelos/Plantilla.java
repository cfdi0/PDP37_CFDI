package com.axa.modelos;

import java.util.Date;

public class Plantilla {

	private int idPlantilla;
	private String nombre;
	private String descripcion;
	private String version;
	private boolean estatus;
	private String tipoDocumento;
	private Date fechaModificacion;

	public Plantilla() {
		super();
	}

	public Plantilla(String nombre, String descripcion, String version, boolean estatus, String tipoDocumento,
			Date fechaModificacion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.version = version;
		this.estatus = estatus;
		this.tipoDocumento = tipoDocumento;
		this.fechaModificacion = fechaModificacion;
	}

	public Plantilla(int idPlantilla, String nombre, String descripcion, String version, boolean estatus,
			String tipoDocumento, Date fechaModificacion) {
		super();
		this.idPlantilla = idPlantilla;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.version = version;
		this.estatus = estatus;
		this.tipoDocumento = tipoDocumento;
		this.fechaModificacion = fechaModificacion;
	}

	public int getIdPlantilla() {
		return idPlantilla;
	}

	public void setIdPlantilla(int idPlantilla) {
		this.idPlantilla = idPlantilla;
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@Override
	public String toString() {
		return "Plantilla [idPlantilla=" + idPlantilla + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", version=" + version + ", estatus=" + estatus + ", tipoDocumento=" + tipoDocumento
				+ ", fechaModificacion=" + fechaModificacion + "]";
	}
}
