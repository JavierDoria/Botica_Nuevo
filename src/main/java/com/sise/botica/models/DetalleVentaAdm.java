/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sise.botica.models;

/**
 *
 * @author jjjja
 */
public class DetalleVentaAdm {
    private Integer id_detalle_venta;
    private Integer id_venta;
    private Integer id_producto;
    private Integer cantidad;

    public Integer getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(Integer id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
