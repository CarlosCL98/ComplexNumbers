package edu.eci;

import java.lang.Math;

/**
 * Esta clase contiene las operaciones que se pueden realizar con los numeros
 * complejos.
 *
 * @author Carlos Andres Medina Rivas
 * @version 3.0
 */
public class MathComplex {

    /**
     * Este metodo realiza la suma de dos numero complejos y devuelve el nuevo
     * numero complejo.
     *
     * @param c1 numero complejo.
     * @param c2 numero complejo.
     * @return el nuevo numero complejo resultado de la suma.
     */
    public static ComplexNumber sumar(ComplexNumber c1, ComplexNumber c2) {
        double real = c1.getReal() + c2.getReal();
        double imaginario = c1.getImaginario() + c2.getImaginario();
        return new ComplexNumber(real, imaginario);
    }

    /**
     * Este metodo realiza la resta de dos numero complejos y devuelve el nuevo
     * numero complejo.
     *
     * @param c1 numero complejo.
     * @param c2 numero complejo.
     * @return el nuevo numero complejo resultado de la resta.
     */
    public static ComplexNumber restar(ComplexNumber c1, ComplexNumber c2) {
        double real = c1.getReal() - c2.getReal();
        double imaginario = c1.getImaginario() - c2.getImaginario();
        return new ComplexNumber(real, imaginario);
    }

    /**
     * Este metodo realiza la multiplicacion de dos numero complejos y devuelve
     * el nuevo numero complejo.
     *
     * @param c1 numero complejo.
     * @param c2 numero complejo.
     * @return el nuevo numero complejo resultado de la multiplicacion.
     */
    public static ComplexNumber multiplicar(ComplexNumber c1, ComplexNumber c2) {
        double real = (c1.getReal() * c2.getReal()) - (c1.getImaginario() * c2.getImaginario());
        double imaginario = (c1.getReal() * c2.getImaginario()) + (c1.getImaginario() * c2.getReal());
        return new ComplexNumber(real, imaginario);
    }

    /**
     * Este metodo realiza la division de dos numero complejos y devuelve el
     * nuevo numero complejo.
     *
     * @param c1 numero complejo.
     * @param c2 numero complejo.
     * @return el nuevo numero complejo resultado de la division.
     * @throws MathComplexException
     */
    public static ComplexNumber dividir(ComplexNumber c1, ComplexNumber c2) throws MathComplexException {
        if ((c2.getReal() == (double) 0) && (c2.getImaginario() == (double) 0)) {
            throw new MathComplexException(MathComplexException.DIVISION_COMPLEJA_CERO);
        }
        double denominador = Math.pow(c2.getReal(), 2) + Math.pow(c2.getImaginario(), 2);
        double real = ((c1.getReal() * c2.getReal()) + (c1.getImaginario() * c2.getImaginario())) / denominador;
        double imaginario = ((c2.getReal() * c1.getImaginario()) - (c1.getReal() * c2.getImaginario())) / denominador;
        return new ComplexNumber(real, imaginario);
    }

    /**
     * Este metodo convierte un numero complejo de coordenadas cartesianas a
     * coordenadas polares.
     *
     * @param c numero complejo.
     * @return el numero complejo con las coordenadas polares.
     */
    public static ComplexNumber convertirAPolar(ComplexNumber c) {
        return new ComplexNumber(c.modulo(), c.phase());
    }

    /**
     * Este metodo convierte un numero complejo de coordenadas polares a
     * coordenadas cartesianas.
     *
     * @param c numero complejo.
     * @return el numero complejo con las coordenadas cartesianas.
     */
    public static ComplexNumber convertirACartesiano(ComplexNumber c) {
        return new ComplexNumber(c.getReal() * Math.cos(c.getImaginario()), c.getReal() * Math.sin(c.getImaginario()));
    }

    /**
     * Este metodo realiza la suma entre dos vectores dados y devuelve un nuevo
     * vector de complejos.
     *
     * @param v1 vector de complejos.
     * @param v2 vector de complejos.
     * @return el vector de complejos resultante de la suma.
     * @throws MathComplexException
     */
    public static ComplexNumber[] sumarVectores(ComplexNumber[] v1, ComplexNumber[] v2) throws MathComplexException {
        if (v1.length != v2.length) {
            throw new MathComplexException(MathComplexException.LONGITUD_VECTORES_DIFERENTE);
        }
        ComplexNumber[] sumaVectores = new ComplexNumber[v1.length];
        for (int i = 0; i < v1.length; i++) {
            sumaVectores[i] = sumar(v1[i], v2[i]);
        }
        return sumaVectores;
    }

