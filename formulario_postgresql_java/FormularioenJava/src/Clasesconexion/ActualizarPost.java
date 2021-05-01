package Clasesconexion;

import Interfaz.MyVentana;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author FranciscoMCC
 */
public class ActualizarPost {
    ConexionPost conexion=new ConexionPost();
    Connection con=conexion.GetConnection();
    PreparedStatement ps=null;
    public void ActualizarRegistro(String codigo,String nombres,String genero,String codigooriginal){
        if (codigo.isEmpty() || nombres.isEmpty() || genero.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null,"Todos los campos son requeridos","WARNING",JOptionPane.WARNING_MESSAGE);
        } else {
            int ncaracteres=codigo.length();
            if (ncaracteres<7) {
                boolean existenciapersona;
                /*En este condicional validamos que si el usuario modifica su codigo me realize la validacion de
                  la existencia de otro registro con ese codigo
                */
                if (codigo.equals(codigooriginal)) {
                    existenciapersona=false;
                } else {
                    //Validamos que no se pueda registrar personas con el mismo codigo y se presente un error
                    existenciapersona=(boolean) new ConsultasPost().verificarexistenciadepersona(codigo);
                }
                if (existenciapersona==false) {
                    try {
                        ps=con.prepareStatement("UPDATE personas SET \"Codigo\"=?,\"Nombres\"=?,\"Genero\"=? "
                                                + "WHERE \"Codigo\"=?");
                        ps.setString(1, codigo);
                        ps.setString(2,nombres);
                        ps.setString(3,genero);
                        ps.setString(4,codigooriginal);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Registro actualizado con exito");
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
