package model;

public class ThongKeDoanhThu_Model {

    private String NgayBD;
    private String NgayKT;
    private String ThangBD;
    private String ThangKT;
    private String NamBD;
    private String NamKT;
    private String luachon_KSX;
    private String luachon_SXT;

    public ThongKeDoanhThu_Model() {
    }

    public ThongKeDoanhThu_Model(String NgayBD, String NgayKT, String ThangBD, String ThangKT, String NamBD, String NamKT, String luachon_KSX, String luachon_SXT) {
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.ThangBD = ThangBD;
        this.ThangKT = ThangKT;
        this.NamBD = NamBD;
        this.NamKT = NamKT;
        this.luachon_KSX = luachon_KSX;
        this.luachon_SXT = luachon_SXT;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(String NgayBD) {
        this.NgayBD = NgayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(String NgayKT) {
        this.NgayKT = NgayKT;
    }

    public String getThangBD() {
        return ThangBD;
    }

    public void setThangBD(String ThangBD) {
        this.ThangBD = ThangBD;
    }

    public String getThangKT() {
        return ThangKT;
    }

    public void setThangKT(String ThangKT) {
        this.ThangKT = ThangKT;
    }

    public String getNamBD() {
        return NamBD;
    }

    public void setNamBD(String NamBD) {
        this.NamBD = NamBD;
    }

    public String getNamKT() {
        return NamKT;
    }

    public void setNamKT(String NamKT) {
        this.NamKT = NamKT;
    }

    public String getLuachon_KSX() {
        return luachon_KSX;
    }

    public void setLuachon_KSX(String luachon_KSX) {
        this.luachon_KSX = luachon_KSX;
    }

    public String getLuachon_SXT() {
        return luachon_SXT;
    }

    public void setLuachon_SXT(String luachon_SXT) {
        this.luachon_SXT = luachon_SXT;
    }
}
