package edu.eci;

import java.lang.Math;

/**
 * Esta clase contiene las operaciones que se pueden realizar con los números
 * complejos.
 *
 * @author Carlos Andrés Medina Rivas
 * @version 2.0
 */
public class MathComplex {

    /**
     * Este método realiza la suma de dos número complejos y devuelve el nuevo
     * número complejo.
     *
     * @param c1 número complejo.
     * @param c2 número complejo.
     * @return el nuevo número complejo resultado de la suma.
     */
    public static ComplexNumber sumarNumerosComplejos(ComplexNumber c1, ComplexNumber c2) {
        double real = c1.getReal() + c2.getReal();
        double imaginario = c1.getImaginario() + c2.getImaginario();
        return new ComplexNumber(real, imaginario);
    }

    /**
     * Este método realiza la resta de dos número complejos y devuelve el nuevo
     * número complejo.
     *
     * @param c1 número complejo.
     * @param c2 número complejo.
     * @return el nuevo número complejo resultado de la resta.
     */
    public static ComplexNumber restarNumerosComplejos(ComplexNumber c1, ComplexNumber c2) {
        double real = c1.getReal() - c2.getReal();
        double imaginario = c1.getImaginario() - c2.getImaginario();
        return new ComplexNumber(real, imaginario);
    }

    /**
     * Este método realiza la multiplicación de dos número complejos y devuelve
     * el nuevo número complejo.
     *
     * @param c1 número complejo.
     * @param c2 número complejo.
     * @return el nuevo número complejo resultado de la multiplicación.
     */
    public static ComplexNumber multiplicarNumerosComplejos(ComplexNumber c1, ComplexNumber c2) {
        double real = (c1.getReal() * c2.getReal()) - (c1.getImaginario() * c2.getImaginario());
        double imaginario = (c1.getReal() * c2.getImaginario()) + (c1.getImaginario() * c2.getReal());
        return new ComplexNumber(real, imaginario);
    }

    /**
     * Este método realiza la división de dos número complejos y devuelve el
     * nuevo número complejo.
     *
     * @param c1 número complejo.
     * @param c2 número complejo.
     * @return el nuevo número complejo resultado de la división.
     * @throws MathComplexException
     */
    public static ComplexNumber dividirNumerosComplejos(ComplexNumber c1, ComplexNumber c2) throws MathComplexException {
        if ((c2.getReal() == (double) 0) && (c2.getImaginario() == (double) 0)) {
            throw new MathComplexException(MathComplexException.DIVISION_COMPLEJA_CERO);
        }
        double denominador = Math.pow(c2.getReal(), 2) + Math.pow(c2.getImaginario(), 2);
        double real = ((c1.getReal() * c2.getReal()) + (c1.getImaginario() * c2.getImaginario())) / denominador;
        double imaginario = ((c2.getReal() * c1.getImaginario()) - (c1.getReal() * c2.getImaginario())) / denominador;
        return new ComplexNumber(real, imaginario);
    }

    /**
     * Este método convierte un número complejo de coordenadas cartesianas a
     * coordenadas polares.
     *
     * @param c número complejo.
     * @return el número complejo con las coordenadas polares.
     */
    public static ComplexNumber convertirAPolarNumerosComplejos(ComplexNumber c) {
        return new ComplexNumber(c.modulo(), c.phase());
    }

    /**
     * Este método convierte un número complejo de coordenadas polares a
     * coordenadas cartesianas.
     *
     * @param c número complejo.
     * @return el número complejo con las coordenadas cartesianas.
     */
    public static ComplexNumber convertirACartesianoNumerosComplejos(ComplexNumber c) {
        return new ComplexNumber(c.getReal() * Math.cos(c.getImaginario()), c.getReal() * Math.sin(c.getImaginario()));
    }

