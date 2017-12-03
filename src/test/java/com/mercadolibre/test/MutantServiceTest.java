package com.mercadolibre.test;

import com.mercadolibre.repository.RepositoryDNA;
import com.mercadolibre.service.MutantService;
import com.mercadolibre.service.MutantServiceImpl;

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

public class MutantServiceTest {

    @MockBean
    private RepositoryDNA dnaRepo;

    @Autowired
    private MutantService mutantService;
    

    @Test
    public void testWrongLetterADNReturnFalse() throws Exception{
    	//ATGCGA
    	//CAGTGC
    	//TTATTT
    	//AGACGG
    	//GCGTCA
    	//XCACTG
        String[] DNAChain = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA", "XCACTG"};
        assertFalse(mutantService.isMutant(DNAChain));
    }

    @Test
    public void testDNAIsMutantReturnFalse() throws Exception{
    	//ATGCGA
    	//CAGTGC
    	//TTATTT
    	//AGACGG
    	//GCGTCA
    	//TCACTG
        String[] DNAChain = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA", "TCACTG"};
        assertFalse(mutantService.isMutant(DNAChain));
    }

    @Test
    public void testDNAIsMutantReturnTrueHorizontalMatch() throws Exception{
    	//GGGGAT -->ok
    	//CAGTGC
    	//TTATGT
    	//AGACGG
    	//GCGTGA
    	//TCACGG
    	String[] DNAChain = {"GGGGAT","CAGTGC","TTATGT","AGACGG","GCGTGA", "TCACGG"};
        assertTrue(mutantService.isMutant(DNAChain));

    }
   

    @Test
    public void testDNAIsMutantReturnTrueVerticalMatch() throws Exception{
    	//    *
    	//ATGCGA
    	//CAGTGC
    	//TTATGT
    	//AGACGG
    	//GCGTGA
    	//TCACGG
        String[] DNAChain = {"ATGCGA","CAGTGC","TTATGT","AGACGG","GCGTGA", "TCACGG"};
        assertTrue(mutantService.isMutant(DNAChain));
    }

    @Test
    public void testDNAIsMutantReturnTrueDiagonalMatch() throws Exception{
    	 //*
    	 //GTGCGA   
    	 //CGCTGC   
    	 //TTGTTT   
    	 //AGAGAG   
    	 //GCGTCA    
    	 //TCACTG
    	 //     *
        String[] DNAChain = {"GTGCGA","CGCTGC","TTGTTT","AGAGAG","GCGTCA", "TCACTG"};
        assertTrue(mutantService.isMutant(DNAChain));
    }
}
