package view;

import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import javax.swing.table.JTableHeader;
import java.text.DecimalFormat;
import javax.swing.WindowConstants;

import model.HoaDon_Model;
import model.ThongKeDoanhThu_Model;
import controller.ThongKeDoanhThu_Controller;
import model.ChiTietHoaDon_Model;

public class ThongKeDoanhThu_View extends javax.swing.JFrame {

    private ThongKeDoanhThu_Controller tkdtctl;
    DefaultTableModel tableModel;
    List<HoaDon_Model> danhsachHD;
    List<HoaDon_Model> danhsachHD_2;
    ThongKeDoanhThu_Model tkdtmd, tkdtmd_2;
    ChiTietHoaDon_Model cthdmd;
    ChiTietHoaDon_View cthdv;
    BieuDoDoanhThu_View bddt;
    DecimalFormat decimalFormat = new DecimalFormat("#"); // convert so dang double (E gi do) sang dang thap phan

    public ThongKeDoanhThu_View() {
        initComponents();
        this.setVisible(true);
        tkdtctl = new ThongKeDoanhThu_Controller();
        tkdtmd = new ThongKeDoanhThu_Model();
        tkdtmd_2 = new ThongKeDoanhThu_Model();
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // khong cho phep sua hang/cot
            }
        };

        JTableHeader header = ThongKeDoanhThu_tb.getTableHeader();
        Font headerfont = new Font("TimesNewRoman", PLAIN, 16);
        header.setFont(headerfont);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        ThongKeDoanhThu_pn = new TaoMauGradient_View(238,171,202,148,187,233);
        LamMoi_btn = new javax.swing.JButton();
        ThongKe_btn = new javax.swing.JButton();
        NgayBatDau_spn = new javax.swing.JSpinner();
        ThangBatDau_spn = new javax.swing.JSpinner();
        NamBatDau_spn = new javax.swing.JSpinner();
        NgayThangNamBD_lbl = new javax.swing.JLabel();
        NgayThangNamKT_lbl = new javax.swing.JLabel();
        NgayKetThuc_spn = new javax.swing.JSpinner();
        ThangKetThuc_spn = new javax.swing.JSpinner();
        NamTKBD_spn = new javax.swing.JSpinner();
        KieuSapXep_lbl = new javax.swing.JLabel();
        SapXepTheo_lbl = new javax.swing.JLabel();
        KieuSapXep_cbb = new javax.swing.JComboBox<>();
        SapXepTheo_cbb = new javax.swing.JComboBox<>();
        ChiTietHoaDon_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ThongKeDoanhThu_tb = new javax.swing.JTable();
        TongDoanhThu_lbl = new javax.swing.JLabel();
        TongDoanhThu_tf = new javax.swing.JTextField();
        ThongKeDoanhThu_lbl = new javax.swing.JLabel();
        TongDoanhThu_lbl1 = new javax.swing.JLabel();
        LoiNhuan_tf = new javax.swing.JTextField();
        TongDoanhThu_lbl2 = new javax.swing.JLabel();
        TienVon_tf = new javax.swing.JTextField();
        ThongKeDoanhThuBD_btn = new javax.swing.JButton();
        QuyThongKe_cbb = new javax.swing.JComboBox<>();
        NamKetThuc_spn = new javax.swing.JSpinner();
        SapXepTheo_lbl1 = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setName("Thống Kê Doanh Thu"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        ThongKeDoanhThu_pn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LamMoi_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        LamMoi_btn.setText("Làm mới");
        LamMoi_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LamMoi_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoi_btnActionPerformed(evt);
            }
        });

        ThongKe_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ThongKe_btn.setText("Thống kê");
        ThongKe_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ThongKe_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongKe_btnActionPerformed(evt);
            }
        });

        NgayBatDau_spn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        NgayBatDau_spn.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        ThangBatDau_spn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ThangBatDau_spn.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        ThangBatDau_spn.setOpaque(true);

        NamBatDau_spn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        NamBatDau_spn.setModel(new javax.swing.SpinnerNumberModel(1900, 1900, 2030, 1));
        NamBatDau_spn.setOpaque(true);

        NgayThangNamBD_lbl.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        NgayThangNamBD_lbl.setText("Từ ngày/tháng/năm:");

        NgayThangNamKT_lbl.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        NgayThangNamKT_lbl.setText("Đến ngày/tháng/năm:");

        NgayKetThuc_spn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        NgayKetThuc_spn.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        NgayKetThuc_spn.setOpaque(true);

        ThangKetThuc_spn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ThangKetThuc_spn.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        ThangKetThuc_spn.setOpaque(true);

        NamTKBD_spn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        NamTKBD_spn.setModel(new javax.swing.SpinnerNumberModel(1900, 1900, 2030, 1));
        NamTKBD_spn.setOpaque(true);

        KieuSapXep_lbl.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        KieuSapXep_lbl.setText("Kiểu sắp xếp:");

        SapXepTheo_lbl.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        SapXepTheo_lbl.setText("Sắp xếp theo:");

        KieuSapXep_cbb.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        KieuSapXep_cbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tăng dần", "Giảm dần" }));

        SapXepTheo_cbb.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        SapXepTheo_cbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày tạo", "Thành tiền" }));

        ChiTietHoaDon_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ChiTietHoaDon_btn.setText("Chi tiết hóa đơn");
        ChiTietHoaDon_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ChiTietHoaDon_btn.setEnabled(false);
        ChiTietHoaDon_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChiTietHoaDon_btnActionPerformed(evt);
            }
        });

        ThongKeDoanhThu_tb.setBackground(new java.awt.Color(255, 222, 241));
        ThongKeDoanhThu_tb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ThongKeDoanhThu_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ThongKeDoanhThu_tb.setSelectionBackground(new java.awt.Color(255, 222, 241));
        ThongKeDoanhThu_tb.setSelectionForeground(new java.awt.Color(51, 51, 255));
        ThongKeDoanhThu_tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThongKeDoanhThu_tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ThongKeDoanhThu_tb);

        TongDoanhThu_lbl.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        TongDoanhThu_lbl.setText("Tổng doanh thu:");

        TongDoanhThu_tf.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        TongDoanhThu_tf.setFocusable(false);

        ThongKeDoanhThu_lbl.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        ThongKeDoanhThu_lbl.setText("THỐNG KÊ DOANH THU");

        TongDoanhThu_lbl1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        TongDoanhThu_lbl1.setText("Lợi nhuận:");

        LoiNhuan_tf.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        LoiNhuan_tf.setFocusable(false);

        TongDoanhThu_lbl2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        TongDoanhThu_lbl2.setText("Tiền vốn bỏ ra:");

        TienVon_tf.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        TienVon_tf.setFocusable(false);

        ThongKeDoanhThuBD_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ThongKeDoanhThuBD_btn.setText("Thống kê biểu đồ");
        ThongKeDoanhThuBD_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ThongKeDoanhThuBD_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongKeDoanhThuBD_btnActionPerformed(evt);
            }
        });

        QuyThongKe_cbb.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        QuyThongKe_cbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quý 1", "Quý 2", "Quý 3", "Quý 4", "Cả năm" }));

        NamKetThuc_spn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        NamKetThuc_spn.setModel(new javax.swing.SpinnerNumberModel(1900, 1900, 2030, 1));
        NamKetThuc_spn.setOpaque(true);

        SapXepTheo_lbl1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        SapXepTheo_lbl1.setText("Thống kê biểu đồ:");

        javax.swing.GroupLayout ThongKeDoanhThu_pnLayout = new javax.swing.GroupLayout(ThongKeDoanhThu_pn);
        ThongKeDoanhThu_pn.setLayout(ThongKeDoanhThu_pnLayout);
        ThongKeDoanhThu_pnLayout.setHorizontalGroup(
            ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ThongKeDoanhThu_pnLayout.createSequentialGroup()
                .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NgayThangNamKT_lbl)
                            .addComponent(NgayThangNamBD_lbl)
                            .addComponent(KieuSapXep_lbl)
                            .addComponent(SapXepTheo_lbl)
                            .addComponent(SapXepTheo_lbl1))
                        .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SapXepTheo_cbb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LamMoi_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ThongKe_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(KieuSapXep_cbb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ChiTietHoaDon_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                                        .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(NgayBatDau_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                            .addComponent(NgayKetThuc_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ThongKeDoanhThu_pnLayout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(ThangBatDau_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(NamBatDau_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ThangKetThuc_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(NamKetThuc_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE))
                            .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(QuyThongKe_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(NamTKBD_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ThongKeDoanhThuBD_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ThongKeDoanhThu_lbl)
                    .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                            .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TongDoanhThu_lbl)
                                .addComponent(TongDoanhThu_lbl1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TongDoanhThu_lbl2))
                            .addGap(21, 21, 21)
                            .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TienVon_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(LoiNhuan_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(TongDoanhThu_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(39, 39, 39))
        );

        ThongKeDoanhThu_pnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {KieuSapXep_lbl, NgayThangNamBD_lbl, NgayThangNamKT_lbl, SapXepTheo_lbl});

        ThongKeDoanhThu_pnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TongDoanhThu_lbl, TongDoanhThu_lbl1, TongDoanhThu_lbl2});

        ThongKeDoanhThu_pnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {LoiNhuan_tf, TienVon_tf, TongDoanhThu_tf});

        ThongKeDoanhThu_pnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {LamMoi_btn, ThongKeDoanhThuBD_btn});

        ThongKeDoanhThu_pnLayout.setVerticalGroup(
            ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(ThongKeDoanhThu_lbl)
                .addGap(18, 18, 18)
                .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                        .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                                .addComponent(NgayThangNamBD_lbl)
                                .addGap(16, 16, 16)
                                .addComponent(NgayThangNamKT_lbl))
                            .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                                .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NgayBatDau_spn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ThangBatDau_spn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NamBatDau_spn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NgayKetThuc_spn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ThangKetThuc_spn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NamKetThuc_spn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(KieuSapXep_lbl)
                                .addGap(25, 25, 25)
                                .addComponent(SapXepTheo_lbl))
                            .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(KieuSapXep_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SapXepTheo_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addComponent(ThongKe_btn)
                        .addGap(30, 30, 30)
                        .addComponent(ChiTietHoaDon_btn)
                        .addGap(30, 30, 30)
                        .addComponent(LamMoi_btn)
                        .addGap(34, 34, 34)
                        .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SapXepTheo_lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(NamTKBD_spn)
                                .addComponent(QuyThongKe_cbb)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ThongKeDoanhThuBD_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TongDoanhThu_lbl)
                    .addComponent(TongDoanhThu_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TongDoanhThu_lbl2)
                    .addGroup(ThongKeDoanhThu_pnLayout.createSequentialGroup()
                        .addComponent(TienVon_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ThongKeDoanhThu_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LoiNhuan_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TongDoanhThu_lbl1))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        ThongKeDoanhThu_pnLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {KieuSapXep_cbb, KieuSapXep_lbl, NgayThangNamBD_lbl, NgayThangNamKT_lbl, SapXepTheo_lbl});

        ThongKeDoanhThu_pnLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TongDoanhThu_lbl, TongDoanhThu_lbl1, TongDoanhThu_lbl2});

        ThongKeDoanhThu_pnLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {LoiNhuan_tf, TienVon_tf, TongDoanhThu_tf});

        ThongKeDoanhThu_pnLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {NamTKBD_spn, QuyThongKe_cbb});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ThongKeDoanhThu_pn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ThongKeDoanhThu_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ChiTietHoaDon_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChiTietHoaDon_btnActionPerformed
        cthdv = new ChiTietHoaDon_View();
        cthdv.setBangChiTietHoaDon(tkdtctl.getSanPhamTrongHD(cthdmd), tkdtctl, cthdmd);
    }//GEN-LAST:event_ChiTietHoaDon_btnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        QuanLyCuaHangTapHoaAdmin_View qlchthadm = new QuanLyCuaHangTapHoaAdmin_View();
    }//GEN-LAST:event_formWindowClosing

    private void ThongKe_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongKe_btnActionPerformed
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[]{
            "Mã hóa đơn", "Ngày tạo", "Thành tiền"
        });
        ThongKeDoanhThu_tb.setModel(tableModel);

        tkdtmd.setNgayBD(NgayBatDau_spn.getValue().toString());
        tkdtmd.setNgayKT(NgayKetThuc_spn.getValue().toString());
        tkdtmd.setThangBD(ThangBatDau_spn.getValue().toString());
        tkdtmd.setThangKT(ThangKetThuc_spn.getValue().toString());
        tkdtmd.setNamBD(NamBatDau_spn.getValue().toString());
        tkdtmd.setNamKT(NamKetThuc_spn.getValue().toString());
        tkdtmd.setLuachon_KSX(String.valueOf(KieuSapXep_cbb.getSelectedIndex()));
        tkdtmd.setLuachon_SXT(String.valueOf(SapXepTheo_cbb.getSelectedIndex()));

        danhsachHD = tkdtctl.getAllHoaDon(tkdtmd);
        for (HoaDon_Model hoaDon_Model : danhsachHD) {
            tableModel.addRow(new Object[]{
                hoaDon_Model.getMaHD(), hoaDon_Model.getNgayTaoHD(), decimalFormat.format(hoaDon_Model.getTriGiaHD())
            }); // them 1 hang vao cuoi danh sach dung vong for de them het cac phan tu
        }

        setCellsAlignment(ThongKeDoanhThu_tb, SwingConstants.CENTER); // can vi tri du lieu o giua

        TongDoanhThu_tf.setText(String.valueOf(decimalFormat.format(tkdtctl.getTongGiaTri())));
        TienVon_tf.setText(String.valueOf(decimalFormat.format(tkdtctl.getTonggiatrinhap(tkdtmd))));
        LoiNhuan_tf.setText(String.valueOf(decimalFormat.format(Float.parseFloat(TongDoanhThu_tf.getText()) - Float.parseFloat(TienVon_tf.getText()))));
        ThongKe_btn.setEnabled(false);
        ChiTietHoaDon_btn.setEnabled(true);

        if (tableModel.getRowCount() <= 0 || danhsachHD.isEmpty() == true) {
            ThongKe_btn.setEnabled(true);
            ChiTietHoaDon_btn.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Khong co du lieu");
        }
    }//GEN-LAST:event_ThongKe_btnActionPerformed

    private void LamMoi_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoi_btnActionPerformed
        if (tableModel.getRowCount() <= 0 || danhsachHD.isEmpty() == true) {
            Lam_Moi();
        } else {
            int sohang = danhsachHD.size();
            for (int i = 0; i < sohang; i++) {
                tableModel.removeRow(0);
            }
            TongDoanhThu_tf.setText("");
            TienVon_tf.setText("");
            LoiNhuan_tf.setText("");
            tkdtctl.setTongGiaTri(0);
            Lam_Moi();
        }
    }//GEN-LAST:event_LamMoi_btnActionPerformed

    private void ThongKeDoanhThu_tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongKeDoanhThu_tbMouseClicked
        cthdmd = new ChiTietHoaDon_Model();
        int selectrow = ThongKeDoanhThu_tb.getSelectedRow();
        if (ThongKeDoanhThu_tb.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(this, "Hay chon 1 hang de xem chi tiet");

        } else {
            cthdmd.setMaHD((String) tableModel.getValueAt(selectrow, 0));
        }
    }//GEN-LAST:event_ThongKeDoanhThu_tbMouseClicked

    private void ThongKeDoanhThuBD_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongKeDoanhThuBD_btnActionPerformed
        String Quy = String.valueOf(QuyThongKe_cbb.getSelectedItem());
        switch (QuyThongKe_cbb.getSelectedIndex()) {
            case 0 -> {
                tkdtmd_2.setNgayBD("1");
                tkdtmd_2.setNgayKT("31");
                tkdtmd_2.setThangBD("1");
                tkdtmd_2.setThangKT("3");
                tkdtmd_2.setNamBD(NamTKBD_spn.getValue().toString());
                tkdtmd_2.setNamKT(NamTKBD_spn.getValue().toString());
                tkdtmd_2.setLuachon_KSX("0");
                tkdtmd_2.setLuachon_SXT("0");
                break;
            }
            case 1 -> {
                tkdtmd_2.setNgayBD("1");
                tkdtmd_2.setNgayKT("30");
                tkdtmd_2.setThangBD("4");
                tkdtmd_2.setThangKT("6");
                tkdtmd_2.setNamBD(NamTKBD_spn.getValue().toString());
                tkdtmd_2.setNamKT(NamTKBD_spn.getValue().toString());
                tkdtmd_2.setLuachon_KSX("0");
                tkdtmd_2.setLuachon_SXT("0");
                break;
            }
            case 2 -> {
                tkdtmd_2.setNgayBD("1");
                tkdtmd_2.setNgayKT("30");
                tkdtmd_2.setThangBD("7");
                tkdtmd_2.setThangKT("9");
                tkdtmd_2.setNamBD(NamTKBD_spn.getValue().toString());
                tkdtmd_2.setNamKT(NamTKBD_spn.getValue().toString());
                tkdtmd_2.setLuachon_KSX("0");
                tkdtmd_2.setLuachon_SXT("0");
                break;
            }
            case 3 -> {
                tkdtmd_2.setNgayBD("1");
                tkdtmd_2.setNgayKT("31");
                tkdtmd_2.setThangBD("10");
                tkdtmd_2.setThangKT("12");
                tkdtmd_2.setNamBD(NamTKBD_spn.getValue().toString());
                tkdtmd_2.setNamKT(NamTKBD_spn.getValue().toString());
                tkdtmd_2.setLuachon_KSX("0");
                tkdtmd_2.setLuachon_SXT("0");
                break;
            }
            case 4 -> {
                tkdtmd_2.setNgayBD("1");
                tkdtmd_2.setNgayKT("31");
                tkdtmd_2.setThangBD("1");
                tkdtmd_2.setThangKT("12");
                tkdtmd_2.setNamBD(NamTKBD_spn.getValue().toString());
                tkdtmd_2.setNamKT(NamTKBD_spn.getValue().toString());
                tkdtmd_2.setLuachon_KSX("0");
                tkdtmd_2.setLuachon_SXT("0");
                break;
            }
        }

        danhsachHD_2 = tkdtctl.getAllHoaDon(tkdtmd_2);
        if (danhsachHD_2.isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "Khong co du lieu");
        } else {
            float tonggiatrinhapbd = tkdtctl.getTonggiatrinhap(tkdtmd_2);
            double tongdoanhthu = tkdtctl.getTongGiaTri();
            bddt = new BieuDoDoanhThu_View("Thống kê bằng biểu đồ", Float.parseFloat(decimalFormat.format(tongdoanhthu)), Float.parseFloat(decimalFormat.format(tonggiatrinhapbd)), Float.parseFloat(decimalFormat.format((tongdoanhthu - tonggiatrinhapbd))), Quy, NamTKBD_spn.getValue().toString());
            bddt.setSize(800, 800);
            bddt.setLocationRelativeTo(null);
            bddt.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            bddt.setVisible(true);
        }
    }//GEN-LAST:event_ThongKeDoanhThuBD_btnActionPerformed

    public static void setCellsAlignment(JTable table, int alignment) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);
        TableModel tableModel = table.getModel();
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }

    private void Lam_Moi() {
        NgayBatDau_spn.setValue(1);
        NgayKetThuc_spn.setValue(1);
        ThangBatDau_spn.setValue(1);
        ThangKetThuc_spn.setValue(1);
        NamBatDau_spn.setValue(1900);
        NamKetThuc_spn.setValue(1900);
        NamTKBD_spn.setValue(1900);
        KieuSapXep_cbb.setSelectedIndex(0);
        SapXepTheo_cbb.setSelectedIndex(0);
        QuyThongKe_cbb.setSelectedIndex(0);
        ThongKe_btn.setEnabled(true);
        ChiTietHoaDon_btn.setEnabled(false);
    }

    public static void main(String[] args) {
        new ThongKeDoanhThu_View().setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChiTietHoaDon_btn;
    private javax.swing.JComboBox<String> KieuSapXep_cbb;
    private javax.swing.JLabel KieuSapXep_lbl;
    private javax.swing.JButton LamMoi_btn;
    private javax.swing.JTextField LoiNhuan_tf;
    private javax.swing.JSpinner NamBatDau_spn;
    private javax.swing.JSpinner NamKetThuc_spn;
    private javax.swing.JSpinner NamTKBD_spn;
    private javax.swing.JSpinner NgayBatDau_spn;
    private javax.swing.JSpinner NgayKetThuc_spn;
    private javax.swing.JLabel NgayThangNamBD_lbl;
    private javax.swing.JLabel NgayThangNamKT_lbl;
    private javax.swing.JComboBox<String> QuyThongKe_cbb;
    private javax.swing.JComboBox<String> SapXepTheo_cbb;
    private javax.swing.JLabel SapXepTheo_lbl;
    private javax.swing.JLabel SapXepTheo_lbl1;
    private javax.swing.JSpinner ThangBatDau_spn;
    private javax.swing.JSpinner ThangKetThuc_spn;
    private javax.swing.JButton ThongKeDoanhThuBD_btn;
    private javax.swing.JLabel ThongKeDoanhThu_lbl;
    private javax.swing.JPanel ThongKeDoanhThu_pn;
    private javax.swing.JTable ThongKeDoanhThu_tb;
    private javax.swing.JButton ThongKe_btn;
    private javax.swing.JTextField TienVon_tf;
    private javax.swing.JLabel TongDoanhThu_lbl;
    private javax.swing.JLabel TongDoanhThu_lbl1;
    private javax.swing.JLabel TongDoanhThu_lbl2;
    private javax.swing.JTextField TongDoanhThu_tf;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
