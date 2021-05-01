package Clasesconexion;

import Interfaz.MyVentana;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FranciscoMCC
 */
public class ConsultasPost {
    ConexionPost conexion=new ConexionPost();
    Connection con=conexion.GetConnection();
    PreparedStatement ps=null;
    ResultSet rs=null;
    public Object verificarexistenciadepersona(String codigo){
        try {
            ps=con.prepareStatement("SELECT * FROM personas WHERE \"Codigo\"=?");
            ps.setString(1, codigo);
            rs=ps.executeQuery();
            if (rs.next()) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println("ERROR AL CONSULTAR EXISTENCIA DE PERSONA");
            System.out.println(e);
        }
        return null;
    }
    public DefaultTableModel consultarRegistros(){
        DefaultTableModel Registros=new javax.swing.table.DefaultTableModel(
            new Object [][] {},new String [] {"Codigo", "Nombres", "Sexo"})
            {boolean[] canEdit = new boolean [] {false, false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}};;
        try {
            ps=con.prepareStatement("SELECT * FROM personas ORDER BY \"Nombres\" ASC");
            rs=ps.executeQuery();
            ResultSetMetaData rsMd=rs.getMetaData();
            int ncolumnas=rsMd.getColumnCount();
            while(rs.next()){
                Object[] filas=new Object[ncolumnas];
                for (int i = 0; i < ncolumnas; i++) {
                    filas[i]=rs.getObject(i+1);
                }
                Registros.addRow(filas);
            }
            return Registros;
        } catch (Exception e) {
            System.out.println("ERROR AL CONSULTAR REGISTROS");
            System.out.println(e);
        }
        return null;
    }
}
