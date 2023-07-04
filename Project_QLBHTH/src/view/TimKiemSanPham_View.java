package view;

import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import model.SanPham_Model;
import dao.TimKiemSanPham_Dao;
import javax.swing.JOptionPane;

public class TimKiemSanPham_View extends javax.swing.JFrame {
    TimKiemSanPham_Dao dao = new TimKiemSanPham_Dao();
    String strFindName = "";
    String strFindType = "";
    
    public TimKiemSanPham_View() {
        initComponents();
        this.setVisible(true);
        fillTable1();
         JTableHeader header = SanPham_tb.getTableHeader();
        Font headerfont = new Font("TimesNewRoman",PLAIN,16);
        header.setFont(headerfont);
        //fillTable2();
    }
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

        tbModel.setColumnIdentifiers(new Object[]{"Mã SP", "Tên SP", "Loại SP", "Giá Bán", "Hạn SD", "Số Lượng Còn"});
        SanPham_tb.setModel(tbModel);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (SanPham_Model sp : dao.searchProductsByType(strFindType)) {
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
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new TaoMauGradient_View(238,171,202,148,187,233);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TimKiemTheoTen_tf = new javax.swing.JTextField();
        Huy_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SanPham_tb = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        TimKiemTheoLoai_tf = new javax.swing.JTextField();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("THÔNG TIN SẢN PHẨM");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel2.setText("Tên sản phẩm:");

        TimKiemTheoTen_tf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TimKiemTheoTen_tfCaretUpdate(evt);
            }
        });
        TimKiemTheoTen_tf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimKiemTheoTen_tfMouseClicked(evt);
            }
        });
        TimKiemTheoTen_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemTheoTen_tfActionPerformed(evt);
            }
        });

        Huy_btn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Huy_btn.setText("Làm mới");
        Huy_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Huy_btnActionPerformed(evt);
            }
        });

        SanPham_tb.setBackground(new java.awt.Color(255, 222, 241));
        SanPham_tb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        SanPham_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Giá niêm yết", "Hạn sử dụng", "Số lượng"
            }
        ));
        SanPham_tb.setSelectionBackground(new java.awt.Color(255, 222, 241));
        jScrollPane1.setViewportView(SanPham_tb);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel3.setText("Loại sản phẩm:");

        TimKiemTheoLoai_tf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TimKiemTheoLoai_tfCaretUpdate(evt);
            }
        });
        TimKiemTheoLoai_tf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimKiemTheoLoai_tfMouseClicked(evt);
            }
        });
        TimKiemTheoLoai_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemTheoLoai_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TimKiemTheoTen_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(TimKiemTheoLoai_tf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(168, Short.MAX_VALUE)
                        .addComponent(Huy_btn)
                        .addGap(163, 163, 163)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TimKiemTheoTen_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TimKiemTheoLoai_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addComponent(Huy_btn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TimKiemTheoTen_tf, jLabel2});

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

    private void TimKiemTheoTen_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemTheoTen_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimKiemTheoTen_tfActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        QuanLyCuaHangTapHoaEmployee_View qlchthemp = new QuanLyCuaHangTapHoaEmployee_View();

    }//GEN-LAST:event_formWindowClosing

    private void TimKiemTheoTen_tfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TimKiemTheoTen_tfCaretUpdate
        strFindName = TimKiemTheoTen_tf.getText();
       
        fillTable1();
        
        //strFindType = TimKiemTheoLoai_tf.getText();
        //fillTable2();
    }//GEN-LAST:event_TimKiemTheoTen_tfCaretUpdate

    private void Huy_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Huy_btnActionPerformed
        TimKiemTheoTen_tf.setText("");
        TimKiemTheoLoai_tf.setText("");
        TimKiemTheoTen_tf.setEnabled(true);
        TimKiemTheoLoai_tf.setEnabled(true);
    }//GEN-LAST:event_Huy_btnActionPerformed

    private void TimKiemTheoLoai_tfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TimKiemTheoLoai_tfCaretUpdate
        strFindType = TimKiemTheoLoai_tf.getText();
        fillTable2();
    }//GEN-LAST:event_TimKiemTheoLoai_tfCaretUpdate

    private void TimKiemTheoLoai_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemTheoLoai_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimKiemTheoLoai_tfActionPerformed

    private void TimKiemTheoTen_tfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimKiemTheoTen_tfMouseClicked
        TimKiemTheoLoai_tf.setEnabled(false);
    }//GEN-LAST:event_TimKiemTheoTen_tfMouseClicked

    private void TimKiemTheoLoai_tfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimKiemTheoLoai_tfMouseClicked
        TimKiemTheoTen_tf.setEnabled(false);
    }//GEN-LAST:event_TimKiemTheoLoai_tfMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Huy_btn;
    private javax.swing.JTable SanPham_tb;
    private javax.swing.JTextField TimKiemTheoLoai_tf;
    private javax.swing.JTextField TimKiemTheoTen_tf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
