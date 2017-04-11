package com.axa.cfdi.operations;

import org.springframework.stereotype.Component;

@Component("replaceCadena")
public class ReplaceCadena {
	
	public String replace(String cadenaCFDI){
		cadenaCFDI=cadenaCFDI.replace("[InicioDatosInformativos]\n", "").replace("[FinDatosInformativos]\n", "")
				 .replace("[InicioCreditos]\n", "").replace("[FinCreditos]\n", "")
				 .replace("[InicioDebitos]\n", "").replace("[FinDebitos]\n", "")
				 .replace("[InicioSaldos]\n", "").replace("[FinSaldos]\n", "")
				 .replace("[InicioConceptos]\n", "").replace("[FinConceptos]\n", "")
				 .replace("[InicioInfoAxa]\n", "").replace("[FinInfoAxa]\n", "")
				 .replace("[InicioAgente]\n", "").replace("[FinAgente]\n", "")
				 .replace("[InicioRefBancarias]\n", "").replace("[FinRefBancarias]\n", "")
				 .replace("[InicioPercepciones]\n", "").replace("[FinPercepciones]\n", "")
				 .replace("[InicioDeducciones]\n", "").replace("[FinDeducciones]\n", "")
				 .replace("[InicioIncapacidad]\n", "").replace("[FinIncapacidad]\n", "")
				 .replace("[InicioHorasExtra]\n", "").replace("[FinHorasExtra]\n", "")
				 .replace("[", "");
		return cadenaCFDI;	
	}
}
