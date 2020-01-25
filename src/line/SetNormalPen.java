package line;

import listener.MousePaintListener;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SetNormalPen extends BasePenBehavior {
    private Color setDefaultColor; // nullable
    private int beforeX = -1, beforeY = -1;

    public SetNormalPen(MousePaintListener listener, String name, Color color) {
        super(listener, name);
        this.setDefaultColor = color;
    }

    public SetNormalPen(String name, Color color) {
        super(name);
        this.setDefaultColor = color;
    }

    @Override
    public void setPenBehavior() {
        super.setPenBehavior();
        if (setDefaultColor != null) getMousePaintListener().getGraphics().setColor(setDefaultColor);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        beforeX = -1;
        beforeY = -1;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (beforeX != -1) getMousePaintListener().getGraphics().drawLine(beforeX, beforeY, mouseEvent.getX(), mouseEvent.getY());
        beforeX = mouseEvent.getX();
        beforeY = mouseEvent.getY();
    }

    int getBeforeX() {
        return beforeX;
    }

    int getBeforeY() {
        return beforeY;
    }
}
