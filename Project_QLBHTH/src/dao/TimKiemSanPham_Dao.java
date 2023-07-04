/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.SanPham_Model;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import model.SanPham_Model;
/**
 *
 * @author Admin
 */
public class TimKiemSanPham_Dao {
    public List<SanPham_Model> searchProductsByName(String TenSP) {
        List<SanPham_Model> dsSanPham = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM sanpham WHERE TrangThai = 0 AND TenSP like '%" + TenSP + "%'";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                    String maSP = resultSet.getString("MaSP");
                    String tenSP = resultSet.getString("TenSP");                 
                    String loaiSP = resultSet.getString("LoaiSP");
                    String giaNiemYet = resultSet.getString("GiaNhap");
                    String giaBan = resultSet.getString("GiaBan");
                    Date ngaySX = resultSet.getDate("ngaySX");
                    Date hanSD = resultSet.getDate("HanSD");
                    int soLuong = resultSet.getInt("SoLuongCon");
                    String MaNCC = resultSet.getString("MaNCC");
                    SanPham_Model sanpham = new SanPham_Model(maSP, tenSP, loaiSP, giaNiemYet, giaBan, ngaySX,hanSD,soLuong,MaNCC);
                    dsSanPham.add(sanpham);
                }
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(conn !=null){
               try{
                   conn.close();
               }catch(SQLException ex){
                   
               } 
            }

        }
        return dsSanPham;
    }
    
    
    
    
    public List<SanPham_Model> searchProductsByType(String LoaiSP) {
        List<SanPham_Model> dsSanPham = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM sanpham WHERE LoaiSP like '%" + LoaiSP + "%'";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                    String maSP = resultSet.getString("MaSP");
                    String tenSP = resultSet.getString("TenSP");                 
                    String loaiSP = resultSet.getString("LoaiSP");
                    String giaNiemYet = resultSet.getString("GiaNhap");
                    String giaBan = resultSet.getString("GiaBan");
                    Date ngaySX = resultSet.getDate("ngaySX");
                    Date hanSD = resultSet.getDate("HanSD");
                    int soLuong = resultSet.getInt("SoLuongCon");
                    String MaNCC = resultSet.getString("MaNCC");
                    SanPham_Model sanpham = new SanPham_Model(maSP, tenSP, loaiSP, giaNiemYet, giaBan, ngaySX,hanSD,soLuong,MaNCC);
                    dsSanPham.add(sanpham);
                }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dsSanPham;
    }
}
