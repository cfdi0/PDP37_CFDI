package com.axa.operaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.axa.modelos.Adicion;
import com.axa.modelos.CampoEmisor;
import com.axa.modelos.Excepcion;
import com.axa.modelos.Movimiento;
import com.axa.modelos.Plantilla;
import com.axa.modelos.Politica;
import com.axa.modelos.Transformacion;
import com.axa.modelos.Validacion;
import com.axa.services.AdicionService;
import com.axa.services.MovimientoService;
import com.axa.services.PlantillaService;
import com.axa.services.PoliticaService;
import com.axa.services.TransformacionService;
import com.axa.services.ValidacionService;

/*
 * Para este cliente el modelo de politica y movimiento cambia ya que requiere los objetos y no solo sus id´s.
 * 
 * El primer paso es obtener la plantilla, que es el 
 * conjunto de todas las politicas a aplicar por documento.
 * 
 * El segundo paso es el de agregar los campos adicionales.
 * 
 * En el tercer paso se realiza primero las operaciones de movimiento
 *  y después las de transformación
 * 
 * El cuarto paso consta de aplicar las reglas de validación, 
 * estas reglas nos permitiran saber si el documento cuenta 
 * con la estructura solicitada
 * */

public class Operaciones {

	private List<Politica> politicas;
	private List<Excepcion> excepciones;
	private List<Adicion> adiciones;
	private List<Movimiento> movimientos;
	private List<Transformacion> transformaciones;
	private List<Validacion> validaciones;
	private List<CampoEmisor> camposEmisor;

	/*
	 * listaPolitcas : Obtine las reglas(poliicas) que se asignaron en la
	 * plantilla
	 */
	public Operaciones(String tipoDocto) {
		excepciones = new ArrayList<Excepcion>();
		PlantillaService service = new PlantillaService();
		Plantilla plantilla = service.obtenerPlantilla(tipoDocto);
		PoliticaService politicaService = new PoliticaService();
		politicas = politicaService.listaPoliticas(plantilla.getIdPlantilla());
	}

	public List<Excepcion> validaDocumento(List<CampoEmisor> listaCamposEmisor) {
		camposEmisor = listaCamposEmisor;
		adiciones = new AdicionService().listaAdiciones();
		movimientos = new MovimientoService().listaMovimientos();
		transformaciones = new TransformacionService().listaTransformaciones();
		validaciones = new ValidacionService().listaValidaciones();

		aplicaAdiciones();
		aplicaMovimientos();
		aplicaTransformaciones();
		aplicaValidaciones();
		return excepciones;
	}

	/*
	 * La aplicación de validaciones es la parte más importante, ya que con ella
	 * podemos saber la estructura del documento, nos permite saber si un campo
	 * es requerido o no.
	 */
	private void aplicaValidaciones() {
		CampoEmisor campoEmisor;
		boolean bRes = true;
		String sRes = "";
		List<Validacion> listaValidaciones;
		List<Politica> listaPoliticas = politicas.stream().filter(a -> Objects.equals(a.getConjunto().getTipo(), "Validacion")).collect(Collectors.toList());
		for (Politica auxPolitica : listaPoliticas) {
			listaValidaciones = validaciones.stream().filter(a -> Objects.equals(a.getIdConjunto(), auxPolitica.getConjunto().getId())).collect(Collectors.toList());
			for (Validacion validacion : listaValidaciones) {
				campoEmisor = camposEmisor.stream().filter(a -> Objects.equals(a.getKey(), auxPolitica.getCampo().getEtiqueta())).findFirst().get();
				if (campoEmisor != null) {
					if (validacion.isObligatorio()) {
						if (campoEmisor.getValue().isEmpty() || campoEmisor.getValue().trim() == "") {
							sRes = "Es requerido y no tiene valor. ";
							bRes = false;
						}
					}
					if (!validacion.getRegex().isEmpty() || validacion.getRegex().trim() != "") {
						if (!campoEmisor.getValue().matches(validacion.getRegex())) {
							sRes = "No cumple con el patrón especificado.";
							bRes = false;
						}
					}
					if (!bRes)
						excepciones.add(new Excepcion("Validacion", auxPolitica.getCampo().getEtiqueta(), sRes));
				}
			}
		}
	}

