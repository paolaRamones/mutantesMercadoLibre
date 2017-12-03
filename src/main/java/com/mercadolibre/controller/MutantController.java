package com.mercadolibre.controller;

import com.mercadolibre.dto.DNADTO;
import com.mercadolibre.model.ADN;
import com.mercadolibre.service.MutantService;
import com.mercadolibre.utils.MercadoLibreConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
/**
 * 
 * 
 * @author Paola Cabrera
 */
@RestController
@RequestMapping("/mutant")
public class MutantController {

    private MutantService mutantService;

    @Autowired
    public MutantController(final MutantService mutantService){
        this.mutantService = mutantService;
    }

    /**
     *  Metodo que se encarga de devolver si una cadena corresponde a mutantes o humanos
     *  Se debe tener en cuenta que si se ingresa en la cadena de string al menos una letra 
     *  diferente a: A,T,C,G esa cadena devolvera 403 y no sera tenida en cuenta a la hora de
     *  obtener la estadistica
     *  
     *  
     * @return devuelve en el HttpServletResponse 
     				****** si el humano es mutante: 200 
     				****** si el humano no es mutante: 403
     * @version 28/11/2017
	 * @author Paola Cabrera.
	*/
    
    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void isMutant(@RequestBody DNADTO dna, HttpServletResponse response){

    	boolean letterOk = false;
    	boolean result = false;
    	String[] abc = {MercadoLibreConstants.LETTER_B, MercadoLibreConstants.LETTER_D, MercadoLibreConstants.LETTER_E, 
    					MercadoLibreConstants.LETTER_F, MercadoLibreConstants.LETTER_H, MercadoLibreConstants.LETTER_I, 
    					MercadoLibreConstants.LETTER_J, MercadoLibreConstants.LETTER_K, MercadoLibreConstants.LETTER_L, 
    					MercadoLibreConstants.LETTER_M, MercadoLibreConstants.LETTER_N, MercadoLibreConstants.LETTER_O,
    					MercadoLibreConstants.LETTER_P, MercadoLibreConstants.LETTER_Q, MercadoLibreConstants.LETTER_R,
    					MercadoLibreConstants.LETTER_S, MercadoLibreConstants.LETTER_U, MercadoLibreConstants.LETTER_V, 
    					MercadoLibreConstants.LETTER_W, MercadoLibreConstants.LETTER_X, MercadoLibreConstants.LETTER_Y, 
    					MercadoLibreConstants.LETTER_Z};
    	

    	for(int i = 0; i< dna.getDna().length; i++){
    		 
    		for(int j = 0; j<abc.length;j++){
                 if(dna.getDna()[i].contains(abc[j]))
                 {
                	 letterOk = false;
                	 break;
                 }else{
                	 letterOk = true;
                 }
             }
    	}
    	//si pasa la validacion de las letras permitidas
    	//se procede a validar si es un mutante o humano
    	//si la valdiacion no fue correcta el adn no se verifica
    	// por lo cual no se tiene en cuenta a la hora de obtener 
    	//la cantidad de mutantes-humanos-ratio --> se devuelve 403
    	
    	if (letterOk){
	        result = mutantService.isMutant(dna.getDna());
	        mutantService.newRequest(new ADN.ADNBuilder().chain(dna.getDna()).mutant(result).build());	       
    	}
    	 if(result)
	            response.setStatus(200);
	        else
	            response.setStatus(403);


    }
}
