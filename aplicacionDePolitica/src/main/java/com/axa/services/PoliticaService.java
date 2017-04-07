package com.axa.services;

import com.axa.modelos.Politica;

import java.util.ArrayList;
import java.util.List;

public class PoliticaService {

	private List<Politica> lista;
	
	public PoliticaService(){
		lista = new ArrayList<Politica>();
	}
	
	public boolean agregar(Politica politica) {
		System.out.println("PoliticaService: Voy a agregar una 'Politica'.");
		lista.add(politica);
		return true;
	}

	public boolean modificar(Politica politica) {
		System.out.println("PoliticaService: Voy a modificar una 'Politica'.");
		return true;
	}

	public boolean eliminar(Politica politica) {
		System.out.println("PoliticaService: Voy a agregar a una 'Politica'.");
		lista.remove(politica);
		return true;
	}

	public List<Politica> listaPoliticas() {
		System.out.println("PoliticaService: Voy por una lista de 'Politicas'.");
		lista.add(new Politica());
		return lista;
	}
	
	public List<Politica> listaPoliticas(int idPlantilla) {
		System.out.println("PoliticaService: Voy por una lista de 'Politicas'.");
		lista.add(new Politica());
		return lista;
	}
}