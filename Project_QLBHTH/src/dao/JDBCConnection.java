/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.DangNhap_Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author admin
 */
public class JDBCConnection {
    public static Connection getJDBCConnection() { // ket noi vs mysql
        String url = "jdbc:mysql://localhost:3306/quanlitaphoa"; //29/5
        String user = "root";
        String password = "123456789";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DangNhap_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
