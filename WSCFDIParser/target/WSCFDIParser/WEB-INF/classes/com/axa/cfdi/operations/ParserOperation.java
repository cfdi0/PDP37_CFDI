package com.axa.cfdi.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axa.cfdi.beans.Campo;
import com.axa.cfdi.service.ParserClient;

@Component("parserOperation")
public class ParserOperation {
	@Autowired
	private ReplaceCadena replaceCadena;
	private ParserClient parserClient;
	public List<Campo> parserReplace(String cadenaCFDI) throws IOException{
		String cadenaCFDIs=replaceCadena.replace(cadenaCFDI);
		String thisLine = null;
		List<Campo> listaCampo = null;
		BufferedReader reader = new BufferedReader(new StringReader(cadenaCFDIs));
		while ((thisLine = reader.readLine()) != null) {
			if(thisLine.contains("InicioDocto")){
				System.out.println("InicioDocto");
				listaCampo = new ArrayList<Campo>();
			}else {
				if(thisLine.contains("FinDocto")){
					System.out.println("FinDocto");
					parserClient = new ParserClient();
					parserClient.parserClient(listaCampo);
				}else{
					String [] valores = thisLine.split("]");
					if(valores.length > 1){
						System.out.println(valores[0]+" = "+valores[1]);
						listaCampo.add(new Campo (valores[0],valores[1]));
					}else{
						System.out.println(valores[0]+" = (vacio)");
						listaCampo.add(new Campo (valores[0],""));
					}
					
				}
			}
		}
		
		return listaCampo;
	}

}
