package com.mercadolibre.service;

import org.springframework.stereotype.Service;

import com.mercadolibre.repository.RepositoryDNA;

/**
 * Servicio  /stats que retorna un Json con las estadísticas de las
 * verificaciones de ADN
 * 
 * getHumans ->> cantidad de cadenas de humanos verificadas
 * getMutants ->> cantidad de cadenas de mutantes verificadas
 * getRatio ->> porcentaje obtenido desde la cantidad de adn mutantes / adn humanos
 * 
 * 
 *@version 28/11/2017
 *@author Paola Cabrera.
*/


@Service
public class StatsServiceImpl implements StatsService {

    private RepositoryDNA dnaRepo;

    public StatsServiceImpl(final RepositoryDNA dnaRepository){
        this.dnaRepo = dnaRepository;
    }

    @Override
    public Double getRatio() {
    	float hum = getHumans().floatValue();
    	float mut = getMutants().floatValue();
    	float result = 0;
    	if (hum!=0){
    		result = mut /hum;
    	}
    	return (double) result;
    	
    }

    @Override
    public Integer getHumans() {
        return dnaRepo.countByMutant(false).intValue();
    }

    @Override
    public Integer getMutants() {
        return dnaRepo.countByMutant(true).intValue();
    }
}
