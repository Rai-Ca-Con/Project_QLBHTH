// hello ae nhom 8
package dao;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.ThongKeDoanhThu_Model;
import model.HoaDon_Model;

public class ThongKeDoanhThu_Dao {

    private List<HoaDon_Model> danhsachhoadon;
    float tonggiatri;
    String sql;
    DecimalFormat decimalFormat = new DecimalFormat("#");

    public void setTonggiatri(float tonggiatri) {
        this.tonggiatri = tonggiatri;
    }

    public List<HoaDon_Model> getAllHoaDon(ThongKeDoanhThu_Model tkdtmd) { /// okie hieu r suong qua !!!!
        danhsachhoadon = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        sql = "SELECT * FROM hoadon where NgayTaoHD between'"
                + tkdtmd.getNamBD() + "-" + tkdtmd.getThangBD() + "-" + tkdtmd.getNgayBD()
                + "'and'"
                + tkdtmd.getNamKT() + "-" + tkdtmd.getThangKT() + "-" + tkdtmd.getNgayKT()
                + "'";
        if (tkdtmd.getLuachon_KSX().equals("0")) {
            if (tkdtmd.getLuachon_SXT().equals("0")) {
                sql += "order by NgayTaoHD ASC";
            }
            if (tkdtmd.getLuachon_SXT().equals("1")) {
                sql += "order by TriGia ASC";
            }
        } else {
            if (tkdtmd.getLuachon_KSX().equals("1")) {
                if (tkdtmd.getLuachon_SXT().equals("0")) {
                    sql += "order by NgayTaoHD DESC";
                }
                if (tkdtmd.getLuachon_SXT().equals("1")) {
                    sql += "order by TriGia DESC";
                }
            }
        }

        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                HoaDon_Model hoadon = new HoaDon_Model();
                hoadon.setMaHD(rs.getString("MaHD"));
                hoadon.setNgayTaoHD(rs.getString("NgayTaoHD"));
                hoadon.setTriGiaHD(rs.getFloat("TriGia"));
                danhsachhoadon.add(hoadon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDoanhThu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tkdtmd.getLuachon_SXT().equals("1")) {
            HoaDon_Model hd = new HoaDon_Model();
            switch (parseInt(tkdtmd.getLuachon_KSX())) {
                case 0:
                    for (int i = 0; i < danhsachhoadon.size() - 1; i++) {
                        for (int j = i + 1; j < danhsachhoadon.size(); j++) {
                            if (danhsachhoadon.get(i).getTriGiaHD() > danhsachhoadon.get(j).getTriGiaHD()) {
                                hd = danhsachhoadon.get(i);
                                danhsachhoadon.set(i, danhsachhoadon.get(j));
                                danhsachhoadon.set(j, hd);
                            }
                        }
                    }
                    break;

                case 1:
                    for (int i = 0; i < danhsachhoadon.size() - 1; i++) {
                        for (int j = i + 1; j < danhsachhoadon.size(); j++) {
                            if (danhsachhoadon.get(i).getTriGiaHD() < danhsachhoadon.get(j).getTriGiaHD()) {
                                hd = danhsachhoadon.get(i);
                                danhsachhoadon.set(i, danhsachhoadon.get(j));
                                danhsachhoadon.set(j, hd);
                            }
                        }
                    }
                    break;
            }
        }
        return danhsachhoadon;
    }

    public float getTonggiatri() {
        tonggiatri = 0;
        for (int i = 0; i < danhsachhoadon.size(); i++) {
            tonggiatri += danhsachhoadon.get(i).getTriGiaHD();
        }
        return tonggiatri;
    }

    public float getTonggiatrinhap(ThongKeDoanhThu_Model tkdtmd) {
        float tongtiennhap = 0;
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            sql = "select hoadonnhap.MaSP, sanpham.GiaNhap,sum(Soluongnhap)as sln from hoadonnhap,sanpham where hoadonnhap.MaSP = sanpham.MaSP and hoadonnhap.Ngaynhap between '"
                    + tkdtmd.getNamBD() + "-" + tkdtmd.getThangBD() + "-" + tkdtmd.getNgayBD()
                    + "'and'"
                    + tkdtmd.getNamKT() + "-" + tkdtmd.getThangKT() + "-" + tkdtmd.getNgayKT()
                    + "' group by MaSP";

            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                double gn = Float.parseFloat(rs.getString("GiaNhap"));
                int sln = rs.getInt("sln");
                double tiennhap = gn * sln;
                tongtiennhap += tiennhap;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDoanhThu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tongtiennhap;
    }
}
