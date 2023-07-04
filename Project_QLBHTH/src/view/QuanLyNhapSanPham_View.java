package view;

import dao.JDBCConnection;
import view.QuanLyCuaHangTapHoaEmployee_View;
import dao.NhapSanPham_Dao;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import model.HoaDonNhap_Model;
import model.SanPham_Model;
import view.QuanLyCuaHangTapHoaAdmin_View;
import view.QuanLyCuaHangTapHoaEmployee_View;
import view.TaoMauGradient_View;
import view.TaoMauGradient_View;
import view.QuanLyMatHang_View;

public class QuanLyNhapSanPham_View extends javax.swing.JFrame {
    
    NhapSanPham_Dao dao = new NhapSanPham_Dao();
    String ngayNhap = "";
    String maSP = "";
    String strFindName = "";
    
    
     
     
    

      
    public QuanLyNhapSanPham_View() {
       
        initComponents();
        this.setVisible(true);
        fillTable1();
        fillTable2();
        Them_btn.setEnabled(false);
        Sua_btn.setEnabled(false);
        Xoa_btn.setEnabled(false);
        MaSanPham_tf.setEnabled(false);
        setCellsAlignment(NhapSanPham_tb, SwingConstants.CENTER);
        JTableHeader header = NhapSanPham_tb.getTableHeader();
        Font headerfont = new Font("TimesNewRoman", PLAIN, 16);
        header.setFont(headerfont);
       

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

    public void fillTable2() {
        DefaultTableModel tbModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa dữ liệu trong bảng
            }
        };

        tbModel.setColumnIdentifiers(new Object[]{"Ngày Nhập", "Số Lượng Nhập", "Mã SP"});
        NhapSanPham_tb.setModel(tbModel);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (HoaDonNhap_Model sp : dao.getAll()) {
            Object dataRow[] = new Object[3];
            dataRow[0] = sp.getNgayNhap();
            dataRow[1] = sp.getSoLuongnhap();
            dataRow[2] = sp.getMaSP();
            tbModel.addRow(dataRow);
        }

        // Áp dụng định dạng giữa cho từng cột
        for (int i = 0; i < NhapSanPham_tb.getColumnCount(); i++) {
            NhapSanPham_tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    // tìm kiếm theo ngày
    public void fillTable3() {
        DefaultTableModel tbModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa dữ liệu trong bảng
            }
        };

        tbModel.setColumnIdentifiers(new Object[]{"Ngày Nhập", "Số Lượng Nhập", "Mã SP"});
        NhapSanPham_tb.setModel(tbModel);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (HoaDonNhap_Model sp : dao.getDataByNgayNhap(ngayNhap)) {
            Object dataRow[] = new Object[3];
            dataRow[0] = sp.getNgayNhap();
            dataRow[1] = sp.getSoLuongnhap();
            dataRow[2] = sp.getMaSP();
            tbModel.addRow(dataRow);
        }

        // Áp dụng định dạng giữa cho từng cột
        for (int i = 0; i < NhapSanPham_tb.getColumnCount(); i++) {
            NhapSanPham_tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    // Tìm kiếm theo mã sản phẩm
    public void fillTable4() {
        DefaultTableModel tbModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa dữ liệu trong bảng
            }
        };

        tbModel.setColumnIdentifiers(new Object[]{"Ngày Nhập", "Số Lượng Nhập", "Mã SP"});
        NhapSanPham_tb.setModel(tbModel);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (HoaDonNhap_Model sp : dao.getDataByID(maSP)) {
            Object dataRow[] = new Object[3];
            dataRow[0] = sp.getNgayNhap();
            dataRow[1] = sp.getSoLuongnhap();
            dataRow[2] = sp.getMaSP();
            tbModel.addRow(dataRow);
        }

