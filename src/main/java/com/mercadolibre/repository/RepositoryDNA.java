package com.mercadolibre.repository;

import com.mercadolibre.model.ADN;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/***
 * 
 * 
 * @author paola.cabrera
 *
 */
@Repository
public interface RepositoryDNA extends MongoRepository<ADN, String> {

	/**
	 * Metodo que obtendra del repositorio de mongo la cantidad de:
	 * 				-	 mutantes con valor true 
	 * 				-	 humanos con valor false 
	 * 							
	 * @author Paola Cabrera
	 * 
	 * @param mutant
	 * @return Long
	 */
    public Long countByMutant(boolean mutant);

}
