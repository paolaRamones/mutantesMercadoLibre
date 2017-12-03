package ar.com.mercadolibre.mutante.model;

import org.springframework.data.annotation.Id;

/**
 * Clase Adn 
 * 
 * @author paola.cabrera
 *
 */

public class Adn {

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

        private Adn adn;

        public ADNBuilder() {
            this.adn = new Adn();
        }

        public ADNBuilder chain(String[] chain) {
            this.adn.dna = chain;
            return this;
        }

        public ADNBuilder mutant(boolean mutant){
            this.adn.mutant = mutant;
            return this;
        }

        public Adn build() {
            return adn;
        }

    }
}
