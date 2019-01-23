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
     *
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
     * Prueba inicial
     */
   public void testApp() {
        assertTrue( true );
    }
   
   /**
    * 
    */
    public void testDeberiaSumarDosNumeroComplejos() {
    	ComplexNumber c1 = new ComplexNumber(1, 5);
    	ComplexNumber c2 = new ComplexNumber(7, 3);
    	ComplexNumber result = MathComplex.sumar(c1, c2);
    	ComplexNumber resultToCompare = new ComplexNumber(8,8);
        assertTrue(result.getReal() == resultToCompare.getReal() && result.getImaginario() == resultToCompare.getImaginario());
    }
}
