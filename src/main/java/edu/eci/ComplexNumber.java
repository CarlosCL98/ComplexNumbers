package edu.eci;

/**
 * Esta clase representa a los n�mero complejos.
 *
 * @author Carlos Andr�s Medina Rivas
 * @version 2.0
 */
public class ComplexNumber {

    private double real;
    private double imaginario;

    /**
     * Constructor vac�o de la clase NumeroComplejo.
     */
    public ComplexNumber() {
        this.real = (double) 0;
        this.imaginario = (double) 0;
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
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginario, 2));
    }

    /**
     * Este m�todo retorna la fase de este n�mero complejo.
     *
     * @return la fase del n�mero complejo.
     */
    public double phase() {
        return Math.atan(imaginario / real);
    }

    /**
     * Este m�todo retorna el conjugado de este n�mero complejo.
     *
     * @return el conjugado de este n�mero complejo.
     */
    public ComplexNumber conjugado() {
        return new ComplexNumber(real, -(imaginario));
    }

    /**
     * Este m�todo retorna la negaci�n del este n�mero complejo, es decir que
     * niega tanto la parte real como la imaginaria.
     *
     * @return el n�mero complejo negado.
     */
    public ComplexNumber negacion() {
        return new ComplexNumber(-(real), -(imaginario));
    }

    /**
     *
     * @return la parte real de este n�mero complejo.
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
     * @return la parte imaginaria de este n�mero complejo.
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
     * Este m�todo retorna como string este n�mero complejo
     *
     * @return el string de la forma a+bi de el n�mero complejo.
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
     * Este m�todo retorna como string las coordenadas cartesianas de este
     * n�mero complejo
     *
     * @return un string de la forma (x=real,y=imaginario)
     */
    public String prettyPrintcoordenadasCartesianas() {
        return "(x = " + real + ", y = " + imaginario + ")";
    }

    /**
     * Este m�todo retorna como string las coordenadas polares de este n�mero
     * complejo
     *
     * @return un string de la forma (p=modulo,theta=fase)
     */
    public String prettyPrintCoordenadasPolares() {
        return "(p = " + modulo() + ", theta = " + phase() + ")";
    }

    /**
     * Este m�todo compara este n�mero complejo con el n�mero complejo que es
     * ingresado en el par�metro
     *
     * @param c es un n�mero complejo
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
