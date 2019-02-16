package edu.eci;

/**
 * Esta clase representa a los número complejos.
 *
 * @author Carlos Andrés Medina Rivas
 * @version 2.0
 */
public class ComplexNumber {

    private double real;
    private double imaginario;

    /**
     * Constructor vacío de la clase NumeroComplejo.
     */
    public ComplexNumber() {
        this.real = (double) 0;
        this.imaginario = (double) 0;
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
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginario, 2));
    }

    /**
     * Este método retorna la fase de este número complejo.
     *
     * @return la fase del número complejo.
     */
    public double phase() {
        return Math.atan(imaginario / real);
    }

    /**
     * Este método retorna el conjugado de este número complejo.
     *
     * @return el conjugado de este número complejo.
     */
    public ComplexNumber conjugado() {
        return new ComplexNumber(real, -(imaginario));
    }

    /**
     * Este método retorna la negación del este número complejo, es decir que
     * niega tanto la parte real como la imaginaria.
     *
     * @return el número complejo negado.
     */
    public ComplexNumber negacion() {
        return new ComplexNumber(-(real), -(imaginario));
    }

    /**
     *
     * @return la parte real de este número complejo.
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
     * @return la parte imaginaria de este número complejo.
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
     * Este método retorna como string este número complejo
     *
     * @return el string de la forma a+bi de el número complejo.
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
     * Este método retorna como string las coordenadas cartesianas de este
     * número complejo
     *
     * @return un string de la forma (x=real,y=imaginario)
     */
    public String prettyPrintcoordenadasCartesianas() {
        return "(x = " + real + ", y = " + imaginario + ")";
    }

    /**
     * Este método retorna como string las coordenadas polares de este número
     * complejo
     *
     * @return un string de la forma (p=modulo,theta=fase)
     */
    public String prettyPrintCoordenadasPolares() {
        return "(p = " + modulo() + ", theta = " + phase() + ")";
    }

    /**
     * Este método compara este número complejo con el número complejo que es
     * ingresado en el parámetro
     *
     * @param c es un número complejo
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
