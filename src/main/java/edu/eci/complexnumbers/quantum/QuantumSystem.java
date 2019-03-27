package edu.eci.complexnumbers.quantum;

import edu.eci.complexnumbers.exceptions.MathComplexException;
import edu.eci.complexnumbers.exceptions.QuantumSystemException;
import edu.eci.complexnumbers.mathcomplexnumbers.MathComplex;
import edu.eci.complexnumbers.mathcomplexnumbers.ComplexNumber;
import java.util.List;

import org.ojalgo.array.Array1D;
import org.ojalgo.array.Array2D;
import org.ojalgo.matrix.ComplexMatrix;
import org.ojalgo.matrix.decomposition.Eigenvalue;

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
        return MathComplex.productoInternoVectores(ket2, ket1);
    }

    /**
     * Este metodo calcula de media de un observable sobre un vector estado.
     *
     * @param m matriz que representa el obserbable.
     * @param ket vector que representa un estado inicial.
     * @return ComplexNumber : representa la media del observable sobre le
     * vector ket.
     * @throws MathComplexException : si la longitud de los vectores es
     * diferente, el producto interno no esta definido para los numeros
     * complejos.
     * @throws QuantumSystemException si la matriz no es hermitiana, no es
     * posible calcular la media de un observable.
     */
    public static ComplexNumber mediaDeUnObservableSobreUnVectorEstado(ComplexNumber[][] m, ComplexNumber[] ket) throws MathComplexException, QuantumSystemException {
        if (!MathComplex.esHermitiana(m)) {
            throw new QuantumSystemException(QuantumSystemException.MATRIZ_NO_HERMITIANA);
        }
        ComplexNumber[] accion = MathComplex.accion(m, ket);
        ComplexNumber media = MathComplex.productoInternoVectores(accion, ket);
        return media;
    }

    /**
     * Este metodo calcula la varianza de un operador hermitiano.
     *
     * @param m matriz que representa a un operador hermitiano.
     * @param ket vector que representa un estado inicial.
     * @return ComplexNumber : representa la varianza de un operador hermitiano.
     * @throws MathComplexException : si la longitud de los vectores es
     * diferente, el producto interno no esta definido para los numeros
     * complejos.
     * @throws QuantumSystemException si la matriz no es hermitiana, no es
     * posible calcular la media de un observable.
     */
    public static ComplexNumber varianzaDeUnOperador(ComplexNumber[][] m, ComplexNumber[] ket) throws MathComplexException, QuantumSystemException {
        if (!MathComplex.esHermitiana(m)) {
            throw new QuantumSystemException(QuantumSystemException.MATRIZ_NO_HERMITIANA);
        }
        ComplexNumber[][] mediaObservableSobreVector = MathComplex.multiplicacionEscalarConMatrices(mediaDeUnObservableSobreUnVectorEstado(m, ket), MathComplex.matrizIdentidad(m.length));
        ComplexNumber[][] deltaObservable = MathComplex.sumarMatrices(m, MathComplex.inversoMatriz(mediaObservableSobreVector));
        ComplexNumber[][] deltaObservable2 = MathComplex.multiplicarMatrices(deltaObservable, deltaObservable);
        ComplexNumber varianza = MathComplex.productoInternoVectores(MathComplex.accion(deltaObservable2, ket), ket);
        return varianza;
    }

    /**
     * Este metodo calcular los valores propios de un observable. Para este uso
     * la interfaz EigenValue del api org.ojalgo. Un valor propio es aquel que
     * si al multiplicar una matriz por un vector el resultado es el mismo que
     * multiplicar dicho valor propio por el mismo vector.
     *
     * @param m matriz que representa un observable hermitiano
     * @return ComplexNumber[] : representa una lista con los valores propios
     * del observable.
     */
    /*public static ComplexNumber[] valoresPropiosDeUnObservable(ComplexNumber[][] m) {
        Array2D.Factory<org.ojalgo.scalar.ComplexNumber> matrizFactory = Array2D.COMPLEX;
        Array2D<org.ojalgo.scalar.ComplexNumber> newMariz = matrizFactory.makeZero(0, 0);
        Array1D.Factory<org.ojalgo.scalar.ComplexNumber> vectorFactory = Array1D.COMPLEX;
        for (int i = 0; i < m.length; i++) {
            Array1D<org.ojalgo.scalar.ComplexNumber> newVector = vectorFactory.makeZero(0);
            for (int j = 0; j < m[0].length; j++) {
                org.ojalgo.scalar.ComplexNumber newComplex = org.ojalgo.scalar.ComplexNumber.of(m[i][j].getReal(), m[i][j].getImaginario());
                newVector.add(newComplex);
            }
            newMariz.fillRow(i, newVector);
        }
        Eigenvalue<org.ojalgo.scalar.ComplexNumber> eigenValue = Eigenvalue.make(newMariz, true);
        Array1D<org.ojalgo.scalar.ComplexNumber> eigenValues = eigenValue.getEigenvalues();
        ComplexNumber[] valoresPropios = new ComplexNumber[(int) eigenValues.length];
        for (long i = 0; i < eigenValues.length; i++) {
            org.ojalgo.scalar.ComplexNumber numeroComplejo = eigenValues.get(i);
            valoresPropios[(int) i] = new ComplexNumber(numeroComplejo.getReal(), numeroComplejo.getImaginary());
        }
        return valoresPropios;
    }

    public static double probabilidadQueElSistemaTransiteALosVectoresPropios(ComplexNumber[][] m, ComplexNumber[] ket) {
        return 0;
    }*/
    /**
     * Este metodo calcula el vector resultante de realizar tantos pasos como
     * sean indicados con un grupo de transformaciones que son matrices
     * unitarias. Esto generara una secuencia de vectores estados, pero al final
     * solo se retornara el estado final.
     *
     * @param times representa la cantidad de pasos para calcular un nuevo
     * estado.
     * @param ket representa un vector del estado inicial.
     * @param sequence representa el grupo de las transformaciones.
     * @return ComplexNumber[] : representa el vector del estado final.
     * @throws MathComplexException : si el numero de columnas de la matriz m es
     * diferente a la cantidad de filas del vector v es diferente, la accion no
     * esta definida en los numeros complejos.
     */
    public static ComplexNumber[] dinamica(int times, ComplexNumber[] ket, List<ComplexNumber[][]> sequence) throws MathComplexException {
        ComplexNumber[] finalState = ket;
        for (int i = 0; i < times; i++) {
            finalState = MathComplex.accion(sequence.get(i), finalState);
        }
        return finalState;
    }

}