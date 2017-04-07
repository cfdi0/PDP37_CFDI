package com.axa.services;

import com.axa.modelos.Adicion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdicionService {

	private List<Adicion> lista;

	public AdicionService() {
		lista = new ArrayList<Adicion>();
	}

	public boolean agregar(Adicion adicion) {
		System.out.println("AdicionService: Voy a agregar una 'Adición'.");
		lista.add(adicion);
		return true;
	}

	public boolean modificar(Adicion adicion) {
		System.out.println("AdicionService: Voy a modificar una 'Adición'.");
		return true;
	}

	public boolean eliminar(Adicion adicion) {
		System.out.println("AdicionService: Voy a agregar a una 'Adición'.");
		lista.remove(adicion);
		return true;
	}

	public List<Adicion> listaAdiciones() {
		System.out.println("AdicionService: Voy por una lista de 'Adiciones'.");
		lista.add(new Adicion(1, "Nombre Receptor", "Adiciona el nombre del receptor solicitado en la verion 3.3",
				"nombreReceptor", "Nombre del Receptor", new Date(), 1));
		lista.add(new Adicion(2, "Clave de producto o servicio", "Adiciona la Clave de producto o servicio",
				"claveProdServ", "0201022", new Date(), 2));
		lista.add(new Adicion(3, "Clave unidad", "Adiciona la Clave de unidad",
				"claveUnidad", "Cat9342", new Date(), 2));
		return lista;
	}
}
