import java.awt.*;
import java.util.ArrayList;

public class CustomGraphics2D {
    Graphics2D graphics;
    CustomGraphics2D(Graphics2D graphics) {
        this.graphics = graphics;
        this.graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
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

    public Graphics getGraphics() {
        return this.graphics;
    }
}
