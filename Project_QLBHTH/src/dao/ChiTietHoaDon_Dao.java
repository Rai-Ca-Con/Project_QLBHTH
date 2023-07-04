package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.ChiTietHoaDon_Model;

public class ChiTietHoaDon_Dao {

    private List<ChiTietHoaDon_Model> dssanphamtronghd;
    String sql;

    // Tạo hàm lấy thông tin chi tiết của các sản phâm trong hóa đơn được chọn
    public List<ChiTietHoaDon_Model> getSanPhamTrongHD(ChiTietHoaDon_Model cthdmd) {
        dssanphamtronghd = new ArrayList<>();
        // Kết nối database và thực hiện truy vấn
        Connection conn = JDBCConnection.getJDBCConnection();
        sql = "select sanpham.MaSP,sanpham.TenSP,hoadon_sanpham.SoLuongBan from hoadon_sanpham,sanpham where hoadon_sanpham.MaSP = sanpham.MaSP and hoadon_sanpham.MaHD = '"
                + cthdmd.getMaHD() + "'order by sanpham.MaSP ASC";
        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                // Tạo 1 đối tượng trung gian để lưu trữ thông tin chi tiết của sản phẩm
                ChiTietHoaDon_Model cthd = new ChiTietHoaDon_Model();
                // Gán các thông tin của sản phẩm cho đối tượng
                cthd.setMaSP(rs.getString("MaSP"));
                cthd.setTenSP(rs.getString("TenSP"));
                cthd.setSoLuongSP(rs.getInt("SoLuongBan"));
                // Thêm đối tượng vào list
                dssanphamtronghd.add(cthd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDoanhThu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Trả về list thông tin chi tiết của các sản phẩm trong hóa đơn được chọn
        return dssanphamtronghd;
    }
}
