package drawing;

import listener.MousePaintListener;
import listener.SetMousePaintListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingJPanel extends JPanel {
    private CustomGraphics2D customGraphics;

    public DrawingJPanel(int width, int height) {
        super();
        setSize(width, height);
        this.customGraphics = new CustomGraphics2D(width, height);
        this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(customGraphics.getCustomImage(), 0, 0, this);
        repaint();
    }

    public void addMousePaintListener(MousePaintListener listener) {
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    public CustomGraphics2D getCustomGraphics() {
        return customGraphics;
    }
}
