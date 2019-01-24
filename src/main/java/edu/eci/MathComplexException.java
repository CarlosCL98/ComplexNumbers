package edu.eci;

import java.lang.Exception;;

public class MathComplexException extends Exception{
	
	public static final String DIVISION_COMPLEJA_CERO = "La división por 0 en los números complejos no está definida.";
	
	public MathComplexException(String mensaje) {
		super(mensaje);
	}
}
