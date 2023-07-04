/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class KhachHang_Model {
    private String maKH;
    private String tenKH;
    private String gioiTinh;
    private String diaChi;
    private String soDT;
    private String vanDe;

    public KhachHang_Model() {
    }

    public KhachHang_Model(String maKH, String tenKH, String gioiTinh, String diaChi, String soDT) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public KhachHang_Model(String maKH, String tenKH, String gioiTinh, String diaChi, String soDT, String vanDe) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.vanDe = vanDe;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getVanDe() {
        return vanDe;
    }

    public void setVanDe(String vanDe) {
        this.vanDe = vanDe;
    }

    @Override
    public String toString() {
        return "KhachHang_Model{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", soDT=" + soDT + ", vanDe=" + vanDe + '}';
    }
    
    
}