    /**
     * Este método realiza la suma entre dos vectores dados y devuelve un nuevo
     * vector de complejos.
     *
     * @param v1 vector de complejos.
     * @param v2 vector de complejos.
     * @return el vector de complejos resultante de la suma.
     * @throws MathComplexException
     */
    public static ComplexNumber[] sumarVectoresComplejos(ComplexNumber[] v1, ComplexNumber[] v2) throws MathComplexException {
        if (v1.length != v2.length) {
            throw new MathComplexException(MathComplexException.LONGITUD_VECTORES_DIFERENTE);
        }
        ComplexNumber[] sumaVectores = new ComplexNumber[v1.length];
        for (int i = 0; i < v1.length; i++) {
            sumaVectores[i] = sumarNumerosComplejos(v1[i], v2[i]);
        }
        return sumaVectores;
    }

    /**
     * Este método retorna el inverso aditivo de un vector dado, es decir que
     * niega la parte real e imaginaria de cada uno de sus componentes.
     *
     * @param v vector de complejos.
     * @return el inverso del vector de complejos.
     */
    public static ComplexNumber[] calcularInversoVector(ComplexNumber[] v) {
        ComplexNumber[] inversoVector = new ComplexNumber[v.length];
        for (int i = 0; i < v.length; i++) {
            inversoVector[i] = v[i].negacion();
        }
        return inversoVector;
    }

    /**
     * Este método retorna el conjugado de un vector de complejos.
     *
     * @param v vector de complejos.
     * @return el conjugado del vector de complejos.
     */
    public static ComplexNumber[] calcularConjugadoVector(ComplexNumber[] v) {
        ComplexNumber[] conjugadoVector = new ComplexNumber[v.length];
        for (int i = 0; i < v.length; i++) {
            conjugadoVector[i] = conjugadoVector[i].conjugado();
        }
        return conjugadoVector;
    }

    /**
     * Este método realiza la multiplicación escalar entre un complejo y un
     * vector de complejos.
     *
     * @param c el complejo escalar a multiplicar.
     * @param v el vector de complejos al que se le va a multiplicar el escalar.
     * @return un vector de complejos resultante de la multiplicación escalar.
     */
    public static ComplexNumber[] calcularMultiplicacionEscalarEnVectoresComplejos(ComplexNumber c, ComplexNumber[] v) {
        ComplexNumber[] multiplicacionEscalarVectores = new ComplexNumber[v.length];
        for (int i = 0; i < v.length; i++) {
            multiplicacionEscalarVectores[i] = multiplicarNumerosComplejos(c, v[i]);
        }
        return multiplicacionEscalarVectores;
    }

