
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author admin
 */
public class BieuDoDoanhThu_View extends javax.swing.JFrame {
    
    private static final long serialVersionUID = 1L;

    public BieuDoDoanhThu_View(String appTitle, float tongdoanhthu, float tonggiatrinhap, float loinhuan, String Quy, String NamThongKe) {
        super(appTitle);
        CategoryDataset dataset = createDataset(tongdoanhthu, tonggiatrinhap, loinhuan, NamThongKe, Quy);
        //Create chart  
        JFreeChart chart = ChartFactory.createBarChart(
                "Thống kê doanh thu theo quý", //Chart Title  
                "", // Category axis  
                "Đồng", // Value axis  
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private CategoryDataset createDataset(float tongdoanhthu, float tonggiatrinhap, float loinhuan, String NamThongKe, String Quy) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();     
        
        dataset.addValue(tongdoanhthu, "Tổng doanh thu", "Quý " + Quy + "/" + NamThongKe);
        dataset.addValue(tonggiatrinhap, "Tiền vốn", "Quý " + Quy + "/" + NamThongKe);
        dataset.addValue(loinhuan, "Lợi nhuận", "Quý " + Quy + "/" + NamThongKe);
       
        return dataset;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
