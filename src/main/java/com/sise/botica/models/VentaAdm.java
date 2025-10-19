/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sise.botica.models;

import java.time.LocalDateTime;

/**
 *
 * @author jjjja
 */
public class VentaAdm {
    private Integer Id_venta;
    private Integer id_empleado;
    private Integer id_cliente;
    private LocalDateTime  fecha;

    public Integer getId_venta() {
        return Id_venta;
    }

    public void setId_venta(Integer Id_venta) {
        this.Id_venta = Id_venta;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    
}
