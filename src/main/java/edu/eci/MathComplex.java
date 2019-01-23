package edu.eci;

import java.lang.Math;

/**
 * Esta clase contiene las operaciones que se pueden realizar con los n�meros complejos.
 * @author Carlos Andr�s Medina Rivas
 * @version 1.0
 */
public class MathComplex {
	
	/**
	 * Este m�todo realiza la suma de dos n�mero complejos y devuelve el nuevo
	 * n�mero complejo.
	 * @param c1
	 * @param c2
	 * @return el nuevo n�mero complejo resultado de la suma.
	 */
	public static ComplexNumber sumar(ComplexNumber c1, ComplexNumber c2) {
		double real = c1.getReal() + c2.getReal();
		double imaginario = c1.getImaginario() + c2.getImaginario();
		return new ComplexNumber(real, imaginario);
	}
	
	/**
	 * Este m�todo realiza la resta de dos n�mero complejos y devuelve el nuevo
	 * n�mero complejo.
	 * @param c1
	 * @param c2
	 * @return el nuevo n�mero complejo resultado de la resta.
	 */
	public static ComplexNumber restar(ComplexNumber c1, ComplexNumber c2) {
		double real = c1.getReal() - c2.getReal();
		double imaginario = c1.getImaginario() - c2.getImaginario();
		return new ComplexNumber(real, imaginario);
	}
	
	/**
	 * Este m�todo realiza la multiplicaci�n de dos n�mero complejos y 
	 * devuelve el nuevo n�mero complejo.
	 * @param c1
	 * @param c2
	 * @return el nuevo n�mero complejo resultado de la multiplicaci�n.
	 */
	public static ComplexNumber multiplicar(ComplexNumber c1, ComplexNumber c2) {
		double real = (c1.getReal() * c2.getReal()) - (c1.getImaginario() * c2.getImaginario());
		double imaginario = (c1.getReal() * c2.getImaginario()) - (c1.getImaginario() * c2.getReal());
		return new ComplexNumber(real, imaginario);
	}
	
	/**
	 * Este m�todo realiza la divisi�n de dos n�mero complejos y 
	 * devuelve el nuevo n�mero complejo.
	 * @param c1
	 * @param c2
	 * @return el nuevo n�mero complejo resultado de la divisi�n.
	 */
	public static ComplexNumber dividir(ComplexNumber c1, ComplexNumber c2) {
		double denominador = Math.pow(c2.getReal(), 2) + Math.pow(c2.getImaginario(), 2);
		double real = ((c1.getReal() * c2.getReal()) + (c1.getImaginario() * c2.getImaginario())) / denominador;
		double imaginario = ((c2.getReal() * c1.getImaginario()) - (c1.getReal() * c2.getImaginario())) / denominador;
		return new ComplexNumber(real, imaginario);
	}
	
	/**
	 * Este m�todo convierte un n�mero complejo de coordenadas cartesianas 
	 * a coordenadas polares.
	 * @param c
	 * @return el n�mero complejo con las coordenadas polares.
	 */
	public static ComplexNumber conversionAPolar(ComplexNumber c) {
		return new ComplexNumber(c.modulo(), c.phase());
	}
	
	/**
	 * Este m�todo convierte un n�mero complejo de coordenadas polares 
	 * a coordenadas cartesianas.
	 * @param c
	 * @return el n�mero complejo con las coordenadas cartesianas.
	 */
	public static ComplexNumber conversionACartesiano(ComplexNumber c) {
		return new ComplexNumber(c.getReal() * Math.cos(c.getImaginario()), c.getReal() * Math.sin(c.getImaginario()));
	}
}
