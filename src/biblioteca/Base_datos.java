/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jhonjar
 */
public class Base_datos {
    // ATRIBUTOS
    private static final String URL="jdbc:mysql://localhost/biblioteca";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    private PreparedStatement sentenciaSQL;
    private ResultSet resultadoconsulta;
    
    //METODOS
    public Connection conectarBD(){
        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Exito conectandose a la BD");
            return conexion;

        } catch (ClassNotFoundException | SQLException error) {
            System.out.println("Tenemos problemas " + error);
            return null;
        }
    }
    
    public void insertarUsuario(String cedula,String nombre,String apellido){//int estado va dentro de consulta
       //1 establecer conexion a la base de datos
       Connection conexion = conectarBD();
       String consulta = "INSERT INTO `usuario`(`cedula`, `nombre`, `apellido`)"
               + "VALUES(?,?,?)";
       //2 intento llevar datos 
       try{
          // 3 asiciar el ps a la conexion
          sentenciaSQL = conexion.prepareStatement(consulta);
         // 4 diferenciar la consulta 
         sentenciaSQL.setString(1, cedula);
         sentenciaSQL.setString(2, nombre);
         sentenciaSQL.setString(3, apellido);
         //5 ejecutar la consulta
         int resultado = sentenciaSQL.executeUpdate();
         // si el resulatdo es mayor a cero es por que hubo fila afectadas
         // 6 validar el resutado
           if (resultado > 0) {
               System.out.println("Exito al registrando el usuario" );
           } else {
                System.out.println("Error al registrando el usuario" );
           }
       }catch(Exception error){
       
          System.out.println("no se puede registar el usuario" + error);
       }finally{
           try {
               conexion.close();
           } catch (Exception error) {
                System.out.println("Error:" + error );
           }
       
       
       }
    }
    public void libro_prestamo(int n_libros){
    
        //1 establecer conexion a la base de datos
       Connection conexion = conectarBD();
       String consulta = "INSERT INTO `usuario`(`n_libros`)"
               + "VALUES(?)";
       //2 intento llevar datos 
       try{
          // 3 asiciar el ps a la conexion
          sentenciaSQL = conexion.prepareStatement(consulta);
         // 4 diferenciar la consulta 
         sentenciaSQL.setInt(1, n_libros);
         
         //5 ejecutar la consulta
         int resultado = sentenciaSQL.executeUpdate();
         // si el resulatdo es mayor a cero es por que hubo fila afectadas
         // 6 validar el resutado
           if (resultado > 0) {
               System.out.println("Exito al registrando el usuario" );
           } else {
                System.out.println("Error al registrando el usuario" );
           }
       }catch(Exception error){
       
          System.out.println("no se puede registar el usuario" + error);
       }finally{
           try {
               conexion.close();
           } catch (Exception error) {
                System.out.println("Error:" + error );
           }
       
       
       }
    
    
    }
    
    public int  consultarLibros(String cedula){
        int libro;
        // establecer la conexion con la base de datos
        Connection conexion = conectarBD();
        
        // definir el estring con la consulta sql
        String consulta = "SELECT `n_libros` FROM `usuario` WHERE = ?";
        try {
            sentenciaSQL = conexion.prepareStatement(consulta);
            sentenciaSQL.setString(1, cedula);
            resultadoconsulta =  sentenciaSQL.executeQuery();
            if(resultadoconsulta.next()){
             libro = resultadoconsulta.getInt("n_libros");
             return libro;
            }
                  
        } catch(Exception error){
       
          System.out.println("no se puede consultar los libros" + error);
       }finally{
           try {
               conexion.close();
           } catch (Exception error) {
                System.out.println("Error:" + error );
           }
       }
        
       
       
      
    }
    
    
}
