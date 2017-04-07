package com.axa.services;

import com.axa.modelos.Plantilla;

import java.util.ArrayList;
import java.util.List;

public class PlantillaService {

	private List<Plantilla> lista;

	public PlantillaService() {
		lista = new ArrayList<Plantilla>();
	}

	public boolean agregar(Plantilla plantilla) {
		System.out.println("PlantillaService: Voy a agregar una 'Plantilla'.");
		lista.add(plantilla);
		return true;
	}

	public boolean modificar(Plantilla plantilla) {
		System.out.println("PlantillaService: Voy a modificar una 'Plantilla'.");
		return true;
	}

	public boolean eliminar(Plantilla plantilla) {
		System.out.println("PlantillaService: Voy a agregar a una 'Plantilla'.");
		lista.remove(plantilla);
		return true;
	}

	public Plantilla obtenerPlantilla(String tipoDocto) {
		return new Plantilla();
	}

	public List<Plantilla> listaPlantillas(String tipoDocto) {
		System.out.println("PlantillaService: Voy por una lista de 'Plantillas'.");
		lista.add(new Plantilla());
		return lista;
	}
}