package com.mercadolibre.dto;
/**
 * StatsDTO dto encargado de transportar la informacion
 * necesaria para el calculo de estaditicas segun la 
 * verificacion de ADN
 * 
 * @author Paola Cabrera
 *
 */
public class StatsDTO {

    private Integer count_mutant_dna;

    private Integer count_human_dna;

    private Double ratio;

    public StatsDTO(Integer mutants, Integer humans, Double ratio){
        this.count_human_dna = humans;
        this.count_mutant_dna = mutants;
        this.ratio = ratio;
    }

    public Integer getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public void setCount_mutant_dna(Integer count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public Integer getCount_human_dna() {
        return count_human_dna;
    }

    public void setCount_human_dna(Integer count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }
}
