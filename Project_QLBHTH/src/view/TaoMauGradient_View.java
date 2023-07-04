package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class TaoMauGradient_View extends JPanel {

    public int r1, r2, g1, g2, b1, b2;

    public TaoMauGradient_View(int r1, int g1, int b1, int r2, int g2, int b2) {
        this.r1 = r1;
        this.r2 = r2;
        this.g1 = g1;
        this.g2 = g2;
        this.b1 = b1;
        this.b2 = b2;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        Color color1 = new Color(r1, g1, b1);
        Color color2 = new Color(r2, g2, b2);

        GradientPaint gp = new GradientPaint(0, 0, color1, 180, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
