package edu.eci;

import java.lang.Math;

/**
 * Esta clase representa a los n�mero complejos.
 *
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
     *
     * @param real
     * @param imaginario
     */
    public ComplexNumber(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    /**
     * Este m�todo retorna el m�dulo de este n�mero complejo.
     *
     * @return el m�dulo del n�mero complejo.
     */
    public double modulo() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginario, 2));
    }

    /**
     * Este m�todo retorna la fase de este n�mero complejo.
     *
     * @return la fase del n�mero complejo.
     */
    public double phase() {
        return Math.atan(this.imaginario / this.real);
    }

    /**
     * Este m�todo retorna el conjugado de este n�mero complejo.
     *
     * @return el conjugado de este n�mero complejo.
     */
    public ComplexNumber conjugado() {
        return new ComplexNumber(this.real, -(this.imaginario));
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
     *
     * @return el string de la forma a+bi de el n�mero complejo.
     */
    public String formaNormalNumeroComplejo() {
        String numeroComplejo = "";
        if (this.imaginario > 0) {
            numeroComplejo = this.real + "+" + this.imaginario + "i";
        } else {
            numeroComplejo = this.real + "" + this.imaginario + "i";
        }
        return numeroComplejo;
    }

    /**
     * Este m�todo retorna como string las coordenadas cartesianas de este
     * n�mero complejo
     *
     * @return un string de la forma (x=real,y=imaginario)
     */
    public String prettyPrintcoordenadasCartesianas() {
        return "(x = " + this.real + ", y = " + this.imaginario + ")";
    }

    /**
     * Este m�todo retorna como string las coordenadas polares de este n�mero
     * complejo
     *
     * @return un string de la forma (p=modulo,theta=fase)
     */
    public String prettyPrintCoordenadasPolares() {
        return "(p = " + this.modulo() + ", theta = " + this.phase() + ")";
    }
    
    public boolean equals(ComplexNumber c) {
        boolean equals = false;
        if (this.real == c.real && this.imaginario == c.imaginario) equals = true;
        return equals;
    }
}
