package model;

public class ThongKeSanPham_Model {

    private String NgayTKSP;
    private String ThangTKSP;
    private String NamTKSP;
    private int SapXepTKSP;
    private int KieuSapXepTKSP;

    public ThongKeSanPham_Model() {
    }

    public ThongKeSanPham_Model(String NgayTKSP, String ThangTKSP, String NamTKSP, int SapXepTKSP, int KieuSapXepTKSP) {
        this.NgayTKSP = NgayTKSP;
        this.ThangTKSP = ThangTKSP;
        this.NamTKSP = NamTKSP;
        this.SapXepTKSP = SapXepTKSP;
        this.KieuSapXepTKSP = KieuSapXepTKSP;
    }

    public String getNgayTKSP() {
        return NgayTKSP;
    }

    public void setNgayTKSP(String NgayTKSP) {
        this.NgayTKSP = NgayTKSP;
    }

    public String getThangTKSP() {
        return ThangTKSP;
    }

    public void setThangTKSP(String ThangTKSP) {
        this.ThangTKSP = ThangTKSP;
    }

    public String getNamTKSP() {
        return NamTKSP;
    }

    public void setNamTKSP(String NamTKSP) {
        this.NamTKSP = NamTKSP;
    }

    public int getSapXepTKSP() {
        return SapXepTKSP;
    }

    public void setSapXepTKSP(int SapXepTKSP) {
        this.SapXepTKSP = SapXepTKSP;
    }

    public int getKieuSapXepTKSP() {
        return KieuSapXepTKSP;
    }

    public void setKieuSapXepTKSP(int KieuSapXepTKSP) {
        this.KieuSapXepTKSP = KieuSapXepTKSP;
    }
}
