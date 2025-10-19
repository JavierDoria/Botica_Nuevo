/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sise.botica.DAO;

import Validacion.EmpleadoValidacion;
import com.sise.botica.models.EmpleadoAdm;
import com.sise.config.Conexion_baseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author jjjja
 */
public class EmpleadoDAO {
    public void insertarEmpleado(EmpleadoAdm empleadoadm) throws Exception{
        Connection cn=null;
        try{
            EmpleadoValidacion validar = new EmpleadoValidacion();
            if(validar.existeDni(empleadoadm.getDni())){
                throw new Exception("EL DNI YA ESTA REGISTRADO.");
                }
            if (validar.existeCelular(empleadoadm.getCelular())) {
                    throw new Exception("EL CELULAR YA ESTA REGISTRADO.");
                }
            if (validar.existeCorreo(empleadoadm.getCorreo())) {
                    throw new Exception("EL CORREO YA ESTA REGISTRADO.");
                }
        cn=Conexion_baseDatos.getConnection();
        cn.setAutoCommit(false);
        
    String hash = BCrypt.hashpw(empleadoadm.getContrasenia(), BCrypt.gensalt());
    
    String sql ="INSERT INTO dbo.Empleados(nombre, dni, celular, direccion, correo,contrasenia,cargo) values (?,?,?,?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1,empleadoadm.getNombre());
            pstm.setString(2,empleadoadm.getDni());
            pstm.setString(3,empleadoadm.getCelular());
            pstm.setString(4, empleadoadm.getDireccion());
            pstm.setString(5,empleadoadm.getCorreo());
            pstm.setString(6,hash);
            pstm.setString(7,empleadoadm.getCargo());
            
            pstm.executeUpdate();
            cn.commit();
            pstm.close();
    
        }catch(Exception e){
            System.out.println(e);
            throw new Exception(e.toString());
        }finally {
            try {
                if(cn != null ){
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println(e);
                throw new Exception(e.toString());
            }
        }
    }
    
    public EmpleadoAdm buscarEmpleadoPorDni(String dni) throws Exception {
    EmpleadoAdm empleado = null;
    try (Connection cn = Conexion_baseDatos.getConnection()) {
        String sql = "SELECT nombre, celular, direccion, correo,contrasenia,cargo FROM Empleados WHERE dni=?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            empleado = new EmpleadoAdm();
            empleado.setDni(dni);
            empleado.setNombre(rs.getString("nombre"));
            empleado.setCelular(rs.getString("celular"));
            empleado.setDireccion(rs.getString("direccion"));
            empleado.setCorreo(rs.getString("correo"));
            empleado.setContrasenia(rs.getString("contrasenia"));
            empleado.setCargo(rs.getString("cargo"));
        }
        rs.close();
        ps.close();
    }
    return empleado;
}
    
    public void actualizarEmpleado(EmpleadoAdm empleado) throws Exception {
    try (Connection cn = Conexion_baseDatos.getConnection()) {
        String sql = "UPDATE Empleados SET nombre=?, celular=?, direccion=?, correo=?,contrasenia=?,cargo=? WHERE dni=?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, empleado.getNombre());
        ps.setString(2, empleado.getCelular());
        ps.setString(3, empleado.getDireccion());
        ps.setString(4, empleado.getCorreo());
        ps.setString(5,empleado.getContrasenia());
        ps.setString(6, empleado.getCargo());
        ps.setString(7, empleado.getDni());
        
        ps.executeUpdate();
        ps.close();
    }
}
    
    public List<EmpleadoAdm> listarEmpleados() throws Exception {
    List<EmpleadoAdm> lista = new ArrayList<>();
    String sql = "SELECT nombre, dni, celular, direccion, correo,contrasenia,cargo FROM Empleados";
    try (Connection cn = Conexion_baseDatos.getConnection();
         PreparedStatement ps = cn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            EmpleadoAdm c = new EmpleadoAdm();
            c.setNombre(rs.getString("nombre"));
            c.setDni(rs.getString("dni"));
            c.setCelular(rs.getString("celular"));
            c.setDireccion(rs.getString("direccion"));
            c.setCorreo(rs.getString("correo"));
            c.setContrasenia(rs.getString("contrasenia"));
            c.setCargo(rs.getString("cargo"));
            lista.add(c);
        }
    }
    return lista;
}
    
    public void eliminarEmpleado(String dni) throws Exception {
    try (Connection cn = Conexion_baseDatos.getConnection()) {
        String sql = "DELETE FROM Empleados WHERE dni=?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, dni);
        ps.executeUpdate();
        ps.close();
    }
}
}
