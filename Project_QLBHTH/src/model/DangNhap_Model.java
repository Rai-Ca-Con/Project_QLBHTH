package model;

public class DangNhap_Model {
    private String TaiKhoan;
    private String MatKhau;

    public DangNhap_Model() {
    }

    public DangNhap_Model(String TaiKhoan, String MatKhau) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }
}

