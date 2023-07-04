/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.JDBCConnection;
import dao.JDBCConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.HoaDonNhap_Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SanPham_Model;
import view.QuanLyNhapSanPham_View;

/**
 *
 * @author Admin
 */
public class NhapSanPham_Dao {
    
    // Phương thức tăng số lượng còn trong bảng sản phẩm ( xử lý phương thức thêm hoá đơn sản phẩm đồng thời tăng số lượng còn lại trong bảng sản phẩm )
    private void updateQuantity(HoaDonNhap_Model hdn){
        int tmp = hdn.getSoLuongnhap();  
        int soLuongcon = 0;
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT SoLuongCon FROM sanpham WHERE MaSP = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, hdn.getMaSP()); 
            
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            soLuongcon = resultSet.getInt("SoLuongCon");  
            
            tmp = tmp + soLuongcon;
      
            String sql1 = "UPDATE sanpham set SoLuongCon = ? and TrangThai = 0 WHERE MaSP = ?";
                          
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            statement1.setInt(1, tmp);  
            statement1.setString(2, hdn.getMaSP());
            statement1.executeUpdate();      
             

                    
                    
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
    // Thêm dữ liệu vào bảng hoá đơn nhập và đồng thời chỉnh sửa lại số lượng còn lại trong bảng sản phẩm
    public int add(HoaDonNhap_Model hdn){
        int check = 0;
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "INSERT IGNORE INTO hoadonnhap(Ngaynhap, Soluongnhap, MaSP)" +
                          "VALUES(?, ?, ? )";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, hdn.getNgayNhap());
            statement.setInt(2, hdn.getSoLuongnhap());
            statement.setString(3, hdn.getMaSP());
            int tmp = statement.executeUpdate();
            if(tmp != 0){
                check = 1;
            }
                
            
            updateQuantity(hdn);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return check;
    }
   
    //**
    // Khi sửa số lượng thêm của 1 sản phẩm tại 1 ngày nào đó thì đồng thời phải thay đổi số lượng còn lại 
    // phương thức sửa lại số lượng còn lại
    public int updateQuantity1(HoaDonNhap_Model hdn){
        Connection conn = JDBCConnection.getJDBCConnection();
        int soLuongnhapcu = 0;
        try{
            //Tính độ chênh lệch giữa lần sửa và lần nhập trước
            //SELECT Soluongnhap FROM hoadonnhap WHERE MaSP = 'TPH002' AND Ngaynhap = '2022-1-1';
            String sql = "SELECT Soluongnhap FROM hoadonnhap WHERE MaSP = ? AND Ngaynhap = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, hdn.getMaSP()); 
            statement.setString(2, hdn.getNgayNhap()); 
            
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            
            soLuongnhapcu = resultSet.getInt("Soluongnhap");   // số lượng nhập sai của lần trước
            
            int soLuongnhap = hdn.getSoLuongnhap();  // số lượng sửa
            int tmp = Math.abs(soLuongnhap - soLuongnhapcu); // Biến xét sự chênh lệch giữa lần sửa và lần nhập trước

            //Lấy số lượng còn hiện tại
            String sql1 = "SELECT SoLuongCon FROM sanpham WHERE MaSP = ?";
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            statement1.setString(1, hdn.getMaSP()); 
            ResultSet resultSet1 = statement1.executeQuery();
            resultSet1.next();
            int soLuongcon = resultSet1.getInt("SoLuongCon");
            if(soLuongnhapcu < soLuongnhap){
                soLuongcon = soLuongcon + tmp;
            }else{
                soLuongcon = soLuongcon - tmp;
            }
            
            // Update lại số lượng còn
            String sql2 = "UPDATE sanpham set SoLuongCon = ? WHERE MaSP = ?";                         
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            statement2.setInt(1, soLuongcon);  
            statement2.setString(2, hdn.getMaSP());
            statement2.executeUpdate();      
             
           
        } catch(SQLException e){
            e.printStackTrace();
        }
        return soLuongnhapcu;
    }
    // xoá dữ liệu bảng hoá đơn nhập dựa theo mã sản phẩm và ngày nhập
    public void delete(HoaDonNhap_Model hdn){
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            // trả lại số lượng trước khi xoá
            updateQuantity2(hdn);
            // xoá
            String sql = "delete from hoadonnhap where MaSP = '" + hdn.getMaSP() + "' and Ngaynhap = '" + hdn.getNgayNhap() + "'";
              
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.executeUpdate();
            
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    // khôi phục lại số lượng bị nhập sai
    public void updateQuantity2(HoaDonNhap_Model hdn){
        Connection conn = JDBCConnection.getJDBCConnection();
        
        try{
            
            //SELECT Soluongnhap FROM hoadonnhap WHERE MaSP = 'TPH002' AND Ngaynhap = '2022-1-1';
            String sql = "SELECT Soluongnhap FROM hoadonnhap WHERE MaSP = ? AND Ngaynhap = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, hdn.getMaSP()); 
            statement.setString(2, hdn.getNgayNhap()); 
            
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            
            int soLuongnhap = resultSet.getInt("Soluongnhap");   // số lượng nhập sai của lần trước
            



            //Lấy số lượng còn hiện tại
            String sql1 = "SELECT SoLuongCon FROM sanpham WHERE MaSP = ?";
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            statement1.setString(1, hdn.getMaSP()); 
            ResultSet resultSet1 = statement1.executeQuery();
            resultSet1.next();
            int soLuongcon = resultSet1.getInt("SoLuongCon");
            
            soLuongcon = soLuongcon - soLuongnhap;
            
            
            // Update lại số lượng còn
            String sql2 = "UPDATE sanpham set SoLuongCon = ? WHERE MaSP = ?";                         
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            statement2.setInt(1, soLuongcon);  
            statement2.setString(2, hdn.getMaSP());
            statement2.executeUpdate();      
             
           
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    // Sửa lại bảng hoá đơn nhập đồng đời sửa lại số lượng còn lại ở bảng sản phẩm
    public void update(HoaDonNhap_Model hdn){
        Connection conn = JDBCConnection.getJDBCConnection();
        //int check = 0;
        try{
            // Cập nhật lại số lượng còn ở bảng sản phẩm
            // Phải cập nhật lại trước (nếu cập nhật sau khi sửa bảng hoá đơn nhập thì không thể tính độ chênh lệch)
            updateQuantity1(hdn);
            // Sửa dữ liệu ở bảng hoá đơn nhập
            String sql = "UPDATE hoadonnhap set Soluongnhap = ? WHERE MaSP = ? AND Ngaynhap = ?";
                          
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, hdn.getSoLuongnhap());
            statement.setString(2, hdn.getMaSP());
            statement.setString(3, hdn.getNgayNhap());
            
            //statement.executeUpdate();
            if(statement.executeUpdate()>0){
                //check = 1;
            }
        
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        //return check;
    }
    // Lấy dữ liệu bảng hoá đơn nhập
    public List<HoaDonNhap_Model> getAll() {
        List<HoaDonNhap_Model> dsHDN = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM hoadonnhap ";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                    
                    String ngayNhap = resultSet.getString("Ngaynhap");
                    int soLuongnhap = resultSet.getInt("Soluongnhap");                 
                    String maSP = resultSet.getString("MaSP");
                    
                    

                    HoaDonNhap_Model hdn = new HoaDonNhap_Model(ngayNhap, soLuongnhap, maSP);
                    dsHDN.add(hdn);
                }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dsHDN;
    }
    
    // Lấy dữ liệu bảng hoá đơn nhập thông qua ngày nhập
    public List<HoaDonNhap_Model> getDataByNgayNhap(String NgayNhap) {
        List<HoaDonNhap_Model> dsHDN = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM hoadonnhap WHERE Ngaynhap = '" + NgayNhap + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                    
                    String ngayNhap = resultSet.getString("Ngaynhap");
                    int soLuongnhap = resultSet.getInt("Soluongnhap");                 
                    String maSP = resultSet.getString("MaSP");
                    
                    

                    HoaDonNhap_Model hdn = new HoaDonNhap_Model(ngayNhap, soLuongnhap, maSP);
                    dsHDN.add(hdn);
                }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dsHDN;
    }
    // Lấy dữ liệu bảng hoá đơn nhập thông qua mã sản phẩm
    public List<HoaDonNhap_Model> getDataByID(String MaSP) {
        List<HoaDonNhap_Model> dsHDN = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM hoadonnhap WHERE MaSP = '" + MaSP + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                    
                    String ngayNhap = resultSet.getString("Ngaynhap");
                    int soLuongnhap = resultSet.getInt("Soluongnhap");                 
                    String maSP = resultSet.getString("MaSP");
                    
                    

                    HoaDonNhap_Model hdn = new HoaDonNhap_Model(ngayNhap, soLuongnhap, maSP);
                    dsHDN.add(hdn);
                }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dsHDN;
    }
    // lấy ngày sản xuất để so sánh với ngày nhâp
    public Date getNgaySanXuatFromDatabase(String maSanPham) {
        Connection conn = JDBCConnection.getJDBCConnection();
        Date nsx = null;
        try {
            // Truy vấn CSDL
            String sql = "SELECT ngaySX FROM sanpham where MaSP =?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, maSanPham);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                nsx = resultSet.getDate("ngaySX");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nsx;
    }
    // lấy HSD để so sánh với ngày nhâp
    public Date gethsdFromDatabase(String maSanPham) {
        Connection conn = JDBCConnection.getJDBCConnection();
        Date hsd = null;
        try {
            // Truy vấn CSDL
            String sql = "SELECT HanSD FROM sanpham where MaSP =?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, maSanPham);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                hsd = resultSet.getDate("HanSD");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hsd;
    }
    // tìm kiếm sản phẩm theo tên
    public List<SanPham_Model> searchProductsByName(String TenSP) {
        List<SanPham_Model> dsSanPham = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM sanpham WHERE TenSP like '%" + TenSP + "%' AND TrangThai = 0";
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
                   ex.printStackTrace();
               } 
            }

        }
        return dsSanPham;
    }
    
 }
