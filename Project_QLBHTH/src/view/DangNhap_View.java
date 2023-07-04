package view;

import javax.swing.JOptionPane;

import controller.DangNhap_Controller;

public class DangNhap_View extends javax.swing.JFrame {

    int check = 0;

    public DangNhap_View() {
        initComponents();
        this.setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new TaoMauGradient_View(9,151,115,67,182,146);
        DangNhapHeThong_lbl = new javax.swing.JLabel();
        MatKhau_lbl = new javax.swing.JLabel();
        DangNhap_btn = new javax.swing.JButton();
        LamMoi_btn = new javax.swing.JButton();
        TaiKhoan_lbl = new javax.swing.JLabel();
        TaiKhoan_tf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MatKhau_pf = new javax.swing.JPasswordField();
        HienPass_lbl = new javax.swing.JLabel();
        HienMatKhau_tf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        DangNhapHeThong_lbl.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        DangNhapHeThong_lbl.setText("Đăng nhập vào hệ thống");

        MatKhau_lbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MatKhau_lbl.setText("Mật khẩu :");

        DangNhap_btn.setBackground(new java.awt.Color(245, 240, 187));
        DangNhap_btn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        DangNhap_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DangNhap_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DangNhap_btn.setLabel("Đăng nhập");
        DangNhap_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangNhap_btnActionPerformed(evt);
            }
        });

        LamMoi_btn.setBackground(new java.awt.Color(229, 249, 216));
        LamMoi_btn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        LamMoi_btn.setText("Làm mới");
        LamMoi_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LamMoi_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LamMoi_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoi_btnActionPerformed(evt);
            }
        });

        TaiKhoan_lbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TaiKhoan_lbl.setText("Tài khoản:");

        TaiKhoan_tf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/Grocery_Image.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/User_Icon.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/Key_Icon.png"))); // NOI18N

        MatKhau_pf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        HienPass_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/Eye_Icon.png"))); // NOI18N
        HienPass_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HienPass_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HienPass_lblMouseClicked(evt);
            }
        });

        HienMatKhau_tf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MatKhau_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TaiKhoan_lbl))
                        .addGap(318, 318, 318))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DangNhap_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(LamMoi_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TaiKhoan_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(DangNhapHeThong_lbl)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(HienMatKhau_tf)
                                            .addComponent(MatKhau_pf, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HienPass_lbl)))
                        .addGap(98, 98, 98))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(DangNhapHeThong_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(TaiKhoan_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TaiKhoan_tf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(MatKhau_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HienPass_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MatKhau_pf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HienMatKhau_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LamMoi_btn)
                    .addComponent(DangNhap_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DangNhap_btn, LamMoi_btn});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TaiKhoan_tf, jLabel2, jLabel3});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DangNhap_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangNhap_btnActionPerformed
        // TODO add your handling code here:
        //Khởi tạo đối tượng thuộc lớp DangNhap_Controller
        DangNhap_Controller dn = new DangNhap_Controller();
        // Khởi tạo 1 biến cờ để kiểm tra thông tin đăng nhập
        boolean kiemtra = dn.DangNhap(TaiKhoan_tf.getText(), String.valueOf(MatKhau_pf.getPassword()));
        if (kiemtra == true && "admin".equals(TaiKhoan_tf.getText()) && "1234".equals(String.valueOf(MatKhau_pf.getPassword()))) {
            // nếu đúng sẽ hiện thông báo thành công và chuyển sang tab chính và ẩn trang đăng nhập
            QuanLyCuaHangTapHoaAdmin_View qlchth = new QuanLyCuaHangTapHoaAdmin_View();
            this.setVisible(false);
        } else {
            // nếu sai sẽ hiện thông báo đăng nhập thất bại
            if (kiemtra == true && "employee".equals(TaiKhoan_tf.getText()) && "5678".equals(String.valueOf(MatKhau_pf.getPassword()))) {
                // nếu đúng sẽ hiện thông báo thành công và chuyển sang tab chính và ẩn trang đăng nhập
                QuanLyCuaHangTapHoaEmployee_View qlchth = new QuanLyCuaHangTapHoaEmployee_View();
                this.setVisible(false);
            } else {
                // nếu sai sẽ hiện thông báo đăng nhập thất bại
                JOptionPane.showMessageDialog(this, "Đăng nhập thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_DangNhap_btnActionPerformed

    private void LamMoi_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoi_btnActionPerformed
        // TODO add your handling code here:
        // Thiết lập giá trị rỗng 
        TaiKhoan_tf.setText("");
        MatKhau_pf.setText("");
        HienMatKhau_tf.setVisible(false);
    }//GEN-LAST:event_LamMoi_btnActionPerformed

    private void HienPass_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HienPass_lblMouseClicked
        // TODO add your handling code here:
        if ("".equals(String.valueOf(MatKhau_pf.getPassword()))) {
            HienMatKhau_tf.setVisible(false);
            check = 1;
        } else if (String.valueOf(MatKhau_pf.getPassword()) != "") {
            switch (check) {
                case 0:
                    HienMatKhau_tf.setVisible(false);
                    check = 1;
                    break;
                case 1:
                    HienMatKhau_tf.setVisible(true);
                    HienMatKhau_tf.setText(String.valueOf(MatKhau_pf.getPassword()));
                    check = 0;
                    break;
            }
        }
    }//GEN-LAST:event_HienPass_lblMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        HienMatKhau_tf.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DangNhapHeThong_lbl;
    private javax.swing.JButton DangNhap_btn;
    private javax.swing.JTextField HienMatKhau_tf;
    private javax.swing.JLabel HienPass_lbl;
    private javax.swing.JButton LamMoi_btn;
    private javax.swing.JLabel MatKhau_lbl;
    private javax.swing.JPasswordField MatKhau_pf;
    private javax.swing.JLabel TaiKhoan_lbl;
    private javax.swing.JTextField TaiKhoan_tf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
