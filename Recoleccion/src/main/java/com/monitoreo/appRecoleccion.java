package com.monitoreo;

import java.io.IOException;

import com.monitoreo.operaciones.RecoleccionOperaciones;

public class appRecoleccion {

	public static void main(String[] args) throws IOException, InterruptedException {
		RecoleccionOperaciones op = new RecoleccionOperaciones();
		op.monitorea();
	}
}