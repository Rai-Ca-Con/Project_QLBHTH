
package view;

import view.QuanLyCuaHangTapHoaEmployee_View;
import dao.QuanLyKhachHang_DAO;
import javax.swing.table.DefaultTableModel;
import dao.TimKiemSanPham_Dao;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import model.KhachHang_Model;
import model.SanPham_Model;
import view.QuanLyCuaHangTapHoaAdmin_View;
import view.QuanLyCuaHangTapHoaEmployee_View;
import view.TaoMauGradient_View;
import view.TaoMauGradient_View;

public class QuanLyKhachHang_View extends javax.swing.JFrame {
    QuanLyKhachHang_DAO khDAO = new QuanLyKhachHang_DAO();
    
    
    TimKiemSanPham_Dao dao = new TimKiemSanPham_Dao();
    String strFindName = "";
    String strFindID = "";
    
    public QuanLyKhachHang_View() {
        initComponents();
        GioiTinhNam_jrb.setSelected(true);
        MaKhachHang_tf.setEnabled(false);
        MaKhachHang_tf.setText("KH" + khDAO.getQuantity()  );
        this.setVisible(true);
        fillTable1();
        JTableHeader header = KhachHang_tb.getTableHeader();
        Font headerfont = new Font("TimesNewRoman",PLAIN,16);
        header.setFont(headerfont);
        Sua_btn.setEnabled(false);
        GiaiQuyet_btn.setEnabled(false);
        
    }
    
    
    // Hàm clear text
    public void resetForm(){
        MaKhachHang_tf.setText("");
        TenKhachHang_tf.setText("");
        GioiTinhNam_jrb.setSelected(true);
        DiaChi_tf.setText("");
        SoDienThoai_tf.setText("");
        VanDe_ta.setText("");
        
        
    }
    public void fillTable1() {
        DefaultTableModel tbModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa dữ liệu trong bảng
            }
        };

        tbModel.setColumnIdentifiers(new Object[]{"Mã KH", "Tên KH", "Giới tính", "Địa chỉ", "Số điện thoại", "Vấn đề"});
        KhachHang_tb.setModel(tbModel);

        for (KhachHang_Model kh : khDAO.getAll()) {
            Object dataRow[] = new Object[6];
            dataRow[0] = kh.getMaKH();
            dataRow[1] = kh.getTenKH();
            dataRow[2] = kh.getGioiTinh();
            dataRow[3] = kh.getDiaChi();
            dataRow[4] = kh.getSoDT();
            dataRow[5] = kh.getVanDe();
            tbModel.addRow(dataRow);
        }

        // Định dạng hiển thị giữa cho cột
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Áp dụng định dạng giữa cho từng cột
        for (int i = 0; i < KhachHang_tb.getColumnCount(); i++) {
            KhachHang_tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    // tìm kiếm theo mã khách hàng
    public void fillTable2() {
        DefaultTableModel tbModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa dữ liệu trong bảng
            }
        };

        tbModel.setColumnIdentifiers(new Object[]{"Mã KH", "Tên KH", "Giới tính", "Địa chỉ", "Số điện thoại", "Vấn đề"});
        KhachHang_tb.setModel(tbModel);

        for (KhachHang_Model kh : khDAO.getDatabyID(strFindID)) {
            Object dataRow[] = new Object[6];
            dataRow[0] = kh.getMaKH();
            dataRow[1] = kh.getTenKH();
            dataRow[2] = kh.getGioiTinh();
            dataRow[3] = kh.getDiaChi();
            dataRow[4] = kh.getSoDT();
            dataRow[5] = kh.getVanDe();
            tbModel.addRow(dataRow);
        }

        // Định dạng hiển thị giữa cho cột
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Áp dụng định dạng giữa cho từng cột
        for (int i = 0; i < KhachHang_tb.getColumnCount(); i++) {
            KhachHang_tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    // tìm kiếm theo têm khách hàng
    public void fillTable3() {
        DefaultTableModel tbModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa dữ liệu trong bảng
            }
        };

        tbModel.setColumnIdentifiers(new Object[]{"Mã KH", "Tên KH", "Giới tính", "Địa chỉ", "Số điện thoại", "Vấn đề"});
        KhachHang_tb.setModel(tbModel);

        for (KhachHang_Model kh : khDAO.getDatabyName(strFindName)) {
            Object dataRow[] = new Object[6];
            dataRow[0] = kh.getMaKH();
            dataRow[1] = kh.getTenKH();
            dataRow[2] = kh.getGioiTinh();
            dataRow[3] = kh.getDiaChi();
            dataRow[4] = kh.getSoDT();
            dataRow[5] = kh.getVanDe();
            tbModel.addRow(dataRow);
        }

        // Định dạng hiển thị giữa cho cột
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Áp dụng định dạng giữa cho từng cột
        for (int i = 0; i < KhachHang_tb.getColumnCount(); i++) {
            KhachHang_tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    // Đưa dữ liệu lên bảng
//    public void fillTable1(){
//        DefaultTableModel tbModel = (DefaultTableModel) KhachHang_tb.getModel();
//        tbModel.setRowCount(0);
//        for(KhachHang_Model kh : khDAO.getAll()){
//            Object dataRow[] = new Object[6];
//            dataRow[0] = kh.getMaKH();
//            dataRow[1] = kh.getTenKH();
//            dataRow[2] = kh.getGioiTinh();
//            dataRow[3] = kh.getDiaChi();
//            dataRow[4] = kh.getSoDT();
//            dataRow[5] = kh.getVanDe();
//            tbModel.addRow(dataRow);
//            
//            
//        }
//    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new TaoMauGradient_View(238,171,202,148,187,233);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TenKhachHang_tf = new javax.swing.JTextField();
        Them_btn = new javax.swing.JButton();
        Sua_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        KhachHang_tb = new javax.swing.JTable();
        Huy_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        MaKhachHang_tf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DiaChi_tf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        SoDienThoai_tf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        VanDe_ta = new javax.swing.JTextArea();
        GioiTinhNam_jrb = new javax.swing.JRadioButton();
        GioiTinhNu_jrb = new javax.swing.JRadioButton();
        GiaiQuyet_btn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        TenKhachHangS_tf1 = new javax.swing.JTextField();
        MaKhachHangS_tf1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        LamMoi_btn = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel2.setText("Tên khách hàng");

        TenKhachHang_tf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TenKhachHang_tfCaretUpdate(evt);
            }
        });
        TenKhachHang_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenKhachHang_tfActionPerformed(evt);
            }
        });

        Them_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Them_btn.setText("Thêm");
        Them_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Them_btnActionPerformed(evt);
            }
        });

        Sua_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Sua_btn.setText("Sửa");
        Sua_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sua_btnActionPerformed(evt);
            }
        });

        KhachHang_tb.setBackground(new java.awt.Color(255, 222, 241));
        KhachHang_tb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        KhachHang_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Giới tính", "Địa chỉ", "Số điện thoại", "Vấn đề"
            }
        ));
        KhachHang_tb.setSelectionBackground(new java.awt.Color(255, 222, 241));
        KhachHang_tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KhachHang_tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(KhachHang_tb);

        Huy_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Huy_btn.setText("Huỷ");
        Huy_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Huy_btnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel3.setText("Mã khách hàng");

        MaKhachHang_tf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                MaKhachHang_tfCaretUpdate(evt);
            }
        });
        MaKhachHang_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaKhachHang_tfActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel4.setText("Giới tính");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel5.setText("Địa chỉ");

        DiaChi_tf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                DiaChi_tfCaretUpdate(evt);
            }
        });
        DiaChi_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiaChi_tfActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel6.setText("Số điện thoại");

        SoDienThoai_tf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                SoDienThoai_tfCaretUpdate(evt);
            }
        });
        SoDienThoai_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoDienThoai_tfActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel7.setText("Vấn đề");

        VanDe_ta.setColumns(20);
        VanDe_ta.setRows(5);
        jScrollPane2.setViewportView(VanDe_ta);

        buttonGroup1.add(GioiTinhNam_jrb);
        GioiTinhNam_jrb.setText("Nam");
        GioiTinhNam_jrb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GioiTinhNam_jrbActionPerformed(evt);
            }
        });

        buttonGroup1.add(GioiTinhNu_jrb);
        GioiTinhNu_jrb.setText("Nữ");

        GiaiQuyet_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        GiaiQuyet_btn.setText("Đã giải quyết");
        GiaiQuyet_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GiaiQuyet_btnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel8.setText("Tìm Kiếm");

        TenKhachHangS_tf1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TenKhachHangS_tf1CaretUpdate(evt);
            }
        });
        TenKhachHangS_tf1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TenKhachHangS_tf1MouseClicked(evt);
            }
        });
        TenKhachHangS_tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenKhachHangS_tf1ActionPerformed(evt);
            }
        });

        MaKhachHangS_tf1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                MaKhachHangS_tf1CaretUpdate(evt);
            }
        });
        MaKhachHangS_tf1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MaKhachHangS_tf1MouseClicked(evt);
            }
        });
        MaKhachHangS_tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaKhachHangS_tf1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel10.setText("Tên khách hàng");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel9.setText("Mã khách hàng");

        LamMoi_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        LamMoi_btn.setText("Làm mới");
        LamMoi_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoi_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(350, 350, 350))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(LamMoi_btn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DiaChi_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TenKhachHang_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SoDienThoai_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(GioiTinhNam_jrb)
                                .addGap(34, 34, 34)
                                .addComponent(GioiTinhNu_jrb))
                            .addComponent(MaKhachHang_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TenKhachHangS_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MaKhachHangS_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Them_btn)
                        .addGap(18, 18, 18)
                        .addComponent(Sua_btn)
                        .addGap(18, 18, 18)
                        .addComponent(GiaiQuyet_btn)
                        .addGap(18, 18, 18)
                        .addComponent(Huy_btn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(MaKhachHang_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TenKhachHang_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(GioiTinhNam_jrb)
                                    .addComponent(GioiTinhNu_jrb))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DiaChi_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SoDienThoai_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Them_btn)
                            .addComponent(Sua_btn)
                            .addComponent(Huy_btn)
                            .addComponent(GiaiQuyet_btn))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(MaKhachHangS_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TenKhachHangS_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(LamMoi_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TenKhachHang_tf, jLabel2});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {GiaiQuyet_btn, Huy_btn, Sua_btn, Them_btn});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TenKhachHang_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenKhachHang_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TenKhachHang_tfActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        QuanLyCuaHangTapHoaEmployee_View qlchthemp = new QuanLyCuaHangTapHoaEmployee_View();

    }//GEN-LAST:event_formWindowClosing

    private void Huy_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Huy_btnActionPerformed
        
        resetForm();
        MaKhachHang_tf.setText("KH" + khDAO.getQuantity()  );
        Them_btn.setEnabled(true);
        Sua_btn.setEnabled(false);
        GiaiQuyet_btn.setEnabled(false);
        //System.exit(0);
    }//GEN-LAST:event_Huy_btnActionPerformed
    // Lấy dữ liệu từ các ô text nhập vào
    public KhachHang_Model getModel(){
        KhachHang_Model kh = new KhachHang_Model();
        kh.setMaKH(MaKhachHang_tf.getText());
        kh.setTenKH(TenKhachHang_tf.getText());
        kh.setGioiTinh("Nam");
        if(GioiTinhNu_jrb.isSelected()){
            kh.setGioiTinh("Nu");
        }
        kh.setDiaChi(DiaChi_tf.getText());
        kh.setSoDT(SoDienThoai_tf.getText());
        kh.setVanDe(VanDe_ta.getText());
        return kh;
    }
    private void Them_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Them_btnActionPerformed
         KhachHang_Model kh = getModel();
         MaKhachHang_tf.setText("KH" + khDAO.getQuantity()  );
         String SDT = SoDienThoai_tf.getText();
         String MaKH = MaKhachHang_tf.getText();
         String TenKH = TenKhachHang_tf.getText();
         String DiaChi = DiaChi_tf.getText();
         String VanDe = VanDe_ta.getText();
         if(kh.getMaKH().isEmpty()||kh.getTenKH().isEmpty()){
             JOptionPane.showMessageDialog(this, "Thiếu thông tin quan trọng");
            }
         else if (!TenKH.matches("[a-zA-Z\\s\\p{L}\\p{M}]+")){
            fillTable1();
            JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
            }
         else if (!kh.getSoDT().isEmpty()&& (!SDT.matches("0\\d{9}"))){ 
            fillTable1();
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
            }   
         else if (!kh.getDiaChi().isEmpty()&&!DiaChi.matches("[a-zA-Z\\s\\p{L}\\p{M}]+")){
            fillTable1();
            JOptionPane.showMessageDialog(this, "Địa chỉ không hợp lệ");
            }
         else if(!kh.getVanDe().isEmpty()&&(!VanDe.matches("[a-zA-Z\\s\\p{L}\\p{M}]+"))){
            fillTable1();
            JOptionPane.showMessageDialog(this, "Vấn đề phải dưới dạng chữ");
            }
         else if (khDAO.add(kh)==1){
             khDAO.add(kh);
            fillTable1();
            JOptionPane.showMessageDialog(this, "Them thanh cong!" );
            }
    }//GEN-LAST:event_Them_btnActionPerformed

    private void TenKhachHang_tfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TenKhachHang_tfCaretUpdate
        
    }//GEN-LAST:event_TenKhachHang_tfCaretUpdate

    private void Sua_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sua_btnActionPerformed
        
        KhachHang_Model kh = getModel();
         String SDT = SoDienThoai_tf.getText();
         String MaKH = MaKhachHang_tf.getText();
         String TenKH = TenKhachHang_tf.getText();
         String DiaChi = DiaChi_tf.getText();
         String VanDe = VanDe_ta.getText();
        if(kh.getMaKH().isEmpty()||kh.getTenKH().isEmpty()){
             JOptionPane.showMessageDialog(this, "Thiếu thông tin quan trọng");
        }
        else if (!TenKH.matches("[a-zA-Z\\s\\p{L}\\p{M}]+")){
            fillTable1();
            JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
        }
        else if (!kh.getSoDT().isEmpty()&& (!SDT.matches("0\\d{9}"))){ 
            fillTable1();
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
        }   
        else if (!kh.getDiaChi().isEmpty()&&!DiaChi.matches("[a-zA-Z\\s\\p{L}\\p{M}]+")){
            fillTable1();
            JOptionPane.showMessageDialog(this, "Địa chỉ không hợp lệ");
         }
        else if(!kh.getVanDe().isEmpty()&&(!VanDe.matches("[a-zA-Z\\s\\p{L}\\p{M}]+"))){
            fillTable1();
            JOptionPane.showMessageDialog(this, "Vấn đề phải dưới dạng chữ");
        }
        else if(khDAO.update(kh)==1){
             khDAO.update(kh);
            fillTable1();
            JOptionPane.showMessageDialog(this, "Sửa thành công" );
        }
        
    }//GEN-LAST:event_Sua_btnActionPerformed

    private void MaKhachHang_tfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_MaKhachHang_tfCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_MaKhachHang_tfCaretUpdate

    private void MaKhachHang_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaKhachHang_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaKhachHang_tfActionPerformed

    private void DiaChi_tfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_DiaChi_tfCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_DiaChi_tfCaretUpdate

    private void DiaChi_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiaChi_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiaChi_tfActionPerformed

    private void SoDienThoai_tfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_SoDienThoai_tfCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_SoDienThoai_tfCaretUpdate

    private void SoDienThoai_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoDienThoai_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SoDienThoai_tfActionPerformed

    private void GioiTinhNam_jrbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GioiTinhNam_jrbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GioiTinhNam_jrbActionPerformed

    private void GiaiQuyet_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GiaiQuyet_btnActionPerformed
        
        KhachHang_Model kh = getModel();
        if(kh.getMaKH().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ban chua nhap ma khach hang" );
        }else{
            
            khDAO.delete(kh);
            
            fillTable1();
            JOptionPane.showMessageDialog(this, "Thanh cong!" );
        }
        
    }//GEN-LAST:event_GiaiQuyet_btnActionPerformed

    private void MaKhachHangS_tf1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_MaKhachHangS_tf1CaretUpdate
        strFindID = MaKhachHangS_tf1.getText();
        fillTable2();
    }//GEN-LAST:event_MaKhachHangS_tf1CaretUpdate

    private void MaKhachHangS_tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaKhachHangS_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaKhachHangS_tf1ActionPerformed

    private void TenKhachHangS_tf1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TenKhachHangS_tf1CaretUpdate
        strFindName = TenKhachHangS_tf1.getText();
        fillTable3();
    }//GEN-LAST:event_TenKhachHangS_tf1CaretUpdate

    private void TenKhachHangS_tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenKhachHangS_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TenKhachHangS_tf1ActionPerformed

    private void MaKhachHangS_tf1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaKhachHangS_tf1MouseClicked
        TenKhachHangS_tf1.setEnabled(false);
        MaKhachHangS_tf1.setEnabled(true);
    }//GEN-LAST:event_MaKhachHangS_tf1MouseClicked

    private void TenKhachHangS_tf1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TenKhachHangS_tf1MouseClicked
        MaKhachHangS_tf1.setEnabled(false); 
        TenKhachHangS_tf1.setEnabled(true);
    }//GEN-LAST:event_TenKhachHangS_tf1MouseClicked

    private void LamMoi_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoi_btnActionPerformed
        TenKhachHangS_tf1.setEnabled(true);
        MaKhachHangS_tf1.setEnabled(true); 
        TenKhachHangS_tf1.setText("");
        MaKhachHangS_tf1.setText("");
    }//GEN-LAST:event_LamMoi_btnActionPerformed

    private void KhachHang_tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhachHang_tbMouseClicked
        Sua_btn.setEnabled(true);
        GiaiQuyet_btn.setEnabled(true);
        Them_btn.setEnabled(false);
        int selectedRow = KhachHang_tb.getSelectedRow();
         if (selectedRow != -1) {
             //Lấy giá trị từ dòng được chọn
             String MaKH = KhachHang_tb.getValueAt(selectedRow, 0).toString();
             String TenKH = KhachHang_tb.getValueAt(selectedRow, 1).toString();
             String GT = KhachHang_tb.getValueAt(selectedRow, 2).toString();
             String DiaChi = KhachHang_tb.getValueAt(selectedRow, 3).toString();
             String SDT = KhachHang_tb.getValueAt(selectedRow, 4).toString();
             String VanDe = KhachHang_tb.getValueAt(selectedRow, 5).toString();
             if(GT.matches("Nam")){
                 GioiTinhNam_jrb.setSelected(true);
             }
             else{
                  GioiTinhNu_jrb.setSelected(true);
             }
             //Đưa giá trị vào các ô văn bản
             MaKhachHang_tf.setText(MaKH);
             TenKhachHang_tf.setText(TenKH);
             DiaChi_tf.setText(DiaChi);
             SoDienThoai_tf.setText(SDT);
             VanDe_ta.setText(VanDe);
         }
    }//GEN-LAST:event_KhachHang_tbMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DiaChi_tf;
    private javax.swing.JButton GiaiQuyet_btn;
    private javax.swing.JRadioButton GioiTinhNam_jrb;
    private javax.swing.JRadioButton GioiTinhNu_jrb;
    private javax.swing.JButton Huy_btn;
    private javax.swing.JTable KhachHang_tb;
    private javax.swing.JButton LamMoi_btn;
    private javax.swing.JTextField MaKhachHangS_tf1;
    private javax.swing.JTextField MaKhachHang_tf;
    private javax.swing.JTextField SoDienThoai_tf;
    private javax.swing.JButton Sua_btn;
    private javax.swing.JTextField TenKhachHangS_tf1;
    private javax.swing.JTextField TenKhachHang_tf;
    private javax.swing.JButton Them_btn;
    private javax.swing.JTextArea VanDe_ta;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
}
