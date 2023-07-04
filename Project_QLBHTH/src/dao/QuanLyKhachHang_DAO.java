/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.JDBCConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang_Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class QuanLyKhachHang_DAO {
    List<KhachHang_Model> ls = new ArrayList<>();
    public int add(KhachHang_Model kh){
        int check = 0;
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "INSERT IGNORE INTO khachhang(MaKH, TenKH, Gioitinh, Diachi, SoDT, Vande)" +
                          "VALUES(?, ?, ?, ?, ?, ? )";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, kh.getMaKH());
            statement.setString(2, kh.getTenKH());
            statement.setString(3, kh.getGioiTinh());
            statement.setString(4, kh.getDiaChi());
            statement.setString(5, kh.getSoDT());
            statement.setString(6, kh.getVanDe());
            if(statement.executeUpdate() != 0){
                check = 1;
            }
                
            //ResultSet resultSet = statement.executeQuery();
            
        } catch(SQLException e){
            e.printStackTrace();
        }   
       return check;
        
    }
    
    public int update(KhachHang_Model kh){
        int check = 0;
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            //
            String sql = "UPDATE khachhang set TenKh = ?, Gioitinh = ?, Diachi = ?, SoDT = ?, Vande = ? WHERE MaKH = ?";
                          
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(6, kh.getMaKH());
            statement.setString(1, kh.getTenKH());
            statement.setString(2, kh.getGioiTinh());
            statement.setString(3, kh.getDiaChi());
            statement.setString(4, kh.getSoDT());
            statement.setString(5, kh.getVanDe());
            if(statement.executeUpdate() != 0){
                check = 1;
            }
       
              
            
            //ResultSet resultSet = statement.executeQuery();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return check;
    }
    
    public void delete(KhachHang_Model kh){
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            //
            
            String sql = "UPDATE khachhang set Vande = '' WHERE MaKH ='" + kh.getMaKH() +"'";
                          
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.executeUpdate();
   
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    

    public int count(){
        return ls.size();
    }
    public List<KhachHang_Model> getAll() {
        List<KhachHang_Model> dsKhachHang = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM khachhang ";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                    //MaKH, TenKH, Gioitinh, Diachi, SoDT, Vande
                    String maKH = resultSet.getString("MaKH");
                    String tenKH = resultSet.getString("TenKH");                 
                    String gioiTinh = resultSet.getString("Gioitinh");
                    String diaChi = resultSet.getString("Diachi");
                    String soDT = resultSet.getString("SoDT");
                    String vanDe = resultSet.getString("Vande");
                    

                    KhachHang_Model khachhang = new KhachHang_Model(maKH, tenKH, gioiTinh, diaChi, soDT, vanDe);
                    dsKhachHang.add(khachhang);
                }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dsKhachHang;
    }
    
    // lấy dữ liệu để tìm kiếm theo mã khách hàng
    public List<KhachHang_Model> getDatabyID(String MaKH) {
        List<KhachHang_Model> dsKhachHang = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM khachhang WHERE MaKH like '%" + MaKH + "%'";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                    //MaKH, TenKH, Gioitinh, Diachi, SoDT, Vande
                    String maKH = resultSet.getString("MaKH");
                    String tenKH = resultSet.getString("TenKH");                 
                    String gioiTinh = resultSet.getString("Gioitinh");
                    String diaChi = resultSet.getString("Diachi");
                    String soDT = resultSet.getString("SoDT");
                    String vanDe = resultSet.getString("Vande");
                    

                    KhachHang_Model khachhang = new KhachHang_Model(maKH, tenKH, gioiTinh, diaChi, soDT, vanDe);
                    dsKhachHang.add(khachhang);
                }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dsKhachHang;
    }
    // lấy dữ liệu để tìm kiếm theo tên khách hàng
    public List<KhachHang_Model> getDatabyName(String TenKH) {
        List<KhachHang_Model> dsKhachHang = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM khachhang WHERE TenKH like '%" + TenKH + "%'";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                    //MaKH, TenKH, Gioitinh, Diachi, SoDT, Vande
                    String maKH = resultSet.getString("MaKH");
                    String tenKH = resultSet.getString("TenKH");                 
                    String gioiTinh = resultSet.getString("Gioitinh");
                    String diaChi = resultSet.getString("Diachi");
                    String soDT = resultSet.getString("SoDT");
                    String vanDe = resultSet.getString("Vande");
                    

                    KhachHang_Model khachhang = new KhachHang_Model(maKH, tenKH, gioiTinh, diaChi, soDT, vanDe);
                    dsKhachHang.add(khachhang);
                }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dsKhachHang;
    }
    // Trả về số lượng khách hàng đã có
    public int getQuantity() {
        int q = 0;  
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            String sql = "SELECT COUNT(*) AS total FROM khachhang";
            PreparedStatement statement = conn.prepareStatement(sql);       
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                q = resultSet.getInt("total") + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return q;
    }
}
