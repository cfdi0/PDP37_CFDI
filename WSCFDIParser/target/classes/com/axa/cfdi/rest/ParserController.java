package com.axa.cfdi.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.axa.cfdi.service.ParserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Path( "/parserCFDI" ) 
@Api( value = "/parserCFDI", description = "Convierte el archivo de los emisores a formato Json" )
public class ParserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ParserController.class.getName());

	@Autowired 
	private ParserService parserService;
	
	@POST
	@ApiOperation( 
			value = "Convertidor a formato Json", 
			notes = "Convierte los archivos de los emisores a formato Json" )
	@ApiResponses( value = {
	    @ApiResponse( code = 201, message = "La operacion convertir a formato Json fue exitosa" ),
	    @ApiResponse( code = 500, message = "Error interno del servidor" )
	} )
	@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	public Response parserCFDI( 			
			@ApiParam( value = "ramo", required = false ) @FormParam( "ramo" ) final String ramo,
			@ApiParam( value = "medio", required = false ) @FormParam( "medio" ) final String medio,
			@ApiParam( value = "transaccion", required = false ) @FormParam( "transaccion" ) final String transaccion,
			@ApiParam( value = "evento", required = false ) @FormParam( "evento" ) final String evento,
			@ApiParam( value = "segmento", required = false ) @FormParam( "segmento" ) final String segmento,
			@ApiParam( value = "rol", required = false ) @FormParam( "rol" ) final String rol,
			@ApiParam( value = "usuario", required = false ) @FormParam( "usuario" ) final String usuario,
			@ApiParam( value = "sistemaId", required = false ) @FormParam( "sistemaId" ) final String sistemaId,
			@ApiParam( value = "cdenaCfdi", required = true ) @FormParam( "cdenaCfdi" ) final String cdenaCfdi ) {

		try {
			LOGGER.info("Se proceso la cadena [cadenaDetails=[{}]]", cdenaCfdi.toString());
			parserService.parserToJAVA( cdenaCfdi );
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return Response.status(201).entity("OK").build();
	}

}
