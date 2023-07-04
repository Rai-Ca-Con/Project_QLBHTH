/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class HoaDon_SanPham_Model {
    private String maHD;
    private String maSP;
    private int soLuongban;

    public HoaDon_SanPham_Model() {
    }

    public HoaDon_SanPham_Model(String maHD, String maSP, int soLuongban) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuongban = soLuongban;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuongban() {
        return soLuongban;
    }

    public void setSoLuongban(int soLuongban) {
        this.soLuongban = soLuongban;
    }
    
}
