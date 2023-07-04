package controller;

import static dao.JDBCConnection.getJDBCConnection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DangNhap_Controller {
    // Tạo hàm đăng nhập
    public boolean DangNhap(String taikhoan, String matkhau) {
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection conn = getJDBCConnection();
            // tạo 1 đối tượng để thực hiên câu truy vấn
            Statement stmt = conn.createStatement();
            // Đối tượng rs sẽ nhận 1 list các giá trị từ database sau khi câu truy vấn thực hiên
            ResultSet rs = stmt.executeQuery("select * from taikhoan");
            while (rs.next()) { // trong khi các bản ghi vẫn còn 
                // kiểm tra tài khoản và mật khẩu có trung với dữ liệu nhập vào không nếu đúng sẽ trả về giá trị true; sai trả về false
                if((rs.getString(1).equalsIgnoreCase(taikhoan) && rs.getString(2).equalsIgnoreCase(matkhau))) {
                    return true;
                } 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DangNhap_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }  
}
