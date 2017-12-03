package com.mercadolibre.service;

import com.mercadolibre.model.ADN;
/***
 * 
 * 
 * @author paola.cabrera
 *
 */

public interface MutantService {

    public boolean isMutant(String[] dna);

    public void newRequest(ADN build);
}
