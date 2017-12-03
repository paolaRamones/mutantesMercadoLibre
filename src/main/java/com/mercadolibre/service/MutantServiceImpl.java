package com.mercadolibre.service;

import com.mercadolibre.model.ADN;
import com.mercadolibre.repository.RepositoryDNA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
/**
 * 
 * @author paola.cabrera
 *
 */
@Service
public class MutantServiceImpl implements MutantService {

    private RepositoryDNA dnaRepo;

    @Autowired
    public MutantServiceImpl(final RepositoryDNA dnaRepository){
        this.dnaRepo = dnaRepository;
    }

    /**
     * 
     * 
     * @param String[] dna: cadena de adn a ser evaluada
     * @return Un valor : 
     				- Verdadero: más de una secuencia de cuatro letras
						   iguales , de forma oblicua, horizontal o vertical.  
     				- False: no se cuenta con una secuencia de cuatro letras iguales
     * @version 28/11/2017
	 * @author Paola Cabrera.
	*/
    public boolean isMutant(String[] dna) {
    	
	 if(!Arrays.asList(dna).stream().allMatch(e -> e.length() == dna.length) && dna.length > 3)
         return false;

     return generateDnaChain(dna).stream().anyMatch(e -> hasFourInARow(e));
    }

    @Override
    public void newRequest(ADN dna) {
        dnaRepo.save(dna);
    }
    /**
     * Este metodo crea la cadena de dna segun lo recibido
     * @param String[] dna: cadena de adn a ser evaluada
     * @return array list 
     * @version 28/11/2017
	 * @author Paola Cabrera.
	*/
    
    private List<String> generateDnaChain(String[] dna){

        List<String> chains = new ArrayList<String>();

        //Horizontal
        chains.addAll(Arrays.asList(dna));

        //Vertical
        chains.addAll(matrix(dna));

        //Diagonal
        chains.add(diagonal(dna));

        return chains;
    }

    /**
     * Este metodo verifica segun el parametro recibido si existe en forma diagonal
     * @param String[] dna: cadena de adn a ser evaluada
     * @return string: 
     * @version 28/11/2017
	 * @author Paola Cabrera.
	*/
    private String diagonal(String[] dna) {

        String element = "";
        for(int i = 0; i< dna.length; i++){
            for(int j = 0; j<dna.length;j++){
                if(i==j)
                    element+=dna[i].charAt(j);
            }
        }
        return element;
    }

    private List<String> matrix(String[] dna){

	    List<String> dnaT = new ArrayList<>();
	
	    for(int i = 0; i< dna.length; i++){
	        String element = "";
	        for(int j = 0; j<dna.length;j++){
	            element+=dna[j].charAt(i);
	        }
	        dnaT.add(element);
	    }
	
	    return dnaT;
    }

    /**
     * Verifica por medio de una expresion regular si 
     * se tiene al menos 4 letras iguales seguidas en la fila
     * @param cadena
     * @return verdadero - false
     */
    private boolean hasFourInARow(String chain){
        return Pattern.compile("G{4}").matcher(chain).find();
    }
}