    /**
     * Este metodo retorna el inverso aditivo de un vector dado, es decir que
     * niega la parte real e imaginaria de cada uno de sus componentes.
     *
     * @param v vector de complejos.
     * @return el inverso del vector de complejos.
     */
    public static ComplexNumber[] inversoVector(ComplexNumber[] v) {
        ComplexNumber[] inversoVector = new ComplexNumber[v.length];
        for (int i = 0; i < v.length; i++) {
            inversoVector[i] = v[i].negacion();
        }
        return inversoVector;
    }

    /**
     * Este metodo retorna el conjugado de un vector de complejos.
     *
     * @param v vector de complejos.
     * @return el conjugado del vector de complejos.
     */
    public static ComplexNumber[] conjugadoVector(ComplexNumber[] v) {
        ComplexNumber[] conjugadoVector = new ComplexNumber[v.length];
        for (int i = 0; i < v.length; i++) {
            conjugadoVector[i] = v[i].conjugado();
        }
        return conjugadoVector;
    }

    /**
     * Este metodo realiza la multiplicacion escalar entre un complejo y un
     * vector de complejos.
     *
     * @param c el complejo escalar a multiplicar.
     * @param v el vector de complejos al que se le va a multiplicar el escalar.
     * @return un vector de complejos resultante de la multiplicacion escalar.
     */
    public static ComplexNumber[] multiplicacionEscalarConVectores(ComplexNumber c, ComplexNumber[] v) {
        ComplexNumber[] multiplicacionEscalarVectores = new ComplexNumber[v.length];
        for (int i = 0; i < v.length; i++) {
            multiplicacionEscalarVectores[i] = multiplicar(c, v[i]);
        }
        return multiplicacionEscalarVectores;
    }

    /**
     * Este metodo calcula el producto interno (tambien llamado producto punto)
     * entre dos vectores dados.
     *
     * @param v1 vector compejo.
     * @param v2 vector compejo.
     * @return un numero complejo, resultado del producto interno entre los
     * vectores complejos v1 y v2.
     * @throws MathComplexException
     */
    public static ComplexNumber productoInternoVectores(ComplexNumber[] v1, ComplexNumber[] v2)
            throws MathComplexException {
        if (v1.length != v2.length) {
            throw new MathComplexException(MathComplexException.LONGITUD_VECTORES_DIFERENTE);
        }
        ComplexNumber productoInternoVector = new ComplexNumber();
        v1 = conjugadoVector(v1);
        for (int i = 0; i < v1.length; i++) {
            productoInternoVector = sumar(productoInternoVector, multiplicar(v1[i], v2[i]));
        }
        return productoInternoVector;
    }

    /**
     * Este metodo calcula la norma o longitud de un vector de complejos.
     *
     * @param v vector complejo.
     * @return un numero real que representa la norma o longitud del vector v de
     * complejos.
     * @throws MathComplexException
     */
    public static double normaVector(ComplexNumber[] v) throws MathComplexException {
        return Math.sqrt(productoInternoVectores(v, v).getReal());
    }

    /**
     * Este metodo calcula la distancia entre dos vectores complejos.
     *
     * @param v1 vector complejo.
     * @param v2 vector complejo.
     * @return un numero real que representa la distancia entre los vectores v1
     * y v2 de complejos.
     * @throws MathComplexException
     */
    public static double distanciaEntreVectores(ComplexNumber[] v1, ComplexNumber[] v2) throws MathComplexException {
        ComplexNumber[] resta = sumarVectores(v1, inversoVector(v2));
        return Math.sqrt(productoInternoVectores(resta, resta).getReal());
    }

