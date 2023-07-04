/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;



import dao.JDBCConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import model.HoaDon_Model;
import model.HoaDon_SanPham_Model;
import model.SanPham_Model;
/**
 *
 * @author Admin
 */
public class XuatSanPham_Dao {
    // Hàm tính tiền mỗi sản phẩm
    public int tinhTien(HoaDon_SanPham_Model hdx){
        Connection conn = JDBCConnection.getJDBCConnection();
        int thanhTien = 0;
        int giaBan = 0;
        int soLuong = 0;
        try{
            String sql = "SELECT GiaBan FROM sanpham WHERE MaSP = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, hdx.getMaSP());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            giaBan = resultSet.getInt("GiaBan");

            
            //
            String sql1 = "SELECT SoLuongBan FROM hoadon_sanpham WHERE MaHD = ? AND MaSP = ?  ";
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            statement1.setString(1, hdx.getMaHD());
            statement1.setString(2, hdx.getMaSP());
            ResultSet resultSet1 = statement1.executeQuery();
            resultSet1.next() ;
            soLuong = resultSet1.getInt("SoLuongBan");

            
            
            thanhTien = giaBan * soLuong;
            
                    
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return thanhTien;

    }

    // tính tổng hoá đơn
    public int get(String MaHD){
        HoaDon_SanPham_Model[] hdsp = new HoaDon_SanPham_Model[getAll1(MaHD).size()];
        int tongTien = 0;
        for (int i = 0; i < hdsp.length; i++) {
            hdsp[i] = getAll1(MaHD).get(i);
            //System.out.println("SP: " + tinhTien(hdsp[i]));
            tongTien += tinhTien(hdsp[i]);        
        }
        return tongTien;
    }
    
    
    // Thêm từng sản phẩm vào hoá đơn sản phẩm (thêm vào bảng hoá đơn sản phẩm)
    // Khi thêm được thì trừ số lượng ( số lượng còn trong bảng sản phẩm )
    public int add(HoaDon_SanPham_Model hdx){
         int check = 0;
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "INSERT IGNORE INTO hoadon_sanpham(MaHD, MaSP, SoLuongBan)" +
                          "VALUES(?, ?, ? )";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, hdx.getMaHD());           
            statement.setString(2, hdx.getMaSP());
            statement.setInt(3, hdx.getSoLuongban());                       
            if(statement.executeUpdate() != 0){
                check = 1;
                updateQuantity(hdx);
            }
            
            // giảm số lượng còn lại 
            //updateQuantity(hdx);
                
       
        } catch(SQLException e){
            e.printStackTrace();
        }
        return check;
    }
    
    // kiểm tra đã có khách hàng này trong dữ liệu hay chưa
    public int check1(String MaKH){
        int check = 0;
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM khachhang WHERE MaKH = ?" ;
                          
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, MaKH);
            
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet.next() == true){
                check = 1;
            }
       
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return check;
    }
    // kiểm tra đã có nhân viên này trong dữ liệu hay chưa
    public int check2(String MaNV){
        int check = 0;
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM nhanvien WHERE MaNV = ?" ;
                          
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, MaNV);
            
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet.next() == true){
                check = 1;
            }
       
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return check;
    }
    // kiểm tra hoá đơn này đã được thanh toán hay chưa 
    public int check3(String MaHD){
        int check = 0;
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM hoadon WHERE MaHD = ?" ;
                          
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, MaHD);
            
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet.next() == true){
                check = 1;
            }
       
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return check;
    }
    // Lấy dữ liệu từ bảng hoá đơn sản phẩm 
    // Hiển thị số lượng
    public List<HoaDon_SanPham_Model> getAll1(String MaHD) {
        List<HoaDon_SanPham_Model> dsHDX = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM hoadon_sanpham WHERE MaHD = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, MaHD);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                    String maHoaDon = resultSet.getString("MaHD");
                    String maSanPham = resultSet.getString("MaSP");
                    int soLuongban = resultSet.getInt("SoLuongBan");                 
                    HoaDon_SanPham_Model hdx = new HoaDon_SanPham_Model(maHoaDon, maSanPham, soLuongban );
                    dsHDX.add(hdx);
                }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dsHDX;
    }
    
    
    // Hiển thị tên sản phẩm đơn giá 
    public List<SanPham_Model> getAll(String MaSP) {
        List<SanPham_Model> dsSP = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "SELECT * FROM sanpham WHERE MaSP = ? AND TrangThai = 0 ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, MaSP);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                    
                    String tenSanPham = resultSet.getString("TenSP");
                    String donGia = resultSet.getString("GiaBan");
                                    
                    SanPham_Model sp = new SanPham_Model( tenSanPham,  donGia);
                    dsSP.add(sp);
                }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dsSP;
    }
    // Hàm cập nhật dữ liệu vào bảng hoá đơn
    public void insert(HoaDon_Model hd){
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            String sql = "INSERT IGNORE INTO hoadon(MaHD, NgayTaoHD, TriGia, MaKH, MaNV)" +
                          "VALUES(?, ?, ?, ?, ? )";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, hd.getMaHD());
            statement.setString(2, hd.getNgayTaoHD());
            statement.setString(3, ""+get(hd.getMaHD()));
            statement.setString(4, hd.getMaKH());
            statement.setString(5, hd.getMaNV());
            
            statement.executeUpdate();
                
            
           
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    // xoá dữ liệu trong bảng hoá đơn sản phẩm thông qua mã hoá đơn( sử dụng cho tạo mới )
    public void deletebyID(String MaHD){
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            //
            String sql = "delete from hoadon_sanpham where MaHD = '" + MaHD + "'";
                          
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.executeUpdate();
   
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    // tính số lượng còn lại
    public void updateQuantity(HoaDon_SanPham_Model hdsp){
        int soLuongban = 0;
        int soLuongcon = 0;
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            // tìm số lượng bán
            String sql = "SELECT SoLuongBan FROM hoadon_sanpham WHERE MaHD = ? AND MaSP = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, hdsp.getMaHD()); 
            statement.setString(2, hdsp.getMaSP()); 
            
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            soLuongban = resultSet.getInt("SoLuongBan");  
            
            // tính số lượng còn 
            String sql2 = "SELECT SoLuongCon FROM sanpham WHERE MaSP = ? ";
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            statement2.setString(1, hdsp.getMaSP()); 
            ResultSet resultSet2 = statement2.executeQuery();
            resultSet2.next();
            soLuongcon = resultSet2.getInt("SoLuongCon");
            
            
            soLuongcon = soLuongcon - soLuongban;
            
      
            String sql1 = "UPDATE sanpham set SoLuongCon = ? WHERE MaSP = ?";
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            statement1.setInt(1, soLuongcon); 
            statement1.setString(2, hdsp.getMaSP());
            statement1.executeUpdate();   
             
                
        } catch(SQLException e){
            e.printStackTrace();
        }            
    }
    // xoá dữ liệu trong bẳng hoá đơn sản phẩm thông qua mã hoá đơn và mã sản phẩm
    public void delete(String MaHD, String MaSP){
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            // trả lại số lượng trước khi xoá
            getAllbyID1(MaHD, MaSP);
            // xoá
            String sql = "delete from hoadon_sanpham where MaHD = '" + MaHD + "' and MaSP = '" + MaSP + "'";
              
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.executeUpdate();
            
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    // Trả lại số lượng cho một sản phẩm
    public int getAllbyID1(String MaHD, String MaSP) {
        int check = 0;
        int soLuongcon = 0;
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
           
                // số lượng đã lấy lên hoá đơn 
                String sql = "SELECT SoLuongBan FROM hoadon_sanpham WHERE MaHD = ? AND MaSP = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, MaHD);
                statement.setString(2,  MaSP);
                ResultSet resultSet = statement.executeQuery();
                
                if(resultSet.next() == true){
                    check = 1;
                    
                    int soLuongban = resultSet.getInt("SoLuongBan");      
                    // số lượng còn lại trong sản phẩm 
                    String sql2 = "SELECT SoLuongCon FROM sanpham WHERE MaSP = ? ";
                    PreparedStatement statement2 = conn.prepareStatement(sql2);
                    statement2.setString(1, MaSP); 
                    ResultSet resultSet2 = statement2.executeQuery();
                    resultSet2.next();
                    soLuongcon = resultSet2.getInt("SoLuongCon");

                    soLuongcon = soLuongcon + soLuongban;
                    // trả lại số lượng cho sản phẩm i
                    String sql1 = "UPDATE sanpham set SoLuongCon = ? WHERE MaSP = ?";
                    PreparedStatement statement1 = conn.prepareStatement(sql1);
                    statement1.setInt(1, soLuongcon); 
                    statement1.setString(2, MaSP);
                    statement1.executeUpdate(); 
                }
                  
            
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return check;
    }
    // Trả về số lượng hoá đơn đã có
    public int getQuantity() {
        int q = 0;  
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            String sql = "SELECT COUNT(*) AS total FROM hoadon";
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
    // Trả lại số lượng cho toàn bộ sản phẩm
    public void getAllbyID(String MaHD) {
        // Lấy toàn bộ thông tin sản phẩm của hoá đơn đó 
        List<HoaDon_SanPham_Model> dsHDX = getAll1(MaHD);
        int soLuongcon = 0;
        Connection conn = JDBCConnection.getJDBCConnection();
        try{
            for(int i = 0; i < dsHDX.size(); i++){
                // số lượng đã lấy lên hoá đơn 
                String sql = "SELECT SoLuongBan FROM hoadon_sanpham WHERE MaHD = ? AND MaSP = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, dsHDX.get(i).getMaHD());
                statement.setString(2, dsHDX.get(i).getMaSP());
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                int soLuongban = resultSet.getInt("SoLuongBan");      
                // số lượng còn lại trong sản phẩm 
                String sql2 = "SELECT SoLuongCon FROM sanpham WHERE MaSP = ? ";
                PreparedStatement statement2 = conn.prepareStatement(sql2);
                statement2.setString(1, dsHDX.get(i).getMaSP()); 
                ResultSet resultSet2 = statement2.executeQuery();
                resultSet2.next();
                soLuongcon = resultSet2.getInt("SoLuongCon");
                
                soLuongcon = soLuongcon + soLuongban;
                // trả lại số lượng cho sản phẩm i
                String sql1 = "UPDATE sanpham set SoLuongCon = ? WHERE MaSP = ?";
                PreparedStatement statement1 = conn.prepareStatement(sql1);
                statement1.setInt(1, soLuongcon); 
                statement1.setString(2, dsHDX.get(i).getMaSP());
                statement1.executeUpdate();   
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    // lấy ngày sản xuất để so sánh với ngày in hoá đơn 
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
    // lấy HSD để so sánh với ngày in hoá đơn 
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
                   
               } 
            }

        }
        return dsSanPham;
    }
    
}   

