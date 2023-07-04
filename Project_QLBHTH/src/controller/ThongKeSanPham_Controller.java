/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.util.ArrayList;

import dao.ThongKeSanPham_Dao;
import model.SanPham_HoaDon_NhapHang_Model;
import model.ThongKeSanPham_Model;

/**
 *
 * @author admin
 */
public class ThongKeSanPham_Controller {
    private final ThongKeSanPham_Dao tksp_dao;
    public ThongKeSanPham_Controller()  {
        tksp_dao = new ThongKeSanPham_Dao();
    }

    public ArrayList<SanPham_HoaDon_NhapHang_Model> getAllSanPham(ThongKeSanPham_Model tkspmd) {
       tksp_dao.getThongTinTKSP();
       tksp_dao.getMatHangBan(tkspmd);
       tksp_dao.getMatHangNhap(tkspmd);
       tksp_dao.getSoLuongConHienTai();
       tksp_dao.getSoLuongTonKho(tkspmd);
       return tksp_dao.getter(tkspmd);
      
    }
    
    public ArrayList<SanPham_HoaDon_NhapHang_Model> clear(){
               return tksp_dao.xoaAll();
 }
}
