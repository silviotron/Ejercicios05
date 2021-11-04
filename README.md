04 - Ejercicios arrays básicos

Ejercicio 1

Crea un array de números donde le indicamos por teclado el tamaño del array, rellenaremos el array con números aleatorios entre 0 y 9, al final muestra por pantalla el valor de cada posición y la suma de todos los valores. Haz un método para rellenar el array (que tenga como parámetros los números entre los que tenga que generar), para mostrar el contenido y la suma del array y un método privado para generar número aleatorio (lo puedes usar para otros ejercicios).

Ejercicio 2

Crea un array aleatorio de 20 posiciones con números comprendidos entre el 1..50. El usuario inserta un número y el programa debe decirle si existe el número en el array. Si existe muestra la primera posición en la que podemos encontrar el elemento.

Ejercicio 3

Crea un array de números aleatorios de un tamaño pasado como parámetro. El array se rellenará aleatoriamente con todos los números existentes entre 1 y el valor pasado. No puede haber repeticiones. Por ejemplo:

Valor pasado 5
[2,1,5,4,3] -> Correcto

Ejercicio 4

Calcula la letra de un DNI, pediremos el DNI por teclado y nos devolverá el DNI completo.

Para calcular la letra, cogeremos el resto de dividir nuestro dni entre 23, el resultado debe estar entre 0 y 22. Haz un método donde según el resultado de la anterior formula busque en un array de caracteres la posición que corresponda a la letra. Esta es la tabla de caracteres:
Posicion	Letra
0	  T
1	  R
2	  W
3	  A
4	  G
5	  M
6	  Y
7	  F
8	  P
9	  D
10  X
11	B
12	N
13	J
14	Z
15	S
16	Q
17	V
18	H
19	L
20	C
21	K
22	E

Ejercicio 5

Crea un programa que simule un bingo. Cada vez que se pulse 1, el programa saca una bola del bombo (sin repetir) y muestra por pantalla las bolas que han salido en el orden en el que lo han hecho. Si se pulsa 0 el programa finaliza.

Ejercicio 6

Implementar en java un algoritmo que genere números primos hasta la cantidad máxima especificada por el usuario. Utilícese el algoritmo denominado Criba de erastóstes.
Descripción del algoritmo:
Dada una matriz de enteros empezando por el numero 2, se tachan los múltiplos de 2. Se busca el siguiente entero sin tachar y se tachan todos los múltiplos. Repetir hasta superar la raiz cuadrada del valor máximo.  
