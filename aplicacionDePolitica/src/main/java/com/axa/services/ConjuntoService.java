package com.axa.services;

import com.axa.modelos.Conjunto;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoService {

	private List<Conjunto> lista;
	
	public ConjuntoService(){
		lista = new ArrayList<Conjunto>();
	}
	
	public boolean agregar(Conjunto conjunto) {
		System.out.println("ConjuntoService: Voy a agregar una 'Conjunto'.");
		lista.add(conjunto);
		return true;
	}

	public boolean modificar(Conjunto conjunto) {
		System.out.println("ConjuntoService: Voy a modificar una 'Conjunto'.");
		return true;
	}

	public boolean eliminar(Conjunto conjunto) {
		System.out.println("ConjuntoService: Voy a agregar a una 'Conjunto'.");
		lista.remove(conjunto);
		return true;
	}

	public List<Conjunto> listaConjuntos() {
		System.out.println("ConjuntoService: Voy por una lista de 'Conjuntos'.");
		lista.add(new Conjunto());
		return lista;
	}
}