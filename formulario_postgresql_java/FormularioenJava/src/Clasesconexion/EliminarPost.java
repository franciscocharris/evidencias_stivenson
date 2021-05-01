package Clasesconexion;

import Interfaz.MyVentana;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author FranciscoMCC
 */
public class EliminarPost {
    ConexionPost conexion=new ConexionPost();
    Connection con=conexion.GetConnection();
    PreparedStatement ps=null;
    public void EliminarRegistro(String codigo){
        try {
            ps=con.prepareStatement("DELETE  FROM personas WHERE \"Codigo\"=?");
            ps.setString(1, codigo);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro Eliminado con exito");
            new MyVentana().JTregistros.setModel(new ConsultasPost().consultarRegistros());
        } catch (Exception e) {
            System.out.println("ERROR AL ELIMINAR EL REGISTRO");
            System.out.println(e);
        }
    }
}
