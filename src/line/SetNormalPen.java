package line;

import listener.MousePaintListener;
import listener.SetMousePaintListener;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SetNormalPen implements PenBehavior, SetMousePaintListener {
    private String name;
    private MousePaintListener paintListener;
    private Color setDefaultColor;

    public SetNormalPen(MousePaintListener listener, String name, Color color) {
        this.name = name;
        this.paintListener = listener;
        this.setDefaultColor = color;
    }

    public SetNormalPen(String name, Color color) {
        this.name = name;
        this.setDefaultColor = color;
    }


    @Override
    public void setPenBehavior() {
        paintListener.setPenBehavior(this);
        if (setDefaultColor != null) paintListener.getGraphics().setColor(setDefaultColor);
    }

    @Override
    public void removePenBehavior() {
    }

    MousePaintListener getPaintListener() {
        return paintListener;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void setMousePaintListener(MousePaintListener listener) {
        paintListener = listener;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        paintListener.getCustomGraphics2D().resetSmoothLineCoordinate();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        paintListener.getCustomGraphics2D().drawSmoothLine(mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