	/*
	 * Transformaciones: Transforma el valor de un campo de acuerdo al criterio
	 * especificado.
	 */
	private void aplicaTransformaciones() {
		CampoEmisor campoEmisor;
		List<Transformacion> listaTransformaciones;
		List<Politica> listaPoliticas = politicas.stream().filter(a -> Objects.equals(a.getConjunto().getTipo(), "Transformacion")).collect(Collectors.toList());
		for (Politica auxPolitica : listaPoliticas) {
			listaTransformaciones = transformaciones.stream().filter(a -> Objects.equals(a.getIdConjunto(), auxPolitica.getConjunto().getId())).collect(Collectors.toList());
			for (Transformacion transformacion : listaTransformaciones) {
				campoEmisor = camposEmisor.stream().filter(a -> Objects.equals(a.getKey(), auxPolitica.getCampo().getEtiqueta())).findFirst().get();
				if (campoEmisor != null) {
					if (campoEmisor.getValue().equals(transformacion.getValorOriginal())) {
						camposEmisor.remove(campoEmisor);
						camposEmisor.add(new CampoEmisor(campoEmisor.getKey(), transformacion.getValorFinal()));
					}
				}
			}
		}
	}

	/*
	 * No es dependiente de un campo. Adiciones: Agrega campos que en un
	 * principio no existen.
	 */
	private void aplicaAdiciones() {
		List<Adicion> listaAdiciones;
		List<Politica> listaPoliticas = politicas.stream().filter(a -> Objects.equals(a.getConjunto().getTipo(), "Adicion")).collect(Collectors.toList());
		for (Politica auxPolitica : listaPoliticas) {
			listaAdiciones = adiciones.stream().filter(a -> Objects.equals(a.getIdConjunto(), auxPolitica.getConjunto().getId())).collect(Collectors.toList());
			for (Adicion aux : listaAdiciones) {
				camposEmisor.add(new CampoEmisor(aux.getEtiqueta(), aux.getValor()));
			}
		}
	}

	/*
	 * No es dependiente de un campo. Movimientos: Asigna el valor de un campo
	 * en otro.
	 */
	private void aplicaMovimientos() {
		CampoEmisor campoOriginal, campoFinal;
		List<Movimiento> listaMovimientos;
		List<Politica> listaPoliticas = politicas.stream().filter(a -> Objects.equals(a.getConjunto().getTipo(), "Movimiento")).collect(Collectors.toList());
		for (Politica auxPolitica : listaPoliticas) {
			listaMovimientos = movimientos.stream().filter(a -> Objects.equals(a.getIdConjunto(), auxPolitica.getConjunto().getId())).collect(Collectors.toList());
			for (Movimiento movimiento : listaMovimientos) {
				campoOriginal = camposEmisor.stream().filter(a -> Objects.equals(a.getKey(), movimiento.getCampoOriginal().getEtiqueta())).findFirst().get();
				if (campoOriginal != null) {
					campoFinal = camposEmisor.stream().filter(a -> Objects.equals(a.getKey(), movimiento.getCampoFinal().getEtiqueta())).findFirst().get();
					if (campoFinal != null) {
						campoFinal.setValue(campoOriginal.getValue());
					} else {
						excepciones.add(new Excepcion("Movimiento", movimiento.getCampoOriginal().getEtiqueta(),"No se encuentra el campo origen [" + movimiento.getCampoOriginal().getEtiqueta() + "] dentro de los campos del emisor."));
					}
				} else {
					excepciones.add(new Excepcion("Movimiento", movimiento.getCampoOriginal().getEtiqueta(),"No se encuentra el campo final [" + movimiento.getCampoFinal().getEtiqueta() + "] dentro de los campos del emisor."));
				}
			}
		}
	}
}
