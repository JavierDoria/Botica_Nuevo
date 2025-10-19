/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.sise.botica.ui;

import com.sise.botica.DAO.BoletaDAO;
import com.sise.botica.DAO.ClienteDAO;
import com.sise.botica.DAO.DetalleVentaDAO;
import com.sise.botica.DAO.ProductoDAO;
import com.sise.botica.DAO.VentaDAO;
import com.sise.botica.models.ClienteAdm;
import com.sise.botica.models.DetalleVentaAdm;
import com.sise.botica.models.ProductoAdm;
import com.sise.botica.models.VentaAdm;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AgregaVentaAdmin extends javax.swing.JInternalFrame {
    DefaultTableModel modeloVenta;
    List<ProductoAdm> oLista = new ArrayList<ProductoAdm>();
    ClienteAdm cliente = new ClienteAdm();
    ProductoAdm prod = new ProductoAdm();
    
    /**
     * Creates new form AgregaVentaAdmin
     */
    DefaultTableModel modelo;
    public AgregaVentaAdmin() {
        initComponents();
        modeloVenta = new DefaultTableModel(
        new Object[]{"CODIGO", "PRODUCTO", "CANTIDAD","PRECIO","STOCK","TOTAL"}, 
        0
        );
        jDatos.setModel(modeloVenta);
        //jDatos.setModel(modelo);
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                String cantidadStr = txtCantidad.getText().trim();
                String producto = txtProducto.getText().trim();
                
                int cantidad;
                cantidad=Integer.parseInt(cantidadStr);
                
                if (cantidadStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad");
                }
                 else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado");
                }
                txtProducto.setText("");
                txtCantidad.setText("");
            }
        }
    });
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnPago = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDatos = new javax.swing.JTable();

        jLabel4.setText("CODIGO");

        jLabel1.setText("PRODUCTO");

        txtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoActionPerformed(evt);
            }
        });
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoKeyPressed(evt);
            }
        });

        jLabel2.setText("CANTIDAD");

        jLabel3.setText("PRECIO");

        jLabel5.setText("STOCK");

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel6.setText("DNI");

        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniKeyPressed(evt);
            }
        });

        jLabel7.setText("NOMBRE");

        btnPago.setText("PAGAR");
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });

        jLabel8.setText("TOTAL A PAGAR");

        txtCosto.setText("-----");

        jDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "PRODUCTO", "CANTIDAD", "PRECIO", "STOCK", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(jDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPago)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29)
                        .addComponent(txtCosto)
                        .addGap(54, 54, 54))))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregar)
                                .addGap(30, 30, 30)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtCosto)
                        .addComponent(btnPago)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed
        try{
            VentaAdm venta = new VentaAdm();
            venta.setId_empleado(9);
            venta.setId_cliente(cliente.getId_Cliente());
            venta.setFecha(LocalDateTime.now());
            VentaDAO dao = new VentaDAO();
            int idventa = dao.insertVenta(venta);
            
            for(ProductoAdm item:oLista){
                DetalleVentaAdm detalle = new DetalleVentaAdm();
                detalle.setId_producto(item.getId_Producto());
                detalle.setCantidad(item.getCantidad());
                
                DetalleVentaDAO detVenta = new DetalleVentaDAO();
                detVenta.insertDetalle(detalle, idventa);
            }
            
            
             double totalPagar = 0;
        for (ProductoAdm item : oLista) {
            totalPagar += item.getCantidad() * item.getPrecio();
        }
                BoletaDAO boletaDAO = new BoletaDAO();
            boletaDAO.generarBoleta(
                cliente.getNombre(), 
                cliente.getDni(), 
                jDatos,  // tu JTable donde ya muestras el detalle
                totalPagar
            );
            JOptionPane.showMessageDialog(this, "Venta registrada con éxito");
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al registrar venta: " + e.getMessage());
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_btnPagoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        @SuppressWarnings("unused")
        int cantidadItemsLista = oLista.size();
        
        ProductoAdm producto = new ProductoAdm();
        producto.setId_Producto(prod.getId_Producto());
        producto.setCodigo(txtCodigo.getText());
        producto.setDescripcion(txtProducto.getText());
        producto.setCantidad(Integer.parseInt(txtCantidad.getText()));
        producto.setPrecio((double)Double.parseDouble(txtPrecio.getText()));
        producto.setStock(Integer.parseInt(txtStock.getText()));
        
        oLista.add(producto);
        
        modeloVenta.setRowCount(0);
        try {
           for (ProductoAdm c : oLista) {
            modeloVenta.addRow(new Object[]{
                c.getCodigo(),
                c.getDescripcion(),
                c.getCantidad(),
                c.getPrecio(),
                c.getStock(),
                c.getCantidad()* c.getPrecio()
            });
            }
          // modeloVenta.addRow(new Object[]{codigo, producto, cantidad, precio, total});
        calcularTotal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar clientes: " + e.getMessage());
        }  
        txtCodigo.setText("");
        txtProducto.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed

    }//GEN-LAST:event_txtProductoActionPerformed

    private void txtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyPressed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String producto =txtProducto.getText().trim();
            
            try {
            ProductoDAO dao = new ProductoDAO();
            prod = dao.buscarProducto(producto);

            if (prod != null) {
                txtCodigo.setText(String.valueOf(prod.getCodigo()));
                txtPrecio.setText(String.valueOf(prod.getPrecio()));
                txtStock.setText(String.valueOf(prod.getStock()));
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_txtProductoKeyPressed

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String dni =txtDni.getText().trim();
            try {
                ClienteDAO cli = new ClienteDAO();
                cliente = cli.buscarClientePorDni(dni);
                if (cliente != null){
                 txtNombre.setText(cliente.getNombre());
                }else{
                    JOptionPane.showMessageDialog(this, "Cliente no encontrado");
                }
                
            }catch(Exception e){
            }
        }        
    }//GEN-LAST:event_txtDniKeyPressed
    private void calcularTotal(){
            double suma =0.0;
            for(int i = 0; i < modeloVenta.getRowCount(); i++) {
                double totalFila = Double.parseDouble(modeloVenta.getValueAt(i, 5).toString());
                suma += totalFila;
            }
        txtCosto.setText(String.valueOf(suma));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnPago;
    private javax.swing.JTable jDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JLabel txtCosto;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
