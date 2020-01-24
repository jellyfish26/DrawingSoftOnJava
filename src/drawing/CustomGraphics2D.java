package drawing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class CustomGraphics2D {
    private BufferedImage bufferedImage;
    private int imageWidth, imageHeight;
    private Graphics2D graphics; // SunGraphics2D is finally class
    private int beforeX = -1, beforeY = -1;

    CustomGraphics2D(int width, int height) {
        this.bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.imageWidth = width;
        this.imageHeight = height;
        this.graphics = bufferedImage.createGraphics();
        this.graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        this.newGraphics(Color.WHITE);
    }

    private void updateBuffer() {
        graphics.drawImage(bufferedImage, 0, 0, null);
    }

    public void updateBuffer(Graphics graphics, ImageObserver observer) {
        graphics.drawImage(bufferedImage, 0, 0, observer);
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

    public boolean saveImage(File file) {
        try {
            int index = file.getName().lastIndexOf(".");
            if (index == -1) {
                return ImageIO.write(bufferedImage, "png", new File(file.getPath() + ".png"));
            }
            String extension = file.getName().substring(index);
            if (extension.equals(".png") || extension.equals(".jpg")) {
                return ImageIO.write(bufferedImage, extension.substring(1), file);
            } else {
                return false;
            }
        } catch (IOException | NullPointerException e) {
            return false;
        }
    }

    public boolean roadImage(File file) {
        try {
            if (file == null) return false;
            BufferedImage originalImage = ImageIO.read(file);
            newGraphics(Color.WHITE);
            bufferedImage.createGraphics().drawImage(originalImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_AREA_AVERAGING),
                    0, 0, imageWidth, imageHeight, null);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void newGraphics(Color background) {
        Color beforeColor = graphics.getColor();
        graphics.setColor(background);
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        graphics.setColor(beforeColor);
        updateBuffer();
    }
}
