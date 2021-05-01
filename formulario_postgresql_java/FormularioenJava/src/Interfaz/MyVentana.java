
package Interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Clasesconexion.*;
/**
 *
 * @author FranciscoMCC
 */
public class MyVentana {
    String codigope=null;
    public void componentes(JPanel panel){
        panel.setLayout(null);
        panel.setBackground(Color.white);
        //Titulos del formulario
        JLabel titulo = new JLabel("FORMULARIO DE PERSONAS");
        titulo.setBounds(0, 10, 600, 36); 
        titulo.setFont(new Font("Consolas", 0, 26));
        titulo.setForeground(new Color(0, 51, 102));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo);
        //Cajas de texto
        
        /*Campo codigo*/
        JLabel etiqueta1 = new JLabel("Codigo:");
        etiqueta1.setBounds(130, 60, 60, 30); 
        etiqueta1.setFont(new Font("Calibri", 1, 16));
        etiqueta1.setForeground(Color.DARK_GRAY);
        panel.add(etiqueta1);
        
        codigo = new JTextField(20);
        codigo.setBounds(200, 60, 250, 30);
        codigo.setHorizontalAlignment(JTextField.CENTER);
        codigo.setFont(new Font("Arial", 0, 14));
        panel.add(codigo);
        
        /*Campo nombre*/
        JLabel etiqueta2 = new JLabel("Nombres:");
        etiqueta2.setBounds(120, 110, 75, 30); 
        etiqueta2.setFont(new Font("Calibri", 1, 16));
        etiqueta2.setForeground(Color.DARK_GRAY);
        panel.add(etiqueta2);
        
        nombres = new JTextField(20);
        nombres.setBounds(200, 110, 250, 30);
        nombres.setHorizontalAlignment(JTextField.CENTER);
        nombres.setFont(new Font("Arial", 0, 14));
        panel.add(nombres);
        
        /*Combobox genero*/
        JLabel etiqueta3 = new JLabel("Genero:");
        etiqueta3.setBounds(130, 158, 75, 30); 
        etiqueta3.setFont(new Font("Calibri", 1, 16));
        etiqueta3.setForeground(Color.DARK_GRAY);
        panel.add(etiqueta3);
        
        genero= new JComboBox();
        genero.setBounds(200, 158, 250, 30);
        genero.setFont(new Font("Arial", 0, 14));
        genero.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Masculino", "Femenino"}));
        genero.setCursor(new Cursor(Cursor.HAND_CURSOR));
        genero.setFocusable(false);
        panel.add(genero);
        
        
        /*Guardar*/
        JButton Guardar = new JButton("Registrar");
        Guardar.setBounds(85, 225, 100, 25);
        Guardar.setFont(new Font("Bahnschrift", 0, 14));
        Guardar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        Guardar.setFocusPainted(false);
        panel.add(Guardar);
        
        /*Editar*/
        JButton actualizar = new JButton("Actualizar");
        actualizar.setBounds(192, 225, 100, 25);
        actualizar.setFont(new Font("Bahnschrift", 0, 14));
        actualizar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        actualizar.setFocusPainted(false);
        panel.add(actualizar);
        
        /*Eliminar*/
        JButton Eliminar = new JButton("Eliminar");
        Eliminar.setBounds(300, 225, 100, 25);
        Eliminar.setFont(new Font("Bahnschrift", 0, 14));
        Eliminar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        Eliminar.setFocusPainted(false);
        panel.add(Eliminar);
        
        /*Tranferir*/
        JButton tranferir = new JButton("Tranferir");
        tranferir.setBounds(410, 225, 100, 25);
        tranferir.setFont(new Font("Bahnschrift", 0, 14));
        tranferir.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        tranferir.setFocusPainted(false);
        panel.add(tranferir);
        
        //Crear Tabla de los registros
        JScrollPane ScrollPane = new JScrollPane();
        JTregistros = new JTable();
        JTregistros.setFont(new java.awt.Font("Consolas", 0, 14));
        JTregistros.setPreferredScrollableViewportSize(new Dimension(500, 80));
        
        ScrollPane.setViewportView(JTregistros);
        ScrollPane.setBounds(20, 270, 555, 230);
        panel.add(ScrollPane);
        //Eventos
        
        /*Evento del boton Guardar*/
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new GuardarPost().guardarRegistro(codigo.getText(), nombres.getText(), genero.getSelectedItem().toString());
            }
        });
        
        /*Evento del boton consultar*/
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new ActualizarPost().ActualizarRegistro(codigo.getText(), nombres.getText(), 
                        genero.getSelectedItem().toString(),codigope);
                limpiarcampos();
            }
        });
        /*Evento del boton eliminar*/
        Eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 try {
                    new EliminarPost().EliminarRegistro(JTregistros.getValueAt(JTregistros.getSelectedRow(), 0).toString());
                    limpiarcampos();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Seleccione el registro a eliminar","WARNING",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        /*Evento del boton tranferir*/
        tranferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    //Enviamos el valor de la fila seleccionada a las casillas del formulario para editar
                    String codigopersona=JTregistros.getValueAt(JTregistros.getSelectedRow(), 0).toString();
                    codigope=codigopersona;
                    codigo.setText(codigopersona);
                    nombres.setText(JTregistros.getValueAt(JTregistros.getSelectedRow(), 1).toString());
                    genero.setSelectedItem(JTregistros.getValueAt(JTregistros.getSelectedRow(), 2).toString());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Seleccione un registro","WARNING",JOptionPane.WARNING_MESSAGE);
                }
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
            java.util.logging.Logger.getLogger(MyVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        JFrame ventana = new JFrame("My Ventana");
        ventana.setSize(600, 550);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contenedor = new JPanel();
        ventana.add(contenedor);
        MyVentana objeto = new MyVentana();
        objeto.componentes(contenedor);
        ventana.setVisible(true);
        JTregistros.setModel(new ConsultasPost().consultarRegistros());
    }
    //Metodo de limpiarcasillas
    private void limpiarcampos(){
        codigo.setText(null);
        nombres.setText(null);
        genero.setSelectedIndex(0);
    }
    public static JTable JTregistros=null;
    private JTextField codigo;
    private JTextField nombres;
    private JComboBox genero;
}
