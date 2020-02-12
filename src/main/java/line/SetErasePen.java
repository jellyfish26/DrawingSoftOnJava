package line;

import listener.MousePaintListener;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SetErasePen extends SetNormalPen {
    private Color beforeColor;

    public SetErasePen(MousePaintListener listener, String name) {
        super(listener, name, Color.WHITE);
        this.beforeColor = listener.getGraphics().getColor();
    }

    public SetErasePen(String name) {
        super(name, Color.WHITE);
    }

    @Override
    public void setPenBehavior() {
        beforeColor = getMousePaintListener().getGraphics().getColor();
        super.setPenBehavior();
    }

    @Override
    public void removePenBehavior() {
        getMousePaintListener().getGraphics().setColor(beforeColor);
        super.removePenBehavior();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        Color updateColor = getMousePaintListener().getGraphics().getColor();
        if (updateColor != Color.WHITE) {
            beforeColor = updateColor;
            getMousePaintListener().getGraphics().setColor(Color.WHITE);
        }
        super.mouseDragged(mouseEvent);
    }
}