        // Áp dụng định dạng giữa cho từng cột
        for (int i = 0; i < NhapSanPham_tb.getColumnCount(); i++) {
            NhapSanPham_tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
//    public void fillTable2(){
//        tbModel = (DefaultTableModel) NhapSanPham_tb.getModel();
//        
//        tbModel.setRowCount(0);
//        for(HoaDonNhap_Model sp : dao.getAll()){
//            Object dataRow[] = new Object[3];
//            dataRow[0] = sp.getNgayNhap();
//            dataRow[1] = sp.getSoLuongnhap();
//            dataRow[2] = sp.getMaSP();
//            
//            tbModel.addRow(dataRow);
//            
//            
//        }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new TaoMauGradient_View(238,171,202,148,187,233);
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Sua_btn = new javax.swing.JButton();
        Them_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        MaSanPham_tf = new javax.swing.JTextField();
        Xoa_btn = new javax.swing.JButton();
        Ngay_jsp = new javax.swing.JSpinner();
        Thang_jsp = new javax.swing.JSpinner();
        Nam_jsp = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        MaSanPhamS_tf = new javax.swing.JTextField();
        LamMoi_btn = new javax.swing.JButton();
        NgayS_jsp1 = new javax.swing.JSpinner();
        ThangS_jsp1 = new javax.swing.JSpinner();
        NamS_jsp1 = new javax.swing.JSpinner();
        TimKiem_btn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NhapSanPham_tb = new javax.swing.JTable();
        SoLuongNhap_jsp = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        SanPham_tb = new javax.swing.JTable();
        TenSanPham_tf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHẬP SẢN PHẨM");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel3.setText("Ngày nhập");

        Sua_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Sua_btn.setText("Sửa");
        Sua_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sua_btnMouseClicked(evt);
            }
        });
        Sua_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sua_btnActionPerformed(evt);
            }
        });

        Them_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Them_btn.setText("Thêm");
        Them_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Them_btnMouseClicked(evt);
            }
        });
        Them_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Them_btnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel4.setText("Số lượng nhập");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel5.setText("Mã sản phẩm");

        MaSanPham_tf.setToolTipText("");
        MaSanPham_tf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                MaSanPham_tfCaretUpdate(evt);
            }
        });
        MaSanPham_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaSanPham_tfActionPerformed(evt);
            }
        });

        Xoa_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Xoa_btn.setText("Xoá");
        Xoa_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Xoa_btnActionPerformed(evt);
            }
        });

        Ngay_jsp.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Ngay_jsp.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        Thang_jsp.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Thang_jsp.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        Nam_jsp.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Nam_jsp.setModel(new javax.swing.SpinnerNumberModel(2015, 2015, 2050, 1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel2.setText("Tìm kiếm hoá đơn");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel6.setText("Ngày nhập");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel7.setText("Mã sản phẩm");

        MaSanPhamS_tf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                MaSanPhamS_tfCaretUpdate(evt);
            }
        });
        MaSanPhamS_tf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MaSanPhamS_tfMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MaSanPhamS_tfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MaSanPhamS_tfMouseExited(evt);
            }
        });
        MaSanPhamS_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaSanPhamS_tfActionPerformed(evt);
            }
        });

        LamMoi_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        LamMoi_btn.setText("Làm mới");
        LamMoi_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoi_btnActionPerformed(evt);
            }
        });

        NgayS_jsp1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        NgayS_jsp1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        NgayS_jsp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NgayS_jsp1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NgayS_jsp1FocusLost(evt);
            }
        });
        NgayS_jsp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NgayS_jsp1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NgayS_jsp1MouseEntered(evt);
            }
        });

        ThangS_jsp1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ThangS_jsp1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        ThangS_jsp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ThangS_jsp1FocusGained(evt);
            }
        });
        ThangS_jsp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThangS_jsp1MouseClicked(evt);
            }
        });

        NamS_jsp1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        NamS_jsp1.setModel(new javax.swing.SpinnerNumberModel(2015, 2015, 2050, 1));
        NamS_jsp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NamS_jsp1FocusGained(evt);
            }
        });
        NamS_jsp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NamS_jsp1MouseClicked(evt);
            }
        });

        TimKiem_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        TimKiem_btn.setText("Tìm kiếm");
        TimKiem_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiem_btnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel8.setText("Nhập sản phẩm");

        NhapSanPham_tb.setBackground(new java.awt.Color(255, 222, 241));
        NhapSanPham_tb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        NhapSanPham_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ngày nhập", "Số lượng nhập", "Mã sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        NhapSanPham_tb.setSelectionBackground(new java.awt.Color(255, 222, 241));
        NhapSanPham_tb.setSelectionForeground(new java.awt.Color(51, 51, 255));
        NhapSanPham_tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NhapSanPham_tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(NhapSanPham_tb);

        SoLuongNhap_jsp.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        SoLuongNhap_jsp.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000, 1));

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
        SanPham_tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SanPham_tbMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(SanPham_tb);

        TenSanPham_tf.setToolTipText("");
        TenSanPham_tf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TenSanPham_tfCaretUpdate(evt);
            }
        });
        TenSanPham_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenSanPham_tfActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel9.setText("Tìm tên sản phẩm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(TimKiem_btn)
                                        .addGap(18, 18, 18)
                                        .addComponent(LamMoi_btn))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(MaSanPhamS_tf)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(NgayS_jsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ThangS_jsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(NamS_jsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(jLabel2)
                                        .addGap(77, 77, 77)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(Ngay_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(Thang_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(Nam_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(MaSanPham_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SoLuongNhap_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Them_btn)
                        .addGap(18, 18, 18)
                        .addComponent(Sua_btn)
                        .addGap(18, 18, 18)
                        .addComponent(Xoa_btn)
                        .addGap(39, 39, 39)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(TenSanPham_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(375, 375, 375))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TenSanPham_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Ngay_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(Nam_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Thang_jsp, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
                                        .addGap(63, 63, 63)
                                        .addComponent(MaSanPham_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(SoLuongNhap_jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Them_btn)
                                    .addComponent(Sua_btn)
                                    .addComponent(Xoa_btn)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(NgayS_jsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ThangS_jsp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NamS_jsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(MaSanPhamS_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LamMoi_btn)
                                    .addComponent(TimKiem_btn))
                                .addGap(64, 64, 64)))
                        .addContainerGap(32, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Nam_jsp, Thang_jsp});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {NamS_jsp1, NgayS_jsp1, ThangS_jsp1});

        Ngay_jsp.getAccessibleContext().setAccessibleDescription("");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        QuanLyCuaHangTapHoaEmployee_View qlchthemp = new QuanLyCuaHangTapHoaEmployee_View();
    }//GEN-LAST:event_formWindowClosing
    // Lấy dữ liệu từ _tf
    public HoaDonNhap_Model getModel() {
        HoaDonNhap_Model hdn = new HoaDonNhap_Model();
     
        int ngay = (int) Ngay_jsp.getValue();
        int thang = (int) Thang_jsp.getValue();
        int nam = (int) Nam_jsp.getValue();
         hdn.setNgayNhap(nam + "-" + thang + "-" + ngay);
         
                  int soLuongnhap = (int) SoLuongNhap_jsp.getValue();
        hdn.setSoLuongnhap(soLuongnhap);
        hdn.setMaSP(MaSanPham_tf.getText());
         
       
        return hdn;
    }
    private void Them_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Them_btnActionPerformed
        HoaDonNhap_Model hdn = getModel();
        int ngay = (int) Ngay_jsp.getValue();
        int thang = (int) Thang_jsp.getValue();
        int nam = (int) Nam_jsp.getValue();
        String nn = String.format("%d-%02d-%02d", nam, thang, ngay);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayNhap = null;

        try {
            ngayNhap = dateFormat.parse(nn);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date nsx = dao.getNgaySanXuatFromDatabase(MaSanPham_tf.getText());
        Date hsd = dao.gethsdFromDatabase(MaSanPham_tf.getText());


        if (MaSanPham_tf.getText().isEmpty()) {
            fillTable2();
            JOptionPane.showMessageDialog(this, "Chưa nhập mã sản phẩm!");
        }else if(ngayNhap.before(nsx)){
            JOptionPane.showMessageDialog(this, "Ngày nhập phải sau ngày sản xuất");
        }else if(ngayNhap.after(hsd)){
            JOptionPane.showMessageDialog(this, "Ngày nhập phải trước hạn sử dụng");
        }else if (dao.add(hdn) == 1) {
            Them_btn.setEnabled(false);
            fillTable1();
            fillTable2();
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            
        } else {
            fillTable2();
            JOptionPane.showMessageDialog(this, "Đã nhập sản phẩm này trong ngày!");
        }


    }//GEN-LAST:event_Them_btnActionPerformed

    private void Sua_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sua_btnActionPerformed
        Sua_btn.setEnabled(false);
        Xoa_btn.setEnabled(false);
        HoaDonNhap_Model hdn = getModel();    
        dao.update(hdn);
        fillTable1();
        fillTable2();
        JOptionPane.showMessageDialog(this, "Sua thanh cong!");
        
        


    }//GEN-LAST:event_Sua_btnActionPerformed

    private void MaSanPham_tfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_MaSanPham_tfCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_MaSanPham_tfCaretUpdate

    private void MaSanPham_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaSanPham_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaSanPham_tfActionPerformed

    
    private void Xoa_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Xoa_btnActionPerformed
        Sua_btn.setEnabled(false);
        Xoa_btn.setEnabled(false);
        HoaDonNhap_Model hdn = new HoaDonNhap_Model();
        hdn.setMaSP(getModel().getMaSP());     
        hdn.setNgayNhap(getModel().getNgayNhap());      
        dao.delete(hdn);
        fillTable1();
        fillTable2();
    }//GEN-LAST:event_Xoa_btnActionPerformed

    private void MaSanPhamS_tfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_MaSanPhamS_tfCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_MaSanPhamS_tfCaretUpdate

    private void MaSanPhamS_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaSanPhamS_tfActionPerformed

    }//GEN-LAST:event_MaSanPhamS_tfActionPerformed

    private void MaSanPhamS_tfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaSanPhamS_tfMouseEntered

    }//GEN-LAST:event_MaSanPhamS_tfMouseEntered

    private void MaSanPhamS_tfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaSanPhamS_tfMouseExited

    }//GEN-LAST:event_MaSanPhamS_tfMouseExited

    private void MaSanPhamS_tfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaSanPhamS_tfMouseClicked
        
        NgayS_jsp1.setEnabled(false);
        ThangS_jsp1.setEnabled(false);
        NamS_jsp1.setEnabled(false);

    }//GEN-LAST:event_MaSanPhamS_tfMouseClicked

    private void LamMoi_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoi_btnActionPerformed
        fillTable2();
        MaSanPhamS_tf.setEnabled(true);
        NgayS_jsp1.setEnabled(true);
        ThangS_jsp1.setEnabled(true);
        NamS_jsp1.setEnabled(true);

        MaSanPhamS_tf.setText("");
        NgayS_jsp1.setValue(1);
        ThangS_jsp1.setValue(1);
        NamS_jsp1.setValue(2015);


    }//GEN-LAST:event_LamMoi_btnActionPerformed
 
    private void NgayS_jsp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NgayS_jsp1MouseClicked
        
        
        MaSanPhamS_tf.setEnabled(false);
    }//GEN-LAST:event_NgayS_jsp1MouseClicked
    
    private void ThangS_jsp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThangS_jsp1MouseClicked
        
        MaSanPhamS_tf.setEnabled(false);
    }//GEN-LAST:event_ThangS_jsp1MouseClicked

    private void NamS_jsp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NamS_jsp1MouseClicked
       
        MaSanPhamS_tf.setEnabled(false);
    }//GEN-LAST:event_NamS_jsp1MouseClicked

    private void NgayS_jsp1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NgayS_jsp1FocusGained

    }//GEN-LAST:event_NgayS_jsp1FocusGained

    private void ThangS_jsp1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ThangS_jsp1FocusGained

    }//GEN-LAST:event_ThangS_jsp1FocusGained

    private void NamS_jsp1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NamS_jsp1FocusGained

    }//GEN-LAST:event_NamS_jsp1FocusGained

    private void NgayS_jsp1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NgayS_jsp1FocusLost


    }//GEN-LAST:event_NgayS_jsp1FocusLost
    // lấy dữ liệu từ spinner ( dành cho tìm kiếm )
    public HoaDonNhap_Model getModel1() {
        HoaDonNhap_Model hdn = new HoaDonNhap_Model();
        int ngay = (int) NgayS_jsp1.getValue();
        int thang = (int) ThangS_jsp1.getValue();
        int nam = (int) NamS_jsp1.getValue();
        hdn.setNgayNhap(nam + "-" + thang + "-" + ngay);
        hdn.setMaSP(MaSanPhamS_tf.getText());
        return hdn;
    }
    private void TimKiem_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiem_btnActionPerformed
        ngayNhap = getModel1().getNgayNhap();
        maSP = getModel1().getMaSP();
        if (maSP.isEmpty()) {
            fillTable3();
        }
        else if(!maSP.matches("TPH\\d{1,3}"))  {
        JOptionPane.showMessageDialog(this, "Nhap sai dinh dang ma san pham!");
        }else {
            fillTable4();
        }

    }//GEN-LAST:event_TimKiem_btnActionPerformed

    private void NhapSanPham_tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhapSanPham_tbMouseClicked
        // TODO add your handling code here:
            int selectedRow = NhapSanPham_tb.getSelectedRow();
            if (selectedRow != -1){
                Sua_btn.setEnabled(true);
                Xoa_btn.setEnabled(true);
                Them_btn.setEnabled(false);
                Nam_jsp.setEnabled(false);
                Thang_jsp.setEnabled(false);
                Ngay_jsp.setEnabled(false);
                String ngaynhap = NhapSanPham_tb.getValueAt(selectedRow, 0).toString();
                int SoLuongNhap = (int)NhapSanPham_tb.getValueAt(selectedRow, 1);
                String MaSP = NhapSanPham_tb.getValueAt(selectedRow, 2).toString();

                String[] parts = ngaynhap.split("-");
                if (parts.length == 3) {
                    int nam = Integer.parseInt(parts[0]);
                    int thang = Integer.parseInt(parts[1]);
                    int ngay = Integer.parseInt(parts[2]);
                    Nam_jsp.setValue(nam);
                    Thang_jsp.setValue(thang);
                    Ngay_jsp.setValue(ngay);
                }
                SoLuongNhap_jsp.setValue(SoLuongNhap);
                MaSanPham_tf.setText(MaSP);
            }
    }//GEN-LAST:event_NhapSanPham_tbMouseClicked

    private void TenSanPham_tfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TenSanPham_tfCaretUpdate
        strFindName = TenSanPham_tf.getText();
        fillTable1();
    }//GEN-LAST:event_TenSanPham_tfCaretUpdate

    private void TenSanPham_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenSanPham_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TenSanPham_tfActionPerformed

    private void SanPham_tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SanPham_tbMouseClicked
        int selectedRow = SanPham_tb.getSelectedRow();
            if (selectedRow != -1){
                Nam_jsp.setEnabled(true);
                Thang_jsp.setEnabled(true);
                Ngay_jsp.setEnabled(true);
                Them_btn.setEnabled(true);
                Sua_btn.setEnabled(false);
                Xoa_btn.setEnabled(false);
                String maSP = SanPham_tb.getValueAt(selectedRow, 0).toString();                          
                MaSanPham_tf.setText(maSP);              
            }
    }//GEN-LAST:event_SanPham_tbMouseClicked

    private void Them_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Them_btnMouseClicked
        
    }//GEN-LAST:event_Them_btnMouseClicked

    private void Sua_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sua_btnMouseClicked
        
    }//GEN-LAST:event_Sua_btnMouseClicked

    private void NgayS_jsp1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NgayS_jsp1MouseEntered
        
    }//GEN-LAST:event_NgayS_jsp1MouseEntered
    public static void setCellsAlignment(JTable table, int alignment) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LamMoi_btn;
    private javax.swing.JTextField MaSanPhamS_tf;
    private javax.swing.JTextField MaSanPham_tf;
    private javax.swing.JSpinner NamS_jsp1;
    private javax.swing.JSpinner Nam_jsp;
    private javax.swing.JSpinner NgayS_jsp1;
    private javax.swing.JSpinner Ngay_jsp;
    private javax.swing.JTable NhapSanPham_tb;
    private javax.swing.JTable SanPham_tb;
    private javax.swing.JSpinner SoLuongNhap_jsp;
    private javax.swing.JButton Sua_btn;
    private javax.swing.JTextField TenSanPham_tf;
    private javax.swing.JSpinner ThangS_jsp1;
    private javax.swing.JSpinner Thang_jsp;
    private javax.swing.JButton Them_btn;
    private javax.swing.JButton TimKiem_btn;
    private javax.swing.JButton Xoa_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private Date layngaynhap(Date nsx,SanPham_Model sp) {
        {
            Connection conn = JDBCConnection.getJDBCConnection();
            
         try{
            String sql = "SELECT NgaySX FROM sanpham WHERE MaSP = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, sp.getMaSP()); 
            
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            nsx = resultSet.getDate("NgaySX");
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNhapSanPham_View.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nsx;
         
    }
    }
}
