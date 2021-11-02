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
            System.out.println("*  2. ...                                        *");
            System.out.println("*  3. ...                                        *");
            System.out.println("*  4. ...                                        *");
            System.out.println("*  5. ...                                        *");
            System.out.println("*  6. ...                                        *");
            System.out.println("*  7. ...                                        *");
            System.out.println("*  8. ...                                        *");
            System.out.println("*  9. ...                                        *");
            System.out.println("* 10. ...                                        *");
            System.out.println("* 11. ...                                         *");
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
        for(int i = 0; i < array.length; i++){
            System.out.println("posición " + i + " = " + array[i]);
        }        
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
    
    public static void ejercicio02(){
        
    }
    
    public static void ejercicio03(){
        
    }
    
    public static void ejercicio04(){
        
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
