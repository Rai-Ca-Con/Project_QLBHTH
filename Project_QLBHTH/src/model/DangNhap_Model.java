/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author admin
 */
public class DangNhap_Model {
    private String taikhoan;
    private String matkhau;

    public DangNhap_Model() {
    }

    public DangNhap_Model(String taikhoan, String matkhau) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
    
   
    
}

