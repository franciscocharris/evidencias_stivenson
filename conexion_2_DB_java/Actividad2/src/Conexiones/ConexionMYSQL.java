/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FranciscoMCC
 */
public class ConexionMYSQL {
    public static String URL="jdbc:mysql://localhost:3306/test";
  public static Connection con=null; 
    public static void getConnection(){
        try{
        con=(Connection) DriverManager.getConnection(URL,"root","");
        JOptionPane.showMessageDialog(null,"Conexion establecida con MYSQL");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR AL CONECTAR CON MYSQL","ERROR",JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
}
