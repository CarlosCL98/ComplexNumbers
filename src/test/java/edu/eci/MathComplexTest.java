package edu.eci;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Pruebas unitarias para la clase MathComplex.
 *
 * @author Carlos Andres Medina Rivas
 */
public class MathComplexTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MathComplexTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MathComplexTest.class);
    }

    public void deberiaCompararDosComplejosTest() {
        ComplexNumber c1 = new ComplexNumber(50, 35);
        ComplexNumber c2 = new ComplexNumber(50, 35);
        assertTrue(c1.equals(c2));

        ComplexNumber c3 = new ComplexNumber(50, 35);
        ComplexNumber c4 = new ComplexNumber(50, -35);
        assertFalse(c3.equals(c4));
    }

    public void testDeberiaSumarDosNumeroComplejos() {
        ComplexNumber c1 = new ComplexNumber(1, 5);
        ComplexNumber c2 = new ComplexNumber(7, 3);
        ComplexNumber result1 = MathComplex.sumar(c1, c2);
        ComplexNumber resultToCompare1 = new ComplexNumber(8, 8);
        assertTrue(resultToCompare1.equals(result1));

        ComplexNumber c3 = new ComplexNumber(26, 9.8);
        ComplexNumber c4 = new ComplexNumber(2.6, 43);
        ComplexNumber result2 = MathComplex.sumar(c3, c4);
        ComplexNumber resultToCompare2 = new ComplexNumber(28.6, 52.8);
        assertTrue(resultToCompare2.equals(result2));

        ComplexNumber c5 = new ComplexNumber(50.1, 6.7);
        ComplexNumber c6 = new ComplexNumber(47.9, 5.8);
        ComplexNumber result3 = MathComplex.sumar(c5, c6);
        ComplexNumber resultToCompare3 = new ComplexNumber(98, 12.5);
        assertTrue(resultToCompare3.equals(result3));
    }

    public void testDeberiaRestarDosNumeroComplejos() {
        ComplexNumber c1 = new ComplexNumber(6, 10);
        ComplexNumber c2 = new ComplexNumber(8, 6);
        ComplexNumber result1 = MathComplex.restar(c1, c2);
        ComplexNumber resultToCompare1 = new ComplexNumber(-2, 4);
        assertTrue(resultToCompare1.equals(result1));

        ComplexNumber c3 = new ComplexNumber(80.5, 65);
        ComplexNumber c4 = new ComplexNumber(9.8, 78);
        ComplexNumber result2 = MathComplex.restar(c3, c4);
        ComplexNumber resultToCompare2 = new ComplexNumber(70.7, -13);
        assertTrue(resultToCompare2.equals(result2));

        ComplexNumber c5 = new ComplexNumber(9.2, 47.4);
        ComplexNumber c6 = new ComplexNumber(12.7, 8.2);
        ComplexNumber result3 = MathComplex.restar(c5, c6);
        ComplexNumber resultToCompare3 = new ComplexNumber(-3.5, 39.2);
        assertTrue(resultToCompare3.equals(result3));
    }

    public void testDeberiaMultiplicarDosNumeroComplejos() {
        ComplexNumber c1 = new ComplexNumber(2, 3);
        ComplexNumber c2 = new ComplexNumber(4, 5);
        ComplexNumber result1 = MathComplex.multiplicar(c1, c2);
        ComplexNumber resultToCompare1 = new ComplexNumber(-7, 22);
        assertTrue(resultToCompare1.equals(result1));

        ComplexNumber c3 = new ComplexNumber(3.7, 0);
        ComplexNumber c4 = new ComplexNumber(14.1, 4.7);
        ComplexNumber result2 = MathComplex.multiplicar(c3, c4);
        ComplexNumber resultToCompare2 = new ComplexNumber(52.17, 17.39);
        assertTrue(resultToCompare2.equals(result2));

        ComplexNumber c5 = new ComplexNumber(-5, -2);
        ComplexNumber c6 = new ComplexNumber(0, 0);
        ComplexNumber result3 = MathComplex.multiplicar(c5, c6);
        ComplexNumber resultToCompare3 = new ComplexNumber(0, 0);
        assertTrue(resultToCompare3.equals(result3));
    }

    public void testNoDeberiaDividirDosNumeroComplejosSiElDenominadorEsCero() {
        ComplexNumber c1 = new ComplexNumber(-8, 3);
        ComplexNumber c2 = new ComplexNumber(0, 0);
        try {
            MathComplex.dividir(c1, c2);
            fail("La división se logro exitosamente.");
        } catch (MathComplexException e) {
            assertTrue(e.getMessage().equals(MathComplexException.DIVISION_COMPLEJA_CERO));
        }
    }

    public void testDeberiaDividirDosNumeroComplejos1() {
        ComplexNumber c1 = new ComplexNumber(5, 0);
        ComplexNumber c2 = new ComplexNumber(0, 2);
        try {
            ComplexNumber result1 = MathComplex.dividir(c1, c2);
            ComplexNumber resultToCompare1 = new ComplexNumber(0, -2.5);
            assertTrue(resultToCompare1.equals(result1));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("La división no se pudo realizar");
        }

        ComplexNumber c3 = new ComplexNumber(0, 5);
        ComplexNumber c4 = new ComplexNumber(2, 0);
        try {
            ComplexNumber result2 = MathComplex.dividir(c3, c4);
            ComplexNumber resultToCompare2 = new ComplexNumber(0, 2.5);
            assertTrue(resultToCompare2.equals(result2));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("La división no se pudo realizar");
        }

        ComplexNumber c5 = new ComplexNumber(0, 3);
        ComplexNumber c6 = new ComplexNumber(-1, -1);
        try {
            ComplexNumber result3 = MathComplex.dividir(c5, c6);
            ComplexNumber resultToCompare3 = new ComplexNumber(-1.5, -1.5);
            assertTrue(resultToCompare3.equals(result3));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("La división no se pudo realizar");
        }
    }

    public void deberiaObtenerElConjugadoDeUnComplejo() {
        ComplexNumber c1 = new ComplexNumber(5, 9);
        ComplexNumber result1 = c1.conjugado();
        ComplexNumber resultToCompare1 = new ComplexNumber(5, -9);
        assertTrue(result1.equals(resultToCompare1));

        ComplexNumber c2 = new ComplexNumber(10, -84.5);
        ComplexNumber result2 = c2.conjugado();
        ComplexNumber resultToCompare2 = new ComplexNumber(10, 84.5);
        assertTrue(result2.equals(resultToCompare2));
    }

    public void testDeberiaCompararDosVectores() {
        ComplexNumber[] v1 = {new ComplexNumber(2, 5), new ComplexNumber(1, 1), new ComplexNumber(4, 3)};
        ComplexNumber[] v2 = {new ComplexNumber(2, 5), new ComplexNumber(1, 1), new ComplexNumber(4, 3)};
        assertTrue(MathComplex.equalsVector(v1, v2));

        ComplexNumber[] v3 = {new ComplexNumber(2, 5), new ComplexNumber(1, 1), new ComplexNumber(4, 3)};
        ComplexNumber[] v4 = {new ComplexNumber(2, 5), new ComplexNumber(1, 1)};
        assertFalse(MathComplex.equalsVector(v3, v4));

        ComplexNumber[] v5 = {new ComplexNumber(2, 5), new ComplexNumber(1, 1), new ComplexNumber(4, 3)};
        ComplexNumber[] v6 = {new ComplexNumber(2, 5), new ComplexNumber(8, 1), new ComplexNumber(4, 3)};
        assertFalse(MathComplex.equalsVector(v5, v6));
    }

    public void testNoDeberiaSumarDosVectoresDeComplejosDeDistintaLongitud() {
        ComplexNumber[] v1 = {new ComplexNumber(2, 5), new ComplexNumber(1, 1), new ComplexNumber(4, 3)};
        ComplexNumber[] v2 = {new ComplexNumber(1, 1), new ComplexNumber(2, 2)};
        try {
            MathComplex.sumarVectores(v1, v2);
            fail("La suma vectorial se logro exitosamente.");
        } catch (MathComplexException e) {
            assertTrue(e.getMessage().equals(MathComplexException.LONGITUD_VECTORES_DIFERENTE));
        }
    }

    public void testDeberiaSumarDosVectoresDeComplejos() {
        ComplexNumber[] v1 = {new ComplexNumber(2, 5), new ComplexNumber(1, 1), new ComplexNumber(4, 3)};
        ComplexNumber[] v2 = {new ComplexNumber(1, 1), new ComplexNumber(2, 2), new ComplexNumber(3, 3)};
        try {
            ComplexNumber[] result = MathComplex.sumarVectores(v1, v2);
            ComplexNumber[] resultToCompare = {new ComplexNumber(3, 6), new ComplexNumber(3, 3), new ComplexNumber(7, 6)};
            assertTrue(MathComplex.equalsVector(result, resultToCompare));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("La suma vectorial no se pudo realizar.");
        }

        ComplexNumber[] v3 = {new ComplexNumber(1, 5), new ComplexNumber(26, 9.8), new ComplexNumber(50.1, 6.7)};
        ComplexNumber[] v4 = {new ComplexNumber(7, 3), new ComplexNumber(2.6, 43), new ComplexNumber(47.9, 5.8)};
        try {
            ComplexNumber[] result2 = MathComplex.sumarVectores(v3, v4);
            ComplexNumber[] resultToCompare2 = {new ComplexNumber(8, 8), new ComplexNumber(28.6, 52.8), new ComplexNumber(98, 12.5)};
            assertTrue(MathComplex.equalsVector(result2, resultToCompare2));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("La suma vectorial no se pudo realizar.");
        }
    }

    public void testDeberiaObtenerElInversoDeUnVectorDeComplejos() {
        ComplexNumber[] v1 = {new ComplexNumber(2, 5), new ComplexNumber(1, 1), new ComplexNumber(4, 3)};
        ComplexNumber[] result1 = MathComplex.inversoVector(v1);
        ComplexNumber[] resultToCompare1 = {new ComplexNumber(-2, -5), new ComplexNumber(-1, -1), new ComplexNumber(-4, -3)};
        assertTrue(MathComplex.equalsVector(result1, resultToCompare1));

        ComplexNumber[] v2 = {new ComplexNumber(1, -5), new ComplexNumber(-26, 9.8), new ComplexNumber(50.1, 6.7)};
        ComplexNumber[] result2 = MathComplex.inversoVector(v2);
        ComplexNumber[] resultToCompare2 = {new ComplexNumber(-1, 5), new ComplexNumber(26, -9.8), new ComplexNumber(-50.1, -6.7)};
        assertTrue(MathComplex.equalsVector(result2, resultToCompare2));

        ComplexNumber[] v3 = {new ComplexNumber(3, -6), new ComplexNumber(3, 3), new ComplexNumber(-7, -6)};
        ComplexNumber[] result3 = MathComplex.inversoVector(v3);
        ComplexNumber[] resultToCompare3 = {new ComplexNumber(-3, 6), new ComplexNumber(-3, -3), new ComplexNumber(7, 6)};
        assertTrue(MathComplex.equalsVector(result3, resultToCompare3));
    }

    public void testDeberiaObtenerElConjugadoDeUnVectorDeComplejos() {
        ComplexNumber[] v1 = {new ComplexNumber(2, 5), new ComplexNumber(1, 1), new ComplexNumber(4, 3)};
        ComplexNumber[] result1 = MathComplex.conjugadoVector(v1);
        ComplexNumber[] resultToCompare1 = {new ComplexNumber(2, -5), new ComplexNumber(1, -1), new ComplexNumber(4, -3)};
        assertTrue(MathComplex.equalsVector(result1, resultToCompare1));

        ComplexNumber[] v2 = {new ComplexNumber(1, -5), new ComplexNumber(-26, 9.8), new ComplexNumber(50.1, 6.7)};
        ComplexNumber[] result2 = MathComplex.conjugadoVector(v2);
        ComplexNumber[] resultToCompare2 = {new ComplexNumber(1, 5), new ComplexNumber(-26, -9.8), new ComplexNumber(50.1, -6.7)};
        assertTrue(MathComplex.equalsVector(result2, resultToCompare2));

        ComplexNumber[] v3 = {new ComplexNumber(3, -6), new ComplexNumber(3, 3), new ComplexNumber(-7, -6)};
        ComplexNumber[] result3 = MathComplex.conjugadoVector(v3);
        ComplexNumber[] resultToCompare3 = {new ComplexNumber(3, 6), new ComplexNumber(3, -3), new ComplexNumber(-7, 6)};
        assertTrue(MathComplex.equalsVector(result3, resultToCompare3));
    }

    public void testDeberiaRealizarLaMultiplicacionEscalarConVector() {
        ComplexNumber[] v1 = {new ComplexNumber(2, 3), new ComplexNumber(4, 5), new ComplexNumber(3.7, 0)};
        ComplexNumber c1 = new ComplexNumber(2, 4);
        ComplexNumber[] result1 = MathComplex.multiplicacionEscalarConVectores(c1, v1);
        ComplexNumber[] resultToCompare1 = {new ComplexNumber(-8, 14), new ComplexNumber(-12, 26), new ComplexNumber(7.4, 14.8)};
        assertTrue(MathComplex.equalsVector(result1, resultToCompare1));

        ComplexNumber[] v2 = {new ComplexNumber(14.5, 4.5), new ComplexNumber(1, 4), new ComplexNumber(-5, -2)};
        ComplexNumber c2 = new ComplexNumber(3, 1);
        ComplexNumber[] result2 = MathComplex.multiplicacionEscalarConVectores(c2, v2);
        ComplexNumber[] resultToCompare2 = {new ComplexNumber(39, 28), new ComplexNumber(-1, 13), new ComplexNumber(-13, -11)};
        assertTrue(MathComplex.equalsVector(result2, resultToCompare2));
    }

    public void testDeberiaCompararDosMatrices() {
        ComplexNumber[][] m1 = {{new ComplexNumber(2, 5), new ComplexNumber(1, 1), new ComplexNumber(4, 3)}, {new ComplexNumber(1, 8), new ComplexNumber(7, 10), new ComplexNumber(0, 3)}};
        ComplexNumber[][] m2 = {{new ComplexNumber(2, 5), new ComplexNumber(1, 1), new ComplexNumber(4, 3)}, {new ComplexNumber(1, 8), new ComplexNumber(7, 10), new ComplexNumber(0, 3)}};
        assertTrue(MathComplex.equalsMatriz(m1, m2));

        ComplexNumber[][] m3 = {{new ComplexNumber(2, 5), new ComplexNumber(1, 1), new ComplexNumber(4, 3)}, {new ComplexNumber(1, 8), new ComplexNumber(7, 10), new ComplexNumber(0, 3)}};
        ComplexNumber[][] m4 = {{new ComplexNumber(2, 5), new ComplexNumber(1, 1)}, {new ComplexNumber(7, 10), new ComplexNumber(0, 3)}};
        assertFalse(MathComplex.equalsMatriz(m3, m4));

        ComplexNumber[][] m5 = {{new ComplexNumber(2, 5), new ComplexNumber(1, 1), new ComplexNumber(4, 3)}, {new ComplexNumber(1, 8), new ComplexNumber(7, 10), new ComplexNumber(0, 3)}};
        ComplexNumber[][] m6 = {{new ComplexNumber(2, 7), new ComplexNumber(-1, 1), new ComplexNumber(4, 3)}, {new ComplexNumber(1, 8), new ComplexNumber(7, 10), new ComplexNumber(45, 3)}};
        assertFalse(MathComplex.equalsMatriz(m5, m6));
    }

    public void testNoDeberiaRealizarLaSumaDeMatricesDeDimensionesDiferentes() {
        ComplexNumber[][] m1 = {{new ComplexNumber(2, 3), new ComplexNumber(4, 5)}, {new ComplexNumber(3, 0), new ComplexNumber(1, 5)}};
        ComplexNumber[][] m2 = {{new ComplexNumber(2, 3)}, {new ComplexNumber(3, 0)}};
        try {
            MathComplex.sumarMatrices(m1, m2);
            fail("La suma matricial se realizo exitosamente.");
        } catch (MathComplexException e) {
            assertTrue(e.getMessage().equals(MathComplexException.SUMA_DIMENSION_MATRICES_DIFERENTE));
        }
    }

    public void testDeberiaRealizarLaSumaDeMatrices() {
        ComplexNumber[][] m1 = {{new ComplexNumber(2, 3), new ComplexNumber(4, 5)}, {new ComplexNumber(3, 0), new ComplexNumber(1, 5)}};
        ComplexNumber[][] m2 = {{new ComplexNumber(2, 3), new ComplexNumber(4, 5)}, {new ComplexNumber(3, 1), new ComplexNumber(1, 5)}};
        try {
            ComplexNumber[][] result1 = MathComplex.sumarMatrices(m1, m2);
            ComplexNumber[][] resultToCompare1 = {{new ComplexNumber(4, 6), new ComplexNumber(8, 10)}, {new ComplexNumber(6, 1), new ComplexNumber(2, 10)}};
            assertTrue(MathComplex.equalsMatriz(result1, resultToCompare1));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("La suma matricial no se pudo realizar.");
        }

        ComplexNumber[][] m3 = {{new ComplexNumber(2, 3), new ComplexNumber(4, 5)}, {new ComplexNumber(3, 0), new ComplexNumber(1, -5)}};
        ComplexNumber[][] m4 = {{new ComplexNumber(2, -3.5), new ComplexNumber(7, 10)}, {new ComplexNumber(3, -1.5), new ComplexNumber(1, 5)}};
        try {
            ComplexNumber[][] result2 = MathComplex.sumarMatrices(m3, m4);
            ComplexNumber[][] resultToCompare2 = {{new ComplexNumber(4, -0.5), new ComplexNumber(11, 15)}, {new ComplexNumber(6, -1.5), new ComplexNumber(2, 0)}};
            assertTrue(MathComplex.equalsMatriz(result2, resultToCompare2));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("La suma matricial no se pudo realizar.");
        }
    }

    public void testDeberiaCalcularElInversoDeUnaMatriz() {
        ComplexNumber[][] m1 = {{new ComplexNumber(2, 3), new ComplexNumber(4, 5)}, {new ComplexNumber(3, 0), new ComplexNumber(1, 5)}};
        ComplexNumber[][] result1 = MathComplex.inversoMatriz(m1);
        ComplexNumber[][] resultToCompare1 = {{new ComplexNumber(-2, -3), new ComplexNumber(-4, -5)}, {new ComplexNumber(-3, 0), new ComplexNumber(-1, -5)}};
        assertTrue(MathComplex.equalsMatriz(result1, resultToCompare1));

        ComplexNumber[][] m2 = {{new ComplexNumber(8, -3), new ComplexNumber(-4, 5.5)}, {new ComplexNumber(3, 75), new ComplexNumber(-105, 5)}};
        ComplexNumber[][] result2 = MathComplex.inversoMatriz(m2);
        ComplexNumber[][] resultToCompare2 = {{new ComplexNumber(-8, 3), new ComplexNumber(4, -5.5)}, {new ComplexNumber(-3, -75), new ComplexNumber(105, -5)}};
        assertTrue(MathComplex.equalsMatriz(result2, resultToCompare2));
    }

    public void testDeberiaRealizarLaMultiplicacionEscalarConMatriz() {
        ComplexNumber[][] m1 = {{new ComplexNumber(4, 4), new ComplexNumber(5, 7)}, {new ComplexNumber(3.5, 25.5), new ComplexNumber(1, 5)}};
        ComplexNumber c1 = new ComplexNumber(2, 4);
        ComplexNumber[][] result1 = MathComplex.multiplicacionEscalarConMatrices(c1, m1);
        ComplexNumber[][] resultToCompare1 = {{new ComplexNumber(-8, 24), new ComplexNumber(-18, 34)}, {new ComplexNumber(-95, 65), new ComplexNumber(-18, 14)}};
        assertTrue(MathComplex.equalsMatriz(result1, resultToCompare1));

        ComplexNumber[][] m2 = {{new ComplexNumber(1, 4), new ComplexNumber(5, 3)}, {new ComplexNumber(3.5, 5.5), new ComplexNumber(1, 2)}};
        ComplexNumber c2 = new ComplexNumber(3, 5);
        ComplexNumber[][] result2 = MathComplex.multiplicacionEscalarConMatrices(c2, m2);
        ComplexNumber[][] resultToCompare2 = {{new ComplexNumber(-17, 17), new ComplexNumber(0, 34)}, {new ComplexNumber(-17, 34), new ComplexNumber(-7, 11)}};
        assertTrue(MathComplex.equalsMatriz(result2, resultToCompare2));
    }

    public void testDeberiaCalcularElConjugadoDeUnaMatriz() {
        ComplexNumber[][] m1 = {{new ComplexNumber(4, 4), new ComplexNumber(5, 7)}, {new ComplexNumber(3.5, 25.5), new ComplexNumber(1, 5)}};
        ComplexNumber[][] result1 = MathComplex.conjugadoMatriz(m1);
        ComplexNumber[][] resultToCompare1 = {{new ComplexNumber(4, -4), new ComplexNumber(5, -7)}, {new ComplexNumber(3.5, -25.5), new ComplexNumber(1, -5)}};
        assertTrue(MathComplex.equalsMatriz(result1, resultToCompare1));

        ComplexNumber[][] m2 = {{new ComplexNumber(1, -4), new ComplexNumber(-5, 3)}, {new ComplexNumber(-3.5, -5.5), new ComplexNumber(1, 2)}};
        ComplexNumber[][] result2 = MathComplex.conjugadoMatriz(m2);
        ComplexNumber[][] resultToCompare2 = {{new ComplexNumber(1, 4), new ComplexNumber(-5, -3)}, {new ComplexNumber(-3.5, 5.5), new ComplexNumber(1, -2)}};
        assertTrue(MathComplex.equalsMatriz(result2, resultToCompare2));
    }

    public void testDeberiaCalcularLaTranspuestaDeUnaMatriz() {
        ComplexNumber[][] m1 = {{new ComplexNumber(4, 4), new ComplexNumber(5, 7)}, {new ComplexNumber(3.5, 25.5), new ComplexNumber(1, 5)}};
        ComplexNumber[][] result1 = MathComplex.transpuestaMatriz(m1);
        ComplexNumber[][] resultToCompare1 = {{new ComplexNumber(4, 4), new ComplexNumber(3.5, 25.5)}, {new ComplexNumber(5, 7), new ComplexNumber(1, 5)}};
        assertTrue(MathComplex.equalsMatriz(result1, resultToCompare1));

        ComplexNumber[][] m2 = {{new ComplexNumber(1, -4), new ComplexNumber(-5, 3)}, {new ComplexNumber(-3.5, -5.5), new ComplexNumber(1, 2)}};
        ComplexNumber[][] result2 = MathComplex.transpuestaMatriz(m2);
        ComplexNumber[][] resultToCompare2 = {{new ComplexNumber(1, -4), new ComplexNumber(-3.5, -5.5)}, {new ComplexNumber(-5, 3), new ComplexNumber(1, 2)}};
        assertTrue(MathComplex.equalsMatriz(result2, resultToCompare2));

        ComplexNumber[][] m3 = {{new ComplexNumber(1, 4), new ComplexNumber(8, 10), new ComplexNumber(5, 3)}, {new ComplexNumber(3.5, 5.5), new ComplexNumber(6, 12), new ComplexNumber(1, 2)}};
        ComplexNumber[][] result3 = MathComplex.transpuestaMatriz(m3);
        ComplexNumber[][] resultToCompare3 = {{new ComplexNumber(1, 4), new ComplexNumber(3.5, 5.5)}, {new ComplexNumber(8, 10), new ComplexNumber(6, 12)}, {new ComplexNumber(5, 3), new ComplexNumber(1, 2)}};
        assertTrue(MathComplex.equalsMatriz(result3, resultToCompare3));
    }

    public void testDeberiaCalcularLaAdjuntaDeUnaMatriz() {
        ComplexNumber[][] m1 = {{new ComplexNumber(4, 4), new ComplexNumber(5, 7)}, {new ComplexNumber(3.5, 25.5), new ComplexNumber(1, 5)}};
        ComplexNumber[][] result1 = MathComplex.adjuntaMatriz(m1);
        ComplexNumber[][] resultToCompare1 = {{new ComplexNumber(4, -4), new ComplexNumber(3.5, -25.5)}, {new ComplexNumber(5, -7), new ComplexNumber(1, -5)}};
        assertTrue(MathComplex.equalsMatriz(result1, resultToCompare1));

        ComplexNumber[][] m2 = {{new ComplexNumber(1, -4), new ComplexNumber(-5, 3)}, {new ComplexNumber(-3.5, -5.5), new ComplexNumber(1, 2)}};
        ComplexNumber[][] result2 = MathComplex.adjuntaMatriz(m2);
        ComplexNumber[][] resultToCompare2 = {{new ComplexNumber(1, 4), new ComplexNumber(-3.5, 5.5)}, {new ComplexNumber(-5, -3), new ComplexNumber(1, -2)}};
        assertTrue(MathComplex.equalsMatriz(result2, resultToCompare2));

        ComplexNumber[][] m3 = {{new ComplexNumber(1, 4), new ComplexNumber(8, 10), new ComplexNumber(5, 3)}, {new ComplexNumber(3.5, 5.5), new ComplexNumber(6, 12), new ComplexNumber(1, 2)}};
        ComplexNumber[][] result3 = MathComplex.adjuntaMatriz(m3);
        ComplexNumber[][] resultToCompare3 = {{new ComplexNumber(1, -4), new ComplexNumber(3.5, -5.5)}, {new ComplexNumber(8, -10), new ComplexNumber(6, -12)}, {new ComplexNumber(5, -3), new ComplexNumber(1, -2)}};
        assertTrue(MathComplex.equalsMatriz(result3, resultToCompare3));
    }

    public void testNoDeberiaMultiplicarMatricesDeDiferentesDimensiones() {
        ComplexNumber[][] m1 = {{new ComplexNumber(1, 2), new ComplexNumber(3, 4)}, {new ComplexNumber(2, 1), new ComplexNumber(4, 5)}};
        ComplexNumber[][] m2 = {{new ComplexNumber(3, 5), new ComplexNumber(1, 5)}};
        try {
            MathComplex.multiplicarMatrices(m1, m2);
            fail("La multiplicacion matricial se realizo exitosamente.");
        } catch (MathComplexException e) {
            assertTrue(e.getMessage().equals(MathComplexException.MULTIPLICACION_DIMENSION_MATRICES_DIFERENTE));
        }
    }

    public void testDeberiaMultiplicarMatrices() {
        ComplexNumber[][] m1 = {{new ComplexNumber(1, 2), new ComplexNumber(3, 4)}, {new ComplexNumber(2, 1), new ComplexNumber(4, 5)}};
        ComplexNumber[][] m2 = {{new ComplexNumber(1, 2), new ComplexNumber(3, 4), new ComplexNumber(1, 1)}, {new ComplexNumber(2, 1), new ComplexNumber(4, 5), new ComplexNumber(4, 6)}};
        try {
            ComplexNumber[][] result1 = MathComplex.multiplicarMatrices(m1, m2);
            ComplexNumber[][] resultToCompare1 = {{new ComplexNumber(-1, 15), new ComplexNumber(-13, 41), new ComplexNumber(-13, 37)}, {new ComplexNumber(3, 19), new ComplexNumber(-7, 51), new ComplexNumber(-13, 47)}};
            assertTrue(MathComplex.equalsMatriz(result1, resultToCompare1));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("La multiplicacion matricial no se pudo realizar.");
        }

        ComplexNumber[][] m3 = {{new ComplexNumber(1, 2), new ComplexNumber(3, 4)}, {new ComplexNumber(2, 1), new ComplexNumber(4, 5)}, {new ComplexNumber(1, 1), new ComplexNumber(2, 2)}};
        ComplexNumber[][] m4 = {{new ComplexNumber(1, 2), new ComplexNumber(3, 4)}, {new ComplexNumber(2, 1), new ComplexNumber(4, 5)}};
        try {
            ComplexNumber[][] result2 = MathComplex.multiplicarMatrices(m3, m4);
            ComplexNumber[][] resultToCompare2 = {{new ComplexNumber(-1, 15), new ComplexNumber(-13, 41)}, {new ComplexNumber(3, 19), new ComplexNumber(-7, 51)}, {new ComplexNumber(1, 9), new ComplexNumber(-3, 25)}};
            assertTrue(MathComplex.equalsMatriz(result2, resultToCompare2));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("La multiplicacion matricial no se pudo realizar.");
        }
    }

    public void testNoDeberiaCalcularLaAccionDeUnaMatrizYUnVectorConDimensionesDiferentes() {
        ComplexNumber[][] m = {{new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(1, 0), new ComplexNumber(0, 0)}, {new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0)}};
        ComplexNumber[] v = {new ComplexNumber(1, 0), new ComplexNumber(0, 0)};
        try {
            MathComplex.accion(m, v);
            fail("La accion se realizo exitosamente.");
        } catch (MathComplexException e) {
            assertTrue(e.getMessage().equals(MathComplexException.ACCION_DIMENSION_MATRIZ_VECTOR_DIFERENTE));
        }
    }

    public void testDeberiaCalcularLaAccion() {
        ComplexNumber[][] m1 = {{new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(1, 0), new ComplexNumber(0, 0)}, {new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0)}};
        ComplexNumber[] v1 = {new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0)};
        try {
            ComplexNumber[] result1 = MathComplex.accion(m1, v1);
            ComplexNumber[] resultToCompare1 = {new ComplexNumber(2, 0), new ComplexNumber(0, 0), new ComplexNumber(2, 0)};
            assertTrue(MathComplex.equalsVector(result1, resultToCompare1));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("La accion no se pudo realizar.");
        }

        ComplexNumber[][] m2 = {{new ComplexNumber(1, 1), new ComplexNumber(0, -3), new ComplexNumber(1, 0)}, {new ComplexNumber(0, 2), new ComplexNumber(0, 0), new ComplexNumber(0, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(1, 3), new ComplexNumber(5, 1)}};
        ComplexNumber[] v2 = {new ComplexNumber(-1, -1), new ComplexNumber(0, -5), new ComplexNumber(2, 3)};
        try {
            ComplexNumber[] result2 = MathComplex.accion(m2, v2);
            ComplexNumber[] resultToCompare2 = {new ComplexNumber(-13, 1), new ComplexNumber(2, -2), new ComplexNumber(22, 12)};
            assertTrue(MathComplex.equalsVector(result2, resultToCompare2));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("La accion no se pudo realizar.");
        }
    }

    public void testNoDeberiaCalcularElProductoInternoDeVectoresConLongitudDiferentes() {
        ComplexNumber[] v1 = {new ComplexNumber(1, 1), new ComplexNumber(0, 2), new ComplexNumber(0, 0)};
        ComplexNumber[] v2 = {new ComplexNumber(1, 0), new ComplexNumber(0, 0)};
        try {
            MathComplex.productoInternoVectores(v1, v2);
            fail("El producto interno se realizo exitosamente.");
        } catch (MathComplexException e) {
            assertTrue(e.getMessage().equals(MathComplexException.LONGITUD_VECTORES_DIFERENTE));
        }
    }

    public void testDeberiaCalcularElProductoInternoEntreVectores() {
        ComplexNumber[] v1 = {new ComplexNumber(1, 1), new ComplexNumber(0, 2), new ComplexNumber(1, 0)};
        ComplexNumber[] v2 = {new ComplexNumber(1, 0), new ComplexNumber(1, 0), new ComplexNumber(1, 3)};
        try {
            ComplexNumber result1 = MathComplex.productoInternoVectores(v1, v2);
            ComplexNumber resultToCompare1 = new ComplexNumber(2, 0);
            assertTrue(result1.equals(resultToCompare1));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("El producto interno vectorial no se pudo realizar.");
        }

        ComplexNumber[] v3 = {new ComplexNumber(0, -3), new ComplexNumber(0, 0), new ComplexNumber(1, 3)};
        ComplexNumber[] v4 = {new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(5, 1)};
        try {
            ComplexNumber result2 = MathComplex.productoInternoVectores(v3, v4);
            ComplexNumber resultToCompare2 = new ComplexNumber(8, -11);
            assertTrue(result2.equals(resultToCompare2));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("El producto interno vectorial no se pudo realizar.");
        }

        ComplexNumber[] v5 = {new ComplexNumber(1, 2), new ComplexNumber(0, 2), new ComplexNumber(-6, -3)};
        ComplexNumber[] v6 = {new ComplexNumber(0, 5), new ComplexNumber(4, -6), new ComplexNumber(5, 1)};
        try {
            ComplexNumber result3 = MathComplex.productoInternoVectores(v5, v6);
            ComplexNumber resultToCompare3 = new ComplexNumber(-35, 6);
            assertTrue(result3.equals(resultToCompare3));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("El producto interno vectorial no se pudo realizar.");
        }

        ComplexNumber[] v7 = {new ComplexNumber(1, 2), new ComplexNumber(0, 2), new ComplexNumber(-6, -3)};
        ComplexNumber[] v8 = {new ComplexNumber(1, 2), new ComplexNumber(0, 2), new ComplexNumber(-6, -3)};
        try {
            ComplexNumber result4 = MathComplex.productoInternoVectores(v7, v8);
            ComplexNumber resultToCompare4 = new ComplexNumber(54, 0);
            assertTrue(result4.equals(resultToCompare4));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("El producto interno vectorial no se pudo realizar.");
        }
    }

    public void testDeberiaCalcularLaTrazaDeUnaMatrizCompleja() {
        ComplexNumber[][] m1 = {{new ComplexNumber(1, 2), new ComplexNumber(3, 4)}, {new ComplexNumber(2, 1), new ComplexNumber(4, 5)}};
        ComplexNumber result1 = MathComplex.trace(m1);
        ComplexNumber resultToCompare1 = new ComplexNumber(5, 7);
        assertTrue(result1.equals(resultToCompare1));

        ComplexNumber[][] m2 = {{new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(1, 0), new ComplexNumber(0, 0)}, {new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0)}};
        ComplexNumber result2 = MathComplex.trace(m2);
        ComplexNumber resultToCompare2 = new ComplexNumber(3, 0);
        assertTrue(result2.equals(resultToCompare2));

        ComplexNumber[][] m3 = {{new ComplexNumber(1, -4), new ComplexNumber(-5, 3)}, {new ComplexNumber(-3.5, -5.5), new ComplexNumber(1, 2)}};
        ComplexNumber result3 = MathComplex.trace(m3);
        ComplexNumber resultToCompare3 = new ComplexNumber(2, -2);
        assertTrue(result3.equals(resultToCompare3));
    }

    public void testDeberiaCalcularElProductoInternoEntreMatricesComplejas() {
        ComplexNumber[][] m1 = {{new ComplexNumber(1, 2), new ComplexNumber(3, 4)}, {new ComplexNumber(2, 1), new ComplexNumber(4, 5)}};
        ComplexNumber[][] m2 = {{new ComplexNumber(1, 2), new ComplexNumber(3, 4)}, {new ComplexNumber(2, 1), new ComplexNumber(4, 5)}};
        try {
            ComplexNumber result1 = MathComplex.productoInternoMatrices(m1, m2);
            ComplexNumber resultToCompare1 = new ComplexNumber(76, 0);
            assertTrue(result1.equals(resultToCompare1));
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("El producto interno matricial no se pudo realizar.");
        }

        ComplexNumber[][] m3 = {{new ComplexNumber(1, 0), new ComplexNumber(0, -2)}, {new ComplexNumber(0, -5), new ComplexNumber(3, 0)}};
        ComplexNumber[][] m4 = {{new ComplexNumber(0, -4), new ComplexNumber(-3, 0)}, {new ComplexNumber(2, 1), new ComplexNumber(3, -2)}};
        try {
            ComplexNumber result2 = MathComplex.productoInternoMatrices(m3, m4);
            ComplexNumber resultToCompare2 = new ComplexNumber(4, -6);
            assertTrue(result2.equals(resultToCompare2));
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("El producto interno matricial no se pudo realizar.");
        }
    }

    public void testDeberiaCalcularLaNormaDeUnVectorComplejo() {
        ComplexNumber[] v1 = {new ComplexNumber(1, 1), new ComplexNumber(0, 2), new ComplexNumber(1, 0)};
        try {
            double result1 = MathComplex.normaVector(v1);
            double resultToCompare1 = Math.sqrt(7);
            assertTrue(result1 == resultToCompare1);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("No se logro calcular la norma de un vector.");
        }

        ComplexNumber[] v2 = {new ComplexNumber(0, -3), new ComplexNumber(0, 0), new ComplexNumber(1, 3)};
        try {
            double result2 = MathComplex.normaVector(v2);
            double resultToCompare2 = Math.sqrt(19);
            assertTrue(result2 == resultToCompare2);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("No se logro calcular la norma de un vector.");
        }

        ComplexNumber[] v3 = {new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(5, 1)};
        try {
            double result3 = MathComplex.normaVector(v3);
            double resultToCompare3 = Math.sqrt(27);
            assertTrue(result3 == resultToCompare3);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("No se logro calcular la norma de un vector.");
        }

        ComplexNumber[] v4 = {new ComplexNumber(4, 3), new ComplexNumber(6, -4), new ComplexNumber(12, -7), new ComplexNumber(0, 13)};
        try {
            double result4 = MathComplex.normaVector(v4);
            double resultToCompare4 = Math.sqrt(439);
            assertTrue(result4 == resultToCompare4);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("No se logro calcular la norma de un vector.");
        }
    }

    public void testDeberiaCalcularLaDistanciaEntreDosVectoresComplejos() {
        ComplexNumber[] v1 = {new ComplexNumber(3, 0), new ComplexNumber(1, 0), new ComplexNumber(2, 0)};
        ComplexNumber[] v2 = {new ComplexNumber(2, 0), new ComplexNumber(2, 0), new ComplexNumber(-1, 0)};
        try {
            double result1 = MathComplex.distanciaEntreVectores(v1, v2);
            double resultToCompare1 = Math.sqrt(11);
            assertTrue(result1 == resultToCompare1);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("No se logro calcular la distancia entre dos vectores.");
        }
    }

    public void testNoDeberiaDeterminarSiUnaMatrizNoCuadradaEsHermitiana() {
        ComplexNumber[][] m = {{new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(1, 0), new ComplexNumber(0, 0)}};
        try {
            MathComplex.esHermitiana(m);
            fail("Se determino si la matriz es hermitiana.");
        } catch (MathComplexException ex) {
            assertTrue(ex.getMessage().equals(MathComplexException.MATRIZ_NO_ES_CUADRADA));
        }
    }

    public void testDeberiaDeterminarSiUnaMatrizCuadradaEsHermitiana() {
        ComplexNumber[][] m1 = {{new ComplexNumber(5, 0), new ComplexNumber(4, 5), new ComplexNumber(6, -16)}, {new ComplexNumber(4, -5), new ComplexNumber(13, 0), new ComplexNumber(7, 0)}, {new ComplexNumber(6, 16), new ComplexNumber(7, 0), new ComplexNumber(-2.1, 0)}};
        try {
            boolean result1 = MathComplex.esHermitiana(m1);
            assertTrue(result1);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("No se logro determinar si la matriz es hermitiana.");
        }

        ComplexNumber[][] m2 = {{new ComplexNumber(7, 0), new ComplexNumber(6, 5)}, {new ComplexNumber(6, -5), new ComplexNumber(-3, 0)}};
        try {
            boolean result2 = MathComplex.esHermitiana(m2);
            assertTrue(result2);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("No se logro determinar si la matriz es hermitiana.");
        }

        ComplexNumber[][] m3 = {{new ComplexNumber(1, 2), new ComplexNumber(3, 4)}, {new ComplexNumber(2, 1), new ComplexNumber(4, 5)}};
        try {
            boolean result3 = MathComplex.esHermitiana(m3);
            assertTrue(result3 == false);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("No se logro determinar si la matriz es hermitiana.");
        }
    }

    public void testDeberiaCalcularLaMatrizIdentidad() {
        ComplexNumber[][] result1 = MathComplex.matrizIdentidad(2);
        ComplexNumber[][] resultToCompare1 = {{new ComplexNumber(1, 0), new ComplexNumber(0, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(1, 0)}};
        assertTrue(MathComplex.equalsMatriz(result1, resultToCompare1));

        ComplexNumber[][] result2 = MathComplex.matrizIdentidad(3);
        ComplexNumber[][] resultToCompare2 = {{new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(1, 0), new ComplexNumber(0, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0)}};
        assertTrue(MathComplex.equalsMatriz(result2, resultToCompare2));
    }

    public void testNoDeberiaDeterminarSiUnaMatrizNoCuadradaEsUnitaria() {
        ComplexNumber[][] resultToCompare = {{new ComplexNumber(0, 0), new ComplexNumber(1, 0), new ComplexNumber(0, 0)}, {new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0)}};
        try {
            MathComplex.esUnitaria(resultToCompare);
            fail("Se determino si la matriz es unitaria.");
        } catch (MathComplexException ex) {
            assertTrue(ex.getMessage().equals(MathComplexException.MATRIZ_NO_ES_CUADRADA));
        }
    }

    public void testDeberiaDeterminarSiUnaMatrizCuadradaEsUnitaria() {
        ComplexNumber[][] m1 = {{new ComplexNumber(0.5, 0.5), new ComplexNumber(0.5, -0.5)}, {new ComplexNumber(0.5, -0.5), new ComplexNumber(0.5, 0.5)}};
        try {
            boolean result1 = MathComplex.esUnitaria(m1);
            assertTrue(result1);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("No se logro determinar si la matriz es unitaria.");
        }
    }

    /*public void testDeberiaCalcularElProductoTensorEntreMatrices() {
        ComplexNumber[][] m1 = {{new ComplexNumber(1, 0), new ComplexNumber(2, 0)}, {new ComplexNumber(3, 0), new ComplexNumber(4, 0)}};
        ComplexNumber[][] m2 = {{new ComplexNumber(5, 0), new ComplexNumber(6, 0)}, {new ComplexNumber(7, 0), new ComplexNumber(8, 0)}};
        ComplexNumber[][] result1 = MathComplex.productoTensorMatrices(m1, m2);
        ComplexNumber[][] resultToCompare1 = {{new ComplexNumber(5, 0), new ComplexNumber(6, 0), new ComplexNumber(10, 0), new ComplexNumber(12, 0)}, {new ComplexNumber(7, 0), new ComplexNumber(8, 0), new ComplexNumber(14, 0), new ComplexNumber(16, 0)}, {new ComplexNumber(15, 0), new ComplexNumber(18, 0), new ComplexNumber(20, 0), new ComplexNumber(24, 0)}, {new ComplexNumber(21, 0), new ComplexNumber(24, 0), new ComplexNumber(28, 0), new ComplexNumber(32, 0)}};
        assertTrue(MathComplex.equalsMatriz(result1, resultToCompare1));
    }*/
}
