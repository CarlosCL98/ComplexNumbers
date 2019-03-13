## Librería de Número Complejos

## Descripción

### Números Complejos
Un número complejo es un número compuesto por un número **real** y un número **imaginario**.

Esta librería realizada en java contiene la representación en objetos de un número complejo y de las posibles operaciones que pueden realizarse entre varios número complejos. También se encuentran operaciones entre vectores y matrices de números complejos.

Un número complejo está representado en esta librería por dos números double, el número de la parte real y el número de la parte imaginaria. La clase que hace posible esta representación se llama **ComplexNumber.java**. En esta clase es posible mostrar en unos formatos como **(x=3, y=5)** o **3+5i** un número complejo, lograr obtener el módulo de un número complejo, su fase, su conjugado entre otros.

Las operaciones que se pueden realizar entre objetos ComplexNumber (números complejos) están dadas por la clase **MathComplex.java** (es similar a la estructura de la clase Math de java.lang, con la diferencia de que se usan números complejos y hay diversas operaciones distintas). Gracias a esta clase se pueden realizar las operaciones básicas entre números complejos como sumar, restar, multiplicar y dividir. Además es posible convertilos de cartesiano a polar y viceverza, sumar vectores y matrices, multiplicarlos, obtener el producto interno, entre otras operaciones más, como se puede ver en las siguientes porciones de código.

Para los vectores y matrices se usan arreglos de longitud fija de la forma **ComplexNumber[]** y **ComplexNumber[][]** respectivamente, tal como se puede ver en los códigos anteriormente mostrados. De esta manera la implementación es mucho más sencilla e intuitiva, pues se usan los arrays básicos de java.

La librería también cuenta con una clase llamada **MathComplexException.java** para las operaciones que no pueden ser realizadas entre números complejos, como la división por 0, pues no se encuentran definidas.

Finalmente se diseño una clase llamada **MathComplexTest.java** en la cuál se realizan pruebas unitarias para verificar la funcionalidad de cada una de las operaciones entre los número complejos. Para esto y con la ayuda de Maven, se realizó la integración con circleci que es un sistema que permite la integración continua, y cada vez que se realice un cambio y este sea cargado en git, las pruebas unitarias serán ejecutadas automáticamente (más adelante se encuentra la insignia).

### Sistemas Cuánticos
El uso de los números complejos permtitió el paso de lo clásico a lo cuántico y de esta manera la creación de sistemas cuánticos que permiten medir un estado respectivo de una partícula dentro de un sistema.
 
Para esto se creó la clase **QuantumExperiments.java**, la cual representa experimentos cuanticos realizados como el de las canicas (números reales) y los fotones (números complejos), esto para poder entender y pasar de la física clásica a la cuántica. Dentro de esta clase se pueden poner a prueba diversos experimentos:

- El primero es el experimento con fotones el cual muestra la probabilidad que un fotón cambie a cualquier estado posible al mismo tiempo. En primera instancia se realizó el experimento con canicas, en donde se tiene un estado inicial (donde se encuentran las canicas actualmente) y una matriz que permite saber cómo las canicas se moverán después de un cambio de estado. De esta manera, se introduce el concepto de probabilidad, permitiendo verificar cuál es la probabilidad que una canica se encuentre en cualquiera de los estados que están disponibles. Más adelante, después de haber entendido este concepto, se traslada el experimento con los fotones. Matemáticamente, se tiene una matriz de adyacencia de números complejos que describe la probabilidad de que un fotón cambie de un estado a otro, un estado inicial que es un vector columna de complejos y la cantidad de cambios de estados a realizar. El procedimiento es realizar la acción entre la matriz de adyacencia y el vector columna inicial, y después por cada cambio de estado se usa el vector columna resultante. El resultado final será la probabilidad de que un fotón esté en alguna posición después de unos cambios de estado.
	
	

- El segundo experimento es el experimento multirendija. En un principio se usaron balas para explicar el comportamiento y después continuamos con los fotones. Con este experimento se logra demostrar que al lanzar una bala (o un electron) por las rendijas, existe cierta posibilidad que tome cualquier camino, por lo que puede pasar por cualquier rendija. En este experimento clásico se establece que al lanzar las particulas (balas o canicas) se forma un patrón con forma de franja en el lugar donde se esta recibiendo los disparos. Con los fotones el concepto es casi el mismo; al lanzar un foton por las rendijas, este toma varios caminos simultáneamente cuando no es medido, formando un patrón llamado patrón de interferencia, que se refiere al choque de las ondas al mismo tiempo (matemáticamente, cuando el choque de ondas ocurre, los números complejos que se suman en estos puntos se cancelan entre ellos). Este experimento es el paso de lo clásico a lo cuántico.

	> Imagenes tomadas del video [Double-Slit Experiment](https://www.youtube.com/watch?v=DfPeprQ7oGc "Double-Slit Experiment")
	> 
	> ![](/src/main/resources/Marble.jpg)
	> ![](/src/main/resources/Foton.jpg)

Después se creó la clase **QuantumSystem.java** la cual representa el primer sistema cuántico diseñado. Este sistema permite calcular la probabilidad que una partícula se encuentre en una posición de un estado determinado, además que permite hallar la amplitud de transición entre dos vectores de estados.

- El primer método dentro del sistema cuántico permite calcula la probabilidad que una partícula se encuentre en una ubicación o estado determinado, es decir, después de observar la particula, se podrá calcular la probabilidad que dicha particula este en un punto, pues al medirla se detecta un sólo estado. Para esto se usará un vector de estados llamado ket, el cual contiene la amplitud de cada punto como números complejos. Este es el vector que indica los posibles estados de la particula y representa que una particula puede estar simultáneamente en todas los ubicaciones o estados.
- El segundo método permite calcular la amplitud de transición entre dos estados. Este permite determinar la probabilidad de que el estado del sistema antes de una medicion especifica (estado inicial), cambie a otro estado (estado final), una vez realizada la medición. Este proceso es llamado bra-ket, pues matemáticamente se calcula el producto interno entre el vector bra (conjugado del vector de estados ket final) y el vector de estados ket incial.

## Experimento Doble Rendija
Para complementar la librería, realizamos junto con Amalia Alfonso --> [link repositorio en git](https://github.com/acai-bjca/NumbersComplex) el experimento de la doble rendija. Para hacer una demostración, realizamos el siguiente video:

> [![Experimento Doble Rendija](http://img.youtube.com/vi/65k-r1hv4q8/0.jpg)](http://www.youtube.com/watch?v=65k-r1hv4q8 "Experimento de la doble rendija")

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

## Colaborador
Agradezco a *Luis Daniel Benavides Navarro, Ph.D.*, quien ha estado presente y en constante revisión de la presente librería de números complejos.

## Licencia
>GNU GENERAL PUBLIC LICENSE - Version 3, 29 June 2007

Para ver más, leer el archivo **LICENSE** ubicado en la raíz de este repositorio.

## Referencias
Las funciones de esta librería fueron diseñadas a partir de la lectura del libro **Quantum Computing for Computer Scientists**

> S. Yanofsky, N., & A. Mannucci, M. (2008). Quantum Computing for Computer Scientists. New York: Cambridge University Press.
