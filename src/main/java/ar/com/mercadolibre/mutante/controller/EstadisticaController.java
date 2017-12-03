package ar.com.mercadolibre.mutante.controller;

import ar.com.mercadolibre.mutante.dto.StatsDTO;
import ar.com.mercadolibre.mutante.service.StatsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Clase encargada de realizar las estadisticas segun
 * cantidad de mutantes y humanos 
 * 
 * @author paola.cabrera
 *
 */

@RestController
@RequestMapping("/stats")
public class EstadisticaController {

    private StatsService statsService;

    @Autowired
    public EstadisticaController(final StatsService statsService){
        this.statsService = statsService;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public StatsDTO getStats(){
        return new StatsDTO(statsService.getMutants(), statsService.getHumans(), statsService.getRatio());
    }

}
