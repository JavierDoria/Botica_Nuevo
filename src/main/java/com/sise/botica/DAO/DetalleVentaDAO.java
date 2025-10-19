/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sise.botica.DAO;

import com.sise.botica.models.DetalleVentaAdm;
import com.sise.config.Conexion_baseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author jjjja
 */
public class DetalleVentaDAO {
    
    public void insertDetalle(DetalleVentaAdm detalleventaadm,int id_venta) throws Exception{
        Connection cn= null;
        PreparedStatement psVenta = null;
        
        try{
            cn=Conexion_baseDatos.getConnection();
            cn.setAutoCommit(false);
            
            String sql ="INSERT INTO dbo.Detalle_venta(id_venta, id_producto, cantidad) values(?,?,?)";
            psVenta = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psVenta.setInt(1, id_venta);
            psVenta.setInt(2, detalleventaadm.getId_producto());
            psVenta.setInt(3, detalleventaadm.getCantidad());
        psVenta.executeUpdate();
        cn.commit();
        psVenta.close();
       
        }catch (Exception e){
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
}
