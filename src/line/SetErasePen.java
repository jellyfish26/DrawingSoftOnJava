package line;

import listener.MousePaintListener;

import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.awt.event.MouseEvent;

public class SetErasePen extends SetNormalPen {
    Color beforeColor;

    public SetErasePen(MousePaintListener listener, String name) {
        super(listener, name, Color.WHITE);
        this.beforeColor = listener.getGraphics().getColor();
    }

    public SetErasePen(String name) {
        super(name, Color.WHITE);
    }

    @Override
    public void setPenBehavior() {
        beforeColor = super.getPaintListener().getGraphics().getColor();
        super.setPenBehavior();
    }

    @Override
    public void removePenBehavior() {
        super.getPaintListener().getGraphics().setColor(beforeColor);
        super.removePenBehavior();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        Color updateColor = super.getPaintListener().getGraphics().getColor();
        if (updateColor != Color.WHITE) {
            beforeColor = updateColor;
            super.getPaintListener().getGraphics().setColor(Color.WHITE);
        }
        super.mouseDragged(mouseEvent);
    }
}
