package model;

public class ChiTietHoaDon_Model {

    String MaHD;
    String MaSP;
    String TenSP;
    int SoLuongSP;

    public ChiTietHoaDon_Model() {
    }

    public ChiTietHoaDon_Model(String MaHD, String MaSP, String TenSP, int SoLuongSP) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuongSP = SoLuongSP;
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuongSP() {
        return SoLuongSP;
    }

    public void setSoLuongSP(int SoLuongSP) {
        this.SoLuongSP = SoLuongSP;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }
}
