/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sise.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jjjja
 */
public class Conexion_baseDatos {
    private final static String DRIVER_CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final static String URL = "jdbc:sqlserver://localhost:1433;databaseName=proyecto_botica;encrypt=true;trustServerCertificate=true;";
    private final static String USERNAME = "sa";
    private final static String PASSWORD = "123456";
   
    private Conexion_baseDatos() {
    }

    @SuppressWarnings("deprecation")
    public static Connection getConnection() throws SQLException {
        Connection cn = null;
        try {
            Class.forName(DRIVER_CLASS_NAME).newInstance();
            cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        }
        return cn;
    }
}
