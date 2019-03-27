package edu.eci.complexnumbers.exceptions;

/**
 * Esta clase representa a las excepciones definidas para un sistema cuantico.
 *
 * @author Carlos Andres Medina Rivas
 */
public class QuantumSystemException extends Exception {

    public static final String MATRIZ_NO_HERMITIANA = "La matriz dada no es hermitiana.";

    public QuantumSystemException(String mensaje) {
        super(mensaje);
    }
}
