package edu.eci;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for MathComplexTest.
 * @author Carlos Andrés Medina Rivas
 */
public class MathComplexTest extends TestCase {
	
    /**
     * Create the test case
     * @param testName name of the test case
     */
    public MathComplexTest( String testName ) {
    	super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
    	return new TestSuite( MathComplexTest.class );
    }
   
   /**
    * 
    */
    public void testDeberiaSumarDosNumeroComplejos1() {
    	ComplexNumber c1 = new ComplexNumber(1, 5);
    	ComplexNumber c2 = new ComplexNumber(7, 3);
    	ComplexNumber result = MathComplex.sumar(c1, c2);
    	ComplexNumber resultToCompare = new ComplexNumber(8, 8);
        assertTrue(result.getReal() == resultToCompare.getReal() && result.getImaginario() == resultToCompare.getImaginario());
    }
    
    /**
     * 
     */
    public void testDeberiaSumarDosNumeroComplejos2() {
		ComplexNumber c1 = new ComplexNumber(26, 9.8);
		ComplexNumber c2 = new ComplexNumber(2.6, 43);
		ComplexNumber result = MathComplex.sumar(c1, c2);
		ComplexNumber resultToCompare = new ComplexNumber(28.6, 52.8);
		assertTrue(result.getReal() == resultToCompare.getReal() && result.getImaginario() == resultToCompare.getImaginario());
    }		
     
     /**
      * 
      */
     public void testDeberiaSumarDosNumeroComplejos3() {
		ComplexNumber c1 = new ComplexNumber(50.1, 6.7);
		ComplexNumber c2 = new ComplexNumber(47.9, 5.8);
		ComplexNumber result = MathComplex.sumar(c1, c2);
		ComplexNumber resultToCompare = new ComplexNumber(98, 12.5);
		assertTrue(result.getReal() == resultToCompare.getReal() && result.getImaginario() == resultToCompare.getImaginario());
     }
     
     /**
      * 
      */
     public void testDeberiaRestarDosNumeroComplejos1() {
		ComplexNumber c1 = new ComplexNumber(6, 10);
		ComplexNumber c2 = new ComplexNumber(8, 6);
		ComplexNumber result = MathComplex.restar(c1, c2);
		ComplexNumber resultToCompare = new ComplexNumber(-2, 4);
		assertTrue(result.getReal() == resultToCompare.getReal() && result.getImaginario() == resultToCompare.getImaginario());
     }
     
     /**
      * 
      */
     public void testDeberiaRestarDosNumeroComplejos2() {
		ComplexNumber c1 = new ComplexNumber(80.5, 65);
		ComplexNumber c2 = new ComplexNumber(9.8, 78);
		ComplexNumber result = MathComplex.restar(c1, c2);
		ComplexNumber resultToCompare = new ComplexNumber(70.7, -13);
		assertTrue(result.getReal() == resultToCompare.getReal() && result.getImaginario() == resultToCompare.getImaginario());
     }
     
     /**
      * 
      */
     public void testDeberiaRestarDosNumeroComplejos3() {
		ComplexNumber c1 = new ComplexNumber(9.2, 47.4);
		ComplexNumber c2 = new ComplexNumber(12.7, 8.2);
		ComplexNumber result = MathComplex.restar(c1, c2);
		ComplexNumber resultToCompare = new ComplexNumber(-3.5, 39.2);
		assertTrue(result.getReal() == resultToCompare.getReal() && result.getImaginario() == resultToCompare.getImaginario());
     }
     
     /**
      * 
      */
     public void testDeberiaMultiplicarDosNumeroComplejos1() {
		ComplexNumber c1 = new ComplexNumber(2, 3);
		ComplexNumber c2 = new ComplexNumber(4, 5);
		ComplexNumber result = MathComplex.multiplicar(c1, c2);
		ComplexNumber resultToCompare = new ComplexNumber(-7, 22);
		assertTrue(result.getReal() == resultToCompare.getReal() && result.getImaginario() == resultToCompare.getImaginario());
     }
     
     /**
      * 
      */
     public void testDeberiaMultiplicarDosNumeroComplejos2() {
		ComplexNumber c1 = new ComplexNumber(3.7, 0);
		ComplexNumber c2 = new ComplexNumber(14.1, 4.7);
		ComplexNumber result = MathComplex.multiplicar(c1, c2);
		ComplexNumber resultToCompare = new ComplexNumber(52.17, 17.39);
		assertTrue(result.getReal() == resultToCompare.getReal() && result.getImaginario() == resultToCompare.getImaginario());
     }
     
     /**
      * 
      */
     public void testDeberiaMultiplicarDosNumeroComplejo3() {
		ComplexNumber c1 = new ComplexNumber(-5, -2);
		ComplexNumber c2 = new ComplexNumber(0, 0);
		ComplexNumber result = MathComplex.multiplicar(c1, c2);
		ComplexNumber resultToCompare = new ComplexNumber(0, 0);
		assertTrue(result.getReal() == resultToCompare.getReal() && result.getImaginario() == resultToCompare.getImaginario());
     }
     
     /**
      * 
      */
     public void testDeberiaDividirDosNumeroComplejos1() {
		ComplexNumber c1 = new ComplexNumber(5, 0);
		ComplexNumber c2 = new ComplexNumber(0, 2);
		ComplexNumber result = new ComplexNumber();
		try {
			result = MathComplex.dividir(c1, c2);
		} catch (MathComplexException e) {
			System.out.println(e.getMessage());
		}
		ComplexNumber resultToCompare = new ComplexNumber(0, -2.5);
		assertTrue(result.getReal() == resultToCompare.getReal() && result.getImaginario() == resultToCompare.getImaginario());
     }
     
     /**
      * 
      */
     public void testDeberiaDividirDosNumeroComplejos2() {
		ComplexNumber c1 = new ComplexNumber(0, 5);
		ComplexNumber c2 = new ComplexNumber(2, 0);
		ComplexNumber result = new ComplexNumber();
		try {
			result = MathComplex.dividir(c1, c2);
		} catch (MathComplexException e) {
			System.out.println(e.getMessage());
		}
		ComplexNumber resultToCompare = new ComplexNumber(0, 2.5);
		assertTrue(result.getReal() == resultToCompare.getReal() && result.getImaginario() == resultToCompare.getImaginario());
     }
     
     /**
      * 
      */
     public void testDeberiaDividirDosNumeroComplejos3() {
		ComplexNumber c1 = new ComplexNumber(0, 3);
		ComplexNumber c2 = new ComplexNumber(-1, -1);
		ComplexNumber result = new ComplexNumber();
		try {
			result = MathComplex.dividir(c1, c2);
		} catch (MathComplexException e) {
			System.out.println(e.getMessage());
		}
		ComplexNumber resultToCompare = new ComplexNumber(-1.5, -1.5);
		assertTrue(result.getReal() == resultToCompare.getReal() && result.getImaginario() == resultToCompare.getImaginario());
     }
     
     /**
      * 
      */
     public void testNoDeberiaDividirDosNumeroComplejosSiElDenominadorEsCero() {
		ComplexNumber c1 = new ComplexNumber(-8, 3);
		ComplexNumber c2 = new ComplexNumber(0, 0);
		try {
			ComplexNumber result = MathComplex.dividir(c1, c2);
		} catch (MathComplexException e) {
			assertTrue(e.getMessage().equals(MathComplexException.DIVISION_COMPLEJA_CERO));
		}
     }
}
