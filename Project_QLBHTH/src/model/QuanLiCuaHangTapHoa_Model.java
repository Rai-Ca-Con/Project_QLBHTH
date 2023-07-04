package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class QuanLiCuaHangTapHoa_Model {

    private String icon;
    private String ten;
    private MenuType loai;

    public QuanLiCuaHangTapHoa_Model() {
    }

    public QuanLiCuaHangTapHoa_Model(String icon, String ten, MenuType loai) {
        this.icon = icon;
        this.ten = ten;
        this.loai = loai;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public MenuType getLoai() {
        return loai;
    }

    public void setLoai(MenuType loai) {
        this.loai = loai;
    }

    public static enum MenuType {
        TITLE, MENU, EMPTY
    }

    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/anh/" + icon + ".png"));
    }
}
