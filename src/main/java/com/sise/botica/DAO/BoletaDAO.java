/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sise.botica.DAO;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTable;
/**
 *
 * @author jjjja
 */
public class BoletaDAO {
    public void generarBoleta(String nombreCliente, String dniCliente, JTable tablaVentas, double txtCosto) {
        Document documento = new Document();
        try {
            String ruta = "boleta_" + System.currentTimeMillis() + ".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            // Encabezado
            Paragraph titulo = new Paragraph("BOLETA DE VENTA",
        FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.BLACK));
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            documento.add(new Paragraph(" "));

            // Datos cliente
            documento.add(new Paragraph("Cliente: " + nombreCliente));
            documento.add(new Paragraph("DNI: " + dniCliente));

            // Fecha de emisión
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            documento.add(new Paragraph("Fecha de emisión: " + dtf.format(LocalDateTime.now())));
            documento.add(new Paragraph(" "));

            // Detalle de venta en tabla
            PdfPTable tabla = new PdfPTable(4); // columnas: Cantidad, Producto, P.Unitario, Total
            tabla.addCell("Producto");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio Unitario");
            tabla.addCell("Total");

            for (int i = 0; i < tablaVentas.getRowCount(); i++) {
                tabla.addCell(tablaVentas.getValueAt(i, 1).toString()); // producto
                tabla.addCell(tablaVentas.getValueAt(i, 2).toString()); // cantidad
                tabla.addCell(tablaVentas.getValueAt(i, 3).toString()); // precio unitario
                tabla.addCell(tablaVentas.getValueAt(i, 5).toString()); // subtotal
            }

            documento.add(tabla);

            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("TOTAL A PAGAR: S/ " + txtCosto,
            FontFactory.getFont("Arial", 14, Font.BOLD, BaseColor.BLACK)));

            documento.close();
            

            System.out.println("Boleta generada en: " + ruta);
            File file = new File(ruta);
            if (file.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file);
                } else {
                    System.out.println(" Tu sistema no soporta abrir archivos automáticamente.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
