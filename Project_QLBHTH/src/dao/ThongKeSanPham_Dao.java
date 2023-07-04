package dao;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.SanPham_HoaDon_NhapHang_Model;
import model.ThongKeSanPham_Model;

public class ThongKeSanPham_Dao {

    private final ArrayList<SanPham_HoaDon_NhapHang_Model> tksp_table = new ArrayList<>();
    private final ArrayList<String> arrStr = new ArrayList<>();
    private final ArrayList<Integer> arrInt = new ArrayList<>();
    private SanPham_HoaDon_NhapHang_Model sphdmd;

    String sql;
    Connection conn = JDBCConnection.getJDBCConnection();

    public ArrayList<String> getArrStr() {
        return arrStr;
    }

    public ArrayList<Integer> getArrInt() {
        return arrInt;
    }

    public void getThongTinTKSP() {

        String layMaSP = "select * from sanpham"; //lluu y

        try {
            PreparedStatement pr = conn.prepareStatement(layMaSP);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                SanPham_HoaDon_NhapHang_Model sp = new SanPham_HoaDon_NhapHang_Model();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                tksp_table.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDoanhThu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getMatHangBan(ThongKeSanPham_Model tkspmd) {

        String dsSPB ="select distinct hoadon_sanpham.MaSP,sum(hoadon_sanpham.SoLuongBan) as SoLuongBan "
                + "from hoadon_sanpham, hoadon where hoadon_sanpham.MaHD = hoadon.MaHD and hoadon.NgayTaoHD = '" + tkspmd.getNamTKSP() + "-" + tkspmd.getThangTKSP() + "-" + tkspmd.getNgayTKSP() + "'group by hoadon_sanpham.MaSP;";

        try {
            PreparedStatement pr = conn.prepareStatement(dsSPB);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < tksp_table.size(); i++) {
                    if (tksp_table.get(i).getMaSP().equals(rs.getString("MaSP"))) {
                        tksp_table.get(i).setSoLuongBanRa(parseInt(rs.getString("SoLuongBan")));
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDoanhThu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getMatHangNhap(ThongKeSanPham_Model tkspmd) {

        String dsSPN = "select hoadonnhap.Ngaynhap,sanpham.MaSP,hoadonnhap.Soluongnhap from sanpham inner join hoadonnhap on sanpham.MaSP = hoadonnhap.MaSP and hoadonnhap.NgayNhap = '" + tkspmd.getNamTKSP() + "-" + tkspmd.getThangTKSP() + "-" + tkspmd.getNgayTKSP() + "'";
        try {
            PreparedStatement pr = conn.prepareStatement(dsSPN);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < tksp_table.size(); i++) {
                    if (tksp_table.get(i).getMaSP().equals(rs.getString("MaSP"))) {
                        tksp_table.get(i).setSoLuongNhap(parseInt(rs.getString("Soluongnhap")));
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDoanhThu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getMatHangBanTrongQuy(String NgayBD, String NgayKT) {

        String dsSPB = "select distinct hoadon_sanpham.MaSP,sanpham.TenSP,sum(hoadon_sanpham.SoLuongBan) as SoLuongBanTrongQuy "
                + " from hoadon_sanpham,hoadon,sanpham where hoadon_sanpham.MaHD = hoadon.MaHD and sanpham.MaSP = hoadon_sanpham.MaSP and hoadon.NgayTaoHD between '"
                + NgayBD + "' and '" + NgayKT
                + "'group by sanpham.TenSP,hoadon_sanpham.MaSP;";

        try {
            PreparedStatement pr = conn.prepareStatement(dsSPB);
            ResultSet rs = pr.executeQuery();
            // lỗi do khi kiểm tra rs.next o if thi rs.next luc day = 1 no dang tro den ban ghi dau tien
            // neu dung while(rs.next()) nx thi luc do no tro den ban ghi thu 2 thi no k chay vao trong vong while nx
            // vi chi co 1 ban ghi no chay sang ban ghi thu 2 la kq false nen k chay vao lenh lap -> k gan dc gia tri
            // fix bang cach do la neu co ban ghi thi sau khi check if thuc hien lay du lieu luon ban ghi do
            if (rs.next() == false) {
                return 0;

            }
            do {
                arrStr.add(rs.getString("MaSP") + ": " + rs.getString("TenSP"));
                arrInt.add(rs.getInt("SoLuongBanTrongQuy"));

            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDoanhThu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public void getSoLuongConHienTai() {

        String soluongconht = "select sanpham.MaSP,sanpham.TenSP,sanpham.SoLuongCon from sanpham;";

        try {
            PreparedStatement pr = conn.prepareStatement(soluongconht);
            ResultSet rs = pr.executeQuery();
            int k = 0;
            while (rs.next()) {
                tksp_table.get(k).setSoLuongConHienTai(parseInt(rs.getString("SoLuongCon")));
                k++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDoanhThu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getSoLuongTonKho(ThongKeSanPham_Model tkspmd) {

        String SoLuongNhapDenHienTai = "select hoadonnhap.MaSP, sum(hoadonnhap.Soluongnhap) as SoLuongNhap from hoadonnhap inner join sanpham on hoadonnhap.MaSP = sanpham.MaSP and hoadonnhap.Ngaynhap > '" + tkspmd.getNamTKSP() + "-" + tkspmd.getThangTKSP() + "-" + tkspmd.getNgayTKSP() + "'group by hoadonnhap.MaSP order by hoadonnhap.MaSP ASC;";
        String SoLuongXuatDenHienTai = "select hoadon_sanpham.MaSP, sum(hoadon_sanpham.SoLuongBan) as SoLuongBan from hoadon_sanpham, hoadon where  hoadon_sanpham.MaHD = hoadon.MaHD  and  hoadon.NgayTaoHD > '" + tkspmd.getNamTKSP() + "-" + tkspmd.getThangTKSP() + "-" + tkspmd.getNgayTKSP() + "' group by hoadon_sanpham.MaSP order by hoadon_sanpham.MaSP ASC";
        try {
            PreparedStatement pr = conn.prepareStatement(SoLuongNhapDenHienTai);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < tksp_table.size(); i++) {
                    if (tksp_table.get(i).getMaSP().equals(rs.getString("MaSP"))) {
                        tksp_table.get(i).setTongSoLuongNhapDenHT(parseInt(rs.getString("SoLuongNhap")));
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDoanhThu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement pr1 = conn.prepareStatement(SoLuongXuatDenHienTai);
            ResultSet rs1 = pr1.executeQuery();
            while (rs1.next()) {
                for (int i = 0; i < tksp_table.size(); i++) {
                    if (tksp_table.get(i).getMaSP().equals(rs1.getString("MaSP"))) {
                        tksp_table.get(i).setTongSoLuongXuatDenHT(parseInt(rs1.getString("SoLuongBan")));
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDoanhThu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < tksp_table.size(); i++) {
            int x = 0;
            // lien quan den so luong con hien tai & tong so luong nhap,xuat den sau ngay thong ke
            x = (tksp_table.get(i).getSoLuongConHienTai()) - (tksp_table.get(i).getTongSoLuongNhapDenHT()) + (tksp_table.get(i).getTongSoLuongXuatDenHT());
            tksp_table.get(i).setSoLuongTonKho(x);
        }
    }

    public ArrayList<SanPham_HoaDon_NhapHang_Model> xoaAll() {
        for (int i = 0; i < tksp_table.size(); i++) {
            tksp_table.clear();
        }
        return tksp_table;
    }

    public ArrayList<SanPham_HoaDon_NhapHang_Model> getter(ThongKeSanPham_Model tkspmd) {
        sphdmd = new SanPham_HoaDon_NhapHang_Model();
        if (tkspmd.getKieuSapXepTKSP() == 0) {
            switch (tkspmd.getSapXepTKSP()) {
                case 0:
                    for (int i = 0; i < tksp_table.size() - 1; i++) {
                        for (int j = i + 1; j < tksp_table.size(); j++) {
                            if (tksp_table.get(i).getSoLuongNhap() > tksp_table.get(j).getSoLuongNhap()) {
                                sphdmd = tksp_table.get(i);
                                tksp_table.set(i, tksp_table.get(j));
                                tksp_table.set(j, sphdmd);
                            }
                        }
                    }
                    break;

                case 1:
                    for (int i = 0; i < tksp_table.size() - 1; i++) {
                        for (int j = i + 1; j < tksp_table.size(); j++) {
                            if (tksp_table.get(i).getSoLuongBanRa() > tksp_table.get(j).getSoLuongBanRa()) {
                                sphdmd = tksp_table.get(i);
                                tksp_table.set(i, tksp_table.get(j));
                                tksp_table.set(j, sphdmd);
                            }
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < tksp_table.size() - 1; i++) {
                        for (int j = i + 1; j < tksp_table.size(); j++) {
                            if (tksp_table.get(i).getSoLuongTonKho() > tksp_table.get(j).getSoLuongTonKho()) {
                                sphdmd = tksp_table.get(i);
                                tksp_table.set(i, tksp_table.get(j));
                                tksp_table.set(j, sphdmd);
                            }
                        }
                    }
                    break;
            }

        }

        if (tkspmd.getKieuSapXepTKSP() == 1) {
            switch (tkspmd.getSapXepTKSP()) {
                case 0:
                    for (int i = 0; i < tksp_table.size() - 1; i++) {
                        for (int j = i + 1; j < tksp_table.size(); j++) {
                            if (tksp_table.get(i).getSoLuongNhap() < tksp_table.get(j).getSoLuongNhap()) {
                                sphdmd = tksp_table.get(i);
                                tksp_table.set(i, tksp_table.get(j));
                                tksp_table.set(j, sphdmd);
                            }
                        }
                    }
                    break;

                case 1:
                    for (int i = 0; i < tksp_table.size() - 1; i++) {
                        for (int j = i + 1; j < tksp_table.size(); j++) {
                            if (tksp_table.get(i).getSoLuongBanRa() < tksp_table.get(j).getSoLuongBanRa()) {
                                sphdmd = tksp_table.get(i);
                                tksp_table.set(i, tksp_table.get(j));
                                tksp_table.set(j, sphdmd);
                            }
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < tksp_table.size() - 1; i++) {
                        for (int j = i + 1; j < tksp_table.size(); j++) {
                            if (tksp_table.get(i).getSoLuongTonKho() < tksp_table.get(j).getSoLuongTonKho()) {
                                sphdmd = tksp_table.get(i);
                                tksp_table.set(i, tksp_table.get(j));
                                tksp_table.set(j, sphdmd);
                            }
                        }
                    }
                    break;
            }

        }
        return tksp_table;
    }

}
