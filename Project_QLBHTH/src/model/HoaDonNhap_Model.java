/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.NhapSanPham_Dao;



/**
 *
 * @author Admin
 */
public class HoaDonNhap_Model {
    private String ngayNhap;
    private int soLuongnhap;
    private String maSP;

    public HoaDonNhap_Model() {
    }

    public HoaDonNhap_Model(String ngayNhap, int soLuongnhap, String maSP) {
        this.ngayNhap = ngayNhap;
        this.soLuongnhap = soLuongnhap;
        this.maSP = maSP;
    }

    

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuongnhap() {
        return soLuongnhap;
    }

    public void setSoLuongnhap(int soLuongnhap) {
        this.soLuongnhap = soLuongnhap;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
 
}

