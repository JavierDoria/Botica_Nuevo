
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validacion;

import com.sise.config.Conexion_baseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jjjja
 */
public class ProductoValidacion {
    
     public boolean existeCodigo(String codigo) {
    String sql = "SELECT COUNT(*) FROM Producto WHERE codigo = ?";
    try (Connection cn = Conexion_baseDatos.getConnection();
         PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, codigo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
   
    public boolean existeDescripcion(String descripcion) {
    String sql = "SELECT COUNT(*) FROM Producto WHERE descripcion = ?";
    try (Connection cn = Conexion_baseDatos.getConnection();
         PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, descripcion);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
}
