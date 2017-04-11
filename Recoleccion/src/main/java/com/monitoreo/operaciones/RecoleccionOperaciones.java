package com.monitoreo.operaciones;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.apache.axis.encoding.Base64;

public class RecoleccionOperaciones {

	private String urlWebService;
	private String urlMonitoreo;
	private String urlGuardar;
	private boolean guardar;

	public RecoleccionOperaciones() {
		Properties propiedades = new Properties();
		try {
			propiedades.load(new FileInputStream("WebContent/WEB-INF/Configuracion.properties"));
			urlWebService = propiedades.getProperty("urlWebService");
			urlMonitoreo = propiedades.getProperty("urlMonitoreo");
			urlGuardar = propiedades.getProperty("urlGuardar");
			guardar = Boolean.parseBoolean(propiedades.getProperty("guardar"));
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public void monitorea() throws IOException, InterruptedException {
		Date fecha = new Date();
		String aux = "";
		long timeMas = 0, time = 0;
		boolean res = false;

		/* Se crea el servicio de monitoreo */
		WatchService watchService = FileSystems.getDefault().newWatchService();

		/* Se asigna el directorio a ser monitoreado */
		Path dir = Paths.get(urlMonitoreo);

		/* Se registran los eventos a monitorear */
		WatchKey watchKey = dir.register(watchService,
				ENTRY_CREATE /* ,ENTRY_DELETE, ENTRY_MODIFY */);
		System.out.println("Monitoreo " + (watchKey.isValid() ? "Activado" : "Desactivado"));
		System.out.println("Directorio: " + dir.toString() + "\n");

		INFINITE_WHILE_LOOP: while (true) {
			try {
				System.out.println("Esperando por evento ... \n");
				watchService.take();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
				System.out.println("Error: " + ex.getMessage());
				break INFINITE_WHILE_LOOP;
			}
			/* Se obtienen y procesan los eventos */
			List<WatchEvent<?>> eventList = watchKey.pollEvents();
			fecha = new Date();
			EVENT_FOR_LOOP: for (WatchEvent<?> genericEvent : eventList) {
				Path filePath = (Path) genericEvent.context();
				time = fecha.getTime();
				System.out.println("\nProcesando archivo: " + filePath);
				if (!filePath.toString().equals(aux)) {
					System.out.println("INFO: \"Archivo con distinto nombre al ultimo procesado.\"");
					aux = filePath.toString();
					timeMas = fecha.getTime() + 100;
					res = true;
				} else {
					if (time > timeMas) {
						System.out.print("INFO: \"Archivo con nombre igual al ultimo procesado pero, ");
						System.out.println("el tiempo (" + time + ") es mayor al permitido (" + timeMas + ").\"");
						timeMas = fecha.getTime() + 100;
						res = true;
					}
				}
				if (res) {
					System.out.print("Fecha: " + new SimpleDateFormat("MM-dd-yyyy").format(fecha));
					System.out.println("| tiempo: " + fecha.getTime());
					switch (genericEvent.kind().toString()) {
					case "ENTRY_CREATE":
						String base64 = codificaBase64(0, urlMonitoreo + "/" + filePath);
						enviaBase64(base64);
						if (guardar)
							guardaArchivo(base64, urlGuardar + "/" + filePath);
						break;
					case "ENTRY_MODIFY":
						System.out.print("Se modifico el archivo: ");
						break;
					case "ENTRY_DELETE":
						System.out.print("Se elimino el archivo: ");
						break;
					default:
						continue EVENT_FOR_LOOP;
					}
					res = false;
				} else {
					System.out.println("El archivo ya se habia procesado.");
				}

			} /* Fin EVENT_FOR_LOOP */

			boolean validKey = watchKey.reset();
			res = false;
			System.out.println("Finalizado!!!.\n\n");
			if (!validKey) {
				System.out.println("Invalid watch key, close the watch service");
				break INFINITE_WHILE_LOOP;
			}
		} /* Fin INFINITE_WHILE_LOOP */

		/* Cierre de servicio de monitoreo */
		watchService.close();
		System.out.println("Watch service closed.");
	} /* Fin doProcess() */

	private void enviaBase64(String base64) {
		try {
			URL url = new URL(urlWebService);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			String input = "textoBASE64=" + base64;
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			if (conn.getResponseCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			System.out.println("Archivo enviado correctamente");
			conn.disconnect();
		} catch (Exception e) {
			System.out.println("Error al invocar Web Service: " + e.getMessage());
		}
	}

	@SuppressWarnings("finally")
	public String codificaBase64(int intento, String rutaArchivo) throws IOException, InterruptedException {
		System.out.println("Codificar: " + rutaArchivo + " intento: " + intento);
		File file;
		FileInputStream fileInputStreamReader = null;
		String encodedfile = "";
		try {
			Thread.sleep((1000 * intento));
			file = new File(rutaArchivo);
			fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			encodedfile = Base64.encode(bytes).toString();
			//System.out.println("Base64: " + encodedfile);
			intento = 5;
			fileInputStreamReader.close();
		} catch (FileNotFoundException e) {
			intento++;
			System.out.println("Error en la codificación del archivo en el intento \"" + intento + "\" : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (intento > 0 && intento < 5)
				encodedfile = codificaBase64(intento, rutaArchivo);
			return encodedfile;
		}
	}

	private void guardaArchivo(String sBase64, String sNombre) throws IOException {
		File fichero = new File(sNombre);
		FileOutputStream fileOutputStreamReader = null;
		try {
			fileOutputStreamReader = new FileOutputStream(fichero);
			Base64.decode(sBase64, fileOutputStreamReader);
			System.out.println("El archivo se guardo exitosamente: " + sNombre);
		} catch (Exception e) {
			System.out.println("Error al guardar archivo: " + e.getMessage());
		} finally {
			fileOutputStreamReader.close();
		}
	}
}
