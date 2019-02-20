## Librería de Número Complejos

Un número complejo es un número compuesto por un número **real** y un número **imaginario**.

Esta librería realizada en java contiene la representación en objetos de un número complejo y de las posibles operaciones que pueden realizarse entre varios número complejos. También se encuentran operaciones entre vectores y matrices de números complejos.

Un número complejo está representado en esta librería por dos números double, el número de la parte real y el número de la parte imaginaria. La clase que hace posible esta representación se llama **ComplexNumber.java**. En esta clase es posible mostrar en unos formatos como **(x=3, y=5)** o **3+5i** un número complejo, lograr obtener el módulo de un número complejo, su fase, su conjugado entre otros.

---
```java

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
```

Demostración de algunos programas
:
```java

	/**
     * Este metodo retorna el modulo de este numero complejo.
     *
     * @return el modulo del numero complejo.
     */
    public double modulo() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginario, 2));
    }
```

```java

	/**
     * Este metodo retorna como string las coordenadas cartesianas de este
     * numero complejo
     *
     * @return un string de la forma (x=real,y=imaginario)
     */
    public String prettyPrintcoordenadasCartesianas() {
        return "(x = " + real + ", y = " + imaginario + ")";
    }
```

---
Las operaciones que se pueden realizar entre objetos ComplexNumber (números complejos) están dadas por la clase **MathComplex.java** (es similar a la estructura de la clase Math de java.lang, con la diferencia de que se usan números complejos y hay diversas operaciones distintas). Gracias a esta clase se pueden realizar las operaciones básicas entre números complejos como sumar, restar, multiplicar y dividir. Además es posible convertilos de cartesiano a polar y viceverza, sumar vectores y matrices, multiplicarlos, obtener el producto interno, entre otras operaciones más, como se puede ver en las siguientes porciones de código.

---
```java

	/**
     * Este metodo realiza la suma de dos numero complejos y devuelve el nuevo
     * numero complejo.
     *
     * @param c1 numero complejo.
     * @param c2 numero complejo.
     * @return el nuevo numero complejo resultado de la suma.
     */
    public static ComplexNumber sumar(ComplexNumber c1, ComplexNumber c2) {
        double real = c1.getReal() + c2.getReal();
        double imaginario = c1.getImaginario() + c2.getImaginario();
        return new ComplexNumber(real, imaginario);
    }
```

```java

	/**
     * Este metodo convierte un numero complejo de coordenadas cartesianas a
     * coordenadas polares.
     *
     * @param c numero complejo.
     * @return el numero complejo con las coordenadas polares.
     */
    public static ComplexNumber convertirAPolar(ComplexNumber c) {
        return new ComplexNumber(c.modulo(), c.phase());
    }
```

```java

	/**
     * Este metodo calcula el producto interno (tambien llamado producto punto)
     * entre dos vectores dados.
     *
     * @param v1 vector compejo.
     * @param v2 vector compejo.
     * @return un numero complejo, resultado del producto interno entre los
     * vectores complejos v1 y v2.
     * @throws MathComplexException
     */
    public static ComplexNumber productoInternoVectores(ComplexNumber[] v1, ComplexNumber[] v2)
            throws MathComplexException {
        if (v1.length != v2.length) {
            throw new MathComplexException(MathComplexException.LONGITUD_VECTORES_DIFERENTE);
        }
        ComplexNumber productoInternoVector = new ComplexNumber();
        v1 = conjugadoVector(v1);
        for (int i = 0; i < v1.length; i++) {
            productoInternoVector = sumar(productoInternoVector, multiplicar(v1[i], v2[i]));
        }
        return productoInternoVector;
    }
```

```java

	/**
     * Este metodo realiza la suma entre las matrices de complejos.
     *
     * @param m1 matriz de complejos.
     * @param m2 matriz de complejos.
     * @return una matriz de complejos resultado de la suma.
     * @throws MathComplexException
     */
    public static ComplexNumber[][] sumarMatrices(ComplexNumber[][] m1, ComplexNumber[][] m2)
            throws MathComplexException {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            throw new MathComplexException(MathComplexException.SUMA_DIMENSION_MATRICES_DIFERENTE);
        }
        ComplexNumber[][] sumaMatrices = new ComplexNumber[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            sumaMatrices[i] = sumarVectores(m1[i], m2[i]);
        }
        return sumaMatrices;
    }
```

---

Para los vectores y matrices se usan arreglos de longitud fija de la forma **ComplexNumber[]** y **ComplexNumber[][]** respectivamente, tal como se puede ver en los códigos anteriormente mostrados. De esta manera la implementación es mucho más sencilla e intuitiva, pues se usan los arrays básicos de java.

La librería también cuenta con una clase llamada **MathComplexException.java** para las operaciones que no pueden ser realizadas entre números complejos, como la división por 0, pues no se encuentran definidas.

Finalmente se diseño una clase llamada **MathComplexTest.java** en la cuál se realizan pruebas unitarias para verificar la funcionalidad de cada una de las operaciones entre los número complejos. Para esto y con la ayuda de Maven, se realizó la integración con circleci que es un sistema que permite la integración continua, y cada vez que se realice un cambio y este sea cargado en git, las pruebas unitarias serán ejecutadas automáticamente (más adelante se encuentra la insignia).

## Documentación de la librería:
Para ver la documentación de esta librería, y más información sobre las funcionalidades, acceda al siguiente link: [API Números Complejos](https://carloscl98.github.io/ComplexNumbers/docs/index.html)

## Insignias

### CircleCI:
[![CircleCI](https://circleci.com/gh/CarlosCL98/ComplexNumbers.svg?style=svg)](https://circleci.com/gh/CarlosCL98/ComplexNumbers)

### Codacy:
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5fd82b18fe334ac7bc0384fe0be4275c)](https://www.codacy.com/app/CarlosCL98/ComplexNumbers?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=CarlosCL98/ComplexNumbers&amp;utm_campaign=Badge_Grade)

## Creador
*Carlos Andrés Medina Rivas*

*Estudiante de Ingeniería de Sistemas de la Escuela Colombiana de Ingeniería Julio Garavito.*

## Revisado por
*Luis Daniel Benavides Navarro, Ph.D.*

## Licencia
>GNU GENERAL PUBLIC LICENSE - Version 3, 29 June 2007

Para ver más, leer el archivo **LICENSE** ubicado en la raíz de este repositorio.

## Referencias
Las funciones de esta librería fueron diseñadas a partir de la lectura del libro **Quantum Computing for Computer Scientists**

> S. Yanofsky, N., & A. Mannucci, M. (2008). Quantum Computing for Computer Scientists. New York: Cambridge University Press.
