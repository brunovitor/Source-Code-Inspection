/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;

/**
 *
 * @author 31207782
 */
public class PapelMoedaTest {
    
    public PapelMoedaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    
    @Test
    public void testGetValorValido() {
        System.out.println("getValor");
        PapelMoeda instance = new PapelMoeda(100, 50);
        int expResult = 100;
        int result = instance.getValor();
        assertEquals("Valor =", expResult, result);
    }
    @Test
     public void testGetValorInvalido() {
        System.out.println("getValor");
        PapelMoeda instance = new PapelMoeda(-100, 50);
        int expResult = -100;
        int result = instance.getValor();
        assertEquals("Valor = 20", expResult, result);
    }

    @Test
    public void testGetQuantidadeValida() {
        System.out.println("getQuantidade");
        PapelMoeda instance = new PapelMoeda(100, 7);
        int expResult = 7;
        int result = instance.getQuantidade();
        assertEquals("Quantidade = ", expResult, result);
    }
    
    @Test
    public void testGetQuantidadeInvalida() {
        System.out.println("getQuantidade");
        PapelMoeda instance = new PapelMoeda(20, -1);
        int expResult = -1;
        int result = instance.getQuantidade();
        assertEquals("Quantidade = ", expResult, result);
    }
}