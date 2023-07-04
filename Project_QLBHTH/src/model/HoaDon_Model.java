/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class HoaDon_Model {
    private String MaHD;
    private String NgayTaoHD;
    private float TriGiaHD;
    private String MaKH;
    private String MaNV;

    public HoaDon_Model() {
    }

    public HoaDon_Model(String MaHD, String NgayTaoHD, float TriGiaHD) {
        this.MaHD = MaHD;
        this.NgayTaoHD = NgayTaoHD;
        this.TriGiaHD = TriGiaHD;
    }

    public HoaDon_Model(String MaHD, String NgayTaoHD, float TriGiaHD, String MaKH, String MaNV) {
        this.MaHD = MaHD;
        this.NgayTaoHD = NgayTaoHD;
        this.TriGiaHD = TriGiaHD;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
    }
    

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getNgayTaoHD() {
        return NgayTaoHD;
    }

    public void setNgayTaoHD(String NgayTaoHD) {
        this.NgayTaoHD = NgayTaoHD;
    }

    public float getTriGiaHD() {
        return TriGiaHD;
    }

    public void setTriGiaHD(float TriGiaHD) {
        this.TriGiaHD = TriGiaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
    
}
