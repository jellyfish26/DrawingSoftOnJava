package line;

import listener.MousePaintListener;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class SetColorfulPen extends SetNormalPen {
    private Color beforeColor;
    private Paint beforePaint;
    private ArrayList<Color> movingColor;
    private int draggedCount = 0;

    public SetColorfulPen(MousePaintListener listener, String name, int colorCompletionLevel, Color... colors) {
        super(listener, name, null);
        this.beforeColor = listener.getGraphics().getColor();
        this.movingColor = new ArrayList<>(Arrays.asList(colors));
        colorCompletion(colorCompletionLevel);
    }

    public SetColorfulPen(String name, int colorCompletionLevel, Color... colors) {
        super(name, null);
        this.movingColor = new ArrayList<>(Arrays.asList(colors));
        colorCompletion(colorCompletionLevel);
    }

    private void colorCompletion(int colorCompletionLevel) {
        if (colorCompletionLevel == 0) return;
        ListIterator<Color> movingColorItr = movingColor.listIterator();
        while (movingColorItr.hasNext()) {
            int movingColorIndex = movingColorItr.nextIndex();
            if (!movingColorItr.hasPrevious()) {
                movingColorItr.add(calcMiddleColor(movingColor.get(movingColor.size() - 1), movingColor.get(movingColorIndex)));
            } else {
                movingColorItr.add(calcMiddleColor(movingColor.get(movingColorIndex - 1), movingColor.get(movingColorIndex)));
            }
            movingColorItr.next();
        }
        colorCompletion(colorCompletionLevel - 1);
    }

    public static Color calcMiddleColor(Color first, Color second) {
        int R = (first.getRed() + second.getRed()) / 2;
        int G = (first.getGreen() + second.getGreen()) / 2;
        int B = (first.getBlue() + second.getBlue()) / 2;
        return new Color(R, G, B);
    }

    @Override
    public void setPenBehavior() {
        beforeColor = super.getPaintListener().getGraphics().getColor();
        beforePaint = super.getPaintListener().getCustomGraphics2D().getGraphics2D().getPaint(); // wow
        super.setPenBehavior();
    }

    @Override
    public void removePenBehavior() {
        super.getPaintListener().getGraphics().setColor(beforeColor);
        super.getPaintListener().getCustomGraphics2D().getGraphics2D().setPaint(beforePaint); // wow
        super.removePenBehavior();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        GradientPaint graduation = new GradientPaint(
                mouseEvent.getPoint(),
                movingColor.get(draggedCount % movingColor.size()),
                new Point(super.getBeforeX(), super.getBeforeY()),
                movingColor.get((draggedCount + 1) % movingColor.size())
        );
        draggedCount++;
        super.getPaintListener().getCustomGraphics2D().getGraphics2D().setPaint(graduation);
        super.mouseDragged(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        draggedCount = 0;
        super.mouseReleased(mouseEvent);
    }
}
