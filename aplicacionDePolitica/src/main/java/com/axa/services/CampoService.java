package com.axa.services;

import com.axa.modelos.Campo;

import java.util.ArrayList;
import java.util.List;

public class CampoService {

	private List<Campo> lista;

	public CampoService() {
		lista = new ArrayList<Campo>();
	}

	/* En teroría este método no se tendría que usar */
	public boolean agregar(Campo campo) {
		System.out.println("CampoService: Voy a agregar una 'Campo'.");
		lista.add(campo);
		return true;
	}

	/* En teroría este método no se tendría que usar */
	public boolean modificar(Campo campo) {
		System.out.println("CampoService: Voy a modificar una 'Campo'.");
		return true;
	}

	/* En teroría este método no se tendría que usar */
	public boolean eliminar(Campo campo) {
		System.out.println("CampoService: Voy a agregar a una 'Campo'.");
		lista.remove(campo);
		return true;
	}

	public List<Campo> listaCampos() {
		lista = new ArrayList<Campo>();
		System.out.println("CampoService: Voy por una lista de 'Campos'.");
		lista.add(new Campo(1, "Forma de Pago", "Forma de pago", "formaPago", "Emisor 1"));
		lista.add(new Campo(2, "Tipo de comprobante", "Tipo de comprobante", "tipoComprobante", "Emisor 1"));
		lista.add(new Campo(3, "Tipo de documento", "Tipo de documento", "tipoDocumento", "Emisor 1"));
		lista.add(new Campo(4, "Método de Pago", "Método de pago", "metodoPago", "Emisor 1"));
		return lista;
	}
}
