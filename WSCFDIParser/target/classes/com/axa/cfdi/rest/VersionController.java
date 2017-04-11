package com.axa.cfdi.rest;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.axa.cfdi.beans.Version;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Path( "/version" ) 
@Api( value = "/version", description = "Balancea diferentes instancias basado en health check" )
public class VersionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VersionController.class.getName());

	@GET
	@ApiOperation( 
			value = "Metodo que permite balancear diferentes instancias basado en health check", 
			notes = "Este metodo debera ser usado en Datapower LoadBlanacer-HealthCheck" )
	@ApiResponses( value = {
	    @ApiResponse(code = 200, message = "Exito al mostrar la version"),
        @ApiResponse(code = 404, message = "No encontro la version"),
        @ApiResponse(code = 500, message = "Error interno del servidor")
	} )
	@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
	public Version versionXML() {
		Version version = new Version();
		String ver = "1.0";
		String hora = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date().getTime());
		String estatus = "Activo";
		LOGGER.info("Se proceso la peticion de version [versionDetails=[{}]]", ver+", "+hora+", "+estatus);
		version.setEstatus(estatus);
		version.setHora(hora);
		version.setVersion(ver);
		return version;
	}


}
