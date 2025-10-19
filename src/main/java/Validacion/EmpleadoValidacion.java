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
public class EmpleadoValidacion {
    public boolean existeDni(String dni) {
    String sql = "SELECT COUNT(*) FROM Empleados WHERE dni = ?";
    try (Connection cn = Conexion_baseDatos.getConnection();
         PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

public boolean existeCelular(String celular) {
    String sql = "SELECT COUNT(*) FROM Empleados WHERE celular = ?";
    try (Connection cn = Conexion_baseDatos.getConnection();
         PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, celular);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

public boolean existeCorreo(String correo) {
    String sql = "SELECT COUNT(*) FROM Empleados WHERE correo = ?";
    try (Connection cn = Conexion_baseDatos.getConnection();
         PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, correo);
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
