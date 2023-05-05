package controller;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
public class DangNhap_Controller {

    public boolean DangNhap(String taikhoan, String matkhau) { // neu nhap sai mat khau va password thi lai goi lai cho den khi nhap dung thi ms break
        if (("admin".equalsIgnoreCase(taikhoan) && "1234".equalsIgnoreCase(matkhau))||("employee".equalsIgnoreCase(taikhoan) && "5678".equalsIgnoreCase(matkhau) )) {
            return true;
        } else {
            return false;
        }
    }
}
