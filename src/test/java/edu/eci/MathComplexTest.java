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
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue( true );
    }
}
