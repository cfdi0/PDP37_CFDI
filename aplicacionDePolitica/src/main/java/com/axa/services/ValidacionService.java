package com.axa.services;

import com.axa.modelos.Validacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValidacionService {

	private List<Validacion> lista;

	public ValidacionService() {
		lista = new ArrayList<Validacion>();
	}

	public boolean agregar(Validacion validacion) {
		System.out.println("ValidacionService: Voy a agregar una 'Validación'.");
		lista.add(validacion);
		return true;
	}

	public boolean modificar(Validacion validacion) {
		System.out.println("ValidacionService: Voy a modificar una 'Validación'.");
		return true;
	}

	public boolean eliminar(Validacion validacion) {
		System.out.println("ValidacionService: Voy a agregar a una 'Validación'.");
		lista.remove(validacion);
		return true;
	}

	public List<Validacion> listaValidaciones() {
		System.out.println("ValidacionService: Voy por una lista de 'Validaciones'.");
		lista.add(new Validacion(1, "RFC", "Realiza validación de RFC", true,
				"[A-Z,Ñ,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?", new Date(), 1));
		lista.add(new Validacion(2, "MONTO", "Realiza validación de Monto", true, "\\d*", new Date(), 1));
		lista.add(new Validacion(3, "CURP", "Realiza validación de CURP", true,
				"[A-Z][A,E,I,O,U,X][A-Z]{2}[0-9]{2}[0-1][0-9][0-3][0-9][M,H][A-Z]{2}[B,C,D,F,G,H,J,K,L,M,N,Ñ,P,Q,R,S,T,V,W,X,Y,Z]{3}[0-9,A-Z][0-9]",
				new Date(), 1));
		return lista;
	}
}
