/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sise.botica.DAO;

import com.sise.botica.models.VentaAdm;
import com.sise.config.Conexion_baseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author jjjja
 */
public class VentaDAO {
    public int insertVenta(VentaAdm ventaadm)throws Exception{
        int idGenerado = 0;
        ResultSet rs = null;
        Connection cn= null;
        try{
            cn=Conexion_baseDatos.getConnection();
            cn.setAutoCommit(false);
            String sql ="INSERT INTO dbo.Ventas(id_empleado, id_cliente, fecha) values(?,?,?)";
            PreparedStatement psmt =cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psmt.setInt(1,ventaadm.getId_empleado());
            psmt.setInt(2,ventaadm.getId_cliente());
            psmt.setTimestamp(3, Timestamp.valueOf(ventaadm.getFecha()));
        
        psmt.executeUpdate();
        
        rs = psmt.getGeneratedKeys();
        if (rs.next()) {
            idGenerado = rs.getInt(1);
        } 
        
        cn.commit();
        psmt.close();
        
        System.out.println("Venta registrada correctamente");
        return idGenerado;
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
}
