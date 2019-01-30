package edu.eci;

/**
 * Esta clase representa a las excepciones definidas para las operaciones entre
 * n�mero complejos.
 * 
 * @author Carlos Andr�s Medina Rivas
 */
public class MathComplexException extends Exception {

    public static final String DIVISION_COMPLEJA_CERO = "La divisi�n por 0 en los n�meros complejos no est� definida.";
    public static final String LONGITUD_VECTORES_DIFERENTE = "Los vectores deben tener la misma longitud.";
    public static final String SUMA_DIMENSION_MATRICES_DIFERENTE = "Las matrices deben tener la misma dimensi�n para sumarlas.";
    public static final String MULTIPLICACION_DIMENSION_MATRICES_DIFERENTE = "La dimension de las columnas de la matriz m1 debe ser igual a la dimensi�n de las filas de la matriz m2 para multiplicarlas.";

    public MathComplexException(String mensaje) {
        super(mensaje);
    }
}