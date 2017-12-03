package ar.com.mercadolibre.mutante.repository;

import ar.com.mercadolibre.mutante.model.Adn;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/***
 * 
 * 
 * @author paola.cabrera
 *
 */
@Repository
public interface RepositorioDna extends MongoRepository<Adn, String> {

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
    public Long countQuantityByMutant(boolean mutant);

}
