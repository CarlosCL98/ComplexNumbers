package edu.eci;

import java.lang.Math;

/**
 * Esta clase contiene las operaciones que se pueden realizar con los números complejos.
 * @author Carlos Andrés Medina Rivas
 * @version 1.0
 */
public class MathComplex {
	
	/**
	 * Este método realiza la suma de dos número complejos y devuelve el nuevo
	 * número complejo.
	 * @param c1
	 * @param c2
	 * @return el nuevo número complejo resultado de la suma.
	 */
	public static ComplexNumber sumar(ComplexNumber c1, ComplexNumber c2) {
		double real = c1.getReal() + c2.getReal();
		double imaginario = c1.getImaginario() + c2.getImaginario();
		return new ComplexNumber(real, imaginario);
	}
	
	/**
	 * Este método realiza la resta de dos número complejos y devuelve el nuevo
	 * número complejo.
	 * @param c1
	 * @param c2
	 * @return el nuevo número complejo resultado de la resta.
	 */
	public static ComplexNumber restar(ComplexNumber c1, ComplexNumber c2) {
		double real = c1.getReal() - c2.getReal();
		double imaginario = c1.getImaginario() - c2.getImaginario();
		return new ComplexNumber(real, imaginario);
	}
	
	/**
	 * Este método realiza la multiplicación de dos número complejos y 
	 * devuelve el nuevo número complejo.
	 * @param c1
	 * @param c2
	 * @return el nuevo número complejo resultado de la multiplicación.
	 */
	public static ComplexNumber multiplicar(ComplexNumber c1, ComplexNumber c2) {
		double real = (c1.getReal() * c2.getReal()) - (c1.getImaginario() * c2.getImaginario());
		double imaginario = (c1.getReal() * c2.getImaginario()) - (c1.getImaginario() * c2.getReal());
		return new ComplexNumber(real, imaginario);
	}
	
	/**
	 * Este método realiza la división de dos número complejos y 
	 * devuelve el nuevo número complejo.
	 * @param c1
	 * @param c2
	 * @return el nuevo número complejo resultado de la división.
	 */
	public static ComplexNumber dividir(ComplexNumber c1, ComplexNumber c2) {
		double denominador = Math.pow(c2.getReal(), 2) + Math.pow(c2.getImaginario(), 2);
		double real = ((c1.getReal() * c2.getReal()) + (c1.getImaginario() * c2.getImaginario())) / denominador;
		double imaginario = ((c2.getReal() * c1.getImaginario()) - (c1.getReal() * c2.getImaginario())) / denominador;
		return new ComplexNumber(real, imaginario);
	}
	
	/**
	 * Este método convierte un número complejo de coordenadas cartesianas 
	 * a coordenadas polares.
	 * @param c
	 * @return el número complejo con las coordenadas polares.
	 */
	public static ComplexNumber conversionAPolar(ComplexNumber c) {
		return new ComplexNumber(c.modulo(), c.phase());
	}
	
	/**
	 * Este método convierte un número complejo de coordenadas polares 
	 * a coordenadas cartesianas.
	 * @param c
	 * @return el número complejo con las coordenadas cartesianas.
	 */
	public static ComplexNumber conversionACartesiano(ComplexNumber c) {
		return new ComplexNumber(c.getReal() * Math.cos(c.getImaginario()), c.getReal() * Math.sin(c.getImaginario()));
	}
}
