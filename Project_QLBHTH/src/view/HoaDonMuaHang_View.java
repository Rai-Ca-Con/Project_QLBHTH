package view;

import view.QuanLyCuaHangTapHoaEmployee_View;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import dao.JDBCConnection;
import dao.XuatSanPham_Dao;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.HoaDon_Model;
import model.HoaDon_SanPham_Model;
import model.SanPham_Model;
import view.QuanLyCuaHangTapHoaEmployee_View;
import view.QuanLyCuaHangTapHoaEmployee_View;
import view.TaoMauGradient_View;
import view.TaoMauGradient_View;




public class HoaDonMuaHang_View extends javax.swing.JFrame  {
    
    XuatSanPham_Dao dao = new XuatSanPham_Dao();
    String strMaHD = "";
    String strFindName = "";
  
    public HoaDonMuaHang_View() {
        initComponents();
        this.setVisible(true);
        MaHoaDon_tf.setText("HD" + dao.getQuantity());
        ThemVao_btn.setEnabled(false);
        ThanhToan_btn.setEnabled(false);
        MaHoaDon_tf.setEnabled(false);
        MaSanPham_tf.setEnabled(false);
        TraLai_btn.setEnabled(false);
        LamMoi_btn.setEnabled(false);
        fillTable1();
    }
    // bảng sản phẩm
    public void fillTable1() {
        DefaultTableModel tbModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa dữ liệu trong bảng
            }
        };

        tbModel.setColumnIdentifiers(new Object[]{"Mã SP", "Tên SP", "Loại SP", "Giá Bán", "Hạn SD", "Số Lượng Còn"});
        SanPham_tb.setModel(tbModel);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (SanPham_Model sp : dao.searchProductsByName(strFindName)) {
            Object dataRow[] = new Object[6];
            dataRow[0] = sp.getMaSP();
            dataRow[1] = sp.getTenSP();
            dataRow[2] = sp.getLoaiSP();
            dataRow[3] = sp.getGiaBan();
            dataRow[4] = sp.getHanSD();
            dataRow[5] = sp.getSoLuongcon();
            tbModel.addRow(dataRow);
        }

        // Áp dụng định dạng giữa cho từng cột
        for (int i = 0; i < SanPham_tb.getColumnCount(); i++) {
            SanPham_tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    // bảng hoá đơn
    public void fillTable2(){
            DefaultTableModel tbModel;
            setCellsAlignment(HoaDon_tb, SwingConstants.CENTER);

            tbModel = (DefaultTableModel) HoaDon_tb.getModel();

            tbModel.setRowCount(0);
            HoaDon_SanPham_Model[] hdsp = new HoaDon_SanPham_Model[dao.getAll1(strMaHD).size()];    
            for(int i = 0; i < hdsp.length; i++){
                Object dataRow[] = new Object[5];
                hdsp[i] = dao.getAll1(strMaHD).get(i);  
                
                dataRow[2] = hdsp[i].getSoLuongban();
                dataRow[4] = dao.tinhTien(hdsp[i]);
                SanPham_Model sp = dao.getAll(hdsp[i].getMaSP()).get(0);
                dataRow[0] = hdsp[i].getMaSP();
                dataRow[1] = sp.getTenSP();          
                dataRow[3] = sp.getGiaBan();           
                tbModel.addRow(dataRow);    
            }

    }
    // bảng rỗng
    public void fillTable3(){
        DefaultTableModel tbModel;
        tbModel = (DefaultTableModel) HoaDon_tb.getModel();
        
        tbModel.setRowCount(0);
        
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new TaoMauGradient_View(238,171,202,148,187,233);
        MaSanPham_tf = new javax.swing.JTextField();
        ThemVao_btn = new javax.swing.JButton();
        MaKH_lbl1 = new javax.swing.JLabel();
        MaKH_lbl = new javax.swing.JLabel();
        MaNhanVien_tf = new javax.swing.JTextField();
        SoLuong_lbl = new javax.swing.JLabel();
        ThanhToan_btn = new javax.swing.JButton();
        TongTien_lbl = new javax.swing.JLabel();
        Ngay_jsp = new javax.swing.JSpinner();
        TongTien_tf = new javax.swing.JTextField();
        Thang_jsp = new javax.swing.JSpinner();
        HoaDonMuaHang_lbl = new javax.swing.JLabel();
        Nam_jsp = new javax.swing.JSpinner();
        MaHD_lbl = new javax.swing.JLabel();
        SoLuong_jsp = new javax.swing.JSpinner();
        MaHoaDon_tf = new javax.swing.JTextField();
        NgayIn_lbl = new javax.swing.JLabel();
        LamMoi_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        HoaDon_tb = new javax.swing.JTable();
        TaoMoi_btn = new javax.swing.JButton();
        MaSP_lbl = new javax.swing.JLabel();
        MaKhachHang_tf = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        SanPham_tb = new javax.swing.JTable();
        MaSP_lbl1 = new javax.swing.JLabel();
        TenSanPham_tf = new javax.swing.JTextField();
        TraLai_btn = new javax.swing.JButton();

        setTitle("Hóa đơn mua hàng");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        MaSanPham_tf.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        ThemVao_btn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ThemVao_btn.setText("Thêm vào");
        ThemVao_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemVao_btnActionPerformed(evt);
            }
        });
        ThemVao_btn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ThemVao_btnKeyReleased(evt);
            }
        });

        MaKH_lbl1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MaKH_lbl1.setText("Mã NV");

        MaKH_lbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MaKH_lbl.setText("Mã KH");

        MaNhanVien_tf.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MaNhanVien_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaNhanVien_tfActionPerformed(evt);
            }
        });

        SoLuong_lbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        SoLuong_lbl.setText("Số lượng ");

        ThanhToan_btn.setText("Thanh toán");
        ThanhToan_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThanhToan_btnMouseClicked(evt);
            }
        });
        ThanhToan_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThanhToan_btnActionPerformed(evt);
            }
        });

        TongTien_lbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TongTien_lbl.setText("Tổng tiền ");

        Ngay_jsp.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        TongTien_tf.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TongTien_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TongTien_tfActionPerformed(evt);
            }
        });

        Thang_jsp.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        HoaDonMuaHang_lbl.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        HoaDonMuaHang_lbl.setText("    HÓA ĐƠN MUA HÀNG");

        Nam_jsp.setModel(new javax.swing.SpinnerNumberModel(2015, 2015, 2050, 1));

        MaHD_lbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MaHD_lbl.setText("Mã Hóa Đơn ");

        SoLuong_jsp.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000, 1));

        MaHoaDon_tf.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MaHoaDon_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaHoaDon_tfActionPerformed(evt);
            }
        });

        NgayIn_lbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        NgayIn_lbl.setText("Ngày in HĐ ");

        LamMoi_btn.setText("Làm mới");
        LamMoi_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LamMoi_btnMouseClicked(evt);
            }
        });
        LamMoi_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoi_btnActionPerformed(evt);
            }
        });

        HoaDon_tb.setAutoCreateRowSorter(true);
        HoaDon_tb.setBackground(new java.awt.Color(255, 222, 241));
        HoaDon_tb.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        HoaDon_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        HoaDon_tb.setSelectionBackground(new java.awt.Color(255, 222, 241));
        HoaDon_tb.setSelectionForeground(new java.awt.Color(51, 51, 255));
        HoaDon_tb.setShowGrid(true);
        HoaDon_tb.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                HoaDon_tbAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        HoaDon_tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HoaDon_tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(HoaDon_tb);

        TaoMoi_btn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TaoMoi_btn.setText("Tạo mới");
        TaoMoi_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaoMoi_btnActionPerformed(evt);
            }
        });

        MaSP_lbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MaSP_lbl.setText("Mã sản phẩm");

        MaKhachHang_tf.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MaKhachHang_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaKhachHang_tfActionPerformed(evt);
            }
        });

        SanPham_tb.setAutoCreateRowSorter(true);
        SanPham_tb.setBackground(new java.awt.Color(255, 222, 241));
        SanPham_tb.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        SanPham_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Đơn giá", "Số lượng còn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SanPham_tb.setSelectionBackground(new java.awt.Color(255, 222, 241));
        SanPham_tb.setSelectionForeground(new java.awt.Color(51, 51, 255));
        SanPham_tb.setShowGrid(true);
        SanPham_tb.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                SanPham_tbAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        SanPham_tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SanPham_tbMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(SanPham_tb);

        MaSP_lbl1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MaSP_lbl1.setText("Tìm tên sản phẩm");

        TenSanPham_tf.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TenSanPham_tf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TenSanPham_tfCaretUpdate(evt);
            }
        });

        TraLai_btn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TraLai_btn.setText("Trả lại");
        TraLai_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TraLai_btnMouseClicked(evt);
            }
        });
        TraLai_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TraLai_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TongTien_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TongTien_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(ThanhToan_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LamMoi_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ThemVao_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MaKH_lbl)
                            .addComponent(MaKH_lbl1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MaNhanVien_tf)
                            .addComponent(MaKhachHang_tf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(TraLai_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TaoMoi_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NgayIn_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(MaSP_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MaHD_lbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SoLuong_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SoLuong_jsp)
                            .addComponent(MaSanPham_tf)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Ngay_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Thang_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Nam_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(MaHoaDon_tf))))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HoaDonMuaHang_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(681, 681, 681)
                .addComponent(MaSP_lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TenSanPham_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HoaDonMuaHang_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TenSanPham_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaSP_lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NgayIn_lbl)
                            .addComponent(Ngay_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Thang_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nam_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MaHD_lbl)
                            .addComponent(MaHoaDon_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MaSP_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MaSanPham_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SoLuong_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SoLuong_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ThemVao_btn)
                            .addComponent(TaoMoi_btn)
                            .addComponent(TraLai_btn))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MaKH_lbl)
                            .addComponent(MaKhachHang_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MaKH_lbl1)
                            .addComponent(MaNhanVien_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ThanhToan_btn)
                            .addComponent(LamMoi_btn))
                        .addGap(162, 162, 162))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TongTien_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TongTien_lbl))
                        .addGap(57, 57, 57))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ThemVao_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemVao_btnActionPerformed
    
        Date nsx = dao.getNgaySanXuatFromDatabase(MaSanPham_tf.getText());
        Date hsd = dao.gethsdFromDatabase(MaSanPham_tf.getText());       
        int ngay = (int) Ngay_jsp.getValue();
        int thang = (int) Thang_jsp.getValue();
        int nam = (int) Nam_jsp.getValue();
        String niHD = String.format("%d-%02d-%02d", nam, thang, ngay);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayinHD = null;
        try {
            ngayinHD = dateFormat.parse(niHD);
    
        } catch (ParseException e) {
                e.printStackTrace();
        }
        HoaDon_SanPham_Model hdsp = getModel();
        strMaHD = MaHoaDon_tf.getText();
        if(MaHoaDon_tf.getText().isEmpty() || MaSanPham_tf.getText().isEmpty()){           
            JOptionPane.showMessageDialog(this, "Nhập đầy đủ thông tin!" );
        }else if(dao.check3(MaHoaDon_tf.getText())== 1){
            JOptionPane.showMessageDialog(this, "Hoá đơn đã được thanh toán!" );
        }else if(ngayinHD.before(nsx)){
            JOptionPane.showMessageDialog(this, "Ngày tạo hoá đơn phải sau ngày sản xuất của sản phẩm!");
        }else if(ngayinHD.after(hsd)){
            JOptionPane.showMessageDialog(this, "Ngày tạo hoá đơn phải trước hạn sử dụng của sản phẩm!");
        }else if(dao.add(hdsp) == 0){
            JOptionPane.showMessageDialog(this, "Đã có sản phẩm này trong hoá đơn!" );
        }else{
            Ngay_jsp.setEnabled(false);
            Thang_jsp.setEnabled(false);
            Nam_jsp.setEnabled(false);
            ThemVao_btn.setEnabled(false);
            dao.add(hdsp);
            ThanhToan_btn.setEnabled(true);
            fillTable2();
            fillTable1();
        }
        

        
        
        
    }//GEN-LAST:event_ThemVao_btnActionPerformed

    private void ThemVao_btnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ThemVao_btnKeyReleased
        // TODO add your handling code here:
        displaydetails(((JTable)evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_ThemVao_btnKeyReleased

    private void MaNhanVien_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaNhanVien_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaNhanVien_tfActionPerformed

    private void ThanhToan_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThanhToan_btnActionPerformed
        ThemVao_btn.setEnabled(false);
        TaoMoi_btn.setEnabled(false);
        strMaHD = MaHoaDon_tf.getText();
        
        HoaDon_Model hd = getModel1();
        String MaKH =MaKhachHang_tf.getText();
        String MaNV = MaNhanVien_tf.getText();
        
        if(MaKH.isEmpty() && MaNV.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nhập đầy đủ thông tin hoá đơn!" );
        }else if(dao.check1(MaKhachHang_tf.getText())==0){
            JOptionPane.showMessageDialog(this, "Chưa có thông tin khách hàng!" );
        }else if(dao.check2(MaNhanVien_tf.getText() ) == 0){
            JOptionPane.showMessageDialog(this, "Chưa có thông tin nhân viên!" );
        }else{
            TongTien_tf.setText("" + dao.get(strMaHD));
            dao.insert(hd);
            JOptionPane.showMessageDialog(this, "Thanh toán thành công!" );
            ThanhToan_btn.setEnabled(false);
            LamMoi_btn.setEnabled(true);
        }
        
    }//GEN-LAST:event_ThanhToan_btnActionPerformed

    private void TongTien_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TongTien_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TongTien_tfActionPerformed

    private void MaHoaDon_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaHoaDon_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaHoaDon_tfActionPerformed

    private void LamMoi_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoi_btnActionPerformed
        MaHoaDon_tf.setText("HD" + dao.getQuantity());
        MaSanPham_tf.setText("");
        TenSanPham_tf.setText("");
        SoLuong_jsp.setValue(1);
        Ngay_jsp.setValue(1);
        Thang_jsp.setValue(1);
        Nam_jsp.setValue(2015);
        Ngay_jsp.setEnabled(true);
        Thang_jsp.setEnabled(true);
        Nam_jsp.setEnabled(true);
        MaKhachHang_tf.setText("");
        MaNhanVien_tf.setText("");
        TongTien_tf.setText("");
        TaoMoi_btn.setEnabled(true);
        ThemVao_btn.setEnabled(false);
        ThanhToan_btn.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel) HoaDon_tb.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng trong model
        

    }//GEN-LAST:event_LamMoi_btnActionPerformed

    private void HoaDon_tbAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_HoaDon_tbAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_HoaDon_tbAncestorAdded

    private void HoaDon_tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoaDon_tbMouseClicked
        int selectedRow = HoaDon_tb.getSelectedRow();
            if (selectedRow != -1){
                ThemVao_btn.setEnabled(false);
                TraLai_btn.setEnabled(true);
                String maSP = HoaDon_tb.getValueAt(selectedRow, 0).toString();                          
                MaSanPham_tf.setText(maSP);              
            }
        displaydetails(((JTable)evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_HoaDon_tbMouseClicked

    private void TaoMoi_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaoMoi_btnActionPerformed
        ThemVao_btn.setEnabled(false);
        ThanhToan_btn.setEnabled(false);
        strMaHD = MaHoaDon_tf.getText();
        dao.getAllbyID(strMaHD);
        dao.deletebyID(strMaHD);
        MaHoaDon_tf.setText("HD" + dao.getQuantity());
        MaSanPham_tf.setText("");
        TenSanPham_tf.setText("");
        SoLuong_jsp.setValue(1);
        fillTable3();
        fillTable1();
    }//GEN-LAST:event_TaoMoi_btnActionPerformed

    private void MaKhachHang_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaKhachHang_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaKhachHang_tfActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
                  QuanLyCuaHangTapHoaEmployee_View qlchthemp = new QuanLyCuaHangTapHoaEmployee_View();
    }//GEN-LAST:event_formWindowClosing

    private void SanPham_tbAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_SanPham_tbAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_SanPham_tbAncestorAdded

    private void SanPham_tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SanPham_tbMouseClicked
        
        int selectedRow = SanPham_tb.getSelectedRow();
            if (selectedRow != -1){
                ThemVao_btn.setEnabled(true);
                TraLai_btn.setEnabled(false);
                String maSP = SanPham_tb.getValueAt(selectedRow, 0).toString();                          
                MaSanPham_tf.setText(maSP);              
            }
    }//GEN-LAST:event_SanPham_tbMouseClicked

    private void TenSanPham_tfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TenSanPham_tfCaretUpdate
        strFindName = TenSanPham_tf.getText();
        fillTable1();
        
    }//GEN-LAST:event_TenSanPham_tfCaretUpdate

    private void TraLai_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TraLai_btnActionPerformed
       
        dao.delete(MaHoaDon_tf.getText(), MaSanPham_tf.getText());
              
        fillTable1();
        fillTable2();
    }//GEN-LAST:event_TraLai_btnActionPerformed

    private void TraLai_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TraLai_btnMouseClicked
        TraLai_btn.setEnabled(false);
    }//GEN-LAST:event_TraLai_btnMouseClicked

    private void ThanhToan_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThanhToan_btnMouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_ThanhToan_btnMouseClicked

    private void LamMoi_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LamMoi_btnMouseClicked
        // TODO add your handling code here:
          LamMoi_btn.setEnabled(false);
    }//GEN-LAST:event_LamMoi_btnMouseClicked
                // Viết hàm getModel để lấy dữ liệu ( phục vụ cho bảng hoá đơn xuất )
    
    private HoaDon_SanPham_Model getModel(){
        HoaDon_SanPham_Model hdx = new HoaDon_SanPham_Model();
        hdx.setMaHD(MaHoaDon_tf.getText());
        hdx.setMaSP(MaSanPham_tf.getText());
        int soluong = (int) SoLuong_jsp.getValue();
        hdx.setSoLuongban(soluong);
        
        
        return hdx;
    }            
    public HoaDon_Model getModel1(){
        
        HoaDon_Model hdx = new HoaDon_Model();
        hdx.setMaHD(MaHoaDon_tf.getText());
        int ngay = (int) Ngay_jsp.getValue();
        int thang = (int) Thang_jsp.getValue();
        int nam = (int) Nam_jsp.getValue();
        
        hdx.setNgayTaoHD(nam+ "-" + thang + "-" + ngay);
        hdx.setTriGiaHD(dao.get(MaHoaDon_tf.getText()));
        hdx.setMaKH(MaKhachHang_tf.getText());
        hdx.setMaNV(MaNhanVien_tf.getText());
        return hdx;
    }    
    private void displaydetails(int selectedRows){
    
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
    private javax.swing.JLabel HoaDonMuaHang_lbl;
    private javax.swing.JTable HoaDon_tb;
    private javax.swing.JButton LamMoi_btn;
    private javax.swing.JLabel MaHD_lbl;
    private javax.swing.JTextField MaHoaDon_tf;
    private javax.swing.JLabel MaKH_lbl;
    private javax.swing.JLabel MaKH_lbl1;
    private javax.swing.JTextField MaKhachHang_tf;
    private javax.swing.JTextField MaNhanVien_tf;
    private javax.swing.JLabel MaSP_lbl;
    private javax.swing.JLabel MaSP_lbl1;
    private javax.swing.JTextField MaSanPham_tf;
    private javax.swing.JSpinner Nam_jsp;
    private javax.swing.JLabel NgayIn_lbl;
    private javax.swing.JSpinner Ngay_jsp;
    private javax.swing.JTable SanPham_tb;
    private javax.swing.JSpinner SoLuong_jsp;
    private javax.swing.JLabel SoLuong_lbl;
    private javax.swing.JButton TaoMoi_btn;
    private javax.swing.JTextField TenSanPham_tf;
    private javax.swing.JSpinner Thang_jsp;
    private javax.swing.JButton ThanhToan_btn;
    private javax.swing.JButton ThemVao_btn;
    private javax.swing.JLabel TongTien_lbl;
    private javax.swing.JTextField TongTien_tf;
    private javax.swing.JButton TraLai_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables


    }




   
