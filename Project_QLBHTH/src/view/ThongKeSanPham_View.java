package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import javax.swing.table.JTableHeader;
import javax.swing.WindowConstants;

import controller.ThongKeSanPham_Controller;
import dao.ThongKeSanPham_Dao;
import model.SanPham_HoaDon_NhapHang_Model;
import model.ThongKeDoanhThu_Model;
import model.ThongKeSanPham_Model;

public class ThongKeSanPham_View extends javax.swing.JFrame {

    private ThongKeSanPham_Controller tkspctl;
    ThongKeSanPham_Dao tksp_dao;
    ThongKeDoanhThu_Model tkdtmd_3;
    DefaultTableModel tableModel;
    ArrayList<SanPham_HoaDon_NhapHang_Model> danhsachSP;
    ThongKeSanPham_Model tkspmd;
    BieuDoSanPham_View bdsp;
    ArrayList<Integer> thang31 = new ArrayList<>();
    ArrayList<Integer> thang30 = new ArrayList<>();

    public ThongKeSanPham_View() {
        initComponents();
        int value = (int) NgayTKSP_spn.getValue();
        this.setVisible(true);
        tkspctl = new ThongKeSanPham_Controller();
        tkspmd = new ThongKeSanPham_Model();
        tkdtmd_3 = new ThongKeDoanhThu_Model();
        tksp_dao = new ThongKeSanPham_Dao();
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép sửa hàng/cột trong bảng
            }
        };

        // Thiết lập font và cỡ chữ của tên các cột
        JTableHeader header = ThongKeSanPham_tb.getTableHeader();
        Font headerfont = new Font("TimesNewRoman", PLAIN, 16);
        header.setFont(headerfont);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new TaoMauGradient_View(238,171,202,148,187,233);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ThongKeSanPham_btn = new javax.swing.JButton();
        LamMoiTKSP_btn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        KieuSapXepTKSP_cbb = new javax.swing.JComboBox<>();
        SapXepTKSP_cbb = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        NamTKSP_spn = new javax.swing.JSpinner();
        NgayTKSP_spn = new javax.swing.JSpinner();
        ThangTKSP_spn = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        ThongKeSanPham_tb = new javax.swing.JTable();
        SapXepTheo_lbl1 = new javax.swing.JLabel();
        QuyThongKe_cbb = new javax.swing.JComboBox<>();
        NamTKBD_spn = new javax.swing.JSpinner();
        ThongKeSanPhamBD_btn = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("THỐNG KÊ SẢN PHẨM");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel2.setText("Ngày thống kê:");

        ThongKeSanPham_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ThongKeSanPham_btn.setText("Thống kê");
        ThongKeSanPham_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ThongKeSanPham_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongKeSanPham_btnActionPerformed(evt);
            }
        });

        LamMoiTKSP_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        LamMoiTKSP_btn.setText("Làm mới");
        LamMoiTKSP_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LamMoiTKSP_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiTKSP_btnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel7.setText("Sắp xếp theo:");

        KieuSapXepTKSP_cbb.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        KieuSapXepTKSP_cbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tăng dần", "Giảm dần" }));

        SapXepTKSP_cbb.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        SapXepTKSP_cbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Số lượng nhập \t", "Số lượng bán ra", "Số lượng tồn kho\t\t" }));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel5.setText("Kiểu sắp xếp:");

        NamTKSP_spn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        NamTKSP_spn.setModel(new javax.swing.SpinnerNumberModel(1900, 1900, 2030, 1));
        NamTKSP_spn.setOpaque(true);

        NgayTKSP_spn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        NgayTKSP_spn.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        ThangTKSP_spn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ThangTKSP_spn.setModel(new javax.swing.SpinnerNumberModel(1, 1,12 , 1));
        ThangTKSP_spn.setOpaque(true);

        ThongKeSanPham_tb.setBackground(new java.awt.Color(255, 222, 241));
        ThongKeSanPham_tb.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ThongKeSanPham_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ThongKeSanPham_tb.setSelectionBackground(new java.awt.Color(255, 222, 241));
        ThongKeSanPham_tb.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane1.setViewportView(ThongKeSanPham_tb);

        SapXepTheo_lbl1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        SapXepTheo_lbl1.setText("Thống kê biểu đồ:");

        QuyThongKe_cbb.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        QuyThongKe_cbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quý 1", "Quý 2", "Quý 3", "Quý 4", "Cả năm" }));
        QuyThongKe_cbb.setBorder(null);

        NamTKBD_spn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        NamTKBD_spn.setModel(new javax.swing.SpinnerNumberModel(1900, 1900, 2030, 1));
        NamTKBD_spn.setBorder(null);
        NamTKBD_spn.setOpaque(true);

        ThongKeSanPhamBD_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ThongKeSanPhamBD_btn.setText("Thống kê biểu đồ");
        ThongKeSanPhamBD_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ThongKeSanPhamBD_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongKeSanPhamBD_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(578, 578, 578))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LamMoiTKSP_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ThongKeSanPham_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7)
                                .addComponent(jLabel2))
                            .addGap(29, 29, 29)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(SapXepTKSP_cbb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(NgayTKSP_spn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ThangTKSP_spn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(NamTKSP_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(KieuSapXepTKSP_cbb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SapXepTheo_lbl1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(QuyThongKe_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NamTKBD_spn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ThongKeSanPhamBD_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel5, jLabel7});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NamTKSP_spn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ThangTKSP_spn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NgayTKSP_spn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(SapXepTKSP_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(KieuSapXepTKSP_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(ThongKeSanPham_btn)
                        .addGap(26, 26, 26)
                        .addComponent(LamMoiTKSP_btn)
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(NamTKBD_spn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(QuyThongKe_cbb)
                            .addComponent(SapXepTheo_lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addComponent(ThongKeSanPhamBD_btn)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(15, 15, 15))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel5, jLabel7});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {KieuSapXepTKSP_cbb, NamTKBD_spn, QuyThongKe_cbb});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void do_it() {
        // Đổ dữ liệu từ TableModel vào JTable
        //Khởi tạo dòng gán dữ liệu bắt đầu từ 0 
        tableModel.setRowCount(0);
        // Khởi tạo tên các cột của bảng
        tableModel.setColumnIdentifiers(new Object[]{
            "Mã sản phẩm", "Tên Sản Phẩm", "Số lượng nhập", "Số lượng bán ra", "Số lượng tồn kho"
        });
        ThongKeSanPham_tb.setModel(tableModel);// Đổ dữ liệu từ TableModel lên JTable

        //Lấy dữ liệu nhập từ người dùng để thống kê
        tkspmd.setNgayTKSP(NgayTKSP_spn.getValue().toString());
        tkspmd.setThangTKSP(ThangTKSP_spn.getValue().toString());
        tkspmd.setNamTKSP(NamTKSP_spn.getValue().toString());
        tkspmd.setKieuSapXepTKSP(KieuSapXepTKSP_cbb.getSelectedIndex());
        tkspmd.setSapXepTKSP(SapXepTKSP_cbb.getSelectedIndex());

        // Lấy ra danh sách các sản phẩm sau khi áp dụng các lựa chọn thống kê của người dùng
        danhsachSP = tkspctl.getAllSanPham(tkspmd);
        for (SanPham_HoaDon_NhapHang_Model dsmd : danhsachSP) {
            tableModel.addRow(new Object[]{
                dsmd.getMaSP(), dsmd.getTenSP(), dsmd.getSoLuongNhap(), dsmd.getSoLuongBanRa(), dsmd.getSoLuongTonKho(),
            }); // Thêm thông tin chi tiết của các sản phẩm vào bảng 
        }

        setCellsAlignment(ThongKeSanPham_tb, SwingConstants.CENTER); // Căn vị trí dự liệu trên bảng ra giữa

        // Sau khi thống kê nút thống kê sẽ được ẩn đi
        ThongKeSanPham_btn.setEnabled(false);

        // Nếu bảng trống hoặc danh sách rỗng theo lựa chọn thống kê của người dùng sẽ hiện thông báo
        if (tableModel.getRowCount() <= 0 || danhsachSP.isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "Không có dữ liệu");
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Khi đóng frame lại sẽ gọi đến frame chính
        QuanLyCuaHangTapHoaAdmin_View qlchthadm = new QuanLyCuaHangTapHoaAdmin_View();
    }//GEN-LAST:event_formWindowClosing

    private void ThongKeSanPham_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongKeSanPham_btnActionPerformed

        thang31.add(1);
        thang31.add(3);
        thang31.add(5);
        thang31.add(7);
        thang31.add(8);
        thang31.add(10);
        thang31.add(12);
        thang30.add(4);
        thang30.add(6);
        thang30.add(9);
        thang30.add(11);

        if (thang31.contains(ThangTKSP_spn.getValue()) && (int) NamTKBD_spn.getValue() >= 1) {
            if ((int) NgayTKSP_spn.getValue() >= 1 && (int) NgayTKSP_spn.getValue() <= 31) {
                do_it();
            } else {
                JOptionPane.showMessageDialog(this, "Ngay thong ke khong co thuc");
            }
        }
        if (thang30.contains(ThangTKSP_spn.getValue()) && (int) NamTKBD_spn.getValue() >= 1) {
            if ((int) NgayTKSP_spn.getValue() >= 1 && (int) NgayTKSP_spn.getValue() <= 30) {
                do_it();
            } else {
                JOptionPane.showMessageDialog(this, "Ngay thong ke khong co thuc");
            }
        }
        if ((int) ThangTKSP_spn.getValue() == 2 && (int) NamTKBD_spn.getValue() >= 1) {
            if ((int) NgayTKSP_spn.getValue() >= 1 && (int) NgayTKSP_spn.getValue() <= 28) {
                do_it();
            } else {
                JOptionPane.showMessageDialog(this, "Ngay thong ke khong co thuc");
            }
        }
        if ((int) (ThangTKSP_spn.getValue()) > 12) {
            JOptionPane.showMessageDialog(this, "Ngay thong ke khong co thuc");
        }
    }//GEN-LAST:event_ThongKeSanPham_btnActionPerformed

    private void LamMoiTKSP_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiTKSP_btnActionPerformed
        // Nếu bảng trống hoặc danh sách rỗng theo lựa chọn thống kê của người dùng sẽ chỉ clear ô nhập thông tin về giá trị mặc định
        if (tableModel.getRowCount() <= 0 || danhsachSP.isEmpty() == true) {
            Lam_Moi();
        } else { // nếu trong bảng có dữ liệu sẽ xóa dữ liệu trên bảng và clear ô nhập thông tin về giá trị mặc định
            int sohang = danhsachSP.size();
            for (int i = 0; i < sohang; i++) {
                tableModel.removeRow(0);
            }
            Lam_Moi();
        }
    }//GEN-LAST:event_LamMoiTKSP_btnActionPerformed

    private void ThongKeSanPhamBD_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongKeSanPhamBD_btnActionPerformed
        // TODO add your handling code here:
        String Quy = String.valueOf(QuyThongKe_cbb.getSelectedIndex() + 1);
        switch (QuyThongKe_cbb.getSelectedIndex()) {
            case 0 -> {
                tkdtmd_3.setNgayBD("1");
                tkdtmd_3.setNgayKT("31");
                tkdtmd_3.setThangBD("1");
                tkdtmd_3.setThangKT("3");
                tkdtmd_3.setNamBD(NamTKBD_spn.getValue().toString());
                tkdtmd_3.setNamKT(NamTKBD_spn.getValue().toString());
                tkdtmd_3.setLuachon_KSX("0");
                tkdtmd_3.setLuachon_SXT("0");
                break;
            }
            case 1 -> {
                tkdtmd_3.setNgayBD("1");
                tkdtmd_3.setNgayKT("30");
                tkdtmd_3.setThangBD("4");
                tkdtmd_3.setThangKT("6");
                tkdtmd_3.setNamBD(NamTKBD_spn.getValue().toString());
                tkdtmd_3.setNamKT(NamTKBD_spn.getValue().toString());
                tkdtmd_3.setLuachon_KSX("0");
                tkdtmd_3.setLuachon_SXT("0");
                break;
            }
            case 2 -> {
                tkdtmd_3.setNgayBD("1");
                tkdtmd_3.setNgayKT("30");
                tkdtmd_3.setThangBD("7");
                tkdtmd_3.setThangKT("9");
                tkdtmd_3.setNamBD(NamTKBD_spn.getValue().toString());
                tkdtmd_3.setNamKT(NamTKBD_spn.getValue().toString());
                tkdtmd_3.setLuachon_KSX("0");
                tkdtmd_3.setLuachon_SXT("0");
                break;
            }
            case 3 -> {
                tkdtmd_3.setNgayBD("1");
                tkdtmd_3.setNgayKT("31");
                tkdtmd_3.setThangBD("10");
                tkdtmd_3.setThangKT("12");
                tkdtmd_3.setNamBD(NamTKBD_spn.getValue().toString());
                tkdtmd_3.setNamKT(NamTKBD_spn.getValue().toString());
                tkdtmd_3.setLuachon_KSX("0");
                tkdtmd_3.setLuachon_SXT("0");
                break;
            }
            case 4 -> {
                tkdtmd_3.setNgayBD("1");
                tkdtmd_3.setNgayKT("31");
                tkdtmd_3.setThangBD("1");
                tkdtmd_3.setThangKT("12");
                tkdtmd_3.setNamBD(NamTKBD_spn.getValue().toString());
                tkdtmd_3.setNamKT(NamTKBD_spn.getValue().toString());
                tkdtmd_3.setLuachon_KSX("0");
                tkdtmd_3.setLuachon_SXT("0");
                break;
            }
        }
        String NgayBD = tkdtmd_3.getNamBD() + "-" + tkdtmd_3.getThangBD() + "-" + tkdtmd_3.getNgayBD();
        String NgayKT = tkdtmd_3.getNamKT() + "-" + tkdtmd_3.getThangKT() + "-" + tkdtmd_3.getNgayKT();
        if (tksp_dao.getMatHangBanTrongQuy(NgayBD, NgayKT) == 0) {
            JOptionPane.showMessageDialog(this, "Không có dữ liệu");

        } else {
            bdsp = new BieuDoSanPham_View("Thống kê bằng biểu đồ", tksp_dao.getArrStr(), tksp_dao.getArrInt());
            bdsp.setSize(800, 800);
            bdsp.setLocationRelativeTo(null);
            bdsp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            bdsp.setVisible(true);
        }


    }//GEN-LAST:event_ThongKeSanPhamBD_btnActionPerformed

    private void Lam_Moi() {
        //clear các ô nhập thông tin về giá trị mặc định
        NgayTKSP_spn.setValue(1);
        ThangTKSP_spn.setValue(1);
        NamTKSP_spn.setValue(1900);
        NamTKBD_spn.setValue(1900);
        // xóa dữ liệu trong list luu thông tin sản phẩm từ database
        danhsachSP = tkspctl.clear();
        // Hiện nút thống kê để thực hiện thống kê mới 
        ThongKeSanPham_btn.setEnabled(true);
        SapXepTKSP_cbb.setSelectedIndex(0);
        KieuSapXepTKSP_cbb.setSelectedIndex(0);
        QuyThongKe_cbb.setSelectedIndex(0);
    }

    public static void setCellsAlignment(JTable table, int alignment) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);
        TableModel tableModel = table.getModel();
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> KieuSapXepTKSP_cbb;
    private javax.swing.JButton LamMoiTKSP_btn;
    private javax.swing.JSpinner NamTKBD_spn;
    private javax.swing.JSpinner NamTKSP_spn;
    private javax.swing.JSpinner NgayTKSP_spn;
    private javax.swing.JComboBox<String> QuyThongKe_cbb;
    private javax.swing.JComboBox<String> SapXepTKSP_cbb;
    private javax.swing.JLabel SapXepTheo_lbl1;
    private javax.swing.JSpinner ThangTKSP_spn;
    private javax.swing.JButton ThongKeSanPhamBD_btn;
    private javax.swing.JButton ThongKeSanPham_btn;
    private javax.swing.JTable ThongKeSanPham_tb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
