/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios05;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author silvio
 */
public class Ejercicios05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String entradaUsuario;
        java.util.Scanner teclado = new java.util.Scanner(System.in);
        do{
            System.out.println("**************************************************");
            System.out.println("*  1. Array aleatoria                            *");
            System.out.println("*  2. Posición numero en array aleatoria         *");
            System.out.println("*  3. Array aleatorio sin repetidos              *");
            System.out.println("*  4. Calcular letra DNI                         *");
            System.out.println("*  5. Bingo                                      *");
            System.out.println("*  6. Primos                                     *");
            System.out.println("*  0. Salir                                      *");
            System.out.println("**************************************************");
            entradaUsuario = teclado.nextLine();
            switch(entradaUsuario){
                case "1":
                    ejercicio01();
                    break;
                case "2":
                    ejercicio02();
                    break;
                case "3":
                    ejercicio03();
                    break;
                case "4":
                    ejercicio04();
                    break;
                case "5":
                    ejercicio05();
                    break;
                case "6":
                    ejercicio06v2();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }while(!entradaUsuario.equals("0"));         
    }
    
    public static void ejercicio01(){
        Scanner sc = new Scanner(System.in);
        int tamArray = -1;
        do{
            System.out.print("Por favor, inserte el tamaño del array: ");
            if(sc.hasNextInt()){
                tamArray = sc.nextInt();                
            }
            if(tamArray < 0){
                System.out.println("ERROR: Debe insertar un número natural.\n");
            }
            sc.nextLine();
        }
        while(tamArray < 0);
        int array[] = arrayAleatorio(tamArray);
        sumArray(array);
        System.out.println("Suma total = " + sumArray(array));
       
        
    }
    public static int[] arrayAleatorio(int tam){
        int result[];
        result = new int[tam];
        for(int i = 0; i < result.length; i++){
            result[i] = (int)(Math.random()*10);
        }
        return result;
    }
    public static int sumArray(int[] array){
        int result = 0;
        for(int i = 0; i < array.length; i++){
            result = result + array[i];
        }
        return result;
    }
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println("posición " + i + " = " + array[i]);
        }         
    }
    
    public static void ejercicio02(){
        int array[] = arrayAleatorio20();
        Scanner sc = new Scanner(System.in);
        int num = -1;
        do{
            do{
                System.out.print("Por favor, inserte un numero del 1 al 50, o 0 para salir: ");
                if(sc.hasNextInt()){
                    num = sc.nextInt();                
                }
                if((num < 1 || num > 50) && num != 0){
                    System.out.println("ERROR: Debe insertar un número del 1 al 50, o 0 para salir.");
                }                
            }
            while((num < 1 || num > 50) && num != 0);
                int pos = posicionNum(num, array);
                if(pos == -1 && num != 0){
                    System.out.println("El numero no existe en el array.");
                }else if(pos > -1 && num != 0){
                    System.out.printf("el numero %s esta en la posición %s\n", num, pos);
                } 
                sc.nextLine();
        }
        while(num != 0); 

    }
    public static int[] arrayAleatorio20(){
        int result[];
        result = new int[20];
        for(int i = 0; i < result.length; i++){
            result[i] = (int)(Math.random()*50 + 1);
        }
        return result;
    }
    public static int posicionNum(int n, int array[]){
        for(int i = 0; i < array.length; i++){
            if(array[i] == n){
                return i;
            }
        }
        return -1;        
    }    
    
    public static void ejercicio03(){
        Scanner sc = new Scanner(System.in);
        int num = -1;
        do{
            System.out.print("Por favor, inserte un número: ");
            if(sc.hasNextInt()){
                num = sc.nextInt();                
            }
            if(num < 0){
                System.out.println("ERROR: Debe insertar un número natural.");
            }
            sc.nextLine();
        }
        while(num < 0); 
        printArray(arrayAleatorio2(num));
    }
    public static int[] arrayAleatorio2(int n){
        int result[];
        result = new int[n];
        boolean existe;
        int random;
        for(int i = 0; i < result.length; i++){            
            do{
                random = (int)(Math.random()*n + 1);
                existe = existeEnArray(random, result);               
            }
            while(existe);
            result[i] = random;
        }
        return result;
    }
    public static boolean existeEnArray(int n, int[] array){
        for(int f = 0; f < array.length; f++){
            if(array[f] == n){
                return true;
            }
        }
        return false;
    }
    
    public static void ejercicio04(){
        Scanner sc = new Scanner(System.in);
        int num = -1;
        do{
            System.out.print("Por favor, introduce un numero de DNI: ");
            if(sc.hasNextInt()){
                num = sc.nextInt();                
            }
            if(num < 0){
                System.out.println("ERROR: Debe insertar un número natural.");
            }
            sc.nextLine();
        }
        while(num < 0);
        System.out.printf("la letra del DNI: %s es %s\n", num, letraDni(num));
    }
    public static char letraDni(int n){
        char[] dni = {'t', 'r', 'w', 'a', 'g', 'm', 'y', 'f', 'p', 'd', 'x', 'b', 'n', 'j', 'z', 's', 'q', 'v', 'h', 'l', 'c', 'k', 'e'};
        return dni[n % 23];
    }
    
    public static void ejercicio05(){
        int[] listaArray = arrayAleatorio2(90);
        int n = 1;
        int posicionLinea = -1;
        int posicionBingo = -1;
        String ganadorLinea = "error";
        String ganadorBingo = "error";
        String num;
        String lista = "" + listaArray[0];
        Scanner sc = new Scanner(System.in); 
        System.out.print("Introduce el numero de jugadores: ");
        int numUsuarios = sc.nextInt();
        int[][] cartonesUsuarios = crearCartones(numUsuarios);
        boolean[][] todoFalse = new boolean[numUsuarios][15];
        String[] nombres = nombresUsuarios(numUsuarios, cartonesUsuarios, todoFalse);
        int[][] ganadores = calcGanadores(cartonesUsuarios, listaArray, numUsuarios);
                                   
        do{
            System.out.println("***********************");            
            System.out.println("*  1. Sacar bola      *");
            System.out.println("*  0. Terminar        *");
            System.out.println("***********************");            
            num = sc.nextLine();
            switch(num){
                case "1": 
                    System.out.printf("Sale la bola: %s\n", listaArray[n - 1]);
                    System.out.printf("ya salieron: [" + lista + "]\n\n");
                    lista = lista + ", " + listaArray[n];
                    if(n == posicionLinea + 1){
                        System.out.println(ganadorLinea);
                    }
                    if(n == posicionBingo + 1){
                        System.out.println(ganadorBingo);
                    }
                    n++;
                    if(n == 90){
                        System.out.println("No hay mas bolas");
                        break;
                    }

                    break;
                case "0":
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    break;
            }
       

        }
        while(!num.equals("0") && n != 90);
    }   
    public static int[] arrayAleatorio3(){
        int result[];
        result = new int[15];
        boolean existe;
        int random;
        for(int i = 0; i < result.length; i++){            
            do{
                random = (int)(Math.random()*90 + 1);
                existe = existeEnArray(random, result);               
            }
            while(existe);
            result[i] = random;
        }
        return result;
    }    
    public static boolean todosTachados(boolean[][] array, int num){
        for (int i = 0; i < 15; i++) {
            if(array[num][i] == false){
                return false;
            }
            
        }
        return true;
        
    }
    public static boolean lineaTachados(boolean[][] array, int num){
        boolean primera = true;
        boolean segunda = true;
        boolean tercera = true;
        for (int i = 0; i < 5; i++) {
            if(array[num][i] == false){
                primera = false;
            }            
        }
        for (int i = 5; i < 10; i++) {
            if(array[num][i] == false){
                segunda = false;
            }            
        }
        for (int i = 10; i < 15; i++) {
            if(array[num][i] == false){
                tercera = false;
            }            
        }
        return primera || segunda || tercera;
        
    }
    public static void printCarton(int[][] numeros, boolean[][] tachados, int num, String[] nombres){
        System.out.printf("\ncarton de %s: \n", nombres[num]);
        System.out.println("**************************************");
        int fila = 0;
        String print;
        for (int i = 0; i < 15; i++) {
            if(fila == 5){
                System.out.print("\n");
                fila = 0;
            }
            switch(numeros[num][i]){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    print = " " + numeros[num][i];
                    break;
                default:
                    print = "" + numeros[num][i];
                    break;
                    
            }
            if(tachados[num][i] == false){
                print = " " + print + " ";
            }else{
                print = "(" + print + ")";    
            }
            System.out.print("   " + print);
            fila++;
        }
        System.out.print("\n");
        System.out.println("**************************************\n");
        
    }
    public static boolean[] todoFalse(boolean[] tachados){                
        for (int i = 0; i < tachados.length; i++) {
            tachados[i] = false;            
        }        
        return tachados;
    }
    public static boolean[] tachar(int numero, int[] cartonNumeros, boolean[] cartonTachados){
        for (int i = 0; i < cartonNumeros.length; i++) {
            if(cartonNumeros[i] == numero){
                cartonTachados[i] = true;
            }
            
        }
        
        return cartonTachados;
    }    
    public static int posicionEnArray(int n, int[] array){
        int posicion = -1;
        for (int i = 0; i < array.length; i++) {
            if(n == array[i]){
                posicion = i;
            }            
        }
        return posicion;
    }
    public static int[][] crearCartones(int num){
        int[][] cartones = new int[num][15];
        boolean existe;
        int random;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 15; j++) {
                do{
                random = (int)(Math.random()*90 + 1);
                existe = existeEnArray(random, cartones[i]);               
                }
                while(existe);
                cartones[i][j] = random;
                
            }
            
        }        
        
        return cartones;
    }
    public static String[] nombresUsuarios(int n, int[][] cartones, boolean[][] tachados){
        Scanner sc = new Scanner(System.in); 
        String[] nombres = new String[n];
        for (int i = 0; i < nombres.length; i++) {
            System.out.printf("Introduce el nombre del %sº usuario: ", i + 1);
            nombres[i] = sc.nextLine();
            printCarton(cartones, tachados, i, nombres);//seguir por aqui
        }
        
        return nombres;
    }
    //[0][0] es el ganador de la linea, [0][1] es la posicion de la linea
    //[1][0] es el ganador del bingo, [1][1] es la posicion del bingo
    public static int[][] calcGanadores(int[][] cartones, int[] lista, int num){
        boolean linea = false;
        boolean bingo = false;

        boolean [][] tachados = new boolean[num][15];
        int[][] ganadores = new int[2][2];
        for (int i = 0; i < lista.length; i++) {            
            for (int j = 0; j < num; j++) {
                for (int k = 0; k < 15; k++) {
                    if(cartones[j][k] == lista[i]){
                        tachados[j][k] = true;
                    }
                    
                }
                if(lineaTachados(tachados, j) && !linea){
                    ganadores[0][0] = j;
                    ganadores[0][1] = i;
                    linea = true;
                }
                if(todosTachados(tachados, j) && !bingo){
                    ganadores[1][0] = j;
                    ganadores[1][1] = i;
                    bingo = true;
                }
            }
            
           
        }
        
        return ganadores;
    }
    
    public static void ejercicio06(){
        Scanner sc = new Scanner(System.in);
        int num = -1;
        do{
            System.out.print("Por favor, introduce un numero: ");
            if(sc.hasNextInt()){
                num = sc.nextInt();                
            }
            if(num < 0){
                System.out.println("ERROR: Debe insertar un número natural.");
            }
            sc.nextLine();
        }
        while(num < 0);        
        boolean[] criba = new boolean[num + 1];
        for(int i = 2; i < criba.length; i++){
            if((Math.pow(i, 2) < num) && (criba[i] == false)){
                criba = tacharMultiplos(criba, i);
            }
        }
        int encontrados = encontrados(criba);
        if(encontrados > 1){ 
            System.out.printf("primos encontrados hasta el %s:\n(encontrados: %s) 2", num, encontrados); 
        }else{
            System.out.printf("no se han encontrados primos hasta el %s", num);
        }       
        for(int i = 3; i < criba.length; i++){
            if(criba[i] == false){                
                System.out.printf(", %s", i);
            }
        }
        System.out.printf("\n");
    }
    public static boolean[] tacharMultiplos(boolean[] array, int m){                
        final boolean tachado = true;
        for(int i = m + 1; i < array.length; i++){
            if(i % m == 0){
                array[i] = tachado;
            }
        }
        return array;
    }
    public static int encontrados(boolean[] array){
        int result = 0;
        for(int i = 2; i < array.length; i++){
            if(array[i] == false){
                result++;
            }
        }
        return result;
    }
    
    public static void ejercicio06v2(){
        System.out.println("Inserte el numero limite que desea calcular de numeros primos");
        Scanner teclado = new Scanner(System.in);
        int n = -1;
        do {
            if (teclado.hasNextInt()) {
                n = teclado.nextInt();
            }
            if (n < 0) {
                System.out.println("Debe insertar un numero entero");
            }
            teclado.nextLine();
        } while (n < 0);
        printearPrimos(primos2(n));
        System.out.println("");
    }
    public static int[] primos2(int n) {
        int[] array = new int[n - 1];
        int borrador;
        for (int i = 0; i < (array.length); i++) {
            array[i] = i + 2;
        }
        int raiz = (int)sqrt(n);
        for (int i = 0;i <= raiz; i++) {
            if (array[i] != 0) {
                borrador = array[i];
                for (int j = borrador; j < array.length; j++) {
                    if (array[j] != 0 && array[j] % borrador == 0) {
                        array[j] = 0;
                    }
                }
            }
        }
        return array;
    }
    public static void printearPrimos(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                System.out.print("[" + array[i] + "]");
            }

        }
    }        
    
}    

