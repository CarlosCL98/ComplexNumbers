package edu.eci.Quantum;

import edu.eci.Exceptions.MathComplexException;
import edu.eci.MathComplexNumbers.MathComplex;
import edu.eci.MathComplexNumbers.ComplexNumber;

/**
 * Esta clase representa un sistema cuantico.
 *
 * @author Carlos Andres Medina Rivas
 */
public class QuantumSystem {

    /**
     * Este metodo permite calcula la probabilidad que una particula se
     * encuentre en una ubicacion o estado determinado. Esto es, despues de
     * observar la particula, se detectara que esta en una posicion en
     * particular, entonces se puede calcular la probabilidad que dicha
     * particula este en un punto x.
     *
     * @param posicionesPosiblesAOcupar es la cantidad de posiciones que una
     * particula puede ocupar dentro del sistema.
     * @param ket es el vector que indica los posibles estados de la particula.
     * Este vector ya tiene las amplitudes. Representa que una particula puede
     * estar simultaneamente en todas los ubicaciones o estados.
     * @param x representa la posicion de la particula a la que se quiere
     * calcula la probabilidad que se encuentre en este punto.
     * @return double : representa la probabilidad de que la particula este en
     * una posicion en particular dada.
     */
    public static double probabilidadEnUnaPosicionParticular(int posicionesPosiblesAOcupar, ComplexNumber[] ket, int x) {
        double normaKet = MathComplex.normaKet(ket);
        double probabilidad = Math.pow(ket[x].modulo(), 2) / Math.pow(normaKet, 2);
        return probabilidad;
    }

    /**
     * Este metodo calcula un numero complejo llamado amplitud de transición.
     * Este permite determinar la probabilidad de que el estado del sistema
     * antes de una medicion especifica (estado inicial), cambie a otro (estado
     * final), una vez realizada la medición. Este proceso es llamado bra-ket,
     * pues se calcula el producto interno entre el vector bra (conjugado del
     * ket2) y el vector ket1.
     *
     * @param ket1 representa el estado inicial.
     * @param ket2 representa el estado final.
     * @return ComplexNumber : numero complejo que representa la probabilidad de
     * que el sistema cambie del estado inicial al final.
     * @throws MathComplexException : si la longitud de los vectores es
     * diferente, el producto interno no esta definido para los numeros
     * complejos.
     */
    public static ComplexNumber calcularAmplitudTransicional(ComplexNumber[] ket1, ComplexNumber[] ket2) throws MathComplexException {
        return MathComplex.productoInternoBraKet(MathComplex.calcularBra(ket2), ket1);
    }

}
