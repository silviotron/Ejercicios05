/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios05;

import java.util.Scanner;

/**
 *
 * @author silvi
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
            System.out.println("*  5. ...                                        *");
            System.out.println("*  6. ...                                        *");
            System.out.println("*  7. ...                                        *");
            System.out.println("*  8. ...                                        *");
            System.out.println("*  9. ...                                        *");
            System.out.println("* 10. ...                                        *");
            System.out.println("* 11. ...                                        *");
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
                    ejercicio06();
                    break;
                case "7":
                    ejercicio07();
                    break;
                case "8":
                    ejercicio08();
                    break;
                case "9":
                    ejercicio09();
                    break;
                case "10":
                    ejercicio10();
                    break;
                case "11":
                    ejercicio11();
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
            System.out.println("Por favor, inserte el tamaño del array");
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
                System.out.println("Por favor, inserte un numero del 1 al 50, o 0 para salir:");
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
            System.out.println("Por favor, inserte un número:");
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
        boolean existe = false;
        for(int i = 0; i < result.length; i++){            
            do{
                int a = (int)(Math.random()*n + 1);
                existe = existeEnArray(a, result);
                if(!existe){
                    result[i] = a;
                }
               
            }
            while(existe);
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
            System.out.println("Por favor, introduce un numero de DNI:");
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
        
    }
    
    public static void ejercicio06(){
        
    }
    
    public static void ejercicio07(){
        
    }
    
    public static void ejercicio08(){
        
    }
    
    public static void ejercicio09(){
        
    }
    
    public static void ejercicio10(){
        
    }
        
    public static void ejercicio11(){
        
    }
        
}
