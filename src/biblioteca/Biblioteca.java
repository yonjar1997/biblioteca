/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.Scanner;

/**
 *
 * @author jhonjar
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada  = new Scanner(System.in);
        Base_datos bd = new Base_datos();
        
        System.out.println("Bienvenido a la biblioteca ");
        System.out.println("Digite la cedula del usuario");
        String cedula = entrada.next();
        System.out.println("Digite el nombre del usuario ");
        String nombre = entrada.next();
        System.out.println("Digite el apellido del usuario");
        String apellido = entrada.next();
        System.out.println("Digite el estado del libro (1/2)");
        int prestamo = entrada.nextInt();
        
        bd.insertarUsuario(cedula, nombre, apellido);
        bd.libro_prestamo(prestamo);
        bd.consultarLibros(cedula);
        
        
    }
    
}
