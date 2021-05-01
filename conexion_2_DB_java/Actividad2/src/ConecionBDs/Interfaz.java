/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConecionBDs;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;
import Conexiones.*;

/**
 *
 * @author FranciscoMCC
 */
public class Interfaz {
    public void componentes(JPanel panel){
        panel.setLayout(null);
        panel.setBackground(Color.white);
        //Creacion de los elementos que va a contener la ventana
        JLabel etiqueta = new JLabel("CONEXION DBS MYSQL Y POSTGRESsql");
        etiqueta.setBounds(0,40, 610, 25); 
        etiqueta.setFont(new Font("Calibri", 1, 18));
        etiqueta.setForeground(new Color(0, 51, 102));
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(etiqueta);
        
        JButton conectarmysql = new JButton("Conectar con MYSQL");
        conectarmysql.setBounds(70, 90, 210, 25);
        conectarmysql.setFont(new Font("Bahnschrift", 0, 14));
        conectarmysql.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        conectarmysql.setFocusPainted(false);
        panel.add(conectarmysql);
        
        JButton conectarpostgres = new JButton("Conectar con POSTGRESQL");
        conectarpostgres.setBounds(320, 90, 210, 25);
        conectarpostgres.setFont(new Font("Bahnschrift", 0, 14));
        conectarpostgres.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        conectarpostgres.setFocusPainted(false);
        panel.add(conectarpostgres);
        
        
        /*Evento del boton conectar mysql*/
        conectarmysql.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               new ConexionMYSQL().getConnection();
            }
        });
        /*Evento del boton conectar Postgres1*/
        conectarpostgres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new ConexionPOST().getConnection();;
            }
        });
    }
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Linux".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        JFrame ventana = new JFrame("Ventana de conexion");
        ventana.setSize(610, 240);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contenedor = new JPanel();
        ventana.add(contenedor);
        Interfaz objeto = new Interfaz();
        objeto.componentes(contenedor);
        ventana.setVisible(true);
    }
}
