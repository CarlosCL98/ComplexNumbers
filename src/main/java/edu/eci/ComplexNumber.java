package edu.eci;

import java.lang.Math;

/**
 * Esta clase representa a los número complejos.
 *
 * @author Carlos Andrés Medina Rivas
 * @version 1.0
 */
public class ComplexNumber {

    private double real;
    private double imaginario;

    /**
     * Constructor vacío de la clase NumeroComplejo.
     */
    public ComplexNumber() {
    }

    /**
     * Constructor con parámetros de la clase NumeroComplejo.
     *
     * @param real
     * @param imaginario
     */
    public ComplexNumber(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    /**
     * Este método retorna el módulo de este número complejo.
     *
     * @return el módulo del número complejo.
     */
    public double modulo() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginario, 2));
    }

    /**
     * Este método retorna la fase de este número complejo.
     *
     * @return la fase del número complejo.
     */
    public double phase() {
        return Math.atan(this.imaginario / this.real);
    }

    /**
     * Este método retorna el conjugado de este número complejo.
     *
     * @return el conjugado de este número complejo.
     */
    public ComplexNumber conjugado() {
        return new ComplexNumber(this.real, -(this.imaginario));
    }

    /**
     *
     * @return la parte real de este número complejo.
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
     * @return la parte imaginaria de este número complejo.
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
     * Este método retorna como string este número complejo
     *
     * @return el string de la forma a+bi de el número complejo.
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
     * Este método retorna como string las coordenadas cartesianas de este
     * número complejo
     *
     * @return un string de la forma (x=real,y=imaginario)
     */
    public String prettyPrintcoordenadasCartesianas() {
        return "(x = " + this.real + ", y = " + this.imaginario + ")";
    }

    /**
     * Este método retorna como string las coordenadas polares de este número
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
