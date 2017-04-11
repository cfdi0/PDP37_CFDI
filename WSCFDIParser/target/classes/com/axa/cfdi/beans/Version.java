package com.axa.cfdi.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "version")

public class Version {
	private String version;
	private String hora;
	private String estatus;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
}
