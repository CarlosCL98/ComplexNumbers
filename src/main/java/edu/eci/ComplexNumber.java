package edu.eci;

import java.lang.Math;

/**
 * Esta clase representa a los n�mero complejos.
 * @author Carlos Andr�s Medina Rivas
 * @version 1.0
 */
public class ComplexNumber {
	
	private double real;
	private double imaginario;
	
	/**
	 * Constructor vac�o de la clase NumeroComplejo.
	 */
	public ComplexNumber() {
	}
	
	/**
	 * Constructor con par�metros de la clase NumeroComplejo.
	 * @param real
	 * @param imaginario
	 */
	public ComplexNumber(double real, double imaginario) {
		this.real = real;
		this.imaginario = imaginario;
	}	
	
	/**
	 * Este m�todo retorna el m�dulo de este n�mero complejo.
	 * @return el m�dulo del n�mero complejo.
	 */
	public double modulo() {
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginario, 2));
	}
	
	/**
	 * Este m�todo retorna la fase de este n�mero complejo.
	 * @return la fase del n�mero complejo.
	 */
	public double phase() {
		return Math.atan(this.imaginario / this.real);
	}
	
	/**
	 * Este m�todo retorna el conjugado de este n�mero complejo.
	 * @return el conjugado de este n�mero complejo.
	 */
	public ComplexNumber conjugado() {
		return new ComplexNumber(this.real,-(this.imaginario));
	}
	
	/**
	 * 
	 * @return la parte real de este n�mero complejo.
	 */
	public double getReal() {
		return this.real;
	}
	
	/**
	 * 
	 * @param real
	 */
	public void setReal(double real) {
		this.real = real;
	}
	
	/**
	 * 
	 * @return la parte imaginaria de este n�mero complejo.
	 */
	public double getImaginario() {
		return this.imaginario;
	}
	
	/**
	 * 
	 * @param imaginario
	 */
	public void setImaginario(double imaginario) {
		this.imaginario = imaginario;
	}
	
	/**
	 * Este m�todo retorna como string este n�mero complejo
	 * @return el string de la forma a+bi de el n�mero complejo.
	 */
	public String numeroComplejo() {
		return this.real + "" + this.imaginario + "i";
	}
	
	/**
	 * Este m�todo retorna como string las coordenadas cartesianas de este n�mero complejo
	 * @return
	 */
	public String coordenadasCartesianas() {
		return "(x = "+this.real+", y = "+this.imaginario+")";
	}
	
	/**
	 * Este m�todo retorna como string las coordenadas polares de este n�mero complejo
	 * @return
	 */
	public String coordenadasPolares() {
		return "(p = "+this.modulo()+", theta = "+this.phase()+")";
	}
}