    /**
     * Este método realiza la suma entre las matríces de complejos.
     *
     * @param m1 matríz de complejos.
     * @param m2 matríz de complejos.
     * @return una matríz de complejos resultado de la suma.
     * @throws MathComplexException
     */
    public static ComplexNumber[][] sumarMatricesComplejas(ComplexNumber[][] m1, ComplexNumber[][] m2) throws MathComplexException {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            throw new MathComplexException(MathComplexException.SUMA_DIMENSION_MATRICES_DIFERENTE);
        }
        ComplexNumber[][] sumaMatrices = new ComplexNumber[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            sumaMatrices[i] = sumarVectoresComplejos(m1[i], m2[i]);
        }
        return sumaMatrices;
    }

    /**
     * Este método retorna el inverso aditivo de una matriz de complejos.
     *
     * @param m matríz de complejos.
     * @return el inverso de la matríz de complejos.
     */
    public static ComplexNumber[][] calcularInversoMatrizCompleja(ComplexNumber[][] m) {
        ComplexNumber[][] inversoMatriz = new ComplexNumber[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            inversoMatriz[i] = calcularInversoVector(m[i]);
        }
        return inversoMatriz;
    }

    /**
     * Este método realiza la multiplicación escalar entre un complejo y una
     * matríz de complejos.
     *
     * @param c el complejo escalar a multiplicar.
     * @param m la matriz de complejos al que se le va a multiplicar el escalar.
     * @return una matríz de complejos resultado de la multiplicación escalar.
     */
    public static ComplexNumber[][] calcularMultiplicacionEscalarEnMatricesComplejas(ComplexNumber c, ComplexNumber[][] m) {
        ComplexNumber[][] multiplicacionEscalarMatrices = new ComplexNumber[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            multiplicacionEscalarMatrices[i] = calcularMultiplicacionEscalarEnVectoresComplejos(c, m[i]);
        }
        return multiplicacionEscalarMatrices;
    }

    /**
     * Este método calcula el conjugado de una matriz de complejos.
     *
     * @param m matriz de complejos.
     * @return el conjugado de la matriz de complejos.
     */
    public static ComplexNumber[][] calcularConjugadoMatrizCompleja(ComplexNumber[][] m) {
        ComplexNumber[][] conjugadoMatriz = new ComplexNumber[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            conjugadoMatriz[i] = calcularConjugadoVector(m[i]);
        }
        return conjugadoMatriz;
    }

    /**
     * Este método calcula la transpuesta de una matriz de complejos.
     *
     * @param m matriz de complejos.
     * @return la transpuesta de la matriz de complejos.
     */
    public static ComplexNumber[][] calcularTranspuestaMatrizCompleja(ComplexNumber[][] m) {
        ComplexNumber[][] transpuestaMatriz = new ComplexNumber[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                transpuestaMatriz[j][i] = m[i][j];
            }
        }
        return transpuestaMatriz;
    }

    /**
     * Este método calcula la adjunta de la matriz de complejos dada, es decir
     * que la transpone y luego la conjuga.
     *
     * @param m matriz de complejos.
     * @return la adjunta de la matriz de complejos.
     */
    public static ComplexNumber[][] adjuntaMatrizCompleja(ComplexNumber[][] m) {
        return calcularConjugadoMatrizCompleja(calcularTranspuestaMatrizCompleja(m));
    }

    /**
     * Este método realiza la multiplicación entre matrices complejas.
     *
     * @param m1 matriz compleja.
     * @param m2 matriz compleja.
     * @return una matriz compleja resultado de la multiplicación de las
     * matrices.
     * @throws MathComplexException
     */
    public static ComplexNumber[][] multiplicarMatricesComplejas(ComplexNumber[][] m1, ComplexNumber[][] m2) throws MathComplexException {
        if (m1[0].length != m2.length) {
            throw new MathComplexException(MathComplexException.MULTIPLICACION_DIMENSION_MATRICES_DIFERENTE);
        }
        ComplexNumber[][] multiplicacionMatrices = new ComplexNumber[m1.length][m2[0].length];
        ComplexNumber result;
        int i_f = 0, j_f = 0;
        for (int i = 0; i < m1.length && i_f < m1.length; i++) {
            result = new ComplexNumber();
            for (int j = 0; j < m1[0].length; j++) {
                result = sumarNumerosComplejos(result, multiplicarNumerosComplejos(m1[i][j], m2[j][i]));
            }
            multiplicacionMatrices[i_f][j_f] = result;
            if (j_f >= m2[0].length) {
                i_f++;
                j_f = 0;
            } else {
                j_f++;
            }
        }
        return multiplicacionMatrices;
    }
    
    /**
     * Este método compara dos vectores complejos.
     * 
     * @param v1 vector de complejos.
     * @param v2 vector de complejos.
     * @return true si son iguales, false si no lo son.
     */
    public static boolean equalsVector(ComplexNumber[] v1, ComplexNumber[] v2) {
        boolean equals = true;
        if (v1.length != v2.length) {
            equals = false;
        } else {
            for (int i = 0; i < v1.length && !equals; i++) {
                if (!v1[i].equals(v2[i])) {
                    equals = false;
                }
            }
        }
        return equals;
    }
    
    /**
     * Este método compara dos matrices complejas.
     * 
     * @param m1 matriz de complejos.
     * @param m2 matriz de complejos.
     * @return true si son iguales, false si no lo son.
     */
    public static boolean equalsMatriz(ComplexNumber[][] m1, ComplexNumber[][] m2) {
        boolean equals = true;
        if (m1.length != m2.length && m1[0].length != m2[0].length) {
            equals = false;
        } else {
            for (int i = 0; i < m1.length && !equals; i++) {
                if (!equalsVector(m1[i], m2[i])) {
                    equals = false;
                }
            }
        }
        return equals;
    }
}
