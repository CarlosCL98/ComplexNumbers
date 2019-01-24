package edu.eci;

import java.lang.Exception;;

public class MathComplexException extends Exception{
	
	public static final String DIVISION_COMPLEJA_CERO = "La divisi�n por 0 en los n�meros complejos no est� definida.";
	
	public MathComplexException(String mensaje) {
		super(mensaje);
	}
}
