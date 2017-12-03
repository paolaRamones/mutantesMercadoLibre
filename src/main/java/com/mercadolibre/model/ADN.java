package com.mercadolibre.model;

import org.springframework.data.annotation.Id;

/**
 * Clase ADN 
 * 
 * @author paola.cabrera
 *
 */

public class ADN {

    @Id
    private String id;

    private String[] dna;

    private boolean mutant;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public boolean isMutant() {
        return mutant;
    }

    public void setMutant(boolean mutant) {
        this.mutant = mutant;
    }

    public static final class ADNBuilder {

        private ADN adn;

        public ADNBuilder() {
            this.adn = new ADN();
        }

        public ADNBuilder chain(String[] chain) {
            this.adn.dna = chain;
            return this;
        }

        public ADNBuilder mutant(boolean mutant){
            this.adn.mutant = mutant;
            return this;
        }

        public ADN build() {
            return adn;
        }

    }
}
