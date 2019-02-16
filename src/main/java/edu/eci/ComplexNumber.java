package edu.eci;

import java.lang.Math;

/**
 * Esta clase representa a un numero complejo.
 *
 * @author Carlos Andres Medina Rivas
 * @version 2.0
 */
public class ComplexNumber {

    private double real;
    private double imaginario;

    /**
     * Constructor vacio de la clase NumeroComplejo.
     */
    public ComplexNumber() {
        this.real = (double) 0;
        this.imaginario = (double) 0;
    }

    /**
     * Constructor con parametros de la clase NumeroComplejo.
     *
     * @param real
     * @param imaginario
     */
    public ComplexNumber(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    /**
     * Este m�todo retorna el modulo de este numero complejo.
     *
     * @return el modulo del numero complejo.
     */
    public double modulo() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginario, 2));
    }

    /**
     * Este metodo retorna la fase de este numero complejo.
     *
     * @return la fase del n�mero complejo.
     */
    public double phase() {
        return Math.atan(imaginario / real);
    }

    /**
     * Este metodo retorna el conjugado de este numero complejo.
     *
     * @return el conjugado de este n�mero complejo.
     */
    public ComplexNumber conjugado() {
        return new ComplexNumber(real, -(imaginario));
    }

    /**
     * Este metodo retorna la negacion del este numero complejo, es decir que
     * niega tanto la parte real como la imaginaria.
     *
     * @return el numero complejo negado.
     */
    public ComplexNumber negacion() {
        return new ComplexNumber(-(real), -(imaginario));
    }

    /**
     *
     * @return la parte real de este numero complejo.
     */
    public double getReal() {
        return real;
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
     * @return la parte imaginaria de este numero complejo.
     */
    public double getImaginario() {
        return imaginario;
    }

    /**
     *
     * @param imaginario
     */
    public void setImaginario(double imaginario) {
        this.imaginario = imaginario;
    }

    /**
     * Este metodo retorna como string este numero complejo
     *
     * @return el string de la forma a+bi de el numero complejo.
     */
    public String prettyPrintFormaNormalNumeroComplejo() {
        String numeroComplejo = "";
        if (imaginario > 0) {
            numeroComplejo = real + "+" + imaginario + "i";
        } else {
            numeroComplejo = real + "" + imaginario + "i";
        }
        return numeroComplejo;
    }

    /**
     * Este metodo retorna como string las coordenadas cartesianas de este
     * numero complejo
     *
     * @return un string de la forma (x=real,y=imaginario)
     */
    public String prettyPrintcoordenadasCartesianas() {
        return "(x = " + real + ", y = " + imaginario + ")";
    }

    /**
     * Este metodo retorna como string las coordenadas polares de este numero
     * complejo
     *
     * @return un string de la forma (p=modulo,theta=fase)
     */
    public String prettyPrintCoordenadasPolares() {
        return "(p = " + modulo() + ", theta = " + phase() + ")";
    }

    /**
     * Este metodo compara este numero complejo con el numero complejo que es
     * ingresado en el parametro
     *
     * @param c es un numero complejo
     * @return true si son iguales, false si no lo son.
     */
    public boolean equals(ComplexNumber c) {
        boolean equals = false;
        if (real == c.real && imaginario == c.imaginario) {
            equals = true;
        }
        return equals;
    }
}
