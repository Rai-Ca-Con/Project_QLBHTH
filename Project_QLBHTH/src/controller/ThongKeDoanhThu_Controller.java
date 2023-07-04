/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ChiTietHoaDon_Dao;
import java.util.List;

import model.HoaDon_Model;
import model.ThongKeDoanhThu_Model;
import dao.ThongKeDoanhThu_Dao;
import model.ChiTietHoaDon_Model;

public class ThongKeDoanhThu_Controller {

    private final ThongKeDoanhThu_Dao hoadon_dao;
    private final ChiTietHoaDon_Dao cthd_dao;

    public ThongKeDoanhThu_Controller() {
        hoadon_dao = new ThongKeDoanhThu_Dao();
        cthd_dao = new ChiTietHoaDon_Dao();
    }

    public List<HoaDon_Model> getAllHoaDon(ThongKeDoanhThu_Model tkdtmd) {
        return hoadon_dao.getAllHoaDon(tkdtmd);
    }

    public float getTongGiaTri() {
        return hoadon_dao.getTonggiatri();
    }
    public float getTonggiatrinhap(ThongKeDoanhThu_Model tkdtmd) {
        return hoadon_dao.getTonggiatrinhap(tkdtmd);
    }

    public void setTongGiaTri(float tonggiatri) {
        hoadon_dao.setTonggiatri(tonggiatri);
    }

    public List<ChiTietHoaDon_Model> getSanPhamTrongHD(ChiTietHoaDon_Model cthdmd) {
        return cthd_dao.getSanPhamTrongHD(cthdmd);
    }
}
