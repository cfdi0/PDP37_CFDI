package com.axa.services;

import com.axa.modelos.Transformacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransformacionService {

	private List<Transformacion> lista;

	public TransformacionService() {
		lista = new ArrayList<Transformacion>();
	}

	public boolean agregar(Transformacion transformacion) {
		System.out.println("TransformacionService: Voy a agregar una 'Transformación'.");
		lista.add(transformacion);
		return true;
	}

	public boolean modificar(Transformacion transformacion) {
		System.out.println("TransformacionService: Voy a modificar una 'Transformación'.");
		return true;
	}

	public boolean eliminar(Transformacion transformacion) {
		System.out.println("TransformacionService: Voy a agregar a una 'Transformación'.");
		lista.remove(transformacion);
		return true;
	}

	public List<Transformacion> listaTransformaciones() {
		System.out.println("TransformacionService: Voy por una lista de 'Transformaciones'.");
		lista.add(new Transformacion(1, "Dolar 1", "Cambia valor moneda por catalogo SAT", "Dolares", "USD", new Date(),1));
		lista.add(new Transformacion(2, "Pesos 1", "Cambia valor moneda por catalogo SAT", "Pesos", "MXN", new Date(), 1));
		lista.add(new Transformacion(3, "UDI 1", "Cambia valor moneda por catalogo SAT", "UDI", "MXV", new Date(), 1));
		return lista;
	}
}
