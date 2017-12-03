package ar.com.mercadolibre.mutante.service;

import ar.com.mercadolibre.mutante.model.Adn;
/***
 * 
 * 
 * @author paola.cabrera
 *
 */

public interface MutantService {

    public boolean isMutant(String[] dna);

    public void newRequest(Adn build);
}
