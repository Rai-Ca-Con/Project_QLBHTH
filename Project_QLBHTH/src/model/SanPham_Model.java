/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class SanPham_Model {
    private String maSP;
    private String tenSP;
    private String loaiSP;
    private String giaNiemYet;
    private String giaBan;
    private Date ngaySX;
    private Date hanSD;
    private int soLuongcon;   
    private String maNCC;
    

    public SanPham_Model() {
    }

    public SanPham_Model( String tenSP, String giaBan) {
        this.tenSP = tenSP;
        this.giaBan = giaBan;
    }
    

    public SanPham_Model(String maSP, String tenSP, String loaiSP, String giaBan, Date hanSD, int soLuongcon) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.giaBan = giaBan;
        this.hanSD = hanSD;
        this.soLuongcon = soLuongcon;
    }

    public SanPham_Model(String maSP, String tenSP, String loaiSP, String giaNiemYet, String giaBan, Date ngaySX, Date hanSD, int soLuongcon, String maNCC) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.giaNiemYet = giaNiemYet;
        this.giaBan = giaBan;
        this.ngaySX = ngaySX;
        this.hanSD = hanSD;
        this.soLuongcon = soLuongcon;
        this.maNCC = maNCC;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getGiaNiemYet() {
        return giaNiemYet;
    }

    public void setGiaNiemYet(String giaNiemYet) {
        this.giaNiemYet = giaNiemYet;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public Date getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(Date ngaySX) {
        this.ngaySX = ngaySX;
    }

    public Date getHanSD() {
        return hanSD;
    }

    public void setHanSD(Date hanSD) {
        this.hanSD = hanSD;
    }

    public int getSoLuongcon() {
        return soLuongcon;
    }

    public void setSoLuongcon(int soLuongcon) {
        this.soLuongcon = soLuongcon;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }
    
    
    
}
