package Clasesconexion;

import Interfaz.MyVentana;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FranciscoMCC
 */
public class GuardarPost {
    ConexionPost conexion=new ConexionPost();
    Connection con=conexion.GetConnection();
    PreparedStatement ps=null;
    public void guardarRegistro(String codigo,String nombres,String genero){
        if (codigo.isEmpty() || nombres.isEmpty() || genero.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null,"Todos los campos son requeridos","WARNING",JOptionPane.WARNING_MESSAGE);
        } else {
            int ncaracteres=codigo.length();
            if (ncaracteres<7) {
                //Validamos que no pueda registrar personas con el mismo codigo y se presente un error
                boolean existenciapersona=(boolean) new ConsultasPost().verificarexistenciadepersona(codigo);
                if (existenciapersona==false) {
                    try {
                        ps=con.prepareStatement("INSERT INTO personas(\"Codigo\",\"Nombres\",\"Genero\") VALUES(?,?,?)");
                        ps.setString(1, codigo);
                        ps.setString(2,nombres);
                        ps.setString(3,genero);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Registro guardado con exito");
                        new MyVentana().JTregistros.setModel(new ConsultasPost().consultarRegistros());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,"ERROR AL GUARDAR REGISTRO","ERROR",JOptionPane.ERROR_MESSAGE);
                        System.out.println(e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Ya existe un registro con este codigo","WARNING",JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,"El codigo supera el numero de caracteres validos","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
