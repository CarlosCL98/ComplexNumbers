package edu.eci.MathComplexNumbers;

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
     * Constructor vacio de la clase ComplexNumber. Crea un numero complejo como
     * si fuera 0, es decir, tanto la parte real como la parte imaginaria son 0.
     */
    public ComplexNumber() {
        this.real = (double) 0;
        this.imaginario = (double) 0;
    }

    /**
     * Constructor con parametros de la clase ComplexNumber.
     *
     * @param real parte real del numero complejo.
     * @param imaginario parte imaginaria del numero complejo.
     */
    public ComplexNumber(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    /**
     * Este metodo retorna el modulo de este numero complejo. El modulo
     * representa la magnitud del numero complejo si lo representamos de manera
     * gráfica en coordenadas polares. Si c = (a, b), entonces el modulo p =
     * (a^2+b^2)^(1/2)
     *
     * @return double: el modulo del numero complejo.
     */
    public double modulo() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginario, 2));
    }

    /**
     * Este metodo retorna la fase de este numero complejo. La fase representa
     * el recorrido que realiza el numero complejo en el plano cartesiano si lo
     * representamos en coordenadas polares. Si c = (a, b), entonces la fase
     * theta = arctan(b / a)
     *
     * @return double : la fase del numero complejo.
     */
    public double phase() {
        return Math.atan(imaginario / real);
    }

    /**
     * Este metodo retorna el conjugado de este numero complejo. El conjugado de
     * un numero complejo es cambiar su parte imaginaria por el inverso aditivo
     * del imaginario.
     *
     * @return ComplexNumber : el conjugado de este numero complejo.
     */
    public ComplexNumber conjugado() {
        return new ComplexNumber(real, -(imaginario));
    }

    /**
     * Este metodo retorna el inverso aditivo del este numero complejo.
     *
     * @return ComplexNumber : el inverso aditivo de este numero complejo.
     */
    public ComplexNumber inversoAditivo() {
        return new ComplexNumber(-(real), -(imaginario));
    }

    /**
     * Este metodo obtiene el numero real de este numero complejo.
     *
     * @return double : la parte real de este numero complejo.
     */
    public double getReal() {
        return real;
    }

    /**
     * Este metodo establece a este numero complejo el real dado.
     *
     * @param real parte real de un numero complejo.
     */
    public void setReal(double real) {
        this.real = real;
    }

    /**
     * Este metodo obtiene el numero imaginario de este numero complejo.
     *
     * @return double : la parte imaginaria de este numero complejo.
     */
    public double getImaginario() {
        return imaginario;
    }

    /**
     * Este metodo establece a este numero complejo el imaginario dado.
     *
     * @param imaginario parte imaginaria de un numero complejo.
     */
    public void setImaginario(double imaginario) {
        this.imaginario = imaginario;
    }

    /**
     * Este metodo retorna como string este numero complejo.
     *
     * @return String : cadena de la forma a+bi del numero complejo.
     */
    public String prettyPrintFormaNormalNumeroComplejo() {
        String numeroComplejo = "";
        if (imaginario >= 0) {
            numeroComplejo = real + "+" + imaginario + "i";
        } else {
            numeroComplejo = real + "" + imaginario + "i";
        }
        return numeroComplejo;
    }

    /**
     * Este metodo retorna como string las coordenadas cartesianas de este
     * numero complejo.
     *
     * @return String : cadena de la forma (x=real,y=imaginario)
     */
    public String prettyPrintcoordenadasCartesianas() {
        return "(x = " + real + ", y = " + imaginario + ")";
    }

    /**
     * Este metodo retorna como string las coordenadas polares de este numero
     * complejo.
     *
     * @return String : cadena de la forma (p=modulo,theta=fase)
     */
    public String prettyPrintCoordenadasPolares() {
        return "(p = " + modulo() + ", theta = " + phase() + ")";
    }

    /**
     * Este metodo compara este numero complejo con el numero complejo que es
     * ingresado en el parametro. Compara la parte real e imaginaria de este
     * numero complejo, con la respectiva parte real e imaginaria del otro
     * numero complejo.
     *
     * @param c es un numero complejo.
     * @return boolean : true si son iguales, false si no lo son.
     */
    public boolean equals(ComplexNumber c) {
        boolean equals = false;
        if (real == c.real && imaginario == c.imaginario) {
            equals = true;
        }
        return equals;
    }
}
