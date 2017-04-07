package com.axa.services;

import java.util.ArrayList;
import java.util.List;

import com.axa.modelos.Movimiento;

public class MovimientoService {

	private List<Movimiento> lista;

	public MovimientoService() {
		lista = new ArrayList<Movimiento>();
	}

	public boolean agregar(Movimiento movimiento) {
		System.out.println("MovimientoService: Voy a agregar una 'Movimiento'.");
		lista.add(movimiento);
		return true;
	}

	public boolean modificar(Movimiento movimiento) {
		System.out.println("MovimientoService: Voy a modificar una 'Movimiento'.");
		return true;
	}

	public boolean eliminar(Movimiento movimiento) {
		System.out.println("MovimientoService: Voy a agregar a una 'Movimiento'.");
		lista.remove(movimiento);
		return true;
	}

	public List<Movimiento> listaMovimientos() {
		System.out.println("MovimientoService: Voy por una lista de 'Movimientos'.");
		lista.add(new Movimiento());
		return lista;
	}
}