    /**
     * Este metodo realiza la suma entre las matrices de complejos.
     *
     * @param m1 matriz de complejos.
     * @param m2 matriz de complejos.
     * @return una matriz de complejos resultado de la suma.
     * @throws MathComplexException
     */
    public static ComplexNumber[][] sumarMatrices(ComplexNumber[][] m1, ComplexNumber[][] m2)
            throws MathComplexException {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            throw new MathComplexException(MathComplexException.SUMA_DIMENSION_MATRICES_DIFERENTE);
        }
        ComplexNumber[][] sumaMatrices = new ComplexNumber[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            sumaMatrices[i] = sumarVectores(m1[i], m2[i]);
        }
        return sumaMatrices;
    }

    /**
     * Este metodo retorna el inverso aditivo de una matriz de complejos.
     *
     * @param m matriz de complejos.
     * @return el inverso de la matriz de complejos.
     */
    public static ComplexNumber[][] inversoMatriz(ComplexNumber[][] m) {
        ComplexNumber[][] inversoMatriz = new ComplexNumber[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            inversoMatriz[i] = inversoVector(m[i]);
        }
        return inversoMatriz;
    }

    /**
     * Este metodo realiza la multiplicacion escalar entre un complejo y una
     * matriz de complejos.
     *
     * @param c el complejo escalar a multiplicar.
     * @param m la matriz de complejos al que se le va a multiplicar el escalar.
     * @return una matriz de complejos resultado de la multiplicacion escalar.
     */
    public static ComplexNumber[][] multiplicacionEscalarConMatrices(ComplexNumber c, ComplexNumber[][] m) {
        ComplexNumber[][] multiplicacionEscalarMatrices = new ComplexNumber[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            multiplicacionEscalarMatrices[i] = multiplicacionEscalarConVectores(c, m[i]);
        }
        return multiplicacionEscalarMatrices;
    }

    /**
     * Este metodo calcula el conjugado de una matriz de complejos.
     *
     * @param m matriz de complejos.
     * @return el conjugado de la matriz de complejos.
     */
    public static ComplexNumber[][] conjugadoMatriz(ComplexNumber[][] m) {
        ComplexNumber[][] conjugadoMatriz = new ComplexNumber[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            conjugadoMatriz[i] = conjugadoVector(m[i]);
        }
        return conjugadoMatriz;
    }

    /**
     * Este metodo calcula la transpuesta de una matriz de complejos.
     *
     * @param m matriz de complejos.
     * @return la transpuesta de la matriz de complejos.
     */
    public static ComplexNumber[][] transpuestaMatriz(ComplexNumber[][] m) {
        ComplexNumber[][] transpuestaMatriz = new ComplexNumber[m[0].length][m.length];
        for (int i = 0; i < m[0].length; i++) {
            for (int j = 0; j < m.length; j++) {
                transpuestaMatriz[i][j] = m[j][i];
            }
        }
        return transpuestaMatriz;
    }

    /**
     * Este metodo calcula la adjunta de la matriz de complejos dada, es decir
     * que la transpone y luego la conjuga.
     *
     * @param m matriz de complejos.
     * @return la adjunta de la matriz de complejos.
     */
    public static ComplexNumber[][] adjuntaMatriz(ComplexNumber[][] m) {
        return conjugadoMatriz(transpuestaMatriz(m));
    }

    /**
     * Este metodo realiza la multiplicacion entre matrices complejas.
     *
     * @param m1 matriz compleja.
     * @param m2 matriz compleja.
     * @return una matriz compleja resultado de la multiplicacion de las
     * matrices.
     * @throws MathComplexException
     */
    public static ComplexNumber[][] multiplicarMatrices(ComplexNumber[][] m1, ComplexNumber[][] m2)
            throws MathComplexException {
        if (m1[0].length != m2.length) {
            throw new MathComplexException(MathComplexException.MULTIPLICACION_DIMENSION_MATRICES_DIFERENTE);
        }
        ComplexNumber[][] multiplicacionMatrices = new ComplexNumber[m1.length][m2[0].length];
        ComplexNumber result;
        int i, j;
        for (int i_f = 0; i_f < m1.length; i_f++) {
            for (int j_f = 0; j_f < m2[0].length; j_f++) {
                result = new ComplexNumber();
                i = 0;
                j = 0;
                while (j < m1[0].length && i < m2.length) {
                    result = sumar(result, multiplicar(m1[i_f][j], m2[i][j_f]));
                    j++;
                    i++;
                }
                multiplicacionMatrices[i_f][j_f] = result;
            }
        }
        return multiplicacionMatrices;
    }

    /**
     * Este metodo calcula y retorna la traza de una matriz de complejos, que es
     * la suma de los elementos de su diagonal principal.
     *
     * @param m matriz compleja.
     * @return un numero complejo, como resultado de calcular la traza de la
     * matriz m.
     */
    public static ComplexNumber trace(ComplexNumber[][] m) {
        ComplexNumber trace = new ComplexNumber();
        for (int i = 0; i < m.length; i++) {
            if (i < m[0].length) {
                trace = sumar(trace, m[i][i]);
            }
        }
        return trace;
    }

    /**
     * Este metodo calcula el producto interno entre dos matrices complejas.
     *
     * @param m1 matriz compleja.
     * @param m2 matriz compleja.
     * @return un numero complejo resultado del producto interno entre las
     * matrices complejas m1 y m2.
     * @throws MathComplexException
     */
    public static ComplexNumber productoInternoMatrices(ComplexNumber[][] m1, ComplexNumber[][] m2)
            throws MathComplexException {
        return trace(multiplicarMatrices(adjuntaMatriz(m1), m2));
    }

    /**
     * Este metodo calcula la accion retornando un vector de complejos,
     * resultado de operar una matriz y un vector ambos de complejos.
     *
     * @param m matriz compleja.
     * @param v vector compejo.
     * @return el resultado de la accion entre la matriz y el vector de
     * complejos.
     * @throws MathComplexException
     */
    public static ComplexNumber[] accion(ComplexNumber[][] m, ComplexNumber[] v) throws MathComplexException {
        if (m[0].length != v.length) {
            throw new MathComplexException(MathComplexException.ACCION_DIMENSION_MATRIZ_VECTOR_DIFERENTE);
        }
        ComplexNumber[] accion = new ComplexNumber[v.length];
        ComplexNumber result;
        for (int i = 0; i < v.length; i++) {
            result = new ComplexNumber();
            for (int j = 0; j < m[0].length; j++) {
                result = sumar(result, multiplicar(m[i][j], v[j]));
            }
            accion[i] = result;
        }
        return accion;
    }

    /**
     * Este metodo determina si una matriz cuadrada es hermitiana, es decir, si
     * la adjunta de la matriz compleja es igual a la matriz original.
     *
     * @param m matriz compleja.
     * @return un booleano que indica true si la matriz dada es hermitiana. En
     * caso contrario, false.
     * @throws MathComplexException
     */
    public static boolean esHermitiana(ComplexNumber[][] m) throws MathComplexException {
        if (m.length != m[0].length) {
            throw new MathComplexException(MathComplexException.MATRIZ_NO_ES_CUADRADA);
        }
        boolean esHermitana = false;
        ComplexNumber[][] adjuntaM = adjuntaMatriz(m);
        esHermitana = equalsMatriz(adjuntaM, m);
        return esHermitana;
    }

    /**
     * Este metodo determina cu�l es la matriz unitaria para n filas y n
     * columnas.
     *
     * @param n es el numero de filas y columnas.
     * @return la matriz unitaria respectiva.
     */
    public static ComplexNumber[][] matrizIdentidad(int n) {
        ComplexNumber[][] in = new ComplexNumber[n][n];
        for (int i = 0; i < n; i++) {
            in[i][i] = new ComplexNumber(1, 0);
        }
        return in;
    }

    /**
     * Este metodo determina si una matriz es unitaria, es decir, si el prodcuto
     * entre la matriz compleja con su adjunta da como resultado la matriz
     * identidad.
     *
     * @param m matriz compleja.
     * @return un booleano que indica true si la matriz dada es unitaria. En
     * caso contrario false.
     * @throws MathComplexException
     */
    public static boolean esUnitaria(ComplexNumber[][] m) throws MathComplexException {
        if (m.length != m[0].length) {
            throw new MathComplexException(MathComplexException.MATRIZ_NO_ES_CUADRADA);
        }
        boolean esUnitaria = false;
        ComplexNumber[][] in = matrizIdentidad(m.length);
        ComplexNumber[][] productoMatAdj = multiplicarMatrices(m, adjuntaMatriz(m));
        esUnitaria = equalsMatriz(productoMatAdj, in);
        return esUnitaria;
    }
    
    /*
    public static ComplexNumber[][] productoTensor(ComplexNumber[][] m1, ComplexNumber[][] m2) {
        ComplexNumber[][] tensor = new ComplexNumber[m1.length * m2.length][m1[0].length * m2[0].length];
        for (int i = 0; i < m1.length; i++) {

        }
        return tensor;
    }*/

    /**
     * Este metodo compara dos vectores complejos.
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
            for (int i = 0; i < v1.length && equals; i++) {
                if (!v1[i].equals(v2[i])) {
                    equals = false;
                }
            }
        }
        return equals;
    }

    /**
     * Este metodo compara dos matrices complejas.
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
            for (int i = 0; i < m1.length && equals; i++) {
                if (!equalsVector(m1[i], m2[i])) {
                    equals = false;
                }
            }
        }
        return equals;
    }
}
