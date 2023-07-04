/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.text.DecimalFormat;import java.util.ArrayList;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author admin
 */
public class BieuDoSanPham_View extends javax.swing.JFrame {

    public BieuDoSanPham_View(String appTitle,ArrayList<String> arrStr,ArrayList<Integer> arrInt) {
        super(appTitle);
        // Create dataset  
        PieDataset dataset = createDataset(arrStr,arrInt);

        // Create chart  
        JFreeChart chart = ChartFactory.createPieChart(
                "Thống kê sản phẩm bán ra theo quý",
                dataset,
                true,
                true,
                false);

        //Format Label  
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);

        // Create Panel  
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private PieDataset createDataset(ArrayList<String> arrStr,ArrayList<Integer> arrInt) {
  
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(int i=0;i<arrStr.size();i++){
             dataset.setValue(arrStr.get(i), arrInt.get(i));
        }

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
