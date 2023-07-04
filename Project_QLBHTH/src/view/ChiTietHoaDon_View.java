package view;

import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.ChiTietHoaDon_Model;
import controller.ThongKeDoanhThu_Controller;

public class ChiTietHoaDon_View extends javax.swing.JFrame {

    DefaultTableModel tableModel; // Tạo 1 TableModel để hứng dữ liệu từ database rồi đổ lên JTable

    public ChiTietHoaDon_View() {
        initComponents();
        this.setVisible(true);
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép sửa hàng/cột
            }
        };
    }

    // Tạo hàm để đổ dữ liệu từ TableModel vào JTable
    public void setBangChiTietHoaDon(List<ChiTietHoaDon_Model> danhsachsanpham, ThongKeDoanhThu_Controller tkdtctl, ChiTietHoaDon_Model cthdmd) {
        tableModel.setRowCount(0); //Khởi tạo dòng gán dữ liệu bắt đầu từ 0 
        tableModel.setColumnIdentifiers(new Object[]{
            "Mã sản phẩm", "Tên sản phẩm", "Số Lượng Bán"
        });// Khởi tạo tên các cột của bảng
        ChiTietHoaDon_tb.setModel(tableModel); // Đổ dữ liệu từ TableModel lên JTable
        danhsachsanpham = tkdtctl.getSanPhamTrongHD(cthdmd); // Lấy ra danh sách các sản phẩm trong hóa đơn được chọn
        for (ChiTietHoaDon_Model hoaDon_Model : danhsachsanpham) {
            tableModel.addRow(new Object[]{
                hoaDon_Model.getMaSP(), hoaDon_Model.getTenSP(), hoaDon_Model.getSoLuongSP()
            }); // Thêm thông tin chi tiết của các sản phẩm vào bảng 
        }
        setCellsAlignment(ChiTietHoaDon_tb, SwingConstants.CENTER); // Căn vị trí dự liệu trên bảng ra giữa
    }

    public static void setCellsAlignment(JTable table, int alignment) {// Hàm căn vị trí dự liệu trên bảng ra giữa
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);
        TableModel tableModel = table.getModel();
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new TaoMauGradient_View(238,171,202,148,187,233);
        jScrollPane1 = new javax.swing.JScrollPane();
        ChiTietHoaDon_tb = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ChiTietHoaDon_tb.setBackground(new java.awt.Color(103, 191, 127));
        ChiTietHoaDon_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(ChiTietHoaDon_tb);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ChiTietHoaDon_tb;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
