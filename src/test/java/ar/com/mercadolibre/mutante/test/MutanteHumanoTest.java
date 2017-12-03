package ar.com.mercadolibre.mutante.test;

import ar.com.mercadolibre.mutante.repository.RepositorioDna;
import ar.com.mercadolibre.mutante.service.MutantService;
import ar.com.mercadolibre.mutante.service.MutantServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * 
 * Clase encargada de testear el servicio de MutantService
 * realizados
 * 
 * @author paola.cabrera
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MutantServiceImpl.class)

public class MutanteHumanoTest {

    @MockBean
    private RepositorioDna dnaRepo;

    @Autowired
    private MutantService mutanteServ;
    

    @Test
    public void testWrongLetter() throws Exception{
    	//ATGCGA
    	//CAGTGC
    	//TTATTT
    	//AGACGG
    	//GCGTCA
    	//XCACTG
        String[] adn = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA", "XCACTG"};
        assertFalse(mutanteServ.isMutant(adn));
    }

    @Test
    public void testADNMutanteFalse() throws Exception{
    	//ATGCGA
    	//CAGTGC
    	//TTATTT
    	//AGACGG
    	//GCGTCA
    	//TCACTG
        String[] adn = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA", "TCACTG"};
        assertFalse(mutanteServ.isMutant(adn));
    }

    @Test
    public void testADNMutanteTrue() throws Exception{
    	//GGGGAT -->ok
    	//CAGTGC
    	//TTATGT
    	//AGACGG
    	//GCGTGA
    	//TCACGG
    	String[] adn = {"GGGGAT","CAGTGC","TTATGT","AGACGG","GCGTGA", "TCACGG"};
        assertTrue(mutanteServ.isMutant(adn));

    }
   

    @Test
    public void testADNMutanteTrueVertical() throws Exception{
    	//    *
    	//ATGCGA
    	//CAGTGC
    	//TTATGT
    	//AGACGG
    	//GCGTGA
    	//TCACGG
        String[] adn = {"ATGCGA","CAGTGC","TTATGT","AGACGG","GCGTGA", "TCACGG"};
        assertTrue(mutanteServ.isMutant(adn));
    }

    @Test
    public void testADNMutanteTrueDiag() throws Exception{
    	 //*
    	 //GTGCGA   
    	 //CGCTGC   
    	 //TTGTTT   
    	 //AGAGAG   
    	 //GCGTCA    
    	 //TCACTG
    	 //     *
        String[] adn = {"GTGCGA","CGCTGC","TTGTTT","AGAGAG","GCGTCA", "TCACTG"};
        assertTrue(mutanteServ.isMutant(adn));
    }
}
