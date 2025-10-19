/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sise.botica.DAO;

import com.sise.botica.models.EmpleadoAdm;
import com.sise.config.Conexion_baseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author jjjja
 */
public class LoginDAO {
    public boolean login(String correo, String contrasenia) throws Exception {
        Connection cn = null;
        try {
            cn = Conexion_baseDatos.getConnection();
            String sql = "SELECT contrasenia FROM Empleados WHERE correo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, correo);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String hashBD = rs.getString("contrasenia");

                // validar contraseña encriptada
                return BCrypt.checkpw(contrasenia, hashBD);
            }
            return false; // no encontró el correo
        } catch (Exception e) {
            throw new Exception("Error en login: " + e.getMessage());
        } finally {
            if (cn != null) cn.close();
        }
    }
}
