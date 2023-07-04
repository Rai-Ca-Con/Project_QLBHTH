package model;

public class SanPham_HoaDon_NhapHang_Model {

    private String MaSP;
    private String TenSP;
    private int SoLuongTonKho;
    private int SoLuongBanRa;
    private int SoLuongNhap;
    private int SoLuongHetHan;
    private int SoLuongConHienTai;
    private int TongSoLuongNhapDenHT;
    private int TongSoLuongXuatDenHT;

    public SanPham_HoaDon_NhapHang_Model() {
    }

    public SanPham_HoaDon_NhapHang_Model(String MaSP, String TenSP, int SoLuongTonKho, int SoLuongBanRa, int SoLuongNhap, int SoLuongHetHan, int SoLuongConHienTai, int TongSoLuongNhapDenHT, int TongSoLuongXuatDenHT) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuongTonKho = SoLuongTonKho;
        this.SoLuongBanRa = SoLuongBanRa;
        this.SoLuongNhap = SoLuongNhap;
        this.SoLuongHetHan = SoLuongHetHan;
        this.SoLuongConHienTai = SoLuongConHienTai;
        this.TongSoLuongNhapDenHT = TongSoLuongNhapDenHT;
        this.TongSoLuongXuatDenHT = TongSoLuongXuatDenHT;
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

    public int getSoLuongTonKho() {
        return SoLuongTonKho;
    }

    public void setSoLuongTonKho(int SoLuongTonKho) {
        this.SoLuongTonKho = SoLuongTonKho;
    }

    public int getSoLuongBanRa() {
        return SoLuongBanRa;
    }

    public void setSoLuongBanRa(int SoLuongBanRa) {
        this.SoLuongBanRa = SoLuongBanRa;
    }

    public int getSoLuongNhap() {
        return SoLuongNhap;
    }

    public void setSoLuongNhap(int SoLuongNhap) {
        this.SoLuongNhap = SoLuongNhap;
    }

    public int getSoLuongHetHan() {
        return SoLuongHetHan;
    }

    public void setSoLuongHetHan(int SoLuongHetHan) {
        this.SoLuongHetHan = SoLuongHetHan;
    }

    public int getSoLuongConHienTai() {
        return SoLuongConHienTai;
    }

    public void setSoLuongConHienTai(int SoLuongConHienTai) {
        this.SoLuongConHienTai = SoLuongConHienTai;
    }

    public int getTongSoLuongNhapDenHT() {
        return TongSoLuongNhapDenHT;
    }

    public void setTongSoLuongNhapDenHT(int TongSoLuongNhapDenHT) {
        this.TongSoLuongNhapDenHT = TongSoLuongNhapDenHT;
    }

    public int getTongSoLuongXuatDenHT() {
        return TongSoLuongXuatDenHT;
    }

    public void setTongSoLuongXuatDenHT(int TongSoLuongXuatDenHT) {
        this.TongSoLuongXuatDenHT = TongSoLuongXuatDenHT;
    }
}
