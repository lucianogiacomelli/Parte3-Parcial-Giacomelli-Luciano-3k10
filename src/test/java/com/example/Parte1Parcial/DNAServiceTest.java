package com.example.Parte1Parcial;

import org.junit.jupiter.api.Test;
import com.example.Parte1Parcial.entities.Algoritmo.mutantePrueba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class DNAServiceTest {



    @Autowired
    private mutantePrueba mutantePrueba;
    @Test
    public void testRows() throws Exception {
        String[] dna = {
                "AAAATG",
                "TGCAGT",
                "GCTTCC",
                "CCCCTG",
                "GTAGTC",
                "AGTCAC"
        };
        assertTrue(mutantePrueba.esMutante(dna));
    }

    @Test
    public void testColumns() throws Exception{
        String[] dna = {
                "AGAATG",
                "TGCAGT",
                "GCTTCC",
                "GTCCTC",
                "GTAGTC",
                "GGTCAC"
        };
        assertTrue(mutantePrueba.esMutante(dna));
    }

    @Test
    public void testMainDiagonals() throws Exception{
        String[] dna = {
                "AGAATG",
                "TACAGT",
                "GCAGCC",
                "TTGATG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(mutantePrueba.esMutante(dna));
    }

    @Test
    public void testSecondaryLeftDiagonals() throws Exception{
        String[] dna = {
                "ATAATG",
                "GTTAGT",
                "GGCTCG",
                "TTGATG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(mutantePrueba.esMutante(dna));
    }

    @Test
    public void testSecondaryRightDiagonals() throws Exception{
        String[] dna = {
                "ATAATG",
                "GTATGA",
                "GCTTAG",
                "TTTAGG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(mutantePrueba.esMutante(dna));
    }

    @Test
    public void testTertiaryLeftDiagonals() throws Exception{
        String[] dna = {
                "ATGATG",
                "GTAGTA",
                "CCTTGG",
                "TCTAGG",
                "GGCGTC",
                "AGTCAA"
        };
        assertTrue(mutantePrueba.esMutante(dna));
    }

    @Test
    public void testTertiaryRightDiagonals() throws Exception{
        String[] dna = {
                "ATGATG",
                "GTATTA",
                "AATTGG",
                "ACTAGT",
                "GGAGTC",
                "AGGCAA"
        };
        assertTrue(mutantePrueba.esMutante(dna));
    }

    @Test
    public void testNonMutant() throws Exception{
        String[] dna = {
                "ATGATG",
                "GTCTTA",
                "AATTGG",
                "ACTAGT",
                "GGATTC",
                "AGGCAA"
        };
        assertFalse(mutantePrueba.esMutante(dna));
    }


    // ====================================================================================================
    // Tests brindados por el profesor
    @Test
    public void testMutant1() throws Exception{
        String[] dna = {
                "AAAA",
                "CCCC",
                "TCAG",
                "GGTC"
        };
        assertTrue(mutantePrueba.esMutante(dna));
    }

    @Test
    public void testNonMutant1() throws Exception{
        String[] dna = {
                "AAAT",
                "AACC",
                "AAAC",
                "CGGG"
        };
        assertFalse(mutantePrueba.esMutante(dna));
    }

    @Test
    public void testMutant2() throws Exception{
        String[] dna = {
                "TGAC",
                "AGCC",
                "TGAC",
                "GGTC"
        };
        assertTrue(mutantePrueba.esMutante(dna));
    }

    @Test
    public void testNonMutant3() throws Exception{
        String[] dna = {
                "AAAA",
                "AAAA",
                "AAAA",
                "AAAA"
        };
        assertFalse(mutantePrueba.esMutante(dna));
    }

    @Test
    public void testNonMutant2() throws Exception{
        String[] dna = {
                "TGAC",
                "ATCC",
                "TAAG",
                "GGTC"
        };
        assertFalse(mutantePrueba.esMutante(dna));
    }

    @Test
    public void testMutant4() throws Exception{
        String[] dna = {
                "TCGGGTGAT",
                "TGATCCTTT",
                "TACGAGTGA",
                "AAATGTACG",
                "ACGAGTGCT",
                "AGACACATG",
                "GAATTCCAA",
                "ACTACGACC",
                "TGAGTATCC"
        };
        assertTrue(mutantePrueba.esMutante(dna));
    }

    @Test
    public void testMutant5() throws Exception {
        String[] dna = {
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "CCGACCAGT",
                "GGCACTCCA",
                "AGGACACTA",
                "CAAAGGCAT",
                "GCAGTCCCC"
        };
        assertTrue(mutantePrueba.esMutante(dna));
    }
}
