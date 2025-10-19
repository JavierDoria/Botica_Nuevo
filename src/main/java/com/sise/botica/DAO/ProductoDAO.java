/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sise.botica.DAO;

import Validacion.ProductoValidacion;
import com.sise.botica.models.ProductoAdm;
import com.sise.config.Conexion_baseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author jjjja
 */
public class ProductoDAO {
    public void insertProducto(ProductoAdm productoadm) throws Exception{
        Connection cn= null;
        try{
            ProductoValidacion validar = new ProductoValidacion();
            if(validar.existeCodigo(productoadm.getCodigo())){
                throw new Exception("EL CODIGO YA ESTA REGISTRADO.");
            }
            if(validar.existeDescripcion(productoadm.getDescripcion())){
                throw new Exception("LA DESCRIPCION YA EXISTE.");
            }
            cn=Conexion_baseDatos.getConnection();
            cn.setAutoCommit(false);
            
            String sql ="INSERT INTO dbo.Productos(codigo, descripcion,cantidad,precio) values(?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, productoadm.getCodigo());
            pstm.setString(2, productoadm.getDescripcion());
            pstm.setInt(3,productoadm.getCantidad());
            pstm.setDouble(4,productoadm.getPrecio());
            
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
    
    public ProductoAdm buscarProducto(String descripcion)throws Exception{
        ProductoAdm producto = null;
        try(Connection cn = Conexion_baseDatos.getConnection()){
            String sql ="SELECT Id_Producto,codigo,cantidad,precio FROM Productos where descripcion =?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, descripcion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            producto = new ProductoAdm();
            producto.setDescripcion(descripcion);
            producto.setId_Producto(rs.getInt("Id_Producto"));
            producto.setCodigo(rs.getString("codigo"));
            producto.setStock(rs.getInt("cantidad"));
            producto.setPrecio(rs.getDouble("precio"));
        }
        rs.close();
        ps.close();
    }
    return producto;
        }
    public void actualizarProducto(ProductoAdm producto) throws Exception {
    try (Connection cn = Conexion_baseDatos.getConnection()) {
        String sql = "UPDATE Productos SET codigo=?, cantidad=?, precio=? WHERE descripcion=?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, producto.getCodigo());
        ps.setInt(2, producto.getCantidad());
        ps.setDouble(3, producto.getPrecio());
        ps.setString(4, producto.getDescripcion());
        ps.executeUpdate();
        ps.close();
    }
    
}
    
    public List<ProductoAdm> listarProducto() throws Exception {
    List<ProductoAdm> lista = new ArrayList<>();
    String sql = "SELECT codigo,descripcion, cantidad, precio FROM Productos";
    try (Connection cn = Conexion_baseDatos.getConnection();
         PreparedStatement ps = cn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            ProductoAdm c = new ProductoAdm();
            c.setCodigo(rs.getString("codigo"));
            c.setDescripcion(rs.getString("descripcion"));
            c.setCantidad(rs.getInt("cantidad"));
            c.setPrecio(rs.getDouble("precio"));
            lista.add(c);
        }
    }
    return lista;
}
    }

