/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sise.botica.DAO;

import Validacion.ClienteValidacion;
import com.sise.botica.models.ClienteAdm;
import com.sise.config.Conexion_baseDatos;
import java.util.List;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jjjja
 */
public class ClienteDAO {
    public void insertarCliente(ClienteAdm clienteadm)throws Exception{
        Connection cn=null;
        try{
            ClienteValidacion validador = new ClienteValidacion();
            if (validador.existeDni(clienteadm.getDni())) {
                throw new Exception("El DNI ya está registrado.");
            }
            if (validador.existeCelular(clienteadm.getCelular())) {
                throw new Exception("El celular ya está registrado.");
            }
            if (validador.existeCorreo(clienteadm.getCorreo())) {
                throw new Exception("El correo ya está registrado.");
            }
            
            cn=Conexion_baseDatos.getConnection();
            cn.setAutoCommit(false);
            
            String sql ="INSERT INTO dbo.Clientes(nombre, dni, celular, direccion, correo) values (?,?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1,clienteadm.getNombre());
            pstm.setString(2,clienteadm.getDni());
            pstm.setString(3,clienteadm.getCelular());
            pstm.setString(4, clienteadm.getDireccion());
            pstm.setString(5,clienteadm.getCorreo());
            
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
    
    public ClienteAdm buscarClientePorDni(String dni) throws Exception {
    ClienteAdm cliente = null;
    try (Connection cn = Conexion_baseDatos.getConnection()) {
        String sql = "SELECT Id_Cliente, nombre, celular, direccion, correo FROM Clientes WHERE dni=?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            cliente = new ClienteAdm();
            cliente.setDni(dni);
            cliente.setId_Cliente(rs.getInt("Id_Cliente"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setCelular(rs.getString("celular"));
            cliente.setDireccion(rs.getString("direccion"));
            cliente.setCorreo(rs.getString("correo"));
        }
        rs.close();
        ps.close();
    }
    return cliente;
}
    public void actualizarCliente(ClienteAdm cliente) throws Exception {
    try (Connection cn = Conexion_baseDatos.getConnection()) {
        String sql = "UPDATE Clientes SET nombre=?, celular=?, direccion=?, correo=? WHERE dni=?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getCelular());
        ps.setString(3, cliente.getDireccion());
        ps.setString(4, cliente.getCorreo());
        ps.setString(5, cliente.getDni());
        ps.executeUpdate();
        ps.close();
    }
}
    
    public List<ClienteAdm> listarClientes() throws Exception {
    List<ClienteAdm> lista = new ArrayList<>();
    String sql = "SELECT nombre, dni, celular, direccion, correo FROM Clientes";
    try (Connection cn = Conexion_baseDatos.getConnection();
         PreparedStatement ps = cn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            ClienteAdm c = new ClienteAdm();
            c.setNombre(rs.getString("nombre"));
            c.setDni(rs.getString("dni"));
            c.setCelular(rs.getString("celular"));
            c.setDireccion(rs.getString("direccion"));
            c.setCorreo(rs.getString("correo"));
            lista.add(c);
        }
    }
    return lista;
}
}

   
