/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicolas.editorial.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nicolas
 */
public class Conexion {

    private Connection conn;

    public Connection open() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/editorial?user=nicolas&password=guest");
        
        return conn;
    }
    
    public void close() throws SQLException{
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
