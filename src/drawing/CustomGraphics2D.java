package drawing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CustomGraphics2D {
    private BufferedImage bufferedImage;
    private Graphics2D graphics; // SunGraphics2D is finally class
    private int beforeX = -1, beforeY = -1;

    CustomGraphics2D(int width, int height) {
        this.bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.graphics = bufferedImage.createGraphics();
        this.graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        this.graphics.setColor(Color.WHITE);
        this.graphics.fillRect(0, 0, width, height);
        this.graphics.setColor(Color.BLACK);
    }

    public synchronized void drawShape(ArrayList<Integer> x, ArrayList<Integer> y) {
        if (x.size() != y.size()) {
            System.err.println("x and y array lengths do not match");
            return;
        }
        try {
            for (int i = 0; i < x.size(); i++) this.graphics.drawLine(x.get(i), y.get(i), x.get((i + 1) % x.size()), y.get((i + 1) % x.size()));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public synchronized void drawSmoothLine(int x, int y) {
        if (beforeX != -1) this.graphics.drawLine(this.beforeX, this.beforeY, x, y);
        this.beforeX = x; this.beforeY = y;
    }

    public void resetSmoothLineCoordinate() {
        this.beforeX = -1; this.beforeY = -1;
    }

    public Graphics getGraphics() {
        return this.graphics;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void changeLineThickness(int level) {
        this.graphics.setStroke(new BasicStroke(level));
    }
}
